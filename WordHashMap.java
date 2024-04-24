package assignment10;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordHashMap extends WordList {
	
	static HashMap<String, Integer>wordsHash =
			new HashMap<String, Integer>();
	static TreeMap<String, Integer> wordsTree =
			new TreeMap<String, Integer>();

	public WordHashMap() {
		super();
		
	}

	/**
	 * Public method findWord
	 * @param inWord String
	 * @return 0 if inWord not found, inWord count if found
	 */
	
	public int findWord(String inWord) {
		// TODO Auto-generated method stub
		
		if(wordsHash.get(inWord) == null)
			return 0;
			else{
				return wordsHash.get(inWord);
			}
	
	}
	
	/**
	 * Public abstract method existsWord
	 * @param inWord String
	 * @return True if inWord exists in WordList
	 */
	
	public boolean existsWord(String inWord) {
		// TODO Auto-generated method stub
		if(wordsHash.get(inWord) == null)
			return false;
			else{
				return true;
			}
	
	}
	

	/**
	 * Public abstract method addWord
	 * @param inWord String
	 * @return 1 if inWord not found, new inWord count if found
	 */
	public int addWord(String inWord) {
		// TODO Auto-generated method stub
		if(wordsHash.get(inWord) != null) {
			
			super.incTotalAllWords();
			 wordsHash.put(inWord,wordsHash.get(inWord) + 1);
		return wordsHash.get(inWord);
	
	} else {
		
			super.incTotalAllWords();
			super.incNumUniqueWords();
				wordsHash.put(inWord,1);
				return 1;
			}
	
	}
	
	
	
	public int incWord(String inWord) {
		// TODO Auto-generated method stub
		if(wordsHash.get(inWord) != null) {
			
			super.incTotalAllWords();
			 wordsHash.put(inWord,wordsHash.get(inWord) + 1);
		return wordsHash.get(inWord);
	
	} else {
				return 0;
			}
	
	}
	
	

	
	public void printWordList(int inMinimum) {
		 if (wordsHash.size() > 0) {
				System.out.println("Total words: " + wordsHash.size());
				for (Map.Entry<String, Integer> u:
					wordsHash.entrySet()){
					if (u.getValue()>= inMinimum) 
					{
					System.out.println(u.getKey() + "=" + u.getValue());
					}
				}
		 }
		
		// TODO Auto-generated method stub
		
	}
	
	
}
