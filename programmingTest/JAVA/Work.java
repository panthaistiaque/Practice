public class Work {
	public static void main(String[] args){
		Employee emp = new Employee();
		emp.setName("Istiaque");
		Employee emp1 = emp;
		
		System.out.println("First employee Name : '"+ emp.getName() + "' Second employee Name : '"+emp1.getName()+"';");
		//		First employee Name : 'Istiaque' Second employee Name : 'Istiaque';
		
		emp1.setName("Hossain");
		System.out.println("First employee Name : '"+ emp.getName() + "' Second employee Name : '"+emp1.getName()+"';"); 
		//		First employee Name : 'Hossain' Second employee Name : 'Hossain';
	}
}

class Employee{
	private int name; 	
	public void setName(int name){
		this.name = name;
	}
	public int getName(){
		return this.name;
	}	
}

