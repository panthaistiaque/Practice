/**
The Fibonacci numbers are the numbers in the following integer sequence.

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..

In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation

    Fn = Fn-1 + Fn-2

with seed values

   F0 = 0 and F1 = 1.
*/
public  class FibonacciRecursion{
	
	static int n1 = 1, n2 = 1, n = 0;
	
	private static void fib(int parm){
		
		if(parm>0){
			n = n1+n2;
			n1 = n2;
			n2 = n; 
			System.out.print(n + " ");
			fib(parm-1);
		}
		
	}
	
	public static void main(String args[]){  
        int numberOfPosition = 10;
		System.out.print(n1+" "+n2+ " ");
		FibonacciRecursion.fib(numberOfPosition-2);
		
	}
}