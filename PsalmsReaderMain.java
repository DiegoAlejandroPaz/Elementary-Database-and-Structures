package java2;
import java.io.*;
import java.util.*;

/**
 * PsalmsReaderMain class - Template for Assignment-3
 * @author TMyatt
 *
 */
public class PsalmsReaderMain {
	
	/**
	 * getReference - Parse and return only the Psalms reference (which psalms it is)
	 * @param inLine
	 * @return
	 */
	static String getReference(String inLine) {
		String ref = "";
		// Write some code to parse inLine for real
		// This only returns characters from position 0 to 5
		String[] refArray = inLine.split("\t");
		ref = refArray[0];
		return ref;
	}
	
	/**
	 * getVerse - Parse and return only the Psalms verse (the actual psalm)
	 * @param inLine
	 * @return
	 */
	static String getVerse(String inLine) {
		String ver = "";
		// Write some code to parse inLine for real
		// This only returns characters from position 6 to the end
		String[] verArray = inLine.split("\t");
		ver = verArray [1];
		return ver;
	}

	/**
	 * PsalmsReaderMain main() - Template for Assignment-3
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isNumber = false;
		do {
			Scanner scannerDP = new Scanner (System.in);
		
			int cH;
			int vR;
			
			System.out.println("-Hey, give me the psalm chapter you need!");
			if (scannerDP.hasNextInt()) {
				cH = scannerDP.nextInt();
				isNumber = true;
			
			System.out.println("-Um I also need the psalm verse");
			if (scannerDP.hasNextInt()) {
			 vR = scannerDP.nextInt();
				isNumber = true;
				
			
				String Ref = "Psalms " + cH +":"+ vR;
				
			
			try {
				// Open the required text file for sequential read
				Scanner inputFile =
						new Scanner (new File("C:\\Users\\Diego Paz\\Documents\\JAVA2DP\\bible_psalms.txt"));
				// Check for EOF, read the next line, and display it
				
				while (inputFile.hasNextLine()) {
					
					String inLine = inputFile.nextLine();
					if (Ref.equals (getReference(inLine))) {
					System.out.println(getVerse(inLine));
					break;
					}
					else if (inputFile.hasNextLine() == false) {
						System.out.println("--The Psalm you asked for does not exist--");
					}
					
					
				}
				// Close the required file when EOF is reached
				inputFile.close();
				scannerDP.close();
			}
			catch (Exception e) {
				// All Exceptions come here for graceful termination
				System.out.println("PsalmsReaderMain Error: " + e);
			} // END try/catch
				
			} else {
				System.err.println("!Error, this is not a valid positive integer!");
				isNumber = false;
				scannerDP.next();
			}} else {
				System.err.println("!Error, this is not a valid positive integer!");
				isNumber = false;
				scannerDP.next();
			}
			} while (!(isNumber));
		
		
	} // END main
} // END class

