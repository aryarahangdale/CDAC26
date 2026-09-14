
public abstract class Employee {

protected
	String name;
	String address;
	int age;
	String gender;
	float basicSalary;
	
	Employee(String name, String address, int age, String gender, float basicSalary){
		this.name = name;
		this.address = address;
		this.age = setAge(age);
		this.gender = gender;
		this.basicSalary = basicSalary;
	}
	
	int setAge(int age) {
		if(age < 18 || age > 65) return 21;
		return age;
	}
}
