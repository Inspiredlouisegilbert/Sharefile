package com.org.MyFristMavenProjectIT;

public class DemoStringsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Notes:
		//In Java, a string is a sequence of characters. For example, "hello" is a string containing a sequence of characters 'h', 'e', 'l', 'l', and 'o'.
		//Strings in Java are not primitive types (like int, char, etc). Instead, all strings are objects of a predefined class named String.
		//And, all string variables are instances of the String class.
		

	    // create first string
	    //String first = "Hi ";
	    //System.out.println("First String: " + first);
	    
	    // create second
	    //String second = "There";
	    //System.out.println("Second String: " + second);

	    // join two strings
	    //String joinedString = first.concat(second);
	    //System.out.println("Joined String: " + joinedString);
	    
	    // include double quote 
	    //String example = "This is the 'String' class";
	    //Since strings are represented by double quotes, the compiler will treat "This is the " as the string. Hence, the above code will cause an error.
		
	    // compare strings
		// create 3 strings
	    //String first = "java programming";
	    //String second = "java programming";
	    //String third = "python programming";

	    // compare first and second strings
	    //boolean result1 = first.equals(second);
	    //System.out.println("Strings first and second are equal: " + result1);

	    // compare first and third strings
	    //boolean result2 = first.equals(third);
	    //System.out.println("Strings first and third are equal: " + result2);

		//create a string
		//String greet = "Hello! IT Health your client id is: 564564569995";
		//System.out.println("String: " + greet);

		// get the length of greet
		//int length = greet.length();
		//System.out.println("Length: " + length);
		
	    //String Str = new String("Welcome to IT Health");
		//String Str = "Welcome to IT Health";
		//Syntax - public String substring(int beginIndex)
	    //System.out.print("Return Value :" );
	    //System.out.println(Str.substring(10) );
	    //System.out.print("Return Value :" );
	    //System.out.println(greet.substring(36) );
	    
	    //for (statement 1; statement 2; statement 3) {
	    	  // code block to be executed
	    //	}
	    
	    //Statement 1 is executed (one time) before the execution of the code block.

	    //Statement 2 defines the condition for executing the code block.

	    //Statement 3 is executed (every time) after the code block has been executed.

	    //The example below will print the numbers 0 to 4:
	    for(int i=1; i<=7;i++) {
	    	System.out.println(i);
	    }
	    
	    //There is also a "for-each" loop, which is used exclusively to loop through elements in an array:
	    
	    //String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
	    //for (String i : cars) {
	    //  System.out.println(i);
	    //}

	}

}
