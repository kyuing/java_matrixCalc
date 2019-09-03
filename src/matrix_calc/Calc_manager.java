package matrix_calc;

public class Calc_manager {

	protected int m1Row, m2Row, m2Col;
	protected double[][] matrix1, matrix2, singleMatrix, operator;
	private double[][] placeHolder;
	
	Calc_manager(double[][] operator, double[][] matrix1, double[][] matrix2) {
		
		this.operator = operator;
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		
		
	}
	
	Calc_manager(double[][] operator, double[][] matrix1, double[][] matrix2, int m1Row, int m2Row, int m2Col) {
		
		this.operator = operator;
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.m1Row = m1Row;
		this.m2Row = m2Row;
		this.m2Col = m2Col;
	}
	
	Calc_manager(double[][] operator, double[][] singleMatrix) {
		
		this.operator = operator;
		this.singleMatrix = singleMatrix;
	}
	
	public double[][] calc() {
		
		//calc
		for (int i=0; i<this.matrix1.length; i++) {
					
			for (int j=0; j<this.matrix1[i].length; j++) {
						
				
			}	
		}
	
		return placeHolder;
	}
	
	
}
