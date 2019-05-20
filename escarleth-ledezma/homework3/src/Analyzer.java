import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

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
        if (filename != null) {
            try (Scanner scanner = new Scanner(new File(filename))) {
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    if (isAValidFormattedSentence(line)) {
                        String[] parts = line.split(" ", 2);
                        sentenceList.add(new Sentence(Integer.parseInt(parts[0]), parts[1]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sentenceList;
    }

    private static boolean isAValidFormattedSentence(String sentence) {
        return sentence.matches("^(-?([1-2]|0)) [a-zA-Z\\s]*$");
    }

    /*
     * Implement this method in Part 2
     */
    public static Set<Word> allWords(List<Sentence> sentences) {
        Set<Word> wordSet = new HashSet<>();
        if (sentences != null && !sentences.isEmpty()) {
            sentences.forEach(sentence -> {
                if (sentence != null) {
                    List<String> words = formatSentence(sentence.getText());
                    words.forEach(word -> {
                        Word newWord = new Word(word);
                        newWord.increaseTotal(sentence.getScore());
                        wordSet.add(newWord);
                    });
                }
            });
        }
        return wordSet;
    }

    private static List<String> formatSentence(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(String::toLowerCase)
                .filter(word -> String.valueOf(word.charAt(0)).matches("[a-z]"))
                .collect(Collectors.toList());
    }

    /*
     * Implement this method in Part 3
     */
    public static Map<String, Double> calculateScores(Set<Word> words) {
        Map<String, Double> scoresMap = new HashMap<>();
        if (words != null && !words.isEmpty()) {
            scoresMap = words.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toMap(Word::getText, Word::calculateScore));
        }
        return scoresMap;
    }

    /*
     * Implement this method in Part 4
     */
    public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
        double score = 0;
        if (wordScores != null && sentence != null && !sentence.isEmpty()) {
            List<String> words = formatSentence(sentence);
            if (words.size() > 0) {
                score = words.stream().
                        flatMapToDouble(word -> DoubleStream.of(wordScores.getOrDefault(word, 0.0)))
                        .average()
                        .getAsDouble();
            }
        }
        return score;
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
