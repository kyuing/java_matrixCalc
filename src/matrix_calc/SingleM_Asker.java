package matrix_calc;

import java.util.Scanner;

public class SingleM_Asker extends Asker{
	
	SingleM_Asker() {
	
		super();
	}
	

	@Override
	public int askUserChoice() {
		
		boolean isValidN;	//a local level boolean viable
		int input = 0;	//declare a local level variable and initialize it as 0.
		sc = new Scanner(System.in);	//set scanner to get input from user
		
		do {	//start do-while loop
			System.out.println("___________________________________________________________________________________" 
		+ "\nPick a matrix for scalar multiplication, scalar division or inverse" + "\n1: matrix 1" + "\n2: matrix 2");	//prompt it
			
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
}
