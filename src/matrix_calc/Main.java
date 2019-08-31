package matrix_calc;

public class Main {

	String fileName = null, menu;
	int m1Row, m1Col, m2Row, m2Col;
	double[][] matrix1, matrix2;
	Asker menuAsker = new Asker();
	Input fileInput = new Input(); 
	
	public Main() {
		

//		Boolean booleanSelector1 = new Boolean();
		
		do { //do
			menu = menuAsker.askUserMenu();	//prompt and ask calculation options to user and return user input to the variable menu  
				
			 if (menu.matches("([1-6])")) {	

				 //read matrix 1
				 fileName = fileInput.fileSelector();
				 SizeReader m1SizeReader = new SizeReader(fileName);
//				 Boolean booleanSelector1 = new Boolean(fileName);
				 m1Row = m1SizeReader.readRow();
				 m1Col = m1SizeReader.readCol();
				 
				 if (m1SizeReader.isValidSizeM1()) {
					 
					 matrix1 = new double [m1Row][m1Col];
					 MatrixReader m1Reader = new MatrixReader(fileName);
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
					 MatrixReader2 m2Reader = new MatrixReader2(fileName);
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
				 
			 }else {
				 System.out.println("Bye Bye");
			 }
		}/* end of do loop */ while (!menu.equalsIgnoreCase("quit"));	//end of while condition.
		
	}
	
	public static void main(String[] args) {
		
		new Main();
	}
}
