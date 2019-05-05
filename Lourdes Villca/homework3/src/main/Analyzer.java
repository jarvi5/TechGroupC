import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {

    /**
     * Method that read a File and save the sentences in a list.
     *
     * @param filename path of the file
     * @return the mapped sentences.
     */
    public static List<Sentence> readFile(String filename) {
        ArrayList<Sentence> sentences = new ArrayList<>();
        if (filename == null) return sentences;
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(str -> {
                if (str.matches("^-{0,1}[0-2]\\s.+$")) {
                    int i = str.indexOf(" ");
                    Sentence sentence = new Sentence(Integer.parseInt(str.substring(0, i)), str.substring(i + 1, str.length()));
                    sentences.add(sentence);
                }
            });
        } catch (IOException e) {
            return sentences;
        }
        return sentences;
    }

    /**
     * Method that map all words of the sentence in a HashSet.
     *
     * @param sentences represent the list of sentences.
     * @return the mapped Word object in a HashSet.
     */
    public static Set<Word> allWords(List<Sentence> sentences) {
        HashSet<Word> words = new HashSet<>();
        if (sentences == null) return words;
        for (Sentence sentence : sentences) {
            if (sentence == null) continue;
            String[] formatSentence = splitSentence(sentence.text);
            for (String word : formatSentence) {
                Word newWord = new Word(word);
                words.add(newWord);
                newWord.increaseTotal(sentence.score);
            }
        }
        return words;
    }

    /**
     * Method that calculate the score of words.
     *
     * @param words Set of words to calculate the corresponding score.
     * @return a map of word with the score.
     */
    public static Map<String, Double> calculateScores(Set<Word> words) {
        HashMap<String, Double> wordScores = new HashMap<>();
        if (words == null) return wordScores;
        words.forEach(word -> {
            if (word != null) wordScores.put(word.getText(), word.calculateScore());
        });
        return wordScores;
    }

    /**
     * Method that calculate the sentence score.
     *
     * @param wordScores Map of words with the corresponding score.
     * @param sentence   Sentence to calculate the score.
     * @return the calculated score.
     */
    public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
        double sentenceScore = 0;
        if (wordScores == null || sentence == null || sentence.isEmpty()) return sentenceScore;
        String[] formattedSentence = splitSentence(sentence);
        for (String word : formattedSentence) {
            Double score = wordScores.get(word);
            if (score != null) {
                sentenceScore += score;
            }
        }
        return formattedSentence.length > 0 ? sentenceScore / formattedSentence.length : 0;
    }

    /**
     * Method that split a sentence and discard words that doesn't start with letters.
     *
     * @param sentence Sentence to be splitted.
     * @return an array of String with the sentence processed.
     */
    public static String[] splitSentence(String sentence) {
        String formattedText = sentence.toLowerCase();
        return Stream.of(formattedText.split(" "))
                .filter(x -> x.matches("^[a-z]+$"))
                .toArray(String[]::new);
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
