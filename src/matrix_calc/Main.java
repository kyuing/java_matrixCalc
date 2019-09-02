package matrix_calc;

public class Main {

	private String fileName = null, menu;
	private int m1Row, m1Col, m2Row, m2Col;
	private double[][] matrix1, matrix2, addition;
	private Asker menuAsker = new Asker();
	private Input fileInput = new Input();
	private MatrixReader m1Reader ;
	private MatrixReader2 m2Reader;
	private boolean isFinalM1;
	private boolean isFinalM2;
	private Boolean isAllValidM;
		
	public Main() {
		
		try {
					
			do { //do
				
				menu = menuAsker.askUserMenu();	//prompt and ask calculation options to user and return user input to the variable menu
				
				boolean isAllvalidMLocal;
					
				 if (menu.matches("([1-6])")) {
					 
//					 fileName.

					 //read matrix 1
					 fileName = fileInput.fileSelector();
					 SizeReader m1SizeReader = new SizeReader(fileName);
//					 Boolean booleanSelector1 = new Boolean(fileName);
					 m1Row = m1SizeReader.readRow();
					 m1Col = m1SizeReader.readCol();
					 
					 if (m1SizeReader.isValidSizeM1()) {
						 
						 matrix1 = new double [m1Row][m1Col];
						 m1Reader = new MatrixReader(fileName);
						 m1Reader.read_m1(matrix1, m1Row, m1Col);
						 
						 if (m1Reader.isValidM1()) {

							 if (m1Reader.isAllValidM1()) {

								 m1Reader.display_m1(matrix1, m1Row, m1Col);	//display matrix 1 by calling display_m1(matrix1, m1Rows, m1Cols) method
								 
							 }else {
								 System.out.println("matrix is not valid in final");
								 m1Reader.isAllValidM1();
							 }
							 
							 
						 }else {
							 System.out.println("matrix is not valid");
							 m1Reader.isValidM1();
						 }
						 
					 }else {	//matrix 1 is not valid input								
						System.out.println("\nsize error found in matrix 1. ");
						m1SizeReader.isValidSizeM1();
						}
					 
					 //read matrix 2 
					 SizeReader2 m2SizeReader = new SizeReader2(fileName);
					 m2Row = m2SizeReader.readRow();
					 m2Col = m2SizeReader.readCol();
					 
					 if (m2SizeReader.isValidSizeM2()) {
						 
						 matrix2 = new double [m2Row][m2Col];
						 m2Reader = new MatrixReader2(fileName);
						 m2Reader.read_m2(matrix2, m2Row, m2Col);
						 
						 if (m2Reader.isValidM2()) {

							 if (m2Reader.isAllValidM2()) {

								 m2Reader.display_m2(matrix2, m2Row, m2Col);	//display matrix 1 by calling display_m1(matrix1, m1Rows, m1Cols) method
								 
							 }else {
								 System.out.println("matrix is not valid at final level");
								 m2Reader.isAllValidM2();
							 }
							 
							 
						 }else {
							 System.out.println("matrix is not valid");
							 m2Reader.isValidM2();
						 }
						 
					 }else {	//matrix 2 is not valid input								
						System.out.println("\nsize error found in matrix 2. ");
						m2SizeReader.isValidSizeM2();
						}
					 
					 				 
					//processing; calculation
					 try {
					
						 //why try-catch with nullPointerException needs to be used here is;
						 //we are about to start a two matrices calculation.
						 //any input having nothing or having only one matrix input in a file should be filtered (thrown exception) before moving out to the calculation. 
						
						 if ((m1SizeReader.isValidSizeM1()) && (m2SizeReader.isValidSizeM2()) ) {
							 
							 isFinalM1 = m1Reader.isAllValidM1();
							 isFinalM2 = m2Reader.isAllValidM2();
							
							 if ((isFinalM1) && (isFinalM2)) {
									isAllValidM = new Boolean(isFinalM1, isFinalM2);
									isAllvalidMLocal = isAllValidM.isAllValidM();
								
									if (menu.equals("1")) {
										//addition
										this.addition = new double[this.m1Row][this.m1Col];	//no matter assigning m1row or m2col or so because size must be the same for addition 
										Add add = new Add(this.addition, this.matrix1, this.matrix2);
										this.addition = add.calc();
										Writer addWriter = new Writer(this.addition);
										addWriter.writer();
																		
									} else if (menu.equals("2")) {
										//addition
										System.out.println("subtraction goes here");																		
									}
									
								}else {
									System.out.println("Cant not carry out addition, subtraction due to invalid input issue. try again");
									isAllvalidMLocal = isAllValidM.isAllValidM();
								}
							 
						 }else {
							 //this program is designed to keep asking the menu once any value is invalid at each step of level.
							 //however, the program does remember the value of an instance.
							 //For example,
							 //    while reading file1, error is at isFinalM1 = m1Reader.isAllValidM1(); and isFinalM1 is true. the instance m1Reader is based on the file1
							 // -> do-while loop runs and prompt menu
							 // -> file2 is selected and it is stored into the instance m1SizeReader. the instance m1SizeReader is based on file2
							 // -> let's say the instance m1SizeReader found an error from file2 and does not move out to any further step to get a new value for the instance m1Reader.
							 // -> the program keeps going and do something to read matrix 2
							 // -> now, look at isFinalM1 = m1Reader.isAllValidM1(); the instance m1Reader is STILL based on the file1, not file2 since m1Reader hasn't got any new value since then. 
							 System.out.println("the final matrix valiation is failed.");
							 isAllvalidMLocal = false;
						 }
					 }catch (NullPointerException npe) {
						 System.out.println("the current file does not have proper input, have input partly or have nothing. check the file again or choose another file");
					 }
				 }else {
					 System.out.println("Bye Bye");
				 }
//			}/* end of do loop */ while ((!menu.equalsIgnoreCase("quit") || (this.isFinalM1 == false) || ((this.isFinalM2 == false)) ) );
			}/* end of do loop */ while ((!menu.equalsIgnoreCase("quit")  ) );	//end of while condition.	
			
		}catch (Exception e) {
			System.out.println("Error found in the program.");
		}
	}
	
	public static void main(String[] args) {
		
		new Main();
	}
}
