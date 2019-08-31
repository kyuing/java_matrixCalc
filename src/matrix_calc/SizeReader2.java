package matrix_calc;

import java.io.BufferedReader;
import java.io.FileReader;

public class SizeReader2 {
	
	BufferedReader br;
	private String fileName;	
	private boolean isValidRow;
	private boolean isValidCol;
	private boolean isValidSizeM2;
	
	public SizeReader2(String fileName) {
		
		this.fileName = fileName;
		this.isValidRow = false;
		this.isValidCol = false;
		this.isValidSizeM2 = false;
	}
	
	public boolean isValidRow() {
		//boolean getter
		return this.isValidRow;
	}
//	
	public boolean isValidCol() {
		//boolean getter
		return this.isValidCol;
	}
	
	public boolean isValidSizeM2() {
		//boolean setter
		if ((isValidRow()) && (isValidCol())) {
		
		this.isValidSizeM2 = true;
		
		}
		return this.isValidSizeM2;
	}	
	
	public int readRow() {
		
		String skipLine, tempLine = null;	//a local level string variable
		String[] input = null;	//declare a 1D string array variable to store the size of matrix 1 from the file.
		int inputToReturn = 0;	//declare an integer variable to return the row size

		Boolean rowValidator2 = new Boolean(fileName);
		try {	//need try-catch for reading file
		
			br = new BufferedReader(new FileReader(fileName)); //set br to read from the file path.
			while ((skipLine = br.readLine()) != null)  {	//while br is not null
				if (skipLine.equals("@")) {	//if skipLine reads @
					tempLine = br.readLine();	//read size
					System.out.println("________________________________________________________________________");
					System.out.println("\nThe size read on a line of matrix 2 is: " + tempLine);
					break;	//break while loop
				}
			}
				input = tempLine.trim().split(" "); //trim and split input
				
				if (rowValidator2.rowValidator(input)) {
						//input is numeric and return true
					isValidRow = rowValidator2.isValidRow();				
						
						for (int i=0; i<input.length; i++) {
							//store row size and column size using loop
							
						}
						
						System.out.println("\nRow size of the matrix 2 stored from " + fileName + " is: " + input[0]);	//print row size	
						inputToReturn = Integer.parseInt(input[0]);	//convert a string-based number in the input array into an actual number.
										
				}else {	// input is not numeric
						System.out.println("Check the input file. Error occured. \nInvalid intput while reading the given size of matrix2 \nOR, diffence between the given size and the actual size of the matrix possibly found from the previous step.");
						isValidRow = rowValidator2.isValidRow();
				}			
			
		} catch (NumberFormatException nfe) {	//input has wrong number format
			// if non numeric input is found by unexpected size of value while reading. the program is hard coded so its very fussy when finding difference between the given size and the actual value as reading lines is very prefixed.
			System.out.println("failed to convert the input into a number while reading row size of matrix 2. check the file");
			isValidRow = false;
		}catch (Exception e) {	//error can happen
			//there can be no more input after reading the first matrix or any other possible error as below
			System.out.println("\nFile Access Error while reading row size of matrix2. \none of the following could happened: \n*no input found \n*no file nmae with correct extension found \n*file not closed, \n*invalid char, \n*size != actual value of size \nan error from the previous step or \n*Unexpected error.");
			isValidRow = false;
		}		
		return inputToReturn;	//return row size
	}
	
	public int readCol() {
		
		String skipLine, tempLine = null;	//local level string variables	
		String[] input = null;	//declare a 1D string array variable to store the size of matrix 1 from the file. initialize it as null
		int inputToReturn = 0;	//declare an integer variable to return the column size. initilaize it as 0

		Boolean colValidator2 = new Boolean(fileName);
		
		try {	//need try-catch for errors 
			br = new BufferedReader(new FileReader(fileName));	//set br to read from the file path.
			while ((skipLine = br.readLine()) != null)  {	//while br is not null
				if (skipLine.equals("@")) { 	//if skipLine reads @
					tempLine = br.readLine();	//read size
					System.out.println("\nThe size read on a line of matrix 2 is: " + tempLine);
					break;	//break while loop
				}
			}	
			input = tempLine.trim().split(" ");	//trim and split inpyt
			
			if (colValidator2.colValidator(input)) {	//if column of matrix 2 is not valid
				
					isValidCol = colValidator2.isValidCol();	
					
					for (int i=0; i<input.length; i++) {
						//store row size and column size using loop
					}
					
					System.out.println("\nColumn size of the matrix 2 stored from " + fileName + " is: " + input[1]);	//print row size	
					inputToReturn = Integer.parseInt(input[1]);	//convert a string based number in the input array into an actual number.
									
			}else {	//input is not numeric
				System.out.println("Wrong reading of row size of matrix 2");
				isValidCol = colValidator2.isValidCol();
			}		
		}catch (NumberFormatException nfe) {	//input has wrong number format
			// if non numeric input is found by unexpected size of value while reading. the program is hard coded so its very fussy when finding difference between the given size and the actual value as reading lines is very prefixed.
			System.out.println("failed to convert the input into a number while reading column size of matrix 2. check the file");
			isValidCol = false;
		}catch (Exception e) { 	//there can be error
				//there can be no more input after reading the first matrix or any otehr possible error as below
			System.out.println("\nFile Access Error while reading column size of matrix2. \none of the following could happened: \n*no input found \n*no file nmae with correct extension found \n*file not closed, \n*invalid char, \n*size != actual value of size \nan error from the previous step or \n*Unexpected error.");
			isValidCol = false;
			}
		return inputToReturn;		//return column size
	}

}
