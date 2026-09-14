
public class Manager extends Employee{
	float hra;
	Manager(String name, String address, int age, String gender, float basicSalary, float hra){
		super(name, address, age, gender, basicSalary);
		this.hra = hra;
	}
	
	void display() {
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println("Basic Salary: " + basicSalary);
		System.out.println("HRA: " + hra);
	}
}
