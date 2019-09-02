package matrix_calc;

import java.io.BufferedReader;
import java.io.FileReader;

public class MatrixReader2 {

	BufferedReader br;
	private String fileName;
	private boolean isValidActualSizeM2;
	private boolean isValidM2;
	private boolean isAllValidM2;
	
	public MatrixReader2 (String fileName) {
		
		this.fileName = fileName;
		this.isValidActualSizeM2 = false;
		this.isValidM2 = false;
		this.isAllValidM2 = false;
		
	}
	
	public boolean isValidM2() {
		//getter
		return this.isValidM2; 
		
	}
	
	public boolean isAllValidM2() {
		//getter
		if (isValidM2()) {
			
			this.isAllValidM2 = true;
		}
		return this.isAllValidM2; 
		
	}
	
	public boolean isValidActualSizeM2() {
		//getter
		
		return isValidActualSizeM2;
	}
	
	public double[][] read_m2(double[][] matrix2, int m2Row, int m2Col) {
		
		String skipLine, tempLine = "";	//declare local level string variables
		String[] line;	//declare a 1D string array variable to store the value of matrix 2 and to determine actual size of column of matrix 2 from the file.
		
		Boolean m2ActualSizeValidator = new Boolean(fileName);
		Boolean isValidM2 = new Boolean(fileName);
		
		try {	//try-catch is used in case there's error and must be used while reading files. 
			br = new BufferedReader(new FileReader(fileName));	//set br to read from the file path.
			
			if (m2ActualSizeValidator.m2ActualSizeValidator(m2Row, m2Col)) {		//if actual size of matrix2 is equal to the given size,
				
				isValidActualSizeM2 = m2ActualSizeValidator.isValidActualSizeM2();	//return true
				
				while ((skipLine = br.readLine()) != null)  {	//while br is not null
					if (skipLine.equals("@")) {	//if skipLine is equal to @
						br.readLine();	//skip size of matrix 2
									
						for (int i=0; i<matrix2.length; i++) {	//rows
							tempLine = br.readLine();	//read rows of matrix 2
		
							if (isValidM2.m2Validator(tempLine)) {	//if matrix 2 is numeric
								this.isValidM2 = isValidM2.isValidM2();		//return true
							
								line = tempLine.trim().split(" ");	//trim and split input and then store value to the variable line
								
								for (int j=0; j<line.length; j++) {	//columns
									
									matrix2[i][j] = Double.parseDouble(line[j]);	//the values converted into numbers are stored in passed_matrix1[i][j]						
								}
								
							}else {
									//matrix 2 is not numeric
									System.out.println("\nCheck the input file. Error occured. \nInvalid char or diffence between the given size and the actual size of the matrix");
									this.isValidM2 = isValidM2.isValidM2();
									break;	//terminate for loop
								}
									
							}
							
						}						
					}					
			}else {	//actual size of matrix1 is not equal to the given size
				System.out.println("actual size of matrix 2 does not match with the given row size. Check input file again.");
				isValidActualSizeM2 = m2ActualSizeValidator.isValidActualSizeM2();
			}		
		}catch (NumberFormatException nfe) {	//there is wrong number format from input
			// if non numeric input is found by unexpected size of value while reading. the program is hard coded so its very fussy when finding difference between the given size and the actual value as reading lines is very prefixed.
			System.out.println("failed to convert the input into a number while reading matrix 2. check the file");
			this.isValidM2 = false;
		}catch (Exception e) {	//there can be any error
			System.out.println("\nFile Access Error while reading matrix2. \none of the following could happened: \n*no input found \n*no file nmae with correct extension found \n*file not closed, \n*invalid char, \n*size != actual value of size \nan error from the previous step or \n*Unexpected error.");
			this.isValidM2 = false;
		}
		return matrix2;	//return value of matrix 2
	}
	
	public void display_m2(double[][] matrix2, int m2Rows, int m2Cols) {
		
		//print matrix 1
		System.out.println("\nMtrix 2 from the the " + fileName + " is: ");
		for (int i=0; i<m2Rows; i++) {
			
			for (int j=0; j<m2Cols; j++) {
				
				System.out.print(matrix2[i][j] + " "); //set space between values
			}
			System.out.println();	//set a new line when a line is displayed
		}
	}
}
