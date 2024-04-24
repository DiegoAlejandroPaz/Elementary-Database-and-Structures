package assignment10;

import java.util.LinkedList;
import java.util.ListIterator;

class WordCountNode {
	String word;
	int count;
	
	/**
	 * WordCountNode constructor
	 * @param inWord
	 */
	public WordCountNode(String inWord) {
		word = inWord;
		count = 1;
	}	
	
	/**
	 * @return the object word datum
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * @return the object count datum
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return the object count auto-incremented
	 */
	public int incrementCount() {
		count++;
		return count;
	}

	public int compareTo(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class WordLinkedList extends WordList {

	static LinkedList<WordCountNode> words =
			new LinkedList<WordCountNode>();
	
	public WordLinkedList() {
		super();
		
	}
	
	/**
	 * Public method findWord
	 * @param inWord String
	 * @return 0 if inWord not found, inWord count if found
	 */
	
	public int findWord(String inWord) {
		// TODO Auto-generated method stub
	
		ListIterator<WordCountNode> x = words.listIterator();
		while(x.hasNext()) {
			WordCountNode n = (WordCountNode) x.next();
			if(inWord.compareTo(n.getWord()) == 0) {
				
				return n.getCount();
				
			}
		}
		return 0;
	}

	/**
	 * Public abstract method existsWord
	 * @param inWord String
	 * @return True if inWord exists in WordList
	 */
	public boolean existsWord(String inWord) {
		// TODO Auto-generated method stub
		
		ListIterator<WordCountNode> x = words.listIterator();
		while(x.hasNext()) {
			WordCountNode n = (WordCountNode) x.next();
			if(inWord.compareTo(n.getWord()) == 0) {
				
				return true;
		
	}
		}
		return false;
	}

	/**
	 * Public abstract method addWord
	 * @param inWord String
	 * @return 1 if inWord not found, new inWord count if found
	 */
	public int addWord(String inWord) {
		// TODO Auto-generated method stub
		
		boolean foundword = false;
		ListIterator<WordCountNode> x = words.listIterator();
		while(x.hasNext()) {
			WordCountNode n = (WordCountNode) x.next();
			if(inWord.compareTo(n.getWord()) == 0) {
				
				foundword = true;
				super.incTotalAllWords();
				n.incrementCount();
				return n.getCount();
			
			}
		}
		if(!foundword) {
			
			super.incTotalAllWords();
			super.incNumUniqueWords();
			
			words.add(new WordCountNode(inWord));
		
		}
		return 1;
	}
	
	/**
	 * Public abstract method incWord
	 * @param inWord String
	 * @return 0 if inWord not found, new inWord count if found
	 */

	public int incWord(String inWord) {
		// TODO Auto-generated method stub
	
		ListIterator<WordCountNode> x = words.listIterator();
		while(x.hasNext()) {
			WordCountNode n = (WordCountNode) x.next();
			if(inWord.compareTo(n.getWord()) == 0) {
				
				super.incTotalAllWords();
				n.incrementCount();
				return n.getCount();
				
			}
		}
		return 0;
	}
	/**
	 * Public abstract method printWordList
	 * @param inMinimum int
	 */

	public void printWordList(int inMinimum) {
		// TODO Auto-generated method stub
		
		System.out.println("Ttl Words:" + words.size());
		ListIterator<WordCountNode> x = words.listIterator();
		while(x.hasNext()) {
			WordCountNode n = (WordCountNode) x.next();
			if (n.getCount() >= inMinimum) {
				System.out.println(n.getWord()+ ":" + n.getCount());
			}
		}
	
	}
	
	
	
}
