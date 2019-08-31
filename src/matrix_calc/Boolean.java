package matrix_calc;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Boolean {

	Scanner sc;
	private String fileName;
	private boolean isValidRow;
	private boolean isValidCol;
//	private boolean isValidSizeM1;
	private boolean isValidActualSizeM1;
	private boolean isValidM1;
	protected boolean isAllValidM1;
	
	
//	public Boolean() {
//		
//		this.isValidRow = false;
//		this.isValidCol = false;
//		this.isValidM1 = false;
//		
//		
//	}
	public Boolean (String fileName) {
		
		this.isValidRow = false;
		this.isValidCol = false;
		this.isValidM1 = false;
		this.fileName = fileName;
//		this.isValidSizeM1 = false;
		this.isValidActualSizeM1 = false;
//		this.isAllValidM1 = false;
		
	}
	
	public boolean isValidRow() {
		//boolean getter
		return this.isValidRow;
	}
	
	public boolean isValidCol() {
		//boolean getter
		return this.isValidCol;
	}
	
	public boolean isValidActualSizeM1() {
		//boolean getter		
		return this.isValidActualSizeM1; 
	}
	
	public boolean isValidM1() {
		//boolean getter		
		return this.isValidM1; 
	}
	
	public boolean rowValidator(String[] passed_input) {
		
		if ((passed_input.toString() != null)) { //if not null
			if ((passed_input[0].toString().matches("[0-9+]")) || !(passed_input[0].toString().matches("[\\D+]++"))) {	//if numeric
				//row size input is numeric return true
				
			this.isValidRow = true;	//set a new value
			return this.isValidRow;
			
			}else {
				System.out.println("string or charactor found in row size of matrix 1");
				return false;
			}
		}else {
			System.out.println("unxpected error happened. null can be retunred");
			return false;
		}
	}
	
	public boolean colValidator(String[] passed_input) {
		
		if ((passed_input.toString() != null)) { //if not null
			if ((passed_input[1].toString().matches("[0-9+]")) || !(passed_input[1].toString().matches("[\\D+]++"))) {	//if numeric
				//row size input is numeric return true
				
			this.isValidCol = true;	//set a new value
			return this.isValidCol;
			
			}else {
				System.out.println("string or charactor found in row size of matrix 1");
				return false;
			}
		}else {
			System.out.println("unxpected error happened. null can be retunred");
			return false;
		}
	}
	
	public boolean m1ActualSizeValidator(int passed_m1Rows, int passed_m1Cols) {
		
		String a_line = "";	//a local level string variable 
		String[] tempCol = null;	//a local level an array variable
		int actualMatrixSizeCounter = 0;	//initialize it as 0
		
				try {	//try-catch in case there is errors
					sc = new Scanner(new FileReader(fileName));	//set scanner to read from the file path.
					
					sc.nextLine();	// skip the given size
					
					while (!(a_line = sc.nextLine()).equals("@")) {	//while input is not @,

						actualMatrixSizeCounter++;	//check actual row size: count rows
						tempCol = a_line.trim().split(" ");	//check actual column size: trim and split input
					}
				} catch (Exception e) {	//error can happen
					System.out.println("\nerror found while checking actual size of matrix 1");
				}				
				
				if ((actualMatrixSizeCounter != passed_m1Rows) || (tempCol.length != passed_m1Cols)){	//if actual row size or column size is not equal to the given size
					
					System.out.println("either actual row size or column size of matrix 1 does not match with the given size.");
					return false;	//return false
					
				}else {	
					
					this.isValidActualSizeM1 = true;
					return this.isValidActualSizeM1;
				}
		
	}
	
	public boolean m1Validator(String passed_tempLine) {	
		
		String pattern_general, pattern_2X2, pattern_3X3;	//local level string variables
		pattern_general = "([\\-?\\d+\\.?\\d+?\\s?])+";	//(-) numeric, decimal
		pattern_2X2 = "^\\-?\\d+\\.?\\d+?\\s\\-?\\d+\\.?\\d+?$";	//(-) numeric, decimal 2 2 size
		pattern_3X3 = "^\\-?\\d+\\.?\\d+?\\s\\-?\\d+\\.?\\d+?\\s\\-?\\d+\\.?\\d+?$";	//(-) numeric, decimal 3 3 size
		
		boolean _general = Pattern.matches(pattern_general, passed_tempLine);	//set pattern of general
		boolean _2X2 = Pattern.matches(pattern_2X2, passed_tempLine);	//set pattern of 2 2
		boolean _3X3 = Pattern.matches(pattern_3X3, passed_tempLine);	//set pattern of 3 3
		
			if ((_general == true) || (_2X2 == true) || (_3X3 == true)) {	//if one of those true,
				
				this.isValidM1 = true;
				return this.isValidM1;	//return true

			}else {	//false 
				System.out.println("\ninvalid input Found from matrix 1 (most like charactor)");
				return false;
			}
	}
}
