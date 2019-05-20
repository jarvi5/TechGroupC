import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {

	public static List<Sentence> readFile(String filename) {
		ArrayList<Sentence> list = new ArrayList<Sentence>();

		if (filename == null) {
			return list;
		}
		File f = new File(filename);
		if (!f.exists()) {
			return list;
		}

		Scanner input = null;
		try {
			input = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (input.hasNextLine() && input.hasNext()) {
			String line = input.nextLine();
			Scanner lineScanner = new Scanner(line);

			String first = lineScanner.next();
			if (!first.equals("0") && !first.equals("1") && !first.equals("2") && !first.equals("-2") && !first.equals("-1")) {
				continue;
			}
			int sentiment = Integer.parseInt(first);

			String sentence;
			if (lineScanner.hasNext()) {
				sentence = lineScanner.next() + lineScanner.nextLine();
			} else {
				continue;
			}
			lineScanner.close();
			list.add(new Sentence(sentiment, sentence.toString()));
		}
		input.close();
		return list;
	}

	public static Set<Word> allWords(List<Sentence> sentences) {
		Set<Word> set = new HashSet<Word>();
		if (sentences == null) {
			return set;
		}
		LinkedHashMap<String, Integer[]> map = new LinkedHashMap<String, Integer[]>(); // word, {count, total}
		while (sentences.size() > 0) {
			Sentence s = sentences.remove(0);
			if (s == null) {
				continue;
			}
			Scanner currentSentence = new Scanner(s.getText());
			while (currentSentence.hasNext()) {
				String currentWord = currentSentence.next().toLowerCase();
				if (currentWord.length() != 0 && currentWord.substring(currentWord.length() - 1, currentWord.length()).equals(".")) {
					currentWord = currentWord.substring(0, currentWord.length() - 1);
				}
				if (currentWord.length() == 0) {
					continue;
				}
				char firstLetter = currentWord.toCharArray()[0];
				if ((firstLetter >= 'A' && firstLetter <= 'Z') || (firstLetter >= 'a' && firstLetter <= 'z')) {
					if (map.containsKey(currentWord)) {
						Integer[] wordValues = map.get(currentWord);
						wordValues[0]++;
						wordValues[1] += s.getScore();
						map.replace(currentWord, wordValues);
					} else {
						Integer[] wordValues = new Integer[2];
						wordValues[0] = 1;
						wordValues[1] = s.getScore();
						map.put(currentWord, wordValues);
					}
				}
			}
			currentSentence.close();
		}
		for (Map.Entry<String, Integer[]> entry : map.entrySet()) { // transfer map to set
			Word w = new Word(entry.getKey());
			Integer[] value = entry.getValue();
			w.count = value[0];
			w.total = value[1];
			set.add(w);
		}
		return set;
	}

	public static Map<String, Double> calculateScores(Set<Word> words) {
		Map<String, Double> map = new HashMap<String, Double>();
		if (words == null) {
			return map;
		}
		for (Word w : words) {
			if (w != null) {
				Double score = w.calculateScore();
				map.put(w.getText(), score);
			}
		}
		return map;

	}

	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		if (sentence == null || wordScores == null || sentence.length() < 1) {
			return 0;
		}
		sentence = sentence.toLowerCase();
		Scanner words = new Scanner(sentence);

		int wordCount = 0;
		Double totalScore = 0.0;
		while (words.hasNext()) {
			String currentWord = words.next();
			char firstLetter = currentWord.toCharArray()[0];
			if ((firstLetter >= 'A' && firstLetter <= 'Z') || (firstLetter >= 'a' && firstLetter <= 'z')) {
				wordCount++;
				Double wordScore = wordScores.get(currentWord);
				if (wordScore != null) {
					totalScore += wordScore;
				}
			}
		}
		words.close();
		if (wordCount != 0) {
			return totalScore / wordCount;
		}
		return 0;
	}

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
