package java2;

import java.util.Properties;

public class HelloWorldClass {

public static void main (String[] args) {
		
		System.out.println("Hello World");
		
		Properties jvm = System.getProperties();
		jvm.list(System.out);
	}

}


