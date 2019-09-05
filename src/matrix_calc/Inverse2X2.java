package matrix_calc;

public class Inverse2X2 extends Calc_manager{

	private double detA;
	
	Inverse2X2(double[][] operator, double[][] singleMatrix) {
		
		super(operator, singleMatrix);
		this.detA = detFinder();
	}

	
	public double detFinder() {
		
		//det for 2X2
		double detA = 0;
		for (int i=0; i<this.singleMatrix.length; i++) {
			
			for (int j=0; j<this.singleMatrix[i].length; j++) {
				/*    det A = |a b|
				//	    	  |c d|
				//		    = ad - bc       */
				detA = this.singleMatrix[0][0] * this.singleMatrix[1][1] - this.singleMatrix[0][1] * this.singleMatrix[1][0];	//calcularate to find det    
			}
		}
//		System.out.println("______________________________________________________________________________________________________________");
//		System.out.println("determinant if the matrix is " + this.detA);
		
		return detA;	//return det
	}
	
	public double getDetA() {
		//getter
		return this.detA;
	}
	
	@Override
	public double[][] calc() {
		
//		if (detA != 0) {	//if not singular,
			
			for (int i=0; i<this.singleMatrix.length; i++) {
				
				for (int j=0; j<this.singleMatrix[i].length; j++) {
					
					double[][] tempM = new double[this.singleMatrix.length][this.singleMatrix[i].length];	//declare size of a tempM for inverse calc.
					//formular: A-1 = 1 / det A * |d -b|
					//			                  |-c a|
					tempM[0][0] = this.singleMatrix[1][1];
					tempM[0][1] = - this.singleMatrix[0][1];
					tempM[1][0] = - this.singleMatrix[1][0];
					tempM[1][1] = this.singleMatrix[0][0];
					
					this.operator[i][j] = 1 / detA * tempM[i][j];	//calculate it   
				}	
			}
			
			//display result
			System.out.println("\nthe inverse of the current matrix is: ");
			for (int i=0; i<this.singleMatrix.length; i++) {
								
				for (int j=0; j<this.singleMatrix[i].length; j++) {
									
					System.out.print(String.format("%.2f", operator[i][j]) + " ");	
				}
			System.out.println();	// a new line when a line is displayed.
			}
			
//		}else {
//			//det is 0.
//			System.out.println("\nThe current matrix is a singular. singular matrices can not have inverses.");
//		}
	
		return this.operator;	//return inverse
	}
	
}
