import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

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
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.lines(Paths.get(filename)).collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<Sentence>();
        }

        for (String line : lines) {
            int spaceIndex = line.indexOf(" ");

            try {
                int score = Integer.parseInt(line.substring(0, spaceIndex));
                String text = line.substring(spaceIndex + 1);

                if (score <= 2 && score >= -2 && !text.isEmpty()) {
                    sentences.add(new Sentence(score, text));
                }
            } catch (Exception e) {
                continue;
            }

        }
        return sentences;
    }

    /*
     * Implement this method in Part 2
     */
    public static Set<Word> allWords(List<Sentence> sentences) {

        List<Word> wordList = new ArrayList<>();

        if (!(sentences == null || sentences.isEmpty())) {
            for (Sentence sentence : sentences) {
                if (sentence != null) {
                    String[] tokens = sentence.getText().toLowerCase().split(" ");
                    for (String token : tokens) {
                        if (Character.isLetter(token.charAt(0))) {
                            Word word = new Word(token);
                            word.increaseTotal(sentence.getScore());

                            if (wordList.contains(word)) {
                                wordList.get(wordList.indexOf(word)).increaseTotal(word.getTotal());
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

    /*
     * Implement this method in Part 3
     */
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

    /*
     * Implement this method in Part 4
     */
    public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

        double score = 0;
        int count = 0;

        if (!(wordScores == null || wordScores.isEmpty()
                || sentence == null || sentence.isEmpty())) {
            String[] tokens = sentence.toLowerCase().split(" ");
            for (String token : tokens) {
                if (Character.isLetter(token.charAt(0))) {
                    if (wordScores.containsKey(token)) {
                        score += wordScores.get(token);
                    }
                    count++;
                }
            }
        }

        return count == 0 ? 0 : score / count;

    }
}
