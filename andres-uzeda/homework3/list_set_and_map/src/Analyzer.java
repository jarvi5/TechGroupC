import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

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
        List<Sentence> sentenceList = new ArrayList<>();
        String line = "";
        if (filename == null){
            return sentenceList;
        }
        try (BufferedReader bufferRead = new BufferedReader(new FileReader(filename))) {
            while ((line = bufferRead.readLine()) != null){
                try {
                    String[] arrayStr = line.split("\\s+");
                    if(arrayStr[0].equals("0") || arrayStr[0].equals("1") || arrayStr[0].equals("-1") || arrayStr[0].equals("-2") || arrayStr[0].equals("2")){
                        String newText = "";
                        for (int index = 1; index < arrayStr.length; index++){
                            newText += arrayStr[index] + " ";
                        }
                        if(newText == ""){
                            continue;
                        }
                        Sentence sentenceToAdd = new Sentence(Integer.valueOf(arrayStr[0]),newText.trim());
                        sentenceList.add(sentenceToAdd);
                    }else{
                        continue;
                    }
                } catch (Exception e){
                    e.getMessage();
                }
            }
        }catch (Exception e){
            e.getMessage();
        }
        return sentenceList;
	}

	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
        List<Word> wordList = new ArrayList<>();
        if (sentences == null || sentences.isEmpty()){
            return new HashSet<Word>(wordList);
        }
        for (Sentence sentence: sentences) {
            if(sentence == null){
                continue;
            }
            sentence.text = sentence.text.toLowerCase();
            String[] arrayStr = sentence.text.split("\\s+");
            for (String text : arrayStr) {
                //expresion regular que ignora los numeros o caracteres especiales en un sentence
                if (!text.matches("^[a-z].*")){
                    continue;
                }
                Word word = new Word(text);
                if (wordList.contains(word)) {
                    wordList.get(wordList.indexOf(word)).increaseTotal(word.getTotal());
                } else {
                    wordList.add(word);
                }
            }
        }
		return new HashSet<Word>(wordList);
	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {
        HashMap<String, Double> scoresMap = new HashMap<>();
        if (words == null || words.isEmpty()){
            return scoresMap;
        }
        for (Word word : words) {
            if (word == null){
                continue;
            }
            scoresMap.put(word.getText(), word.calculateScore());
        }
        return scoresMap;
	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
        double total = 0;
        int count = 0;
        if (wordScores == null || wordScores.isEmpty() || sentence == null || sentence.isEmpty()){
            return 0;
        }
        String[] sentenceArray = sentence.split("\\s+");
        for (String text : sentenceArray) {
            text = text.toLowerCase();
            if (!text.matches("^[a-z].*")){
                continue;
            } else if (wordScores.containsKey(text)) {
                total += wordScores.get(text);
            }
            count++;
        }
        if(count > 0){
            return total / count;
        }else {
            return 0;
        }

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
//		if (args.length == 0) {
//			System.out.println("Please specify the name of the input file");
//			System.exit(0);
//		}
//		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile("./movie_reviews/reviews.txt");
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
