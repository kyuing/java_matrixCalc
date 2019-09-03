package matrix_calc;

public class Mul extends Calc_manager {
	
	Mul(double[][] operator, double[][] matrix1, double[][] matrix2) {
		
		super(operator, matrix1, matrix2);
	}
	
	@Override
	public double[][] calc() {
		
		//calc multiplication		
		for (int i=0; i<this.matrix1.length; i++) {	//set rows
			
			for (int j=0; j<this.matrix1[i].length; j++) {	//set columns
				
				for (int k=0; k<this.matrix1[i].length; k++) {
					// k nested for loop = inside j nested for loop = inside i for loop
					// k is a column of passed_matrix1, while it is also a row of passed_matrix2 so that the product of multiplication of two matrices can be done. 
					operator[i][j] += this.matrix1[i][k] * this.matrix2[k][j];
					//useful to check iterations: System.out.println(i + ",  "+ j +",  " +  k+ ",  " + passed_matrix1[i][k]+ ",  " + passed_matrix2[k][j]+",  " + passed_multiplication[i][j] + "\n");
				}
			} 
		}	
		
		
		//display result
		System.out.println("\nMultiplication of the two matrices is: ");
		for (int i=0; i<this.matrix1.length; i++) {
					
			for (int j=0; j<this.matrix1[i].length; j++) {
						
				System.out.print(String.format("%.2f", operator[i][j]) + " ");	//display sum with a space between value round to two decimal place
			}
		System.out.println();	// a new line when a line is displayed.
		}			
		
		return this.operator;
	}

}
