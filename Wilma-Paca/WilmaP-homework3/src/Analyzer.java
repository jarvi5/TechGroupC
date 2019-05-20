import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static boolean isInt(String value) {
		int[] valueScore = {-2,-1,0,1,2};
		boolean booleanFlag = false;
		try {
			if(Integer.parseInt(value) >= -2 || Float.parseFloat(value) >= -2.0) {
				for(int i : valueScore)	
					if(i == Integer.parseInt(value) ) {
					booleanFlag = true;
					}
			}
		}catch (NumberFormatException excepcion){
			System.out.println("It is not valid number");
		}
		return booleanFlag;
	}
	
	public static  Sentence addSentence(String linea){
		String[] stringArrays = null;
		Sentence sentence = null;
		int score =0;
		String text = "";
		if(!linea.isEmpty()) {
			stringArrays = linea.split(" ");
			for(int i =0;i < stringArrays.length;i++) {
				if(isInt(stringArrays[0]) == true ) {
					score = Integer.parseInt(stringArrays[0]);
					if(-3 <score &&score <3 ) {
						if(i != 0 && i != 1 ) {
						text = text +" "+ stringArrays[i];
						}
						if(i == 1 && !stringArrays[i].isEmpty()){
							text = stringArrays[i];
						}
					}
				
				}else {
					score = 10;
					break;
				}
			}
			if(!text.isEmpty() && score != 10) {
				Sentence sentenceString = new Sentence(score,text);
				sentence = sentenceString;
			}
		}
		return sentence;
	}
	
	public static List<Sentence> readFile(String filename) {

		/* IMPLEMENT THIS METHOD! */
		List<Sentence> sentenceList = new ArrayList();
		File archivo = new File(filename);
	    FileReader fr = null;
	    BufferedReader br = null;
	     try { 
			if(!filename.isEmpty()&& filename != null && archivo.exists()) {
				try {
					fr = new FileReader (archivo);
			         br = new BufferedReader(fr);
	
				     // Reading the file    
			         	 String linea;
				         while((linea=br.readLine())!=null && !linea.isEmpty()) {
				            //System.out.println(linea);
				         	String cadena = linea;
				         	if(addSentence(cadena) != null) {
				         		sentenceList.add(addSentence(cadena));
				         	}
				          
				         }
				     
				}catch(Exception e){
			         e.printStackTrace();
			      }finally{
			         try{                    
			            if( null != fr ){   
			               fr.close();     
			            }                  
			         }catch (Exception e2){ 
			            e2.printStackTrace();
			         }
			      }
			}
	     }catch (Exception e){
				System.out.println("filenme is not valid"); 
	     }	
		
		return sentenceList; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Map<Integer, String> addList(String[] wordArrays){
	
		List<String> wordList = new ArrayList();
		int count = 0;		
		String stringValue = "";
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
			for(String st: wordArrays) {
				wordList.add(st.toLowerCase());					
			}
			while(wordList.size() > 0) {
				for(int i=0; i < wordList.size(); i++) {
					for(int j=0; j < wordList.size(); j++) {
						if(wordList.get(i) == wordList.get(j)) {
							count++;
							stringValue = wordList.get(i);	
							wordList.remove(j);
							if(!treeMap.containsValue(stringValue)) {
								treeMap.put(count, stringValue);
							}else {
								treeMap.put(count, stringValue);
							}
						}
					}
				}
			}
		
		return treeMap;
	}
	public static Set<Word> allWords(List<Sentence> sentences) {

		/* IMPLEMENT THIS METHOD! */
		String[] words = {};
		String value = "";
		int count = 0;
		String wordVal = "";
		Set<Word> wordSet = new TreeSet<Word>();
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		try {
			if(	!sentences.isEmpty() || sentences != null) {
				for(Sentence sentenceValue: sentences) {
					if(sentenceValue != null) {					
						value = sentenceValue.getText();
						words = value.split(" ");
						treeMap = addList(words);
						
						Iterator it = treeMap.keySet().iterator();
						while(it.hasNext()){
						  Integer key = (Integer) it.next();
						  
						  if(treeMap.get(key).charAt(0) != '?' && treeMap.get(key).charAt(0)!='$' ) {
							  Word word = new Word(treeMap.get(key));
							  word.increaseTotal(sentenceValue.getScore());
							  wordSet.add(word);
							 // System.out.println("Clave: " + key + " -> Valor: " + treeMap.get(key));
						  }
						  
						}
						
					}
				}
			}
		}catch(Exception e){
			System.out.println("Set is not valid");
		}
		return wordSet; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		/* IMPLEMENT THIS METHOD! */
		int count = 0;
		double val = 0.0;
		Map<String, Double> treeMap = new TreeMap<String, Double>();
		Iterator it = words.iterator();
		try {
			if(words != null && !words.isEmpty()) {
			
				while(it.hasNext()){
					Word word = (Word) it.next();
					if(word != null) {
					  treeMap.put(word.getText(), word.calculateScore());
					  //System.out.println("Clave: " + word.getCount() + " -> Valor: " + word.getText());
					}
				}
			
			}else {
			System.out.println("Map is empty? :"+treeMap.isEmpty());
			return treeMap;
			}
		}catch(Exception e){
			System.out.println("Map is not valid");
			
		}
		return treeMap; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static boolean allScoreAreDouble(Map<String, Double> wordScores) 
	{
	
		boolean valueFlag = true;
		double number = 0;
		Iterator it = wordScores.keySet().iterator();
		while(it.hasNext()){
			  String key = (String) it.next();
			  number = wordScores.get(key);
			 if(number % 1 == 0) {
				 valueFlag = false;
			 } 
		
		}
		
		return valueFlag;
	}
	
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		/* IMPLEMENT THIS METHOD! */
		double score = 0.0;
		int count = 0;
		String key = "";
		String[] stringArray = sentence.split(" ");
		try {		
			if(wordScores != null) {
				if( sentence != null) {
				if(!wordScores.isEmpty() && !sentence.isEmpty()) {
							
						for(String value: stringArray) {						
								if(wordScores.containsKey(value.toLowerCase())) {							
									//System.out.println("Clave: " + key + " -> Valor: " + wordScores.get((value.toLowerCase())));
									score = score + wordScores.get((value.toLowerCase()));
									count++;
									
								}					
					}
					score = score/count;
					if(allScoreAreDouble(wordScores) == true) {
						return (double)score;
					}
				}else {
					score = 0;
				}
			}
			}
			
		}catch (Exception e){
			System.out.println("Map is not valid");
		}
		return (int)score; // this line is here only so this code will compile if you don't modify it

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
