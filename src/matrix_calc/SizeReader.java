package matrix_calc;
import java.io.BufferedReader;
import java.io.FileReader;

public class SizeReader {
	
	BufferedReader br;
	private String fileName;
	
	private boolean isValidRow;
	private boolean isValidCol;
	private boolean isValidSizeM1;
	protected boolean isValidActualSizeM1;
	
	
	public SizeReader(String fileName) {
		
		this.fileName = fileName;
		this.isValidRow = false;
		this.isValidCol = false;
		this.isValidSizeM1 = false;
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
	
	public boolean isValidSizeM1() {
		//boolean setter
		if ((isValidRow()) && (isValidCol())) {
		
		this.isValidSizeM1 = true;
		
		}
		return this.isValidSizeM1;
	}	
	
//	public boolean isValidActualSizeM1() {
//		//boolean getter		
//		return this.isValidActualSizeM1; 
//	}
	
	
	public int readRow() {
		
		String tempLine = "";	// a local level string variable 
		String[] input = null;	//declare a 1D string array variable to store the size of matrix 1 from the file.
		int inputToReturn = 0;	//declare a variable and initialize it as 0
		
		Boolean rowValidator = new Boolean(fileName);
		try {	//need try-catch for reading file		
			br = new BufferedReader(new FileReader(fileName));	//set br to read from the file path.			
			
			tempLine = br.readLine();	// read line 0
			System.out.println("\nThe size of matrix 1: " + tempLine);
			
			input = tempLine.trim().split(" ");	//get the line splited using .split() and store in into input[]	
			
			if (rowValidator.rowValidator(input)) {	//if row of matrix 1 is not valid

				isValidRow = rowValidator.isValidRow();
//				isValidRow = true;
			
					for (int i=0; i<input.length; i++) {
						//store row size and column size using for loop
					}
					System.out.println("Row size of the matrix 1 stored from " + fileName + " is: " + input[0]);	//print row size
					inputToReturn = Integer.parseInt(input[0]);	//convert a string-based number of the input array into an actual number.
					
			}else {	//valid row of matrix 1
				
				System.out.println("Wrong reading of row size of matrix 1");
				isValidRow = rowValidator.isValidRow();
//				isValidRow = false;
			}						
		}catch (NumberFormatException nfe) {
			//its possible that there is an other input than numbers in the file.
			System.out.println("\nnon-numeric input found while reading row size of matrix 1. check the file input.");
			isValidRow = false;
			
		}catch (Exception e) {	//there can be error while reading input matrix 1
			System.out.println("\nFile Access Error while reading row size of matrix1. \none of the following could happened: \n*no input found \n*no file nmae with correct extension found \n*file not closed, \n*invalid char, \n*size != actual value of size \nan error from the previous step or \n*Unexpected error.");
			isValidRow = false;
		}
		return inputToReturn;		//return the row size
	}
	
	public int readCol() {
		String tempLine = "";	// a local level string variable 
		String[] input = null;	//declare a 1D string array variable to store the size of matrix 1 from the file.
		int inputToReturn = 0;	//declare a variable and initialize it as 0 

		Boolean colValidator = new Boolean(fileName);
		
		try {	//need try-catch for reading file		
			br = new BufferedReader(new FileReader(fileName));	//set br to read from the file path.			
			
			tempLine = br.readLine();	// read line 0
			System.out.println("\nThe size of matrix 1: " + tempLine);
			
			input = tempLine.trim().split(" ");	//get the line splited using .split() and store in into input[]
			
			if (colValidator.colValidator(input)) {	//if row of matrix 1 is not valid

				isValidCol = colValidator.isValidCol();
				isValidCol = true;
			
					for (int i=0; i<input.length; i++) {
						//store row size and column size using for loop
					}
					System.out.println("Column size of the matrix 1 stored from " + fileName + " is: " + input[1]);	//print row size
					inputToReturn = Integer.parseInt(input[1]);	//convert a string-based number of the input array into an actual number.
					
			}else {	//valid row of matrix 1
				
				System.out.println("Wrong reading of column size of matrix 1");
				isValidCol = colValidator.isValidCol();
				isValidCol = false;
			}						
		}catch (NumberFormatException nfe) {
			//its possible that there is an other input than numbers in the file.
			System.out.println("\nnon-numeric input found while reading column size of matrix 1. check the file input.");
			isValidCol = false;
			
		}catch (Exception e) {	//there can be error while reading input matrix 1
			System.out.println("\nFile Access Error while reading column size of matrix1. \none of the following could happened: \n*no input found \n*no file nmae with correct extension found \n*file not closed, \n*invalid char, \n*size != actual value of size \nan error from the previous step or \n*Unexpected error.");
			isValidCol = false;
		}
		return inputToReturn;		//return the row size
	}

}
