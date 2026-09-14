
public class Engineer extends Employee{
	float overtime;
	Engineer(String name, String address, int age, String gender, float basicSalary, float overtime){
		super(name, address, age, gender, basicSalary);
		this.overtime = overtime;
	}
	
	void display() {
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println("Basic Salary: " + basicSalary);
		System.out.println("Overtime: " + overtime);
	}
}
