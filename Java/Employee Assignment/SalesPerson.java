
public class SalesPerson extends Employee{
	float commission;
	SalesPerson(String name, String address, int age, String gender, float basicSalary, float commission){
		super(name, address, age, gender, basicSalary);
		this.commission = commission;
	}
	
	void display() {
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println("Basic Salary: " + basicSalary);
		System.out.println("Commission: " + commission);
	}
}

