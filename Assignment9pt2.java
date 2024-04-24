package java2;

import java.nio.file.*;
import java.io.*;
import java.util.*;


public class Assignment9pt2 {
	public static String convertFile2String(String fileName)throws Exception
	{
		
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(fileName)));
		return data;
		
	}

	public static boolean balancedExp(String inWord) throws IOException {
		Stack<Character> stack = new Stack<Character>();
		if(inWord == null || inWord.length() == 0) {
			return false;
		} else 
			{    
			
			
			boolean cmnt = false;
			
			for(int i = 0; i < inWord.length(); i++){
		            
		            if (inWord.charAt(i) == '/'){
								 if (inWord.charAt(i + 1) == '*') {
								cmnt = true;
							}
								 
						} if (inWord.charAt(i) == '*') {
							
							
							if (inWord.charAt(i + 1) == '/') {
								cmnt = false;
								
								
							} else {
								cmnt = true;
							}
						}
		            
		            if (!cmnt) {
		            
		           	if (inWord.charAt(i) == '(' || inWord.charAt(i) == '{' || inWord.charAt(i) == '[' ) {
							stack.push(inWord.charAt(i));
						} else {
						switch (inWord.charAt(i)) {
						
					case ')' :
							
							
							
							if(!stack.isEmpty() && stack.peek() == '(') {
								stack.pop();
								
							} else if (!stack.isEmpty() && stack.peek() == '['){
								System.out.println("Not balanced: Expected ], found " + inWord.charAt(i));
								return false;
								
								
							} else if (stack.isEmpty()) {
								System.out.println("Not balanced: Stack is empty, found " + inWord.charAt(i));
								return false;
							
							} else if (!stack.isEmpty() && stack.peek() == '{'){
								System.out.println("Not balanced: Expected }, found " + inWord.charAt(i));
								return false;
								
							}
							
					case ']' :		
						
						if(!stack.isEmpty() && stack.peek() == '[') {
							stack.pop();
							
						} else if (!stack.isEmpty() && stack.peek() == '('){
							System.out.println("Not balanced: Expected ), found " + inWord.charAt(i));
							return false;
							
						} else if (stack.isEmpty()) {
								System.out.println("Not balanced: Stack is empty, found " + inWord.charAt(i));
								return false;
							
							
						} else if (!stack.isEmpty() && stack.peek() == '{'){
							System.out.println("Not balanced: Expected }, found " + inWord.charAt(i));
							return false;
							
						} 
							
					
					case '}':
						
						if(!stack.isEmpty() && stack.peek() == '{') {
							stack.pop();
							
						} else if (!stack.isEmpty() && stack.peek() == '('){
							System.out.println("Not balanced: Expected ), found " + inWord.charAt(i));
							return false;
							
						} else if (stack.isEmpty()) {
							System.out.println("Not balanced: Stack is empty, found " + inWord.charAt(i));
							return false;
						
							
						} else if (!stack.isEmpty() && stack.peek() == '['){
							System.out.println("Not balanced: Expected ], found " + inWord.charAt(i));
							return false;
						}
						
						
						
						
						}
		
					} 
				}     
			}
	
			if(stack.isEmpty()) {
				System.out.println("Balanced.");
				return true;
			} else {
				System.out.println("Not balanced: Stack is not empty at end.");
				return false;
				}
		}
	}

		public static void main(String[] args) throws Exception {
			String data = convertFile2String(args[0]);
			balancedExp(data);
	}
}


