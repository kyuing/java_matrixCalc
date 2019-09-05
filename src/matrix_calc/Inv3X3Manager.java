package matrix_calc;

public class Inv3X3Manager extends Calc_manager{

	private double[][] minor = null;
	private double[][] coFactor = null;
	private double det = 0;
	private double[][] cT = null;
	private double[][] inverse = null;
	
	Inv3X3Manager(double[][] singleMatrix) {
		
		super(singleMatrix);
		minorFinder();
		coFactorFinder();
		detFinder();
	}
	
	public double[][] getMinor() {
		
		return this.minor;
	}
	
	public double[][] getCoFactor() {
		
		return this.coFactor;
	}
	
	public double[][] getInverse() {
		
		return this.inverse;
	}
	
	public double getDet() {
		
		return this.det;
	}
	
	public double[][] minorFinder() {
		
		for (int i=0; i<this.singleMatrix.length; i++) {
			
			for (int j=0; j<this.singleMatrix[i].length; j++) {
				// find determinant
				// M[i][j] = a*d - c*d 			
				this.minor = new double[this.singleMatrix.length][this.singleMatrix[i].length];
				
				this.minor[0][0] = this.singleMatrix[1][1] * this.singleMatrix[2][2] - this.singleMatrix[1][2] * this.singleMatrix[2][1]; 
				this.minor[0][1] = this.singleMatrix[1][0] * this.singleMatrix[2][2] - this.singleMatrix[1][2] * this.singleMatrix[2][0];
				this.minor[0][2] = this.singleMatrix[1][0] * this.singleMatrix[2][1] - this.singleMatrix[1][1] * this.singleMatrix[2][0];
				this.minor[1][0] = this.singleMatrix[0][1] * this.singleMatrix[2][2] - this.singleMatrix[0][2] * this.singleMatrix[2][1];
				this.minor[1][1] = this.singleMatrix[0][0] * this.singleMatrix[2][2] - this.singleMatrix[0][2] * this.singleMatrix[2][0];
				this.minor[1][2] = this.singleMatrix[0][0] * this.singleMatrix[2][1] - this.singleMatrix[0][1] * this.singleMatrix[2][0];
				this.minor[2][0] = this.singleMatrix[0][1] * this.singleMatrix[1][2] - this.singleMatrix[0][2] * this.singleMatrix[1][1];
				this.minor[2][1] = this.singleMatrix[0][0] * this.singleMatrix[1][2] - this.singleMatrix[0][2] * this.singleMatrix[1][0];
				this.minor[2][2] = this.singleMatrix[0][0] * this.singleMatrix[1][1] - this.singleMatrix[0][1] * this.singleMatrix[1][0];
			}
			
			//print
			System.out.println("\nMinor of the current matrix is: ");
			
			for ( i=0; i<this.singleMatrix.length; i++) {
						
				for (int j=0; j<this.singleMatrix[i].length; j++) {
				
					System.out.print(String.format("%.2f", minor[i][j]) + " ");	////display the result with a space between value representing as two decimal point
				}
			System.out.println();	//a new line for the next rows and cols
			}
		}
		return minor;
	}
	
	public double[][] coFactorFinder() {
		
//		boolean isNegativeSign = false;
		for (int i=0; i<this.singleMatrix.length; i++) {
			
			for (int j=0; j<this.singleMatrix[i].length; j++) {
				/*   co-factor: change signs.
					|+ - +|
					|- + -|
					|+ - +|	   */
				this.coFactor = new double[this.singleMatrix.length][this.singleMatrix[i].length];
				
				this.coFactor[0][0] = this.minor[0][0];
				this.coFactor[0][1] = - this.minor[0][1];
				this.coFactor[0][2] = this.minor[0][2];
				this.coFactor[1][0] = - this.minor[1][0];
				this.coFactor[1][1] = this.minor[1][1];
				this.coFactor[1][2] = - this.minor[1][2];
				this.coFactor[2][0] = this.minor[2][0];
				this.coFactor[2][1] = - this.minor[2][1];
				this.coFactor[2][2] =  this.minor[2][2];
					
			}
		}				
		//	print
			System.out.println("\nCo-factor of the current matrix is: ");
			for (int i=0; i<this.singleMatrix.length; i++) {
						
				for (int j=0; j<this.singleMatrix[i].length; j++) {
			 		
					System.out.print(String.format("%.2f", coFactor[i][j]) + " ");	//display the result with a space between value representing as two decimal point
				}
			System.out.println();	//a new line for the next row and cols
			}
		return coFactor;	//return co-factors
		}
	
