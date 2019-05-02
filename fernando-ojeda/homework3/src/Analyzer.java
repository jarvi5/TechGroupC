import java.io.BufferedReader;
import java.io.File;
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
        String concatResult = "";
        List<Sentence> sentences = new ArrayList<>();
        if (filename != null) {
            List<String> fileData = getFileData(filename);
            if (fileData.size() != 0) {
                for (String item : fileData) {
                    concatResult = addSentenceToList(concatResult, sentences, item);
                }
            }
        }
        return sentences;
    }

    private static String addSentenceToList(String concatResult, List<Sentence> sentences, String item) {
        if (!item.equals(" ")) {
            String[] itemsData = item.split(" ");
            if (isNumeric(itemsData[0]) && itemsData.length > 1 && (Integer.parseInt(itemsData[0]) >= -2 &&
                    Integer.parseInt(itemsData[0]) <= 2)) {
                for (int count = 1; count < itemsData.length; count++) {
                    concatResult = concatResult + itemsData[count] + " ";
                }
                Sentence sentence = new Sentence(Integer.parseInt(itemsData[0]),
                        concatResult.substring(0, concatResult.length() - 1));
                sentences.add(sentence);
                concatResult = "";
            }
        }
        return concatResult;
    }

    private static boolean isNumeric(String word) {
        try {
            Integer.parseInt(word);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private static List<String> getFileData(String filename) {
        List<String> sentences = new ArrayList<>();
        FileReader fileReader = null;
        try {
            File archivo = new File(filename);
            if (archivo.exists()) {
                fileReader = new FileReader(archivo);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String data;
                while ((data = bufferedReader.readLine()) != null) {
                    sentences.add(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileReader) {
                    fileReader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return sentences;
    }

    /*
     * Implement this method in Part 2
     */
    public static Set<Word> allWords(List<Sentence> sentences) {
        Set<Word> result = new HashSet<>();
        if (sentences != null && sentences.size() != 0) {
            for (Sentence sentence : sentences) {
                if (sentence != null) {
                    String[] words = sentence.getText().split(" ");
                    for (String word1 : words) {
                        if (isLetter(word1)) {
                            Word word = new Word(word1);
                            result.add(word);
                            word.increaseTotal(sentence.getScore());
                        }
                    }
                }
            }
        }
        return result;
    }

    private static boolean isLetter(String word) {
        boolean result = false;
        if ((word).matches("([a-z]|\\s)+")) {
            result = true;
        }
        return result;
    }

    /*
     * Implement this method in Part 3
     */
    public static Map<String, Double> calculateScores(Set<Word> words) {
        Map<String, Double> result = new HashMap<>();
        if (words != null && words.size() != 0) {
            for (Word word : words) {
                if (word != null) {
                    String wordData = word.getText();
                    double score = word.calculateScore();
                    result.put(wordData.toLowerCase(), score);
                }
            }
        }
        return result;
    }

    /*
     * Implement this method in Part 4
     */
    public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
        double result = 0.00;
        double average = 0.00;
        int count = 0;
        if (sentence != null && sentence.length() != 0 && wordScores != null &&
                wordScores.size() != 0 && isLetter(sentence.toLowerCase().split(" ")[0])) {
            String[] words = sentence.toLowerCase().split(" ");
            for (String word : words) {
                if (isLetter(word)) {
                    if (wordScores.containsKey(word)) {
                        result = result + wordScores.get(word);
                        count += 1;
                    } else {
                        count += 1;
                    }
                }
            }
            average = result / count;
        }
        return average;
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
