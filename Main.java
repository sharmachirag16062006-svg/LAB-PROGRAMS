package employeeDetails;

public class Main {
	
	public static void main(String[] args) {
		Employee emp1 = new Employee("chirag sharma",60,10000);
		Employee emp2 = new Employee("kelly",61,25000);
		
		System.out.println("inital details are");
		emp1.display_details();
		emp2.display_details();
		
		emp1.increase_salary(0);
		emp2.increase_salary(0);
		
		System.out.println("updated Employee Details are");
		emp1.display_details();
		emp2.display_details();
		
		emp1.increase_salary(0);
		emp2.increase_salary(0);
		
		
	}

}
