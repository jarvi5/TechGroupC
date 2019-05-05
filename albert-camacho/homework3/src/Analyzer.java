import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	private static final Logger LOGGER = Logger.getLogger(Analyzer.class.getName());
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {
		List<Sentence> sentences = new ArrayList<>();
		if (filename != null)
			try {
				File file = new File(filename);
				Scanner sc = new Scanner(file);
				while (sc.hasNext()){
					Sentence sentence = getSentence(sc.nextLine());
					if (sentence != null)
						sentences.add(sentence);
				}
				sc.close();
			} catch (FileNotFoundException e) {
				LOGGER.log(Level.WARNING, "File '" + filename + "' was not found.");
			}

		return sentences;
	}

	private static Sentence getSentence(String text){
		String []data = text.split(" ", 2);
		Sentence sentence = null;
		try {
			int score = Integer.parseInt(data[0]);
			if (score > -3 && score < 3)
				sentence = new Sentence(score, data[1]);
		}catch (NumberFormatException | ArrayIndexOutOfBoundsException ex){
			LOGGER.log(Level.INFO, "Score isn't a Integer or there is'nt a text line");
		}
		return sentence;
	}
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
		Set<Word> words = new HashSet<>();
		if (sentences != null && !sentences.isEmpty())
			for (Sentence sentence : sentences){
				if (sentence != null) {
					List<String> tokens = getTokens(sentence.getText());
					for (String token : tokens){
						if (!words.add(new Word(token)))
							trackCumulativeScore(token, sentence.getScore(), words);
					}
				}
			}

		return words;
	}

	private static List<String> getTokens(String sentence){
		List<String> tokens = new ArrayList<>();
		if (sentence != null && !sentence.equals("")){
			String []words = sentence.split("\\s");
			for (String word : words) {
				if (word.matches("^[a-zA-Z]*$"))
					tokens.add(word.toLowerCase());
			}
		}
		return tokens;
	}

	private static void trackCumulativeScore(String token, int score, Set<Word> words){
		for (Word update : words) {
			if (update.getText().equals(token)) {
				update.increaseTotal(score);
			}
		}
	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {
		Map<String, Double> scores = new HashMap<>();
		if (words != null && !words.isEmpty())
			for (Word word : words){
				if (word != null)
					scores.put(word.getText(), word.calculateScore());
			}

		return scores;
	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		double result = 0;
		List<String> tokens = getTokens(sentence);
		if (wordScores != null && !wordScores.isEmpty() && !tokens.isEmpty()) {
			for (String token : tokens) {
				if (!wordScores.containsKey(token))
					wordScores.put(token, 0.0);

				result += wordScores.get(token);
			}
			result = result / tokens.size();
		}
		
		return result;
	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
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
