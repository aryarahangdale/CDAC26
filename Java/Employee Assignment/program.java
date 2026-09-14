
public class Program {
//Manager(String name, String address, int age, char gender, float basicSalary, float hra)
//SalesPerson(String name, String address, int age, char gender, float basicSalary, float commission)
//Engineer(String name, String address, int age, char gender, float basicSalary, float overtime)
	
	static void Manager_Creation(Manager[] m_arr, int idx) {
		CommonDetails c = new CommonDetails();
		float hra = ConsoleInput.getFloat();
		m_arr[idx] = new Manager(c.name, c.address, c.age, c.gender, c.basicSalary, hra);
	}
	
	static void Engineer_Creation(Engineer[] e_arr, int idx) {
		CommonDetails c = new CommonDetails();
		float overtime = ConsoleInput.getFloat();
		e_arr[idx] = new Engineer(c.name, c.address, c.age, c.gender, c.basicSalary, overtime);
	}
	
	static void SalesPerson_Creation(SalesPerson[] s_arr, int idx) {
		CommonDetails c = new CommonDetails();
		float commission = ConsoleInput.getFloat();
		s_arr[idx] = new SalesPerson(c.name, c.address, c.age, c.gender, c.basicSalary, commission);
	}
	
	static void displayAll(Manager[] m_arr,int mCount, Engineer[] e_arr, int eCount, SalesPerson[] s_arr, int sCount) {
		System.out.println("Manager Details:");
		for(int idx = 0; idx < mCount; idx++) {
			m_arr[idx].display();
			System.out.println();
		}
		System.out.println("Engineer Details:");
		for(int idx = 0; idx < eCount; idx++) {
			e_arr[idx].display();
			System.out.println();
		}
		System.out.println("SalesPerson Details:");
		for(int idx = 0; idx < sCount; idx++) {
			s_arr[idx].display();
			System.out.println();
		}
	}
	
	//Upcasting
	static void bubbleSort(Employee[] arr, int length) {
		for(int idx = 0; idx < length-1; idx++) {
			boolean isSwapped = false;
			for(int idx2 = 0; idx2 < length - idx - 1; idx2++) {
				String currString = arr[idx2].name;
				String nextString = arr[idx2+1].name;
				if(currString.compareTo(nextString) > 0) {
					Employee temp = arr[idx2];
	                	arr[idx2] = arr[idx2 + 1];
	                	arr[idx2 + 1] = temp;
	                	
	                	isSwapped = true;
				}
			}
			
			if(!isSwapped) break;
		}
	}
	
	static void bubbleSortDesc(Employee[] arr, int length) {
		for(int idx = 0; idx < length-1; idx++) {
			boolean isSwapped = false;
			for(int idx2 = 0; idx2 < length - idx - 1; idx2++) {
				String currString = arr[idx2].name;
				String nextString = arr[idx2+1].name;
				if(currString.compareTo(nextString) < 0) {
					Employee temp = arr[idx2];
	                	arr[idx2] = arr[idx2 + 1];
	                	arr[idx2 + 1] = temp;
	                	
	                	isSwapped = true;
				}
			}
			
			if(!isSwapped) break;
		}
	}
	
	public static void main(String[] args) {
		Manager[] m_arr = new Manager[100];
		int mCount = 0;
		Engineer[] e_arr = new Engineer[100];
		int eCount = 0;
		SalesPerson[] s_arr = new SalesPerson[100];
		int sCount = 0;
		int choice = 0;
		do {
			System.out.println("---------------Menu For Program---------------");
			System.out.println("1.Add\n2.Display\n3.Sort\n4.Exit");
			choice = ConsoleInput.getInteger();
			switch(choice) {
			case 1:
				int choiceAdd = 0;
				do {
					System.out.println("---------------Menu For Adding---------------");
					System.out.println("1.Manager\n2.Engineer\n3.Salesperson\n4.Exit");
					choiceAdd = ConsoleInput.getInteger();
					if(choiceAdd == 1) { 
						Manager_Creation(m_arr, mCount);
						mCount++;
					}
					else if(choiceAdd == 2) { 
						Engineer_Creation(e_arr, eCount);
						eCount++;
					}
					else if(choiceAdd == 3) {
						SalesPerson_Creation(s_arr, sCount);
						sCount++;
					}
				}
				while(choiceAdd != 4);
				break;
			case 2:
				displayAll(m_arr, mCount, e_arr, eCount, s_arr, sCount);
				break;
			case 3:
				int choiceSort = 0;
				do {
					System.out.println("---------------Menu For Adding---------------");
					System.out.println("1.Ascending Sort\n2.Desencding Sort\n4.Exit");
					choiceSort = ConsoleInput.getInteger();
					if(choiceSort == 1) {
						bubbleSort(m_arr, mCount);
						bubbleSort(e_arr, eCount);
						bubbleSort(s_arr, sCount);
					}
					else if(choiceSort == 2) {
						bubbleSortDesc(m_arr, mCount);
						bubbleSortDesc(e_arr, eCount);
						bubbleSortDesc(s_arr, sCount);
					}
				}
				while(choiceSort != 4);
				
				break;
			case 4:
				return;
			default:
				break;
				
			}
		}while(choice != 4);
		
	}

}
