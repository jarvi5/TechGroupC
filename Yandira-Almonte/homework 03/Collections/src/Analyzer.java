import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
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
				BufferedReader br = Files.newBufferedReader(Paths.get(filename));
				List<String> lines = br.lines().collect(Collectors.toList());
				for (String line : lines) {
					if (!line.trim().isEmpty()) {
						StringTokenizer tokens = new StringTokenizer(line);
						double value = Double.valueOf(tokens.nextToken(" "));
						int intPart = (int) value;
						String text = tokens.nextToken("\n").trim();
						if (value < -2 || value > 2) {
							continue;
						} else if (value - intPart != 0)
							continue;
						if (text.isEmpty())
							continue;
						sentences.add(new Sentence((int) value, text));

					}
				}
			} catch (IOException e) {
				System.out.println("The file doesnot exist.");
				e.printStackTrace();
			}
		}
		return sentences;

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
		return scores; // this line is here only so this code will compile if
						// you don't modify it

	}

	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		double score = 0.0;
		if (sentence == null)
			return score;
		if (wordScores != null && !sentence.isEmpty()) {
			StringTokenizer token = new StringTokenizer(sentence, " ");
			while (token.hasMoreElements()) {
				String strWord = token.nextToken().toLowerCase();
				if (!strWord.chars().allMatch(Character::isLetter))
					continue;
				else if (wordScores.containsKey(strWord)) {
					score += wordScores.get(strWord).doubleValue();
				} else
					score += 0;

			}

		}

		return score; // this line is here only so this code will compile if you
						// don't modify it

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
		// words.forEach(value-> System.out.println(value));
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
