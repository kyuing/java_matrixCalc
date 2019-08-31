package matrix_calc;
import java.io.BufferedReader;
import java.io.FileReader;

public class MatrixReader {

	BufferedReader br;
	private String fileName;
	private boolean isValidActualSizeM1;
	private boolean isValidM1;
	private boolean isAllValidM1;
	
	public MatrixReader(String fileName) {
		
		this.fileName = fileName;
		this.isValidActualSizeM1 = false;
		this.isValidM1 = false;
		this.isAllValidM1 = false;
		
	}
	
	public boolean isValidM1() {
		//getter
		return this.isValidM1; 
		
	}
	
	public boolean isAllValidM1() {
		//getter
		if (isValidM1()) {
			
			this.isAllValidM1 = true;
		}
		return this.isAllValidM1; 
		
	}
	
	public boolean isValidActualSizeM1() {
		//getter
		
		return isValidActualSizeM1;
	}
	
	public double[][] read_m1(double[][] matrix1, int m1Row, int m1Col) {
		
		String tempLine = "";	//declare a local level string variable
		String[] line;	//declare a 1D string array variable to store the value of matrix 1 and to determine actual size of column of matrix 1 from the file.

		Boolean m1ActualSizeValidator = new Boolean(fileName);
		Boolean isValidM1 = new Boolean(fileName);
		
		try {	//try-catch is used in case there's error and must be used while reading files. 
			br = new BufferedReader(new FileReader(fileName));	//set br to read from the file path.
			br.readLine();	//skip line 0 (size of matrix)			
			
			if (m1ActualSizeValidator.m1ActualSizeValidator(m1Row, m1Col)) {	//if actual size of matrix1 is equal to the given size,
				
				isValidActualSizeM1 = m1ActualSizeValidator.isValidActualSizeM1();
				
				for (int i=0; i<matrix1.length; i++) {	//rows
					tempLine = br.readLine();	//read row. line 1
	
					if (isValidM1.m1Validator(tempLine)) {	//if matrix 1 is numeric,
						this.isValidM1 = isValidM1.isValidM1();
						
						line = tempLine.trim().split(" ");	//trim and split input
						
						for (int j=0; j<line.length; j++) {	//columns
												
								matrix1[i][j] = Double.parseDouble(line[j]);	//the values converted into numbers are stored in passed_matrix1[i][j]
						}
						
					}else {	//non numeric
						
						System.out.println("\nCheck the input file. Error occured. \nInvalid char or diffence between the given size and the actual size of the matrix");
						this.isValidM1 = isValidM1.isValidM1();
					}				
					
				}
			}else {	//actual size of matrix1 is not equal to the given size
				System.out.println("actual size of matrix 1 does not match with the given row size. Check input file again.");
				isValidActualSizeM1 = m1ActualSizeValidator.isValidActualSizeM1();
			}

		}catch (NumberFormatException nfe) {	//number format is wrong
			System.out.println("invalid input found (empty or non-numeric input.) check the file please.");
			this.isValidM1 = false;
			
		}catch (Exception e) {	//there can be error while reading matrix 1
			System.out.println("\nFile Access Error while reading matrix1. \none of the following could happened: \n*no input found \n*no file nmae with correct extension found \n*file not closed, \n*invalid char, \n*size != actual value of size \nan error from the previous step or \n*Unexpected error.");
			this.isValidM1 = false;
		}
		return matrix1;	//return the value of matrix 1
	}
	
	public void display_m1(double[][] passed_matrix1, int passed_m1Rows, int passed_m1Cols) {
		
		//print matrix 1
		System.out.println("\nMtrix 1 from the the " + fileName + " is: ");
		for (int i=0; i<passed_m1Rows; i++) {
			
			for (int j=0; j<passed_m1Cols; j++) {
				
				System.out.print(passed_matrix1[i][j] + " "); //set space between values
			}
			System.out.println();	//set a new line when a line is displayed
		}
	}
}
