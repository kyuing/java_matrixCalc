package matrix_calc;

public class ScDiv extends ScMul{
	
	private double n;
	
	ScDiv(double[][] operator, double[][] singleMatrix) {
		
		super(operator, singleMatrix);
		this.n = 0;
	}
	
	public double getN() {
		//getter
		return this.n;
	}
	
	@Override
	public double[][] calc() {
		
		Asker nAsker = new Asker();
		n = nAsker.askUserN("Enter a number for scalar division");
		
		if (n != 0) {
			//Scalar division is computed by multiplying the reciprocal of the number you want to divide by.
			// formula: m / n => 1 / n * m => 1 / n * |matrix|
			for (int i=0; i<this.singleMatrix.length; i++) {
						
				for (int j=0; j<this.singleMatrix[i].length; j++) {
							
					operator[i][j] = 1 / n * this.singleMatrix[i][j];  
				}	
			}			
			
			//display result
			System.out.println("\nThe result of Scalar division of the current matrix is: ");
			for (int i=0; i<this.singleMatrix.length; i++) {
						
				for (int j=0; j<this.singleMatrix[i].length; j++) {
							
					System.out.print(String.format("%.2f", operator[i][j]) + " ");	//display sum with a space between value round to two decimal place
				}
			System.out.println();	// a new line when a line is displayed.
			}	
		}else {
			//n == 0 or so
			System.out.println("Division by zero results in zero. Pick another number");
			
		}
		
		return this.operator;
	}

}
