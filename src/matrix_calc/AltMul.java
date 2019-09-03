package matrix_calc;

public class AltMul extends Calc_manager{

	AltMul(double[][] operator, double[][] matrix1, double[][] matrix2, int m1Row, int m2Row, int m2Col) {
		
		super(operator, matrix1, matrix2, m1Row, m2Row, m2Col);
	}
	
	@Override
	public double[][] calc() {
		
		//calc multiplication		
		for (int i=0; i<m1Row; i++) {	//set rows
			
			for (int j=0; j<m2Col; j++) {	//set columns
				
				for (int k=0; k<m2Row; k++) {
					// k nested for loop = inside j nested for loop = inside i for loop
					// k is a column of passed_matrix1, while it is also a row of passed_matrix2 so that the product of multiplication of two matrices can be done. 
					operator[i][j] += this.matrix1[i][k] * this.matrix2[k][j];
					//useful to check iterations: System.out.println(i + ",  "+ j +",  " +  k+ ",  " + passed_matrix1[i][k]+ ",  " + passed_matrix2[k][j]+",  " + passed_multiplication[i][j] + "\n");
				}
			} 
		}	
		
		
		//display result
		System.out.println("\nthe column size of matrix 1 and the row size of matrix 2 are the same.\nAlternative multiplication of the two matrices is: ");
		for (int i=0; i<m1Row; i++) {
					
			for (int j=0; j<m2Col; j++) {
						
				System.out.print(String.format("%.2f", operator[i][j]) + " ");	
			}
		System.out.println();	// a new line when a line is displayed.
		}			
		
		return this.operator;
	}
}
