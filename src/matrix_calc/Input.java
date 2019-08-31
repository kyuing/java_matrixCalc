package matrix_calc;

public class Input {
	
	String fileName, menu, txtInput, inputFileName;
	
	public String fileSelector() {
		
		Asker asker1 = new Asker();
		
		do { //do
				txtInput = asker1.selecet_input();
				 
				 	if (txtInput.equals("1")) {
				 		
				 		fileName = "matrix.txt"; 
				 		
				 	}else if (txtInput.equals("2")) {
				 		
				 		fileName = "matrix2.txt";
				 		
				 	}else if (txtInput.equals("3")) {
				 		
				 		fileName = "invalidFile.txt";
				 		
				 	}else if (txtInput.equals("4")) {
				 		
				 		fileName = "invalidFile2.txt";
				 		
				 	}else {
				 		//ask user for specified name of file input
				 		inputFileName	= asker1.askuserFileNameInput();
				 		
				 		if (inputFileName == null) {	//null	 	
				 			System.out.println("enter proper file name of txt input or check if the file exists in the the folder");
				 
				 		}else {//not null
				 			fileName =  inputFileName + ".txt";	
				 		}
		
				 	}
				 	
				 	return fileName;
		
			 } while (!txtInput.matches("[1|2|3|4|5]"));	
	
	}
}
