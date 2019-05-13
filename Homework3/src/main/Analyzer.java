package main;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Analyzer {
	
	public static List<Sentence> readFile(String filename) {
		List<Sentence> sentences = new ArrayList<>();
		List<String> lines = new ArrayList<>();
		try {
			lines = Files.lines(Paths.get(filename)).collect(Collectors.toList());
		} catch (Exception e) {
			return new ArrayList<Sentence>(); // if the file cannot be opened for reading or if the input filename is null, this method should return an empty List.
		}
		
		for (String line : lines) {
			int spaceIndex = line.indexOf(" ");
			 
			try { 
				int score = Integer.parseInt(line.substring(0, spaceIndex));
				String text = line.substring(spaceIndex + 1); 
				
				if (score <= 2 && score >= -2 && !text.isEmpty()) { // well formatted
					sentences.add(new Sentence(score, text));
				}
			} catch(Exception e) {
				continue;
			}
			
		}
		
		return sentences; 
	}
	
	public static Set<Word> allWords(List<Sentence> sentences) {
		List<Word> wordList = new ArrayList<>(); // use List because easier when process
		
		if (!(sentences == null || sentences.isEmpty())) { // sentences list not null or empty
			for (Sentence sentence : sentences) {
				if (sentence != null) {
					String[] tokens = sentence.getText().toLowerCase().split(" ");
					for (String token : tokens) {
						if (Character.isLetter(token.charAt(0))) { // token starts with a letter
							Word word = new Word(token);
							word.increaseTotal(sentence.getScore());
							
							if (wordList.contains(word)) {
								wordList.get(wordList.indexOf(word)).increaseTotal(word.getTotal()); // update word 
							} else {
								wordList.add(word);
							}
						}
					}
				}
			}
		}
		
		return new HashSet<Word>(wordList);
	}
	
	public static Map<String, Double> calculateScores(Set<Word> words) {
		Map<String, Double> map = new HashMap<String, Double>();
		
		if (words != null && !words.isEmpty()) {
			for (Word word : words) {
				if (word != null) {
					map.put(word.text, word.calculateScore());
				}
			}
		}		
		
		return map; 
	}
	
	
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		double score = 0;
		int count = 0;
		
		if (!(wordScores == null || wordScores.isEmpty() 
				|| sentence == null || sentence.isEmpty())) {
			String[] tokens = sentence.toLowerCase().split(" ");
			for (String token : tokens) {
				if (Character.isLetter(token.charAt(0))) { // token starts with a letter
					if (wordScores.containsKey(token)) {
						score += wordScores.get(token);
					}
					count++;
				}
			}
		}
		
		return count == 0 ? 0 : score / count; 
	}
	
    /*Main*/
	public static void main(String[] args) {
		
		System.out.print("Enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		
		String filename = "reviews.txt";
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("Score is " + score);
			
	}
}
