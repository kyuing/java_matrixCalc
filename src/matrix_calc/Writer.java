package matrix_calc;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Writer {

	private double[][] result;
	
	
	Writer(double[][] result) {
	
		this.result = result;
	}
	
	public void writer() {
		
		String _default = "answer", nameToFile = "";	//declare a string variable and initialize it to get input
		int userN = 0;
		Scanner sc = new Scanner(System.in);	//set scanner to scan user input
		Asker writeAsker = new Asker();
		userN = writeAsker.askUserChoice();
			if (userN == 1) {	//user wanna output the result to a file nmaed answer.txt
				//write to file
				try {	//use try-catch in case there some errors
					BufferedWriter bw = new BufferedWriter(new FileWriter(_default + ".txt", false));	//overwrite
					bw.write(result.length + " " + result.length);	//size
					bw.newLine();	// a new line for answers
					for (int i=0; i<result.length; i++) {	//build rows
						
						for (int j=0; j<result[i].length; j++) {	//build columns
									
							bw.write(String.format("%.2f", result[i][j]));	//write round to two decimal places
							
							if (j < result[i].length-1) {	//if a value is not the last row or column
							
								bw.write(" ");	// a space between values. 
							}
						}
						if (i < result.length-1) {	//if a value is not the last value of the calculation
						bw.newLine();	// a new line for the next rows
						}
					}
					bw.close();	//save and close the writer
					
					System.out.println("The file is saved in '" + _default + ".txt'");	//let the user know that the file is saved.
					
				}catch (IOException ioe) {	//it's possible that there were unexpected input & output errors 
					
					System.out.println("File Access Error while writing the result.");
				}		
					
			}else {	//user wants to output to a file with the a file name specified individually
				
				System.out.println("\nPlease enter the file name you prefer to save the result to a file.");	//ask user a file name for writing
				try {	//use try-catch in case there some errors
					nameToFile = sc.nextLine();	//prompt and get input from user
					
				} catch (Exception e) {	//it's possible that there were unexpected errors
					System.out.println("an error occured.");	
				}
				nameToFile = nameToFile.trim().replaceAll(" ", "_");	//delete all the spaces at the beginning and at the end. replace all spaces with underscore 
				
				//write to file
				try {	//use try-catch in case there some errors
					BufferedWriter bw = new BufferedWriter(new FileWriter(nameToFile + ".txt", true));
					bw.write(result.length + " " + result.length);
					bw.newLine();	// a new line for answers
					for (int i=0; i<result.length; i++) {	//build rows
						
						for (int j=0; j<result[i].length; j++) {	//build columns
									
							bw.write(String.format("%.2f", result[i][j]));	//write round to two decimal places
							
							if (j < result[i].length-1) {	//if a value is not the last row or column
							
								bw.write(" ");	// a space between values.
							}
						}
						if (i < result.length-1) {	//if a value is not the last value of the calculation
							bw.newLine();	// a new line for the next rows
							}
					}
					bw.close();	//save and close the writer
					
					System.out.println("The file is saved in '" + nameToFile + ".txt'");	//let the user know that the file is saved.
					
				}catch (IOException ioe) {	//it's possible that there were unexpected input & output errors 
					
					System.out.println("File Access Error while writing to a file.");
				}		
				
			}
			
	}
}
