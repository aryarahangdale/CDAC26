
public class Date_Main {

	public static void main(String[] args) {
		Date obj  = new Date();
		System.out.println("Enter your date: ");
		int date = ConsoleInput.getInteger();
		int month = ConsoleInput.getInteger();
		int year = ConsoleInput.getInteger();
		obj.setDate(date, month, year);
		
		System.out.println(obj.getDay() + "/" + obj.getMonth() + "/" + obj.getYear());
//		obj.addDays(1234);
		obj.addMonth(12);
		System.out.println();
		System.out.println(obj.getDay() + "/" + obj.getMonth() + "/" + obj.getYear());
	}

}
