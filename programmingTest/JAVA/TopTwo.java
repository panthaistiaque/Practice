public class TopTwo {
	private static void findTopTwo(int[] param){
	int firstValue = param[0];
		int secondValue = param[0];
		for(int i : param){ 
			if(firstValue<i){ 
				firstValue = i;
			}
			if(secondValue>i){
				secondValue  = i;
			}
		}
		System.out.println("1st Max value "+ firstValue);
		System.out.println("2nd Max value "+ secondValue); 
	}
	
	public static void main(String[] args){
		int[] iArray = {12,1,15,654,12,65,14,12,3,2,90};
		findTopTwo(iArray);
	}
}