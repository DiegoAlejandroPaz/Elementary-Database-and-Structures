package java2;
	import java.io.*;
	import java.util.*;

	/**
	 * PsalmsReaderMain class - Template for Assignment-4
	 * @author TMyatt
	 *
	 */
	public class wordCount {
		static String words[] = new String[100000];
		static int count[] = new int[100000];
		static int lastIndex = 0;
		
		/**
		 * addWordToList - add word to list or increment counter
		 * @param inWord - the word to add to the list
		 * @return number of words in the list
		 */
		static int addWordToList(String inWord) {
			  for (int i = 0; i <= lastIndex ; i++)
			  {
			         if (inWord.equals(words[i])) {
			        	 count[i]=count[i]+1;
			        	 break;
			         }
			         if ((i == lastIndex)&&(!inWord.equals(words[i])))
			        	{
			        	 lastIndex ++;
			        	 words[lastIndex] = inWord;
			        	 count[lastIndex] = 1;
			        	 break;
			         }
			         }
			            return lastIndex;
		}
		
		/**
		 * printWordList - dump the list if count > inMinimum
		 */
		static void printWordList(int inMinimum) {
				for (int i = 0; i < lastIndex ; i++)
				{
					if (count[i] > 10000)
				//
					{ System.out.println(words[i]);
					System.out.println(count[i]);
						
						
					}
				}
		}

		/**
		 * getVerse - Parse and return only the Psalms verse
		 * @param inLine - the line to parse on tab delimiter
		 * @return right half of tab delimited string
		 */
		static String getVerse(String inLine) {
			String ver = "";
			String[] verArray = inLine.split("\t");
			ver = verArray [1];
			return ver;
		}

		/**
		 * PsalmsReaderMain main() - Template for Assignment-4
		 * @param args
		 */
		public static void main(String[] args) {
			try {
				// Open the required text file for sequential read
				Scanner inputFile =
						new Scanner (new File("C:\\Users\\Diego Paz\\Documents\\JAVA2DP\\bible-complete.txt"));
				// Check for EOF, read the next line, and display it
				while (inputFile.hasNextLine()) {
					String inLine, verse;
					String[] verseParsed;
					
					inLine = inputFile.nextLine();
					verse = getVerse(inLine);
					verseParsed = verse.split("[ :;,.'!?()-]+");
		
					for (String s: verseParsed) {
						addWordToList(s.toLowerCase());
					}
				}
				// Close the required file when EOF is reached
				inputFile.close();
				printWordList(10000);
			} // END try
			catch (Exception e) {
				// All Exceptions come here for graceful termination
				System.out.println("PsalmsReaderMain Error: " + e);
			} // END catch
		} // END main
	} // END class


