import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {

	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {

		List<Sentence> sentences = new ArrayList<>();
		if (filename != null && Paths.get(filename) != null) {
			try {
				List<String> lines = Files.newBufferedReader(Paths.get(filename)).lines().collect(Collectors.toList());
				for (String line : lines) {
					if (!line.trim().isEmpty()) {
						Sentence sentence = getSentence(line);
						if (sentence != null)
							sentences.add(sentence);
					}
				}
			} catch (IOException e) {
				System.out.println("The file doesnot exist.");

			}
		}
		return sentences;

	}

	private static Sentence getSentence(String line) {
		StringTokenizer tokens = new StringTokenizer(line);
		Sentence sentence = null;
		try {
			double value = Double.valueOf(tokens.nextToken(" "));
			int intPart = (int) value;
			String text = tokens.nextToken("\n").trim();
			if (value < -2 || value > 2) {
				return null;
			} else if (value - intPart != 0)
				return null;
			if (text.isEmpty())
				return null;
			sentence = new Sentence((int) value, text);
		} catch (Exception e) {
			System.out.println("No more tokens");			
		}
		return sentence;
	}

	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
		Map<String, Word> words = new TreeMap<String, Word>();
		if (sentences != null) {
			for (Sentence sentence : sentences) {
				if (sentence == null)
					continue;
				StringTokenizer token = new StringTokenizer(sentence.getText(), " ");
				while (token.hasMoreElements()) {
					String strWord = token.nextToken().toLowerCase();
					Word word = null;
					if (!strWord.chars().allMatch(Character::isLetter))
						continue;
					else if (words.containsKey(strWord)) {
						word = words.get(strWord);
						words.remove(strWord);
					} else
						word = new Word(strWord);
					if (word != null) {
						word.increaseTotal(sentence.getScore());
						words.put(strWord, word);
					}
				}
			}
		}
		return words.values().stream().collect(Collectors.toSet());

	}

	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {
		Map<String, Double> scores = new TreeMap<String, Double>();
		if (words != null) {
			for (Word word : words) {
				if (word != null && !word.getText().isEmpty()) {
					scores.put(word.getText(), word.calculateScore());
				}
			}
		}
		return scores; 

	}

	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		double score = 0.0;
		int length = 0;
		if (sentence == null || wordScores == null || sentence.isEmpty())
			return score;

		StringTokenizer token = new StringTokenizer(sentence, " ");
		length = token.countTokens();
		while (token.hasMoreElements()) {
			String strWord = token.nextToken().toLowerCase();
			if (!strWord.chars().allMatch(Character::isLetter)){
				length--;
				continue;
			}
			else if (wordScores.containsKey(strWord)) {
				score += wordScores.get(strWord).doubleValue();
			} 
		}
		return score / length;
	}

	/*
	 * This method is here to help you run your program. Y You may modify it as
	 * needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
		
	}
}
