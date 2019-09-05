package matrix_calc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Asker {

	BufferedReader br;
	Scanner sc;
	
	Asker() {
		
	}
	
	public String askUserMenu() {
		
		boolean isValidOption;	//menu selection in constructor only works when input is true.
		String input = "";	//declare a string local level string variable and initialize it as ""
		br = new BufferedReader(new InputStreamReader(System.in));	//set br to read input from user
		
		do {//start do-while loop
			
			System.out.println("\n############################################################################"
					+ "\n(Note that if you want to read your own file, \n SHOULD you put your own text file in the same folder in advance)\n"
					+ "\nEnter an option number for matrix calcuation. The options will be as follows: "
					+ "\n1: Add two matrices" + "\n2: Subtract Matrices"
					+ "\n3: Scalar Multiplication of a Matrix (or Multiply a matrix by an Integer)"
					+ "\n4: Multiply two matrices" + "\n5: Scalar Division"
					+ "\n6: Calculate the Reciprocal (or Inverse)"
					+ "\nOtherwise, Enter 'quit' to exit the program.");	//prompt menu options to user
			try {// try-catch is used in case if there's error 
				input = br.readLine();	//read line and stored the value into the variable input
				if (input.matches("[1|2|3|4|5|6]") || input.equalsIgnoreCase("quit")) {	//if user input is valid when one of exact 1, 2, 3, 4, 5, 6 and quit is entered only 

					//valid input
					isValidOption = true;
					
				}else {
					//wrong input
					System.out.println("Input MUST be one of exact '1', '2', '3', '4', '5', '6' and 'quit'. Try again.");
					isValidOption = false;
				}
			} catch (IOException e) {

				//only the given input is allowed.
				System.out.println("Please choose one of the options given. Try again.");
				isValidOption = false;
			} 
		} while (!isValidOption);	// do-while keeps going while input option is invalid. 
		
		return input;	// return valid input ONLY.
		
	}
	
	public String askuserFileNameInput() {
		
		String input = "";	//a local level string variable and initialize as null
		sc = new Scanner(System.in);	//set scanner
//		sc.reset();
		
			System.out.println("\nCAREFULLY ONLY enter file name EXCEPT extension that you would like to read \n(note that if you do want to read your own txt file, you should put your file in the same folder in advance)");	//prompt .txt file options
			
			try {//try-chatch in case there error
				input = sc.nextLine();	//read input
		
				
			}catch (Exception ee) {//catch unexpected error.
				
				System.out.println("carefully check input condition please.");
				return null;
			}
		return input.trim();	//return input
	}
	
	public String selecet_input() {
		
		boolean isValidNum = false;
		String input = null;	//a local level string variable and initialize as null
		sc = new Scanner(System.in);	//set scanner
//		sc.reset();
		
		do {		//do	
			System.out.println("___________________________________________________________\nIt is thought that you are given FOUR sample .txt files: \n*REMEMBER that the input files MUST be in the same folder*"
			 		+ "\n\nChoose a file you would like to read:"
			 		+ "\n1: matrix.txt (valid 2X2) \n2: matrix2.txt (valid 3X3) \n3: invalidFile.txt (a character in matrix) \n4: invalidFile2.txt (wrong match between size and actual size) \n5: Otherwise, type a file name manually");;	//prompt .txt file options
			
			try {//try-chatch in case there error
				input = sc.nextLine();	//read input
				 
					if (input.matches("^[1-5]$")) {	//if matches,
					
					isValidNum = true;
					}else {	//not matched
						
						System.out.println("enter 1, 2, 3, 4 or 5 ONLY");
						isValidNum = false;
					}
			}catch (Exception e) {//chatch erros expected.
				
				System.out.println("input is not numeric or is not 1 though 5.");
				isValidNum = false;
			}
		}while (!isValidNum); //while input is not one of 1-5
		return input.trim();	//return input
	}
	
	public int askUserChoice() {
		
		boolean isValidN;	//a local level boolean viable
		int input = 0;	//declare a local level variable and initialize it as 0.
		sc = new Scanner(System.in);	//set scanner to get input from user
		
		do {	//start do-while loop
			System.out.println("\n" + "_______________________________________________________________________\nenter one of two choices below to output the result to a file: \n1: output to a file named answer.txt "
					+ "\n\n(NOTE that answer.txt will contain ONLY one current result of any calculation "
					+ "\nthat means, if the program keeps calcualting after a calculation, \nthe previous answer stored will be replaced with a current result of any calulation."
					+ "\n\nIf you wanted to have a specified result file each, \nit is recommended to choose an option below so that an output can be stored individually)"
					+ "\n\n2: output to a file with the a file name specified individually");	//prompt it
			try {
				input = sc.nextInt();	//scan the input.
				if ((input == 1) || (input == 2)) { //if input is either 1 or 2,
					
					isValidN = true;	//number input is valid.
					
				}else {	//wrong input
										
					isValidN = false;
				}				
			} catch (Exception e) {
				//display error message. it is possible to get any error. 
				System.out.println("Input must be numeric and Only either 1 or 2 is allowed. try again");	//invalid number
				isValidN = false;	//number input is invalid.
				String pass = sc.nextLine();	
				//if variable type is int, its function of is to skip invalid string-based input to keep asking a valid number input from user(it happens sometimes) one by one loop.
				//without this line, do-while loop might never stop. 
			} 
		} while (!isValidN);	//do-while loop keeps going while input is not valid input.
		
		return input;	//return a numeric value only.
	}
	
	public double askUserN(String promptN) {
		
		boolean isValidN;	//a calculation with a n input from user only works in constructor when input is true.
		String input = "";	//a local level string variable
		double numInput = 0;	//declare a local level variable and initialize it as 0.
		sc = new Scanner(System.in);	//set scanner to get input from user
		
		do {	//start do-while loop
			System.out.println("\n" + promptN);	//prompt it
			try {
				input = sc.nextLine();	//scan the input.
				
				if (input.matches("^\\-?\\d+\\.?\\d*$") && (!input.matches("[a-zA-Z]++")))  { //if positive, negative,  a number or decimal,{	//0	
					if (!input.matches("^\\-?[0|0+]\\.?[0]*$")) {	//if not any zero,
		 	
						isValidN = true;
						
					}else {
						System.out.println("0 can not be a multiplicand or a divisor. Otherwise, wrong inpyt format found  try again");
						isValidN = false;	//number input is valid.					
					}				
				}else {
					
					System.out.println("non-numeric found, \nthere is still 0-related input \nOR, unnecessary 0 paddings more than ONE 0 before decimal found.\nex) 01.1 = 1.1 \n\ntry again");
					isValidN = false;
				}
			}catch (Exception e) {
				//display error message. it is possible to get any error. 
				System.out.println("Unexpected error occured. try again");
				isValidN = false;	//number input is invalid.
				String pass = sc.nextLine();	
				//it is not in use as the program works well.
				//if variable type is int or double, its function of is to skip invalid string input to keep asking a valid number input from user(it happens sometimes) one by one loop.
				//without this line, do-while loop might never stop. 
				//(here, loop goes with string variable and then its parsed)
			} 
		} while (!isValidN);	//do-while loop keeps going while input is not valid input.
		numInput = Double.parseDouble(input);	//convert string value into double
		return numInput;	//return a numeric value only.
	}
}
