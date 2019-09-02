package matrix_calc;

public class Add extends Calc_manager {
	
	
	Add(double[][] addition, double[][] matrix1, double[][] matrix2) {
		
		super(addition, matrix1, matrix2);
	}
	
	@Override
	public double[][] calc() {
		
		//calc addition
		for (int i=0; i<this.matrix1.length; i++) {
					
			for (int j=0; j<this.matrix1[i].length; j++) {
						
				addition[i][j] = this.matrix1[i][j] + this.matrix2[i][j];  //do addition
			}	
		}
		
		
		//display result
		System.out.println("\nSum of the two matrices is: ");
		for (int i=0; i<this.matrix1.length; i++) {
					
			for (int j=0; j<this.matrix1[i].length; j++) {
						
				System.out.print(String.format("%.2f", addition[i][j]) + " ");	//display sum with a space between value round to two decimal place
			}
		System.out.println();	// a new line when a line is displayed.
		}			
		
		return this.addition;
	}

}