	public double detFinder() {
		
		for (int i=0; i<this.singleMatrix.length; i++) {
			//det  = a[0][0]*c[0][0]+ a[0][1]*c[0][1] + a[0][2]*c[0][2]
			
			for (int j=0; j<this.singleMatrix[i].length; j++) {
				
//				this.inverse = new double[this.singleMatrix.length][this.singleMatrix[i].length];
				det = this.singleMatrix[0][0] * coFactor[0][0] + this.singleMatrix[0][1] * coFactor[0][1] + this.singleMatrix[0][2] * coFactor[0][2];  //calculate it
			}
		}
		System.out.println("\nDeterminant of the matrix is: " + det);	//print determinant
		return det;		//return determinant
	}
	
	@Override
	public double[][] calc() {
		
		//this for-loop only initializes the size of this.inverse
		for (int i=0; i<this.singleMatrix.length; i++) {
			
			for (int j=0; j<this.singleMatrix[i].length; j++) {
				
				this.inverse = new double[this.singleMatrix.length][this.singleMatrix[i].length];
			}
		}
		
		
		if (this.det != 0) {	//if determinant is not 0.
			
			for (int i=0; i<this.singleMatrix.length; i++) {	
				
				for (int j=0; j<this.singleMatrix[i].length; j++) {
					
					this.cT = new double[this.singleMatrix.length][this.singleMatrix[i].length];	//declare the size of co-factor matrix transposed

					this.cT[i][j] = this.coFactor[j][i];	//the rows of cT = the cols of coFactor matrix. the cols of cT = the rows of coFactor matrix
					
					/* # you might want to initialize this.inverse and calculate right after the above cT calculation done as follow,
					  
					 	--------------------------------------------------------------------------------------
					 	- this.inverse = new double[this.singleMatrix.length][this.singleMatrix[i].length];  -
					 	- this.inverse[i][j] = 1 / this.det * this.cT[i][j];                                 -
					 	--------------------------------------------------------------------------------------
					   
					   technically, it's not really a problem when it comes to initializing one more variable in the same loop.
					   however, this specific situation, that three variables (coFacotr, cT and inverse) and their values are involved in, occurs an unexpected result which is still not an error.
					   
					   this.coFactor is done in a loop in initializing and calculating 
					   this.cT and this.inverse are done in a loop in initializing and calculating
					   
					   # thus, calculation goes as it goes and this.inverse will be kept initializing until the loop ends.
					     this.inverse will then always & only store its running value at a current location depending on increment of i and j.
					     you will see only one result at the last index and won't see all the values stored correctly.
					     (all of the values will be zero except the last value at the last index)
					   
					   # one simple solution is to initialize and calculate a variable -inverse in this case- in a separate for-loop
					   
					 */

					//calculate inverse here but initialize it in another for-loop
					this.inverse[i][j] = 1 / this.det * this.cT[i][j];  //formula: A-1 = 1 / det * cT
				}	
			}
			
		}else {	//det is 0
			
			System.out.println("\nThe matrix is a singular. singular matrices can not have inverses.");
		}
		
		//print
		System.out.println("\nInverse of the current matrix is: ");
		for (int i=0; i<this.singleMatrix.length; i++) {
					
			for (int j=0; j<this.singleMatrix[i].length; j++) {
		 		
				System.out.print(String.format("%.2f", this.inverse[i][j]) + " ");	//display the result with a space between value representing as two decimal point
//				System.out.print(this.inverse[i][j] + " ");	//display the result with a space between value representing as two decimal point
			}
		System.out.println();	//a new line for the next row and cols
		}
		
		return inverse;	//return the value of inverse
	}
}
