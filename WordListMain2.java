package assignment10;

import java.io.*;
import java.util.*;

/**
 * 
 * @author TMyatt
 * 
 */
public class WordListMain2 {

	/**
	 * 
	 * @param inLine String
	 * @return
	 */
	static String getVerse(String inLine) {
		String[] ver = inLine.split("\t");
		return ver[1];
	}
	
	/**
	 * 
	 * @param args String[]
	 */
	public static void main(String[] args) {
		long mSec, mSecSum = 0;
		try {
			
			if (args[1].compareTo("A") == 0) {
				// Open the required text file for sequential read
				Scanner inputFile =
						new Scanner (new File(args[0]));
				
				WordArrayList wordArrayList;
				wordArrayList = new WordArrayList();
				
				// Check for EOF, read the next line, and display it
				while (inputFile.hasNextLine()) {
					String inLine, verse;
					String[] verseParsed;
					
					inLine = inputFile.nextLine();
					verse = getVerse(inLine);
					verseParsed = verse.split("[ :;,.'!?()-]+");
					// We're going to do a millisecond execution calc
					mSec = System.nanoTime()/1000000;
					for (String s: verseParsed) {
						wordArrayList.addWord(s.toLowerCase());
					}
					mSecSum += (System.nanoTime()/1000000 - mSec);
				}		
				// Close the required file when EOF is reached
				inputFile.close();
				wordArrayList.printWordList(Integer.parseInt(args[2]));
		        System.out.println("Elapsed Time: " + mSecSum + " ms");
			}
			
			else if (args[1].compareTo("H") == 0) {
				// Open the required text file for sequential read
				Scanner inputFile =
						new Scanner (new File(args[0]));
				
				WordHashMap wordHashMap;
				wordHashMap = new WordHashMap();
				
				// Check for EOF, read the next line, and display it
				while (inputFile.hasNextLine()) {
					String inLine, verse;
					String[] verseParsed;
					
					inLine = inputFile.nextLine();
					verse = getVerse(inLine);
					verseParsed = verse.split("[ :;,.'!?()-]+");
					// We're going to do a millisecond execution calc
					mSec = System.nanoTime()/1000000;
					for (String s: verseParsed) {
						wordHashMap.addWord(s.toLowerCase());
					}
					mSecSum += (System.nanoTime()/1000000 - mSec);
				}		
				// Close the required file when EOF is reached
				inputFile.close();
				wordHashMap.printWordList(Integer.parseInt(args[2]));
		        System.out.println("Elapsed Time: " + mSecSum + " ms");
			}
			
			else if (args[1].compareTo("L") == 0) {
				// Open the required text file for sequential read
				Scanner inputFile =
						new Scanner (new File(args[0]));
				
				WordLinkedList wordLinkedList;
				wordLinkedList = new WordLinkedList();
				
				// Check for EOF, read the next line, and display it
				while (inputFile.hasNextLine()) {
					String inLine, verse;
					String[] verseParsed;
					
					inLine = inputFile.nextLine();
					verse = getVerse(inLine);
					verseParsed = verse.split("[ :;,.'!?()-]+");
					// We're going to do a millisecond execution calc
					mSec = System.nanoTime()/1000000;
					for (String s: verseParsed) {
						wordLinkedList.addWord(s.toLowerCase());
					}
					mSecSum += (System.nanoTime()/1000000 - mSec);
				}		
				// Close the required file when EOF is reached
				inputFile.close();
				wordLinkedList.printWordList(Integer.parseInt(args[2]));
		        System.out.println("Elapsed Time: " + mSecSum + " ms");
			}
			
			else {
				System.out.println(" -- NOT VALID -- ");
				System.out.println (" Please insert a valid character.");
			}
			
			
			
		} // END try
		catch (Exception e) {
			// All Exceptions come here for graceful termination
			System.out.println("PsalmsReaderMain Error: " + e);
		} // END catch		
	} // END main
} // END class


