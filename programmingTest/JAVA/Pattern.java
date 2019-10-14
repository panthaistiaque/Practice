/**
    *
   * *
  *   *
 *     *
*       *
 *     *
  *   *
   * *
    *

*/

public class Pattern{
	
	public static void main(String[] args) {
		for(int i = 0; i<9; i++){
			for(int k = 0; k<9; k++){
				if(k+i==4||k-i==4||k+i==12||i-k==4){
					System.out.print( " ");
				}else{
					System.out.print( "*");
				}
			}
			System.out.println();
		}
	}
}