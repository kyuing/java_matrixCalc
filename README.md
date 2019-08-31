# java_matrixCalc
* matrix calculator *

1. Input
   - read matrix input from file (txt)
     the file should look like;
     
     2 2 <--- two row, two column 
     
     1 2 <--- data for row 1, separated by a space
     
     3 4 <--- data for row 2, separated by a space
     
     @ <----- denote end of the first matrix
     
     2 2 <--- two row, two column
     
     5 6
     
     7 8
  
   - the import of input must occur after user has selected a calculation option
   - the user will be asked to provide a filename and the program will read the data from this file and store it within the program 
     so that calculations can be carried out. 

2. Calcuation; processing
   - prompt calcuation options
     - Add two matrices
     - Subtract Matrices
     - Scalar Multiplication of a Matrix (or Multiply a matrix by an Integer)
     - Multiply two matrices
     - Scalar Division
     - Calculate the Reciprocal (or Inverse)
     - QUIT PROGRAM 
       (If it is selected, the program should display a goodbye message and end. The program should only end when the user selects the "quit" option)
   - do the calculation selected by user
     - follow the maths rules where necessary
     
3. Validation
   - data input validation: All data input into the program must be validated appropriately to ensure that the program does not crash. Display a error message and prompt the user again for valid data if there's invalid input
   - data processing validation: If impossible to carry out calculation due to maths rule, output a message to inform the user why it is not possible 

4. Output
   - clear and sensible error message and prompts
   - write the answer to a file

5. The objective of this review is to apply instance & inheritance approach to the program
   So, you can create as many classes as you want as far as they are based on instance or inheritance approach.
   


