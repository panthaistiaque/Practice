/**
Floyd's triangle is a right-angled triangular array of natural numbers, used in computer science education. 
It is named after Robert Floyd. It is defined by filling the rows of the triangle with consecutive numbers, 
starting with a 1 in the top left corner:

1
2 	3
4 	5 	6
7 	8 	9 	10
11 	12 	13 	14 	15


Summing up the row sums in Floyd's triangle reveals the doubly triangular numbers 
(triangular numbers with an index that is triangular)

    1            = 1 = T(T(1))


    1            = 6 = T(T(2))
    2 + 3

    1
    2 + 3     = 21 = T(T(3))
    4 + 5 + 6
*/
import java.util.Scanner;

public class FloydsTriangle{
	
	public static void main(String[] args) {
		
	    int k = 1;
	    int input = 0;
	    
	  Scanner in = new Scanner(System.in);
      System.out.println("Enter the number of rows of floyd's triangle you want");
      input = in.nextInt();
      
      System.out.println("Floyd's triangle :-");
      
	    for(int i = 1; i<=input; i++){
			
	        for(int n = 1; n<= i; n++){
		        System.out.print(k+ "  "); //print every element of triangle 
		        k++;
	        }
			
	        System.out.println();//print new line  of triangle 
	    }
	}
	
}
