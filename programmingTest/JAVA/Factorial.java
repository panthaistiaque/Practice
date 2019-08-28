import java.math.BigInteger;
import java.util.*;
public class Factorial {
	public Integer fact(int n){
		if(n == 1) return 1;	
		return n*fact(n - 1 );
	}
	public static void main(String[] args){ 
	
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number");
		int i = scan.nextInt();
		if(i<13 && i>0){
			Factorial factorial = new Factorial(); 
			int f = factorial.fact(i);
			System.out.println("Factorial value of : "+i+" :: "+f); 
		}else{
			System.out.println("Enter a number shoulf be grater then 0 and lower then 13");
		}	
	}
}