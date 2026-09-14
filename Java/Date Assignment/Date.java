
public class Date {
	private int day;
	private int month;
	private int year;
	private byte month_days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
							  // 1   2   3   4   5   6   7   8    9  10  11  12
							  // 0   1   2   3   4   5   6   7    8  9  10  11
	public boolean isLeap(int yy) {
		if(yy % 4 == 0) {
			return true;
		}
		else if(yy % 100 == 0 && yy % 400 == 0) {
			return true;
		}
		
		return false;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	public void changeFeb() {
		if(isLeap(getYear())) {
			month_days[1] = 29;
		}
		else {
			month_days[1] = 28;
		}
	}
	public void addDays(int to_add) {
		changeFeb();
		to_add = (to_add + getDay());
		int idx = getMonth()-1;
		int curr_days_rem = 0;
		while(to_add > 0) {
			//5 < 31
//			System.out.println("month: " + (idx+1) + " " + month_days[idx] + " " + year);
			if(to_add <= month_days[idx]) {
//				System.out.println(to_add + " idx : " + idx);
				day = to_add;
				month = idx+1;
				return;
			}
			curr_days_rem = (to_add - month_days[idx]);
			
			if((idx + 1) % 12 == 0) {
				year++;
				changeFeb();
				
			}
			idx = (idx + 1)%12;
			to_add = curr_days_rem;
		}
	}
	
	public void addMonth(int to_add) {
		int idx = getMonth()-1;
		int sum_of_days = 0;
		int tempyear = getYear();
		while(to_add > 0) {
			int days = month_days[idx];
			if(idx == 1) {
				days = isLeap(tempyear) ? 29 : 28;
			}
			sum_of_days += days;
			to_add--;
			if((idx+1)%12 == 0) tempyear++;
			idx = (idx+1)%12;
		}
		
		addDays(sum_of_days);
	}
	
	public void addYear(int to_add) {
		year += to_add;
		if(month == 2 && day == 29 && !isLeap(year)) {
			day = 28;
		}
		changeFeb();
	}
	
	public void setDate(int dd, int mm, int yy) {
		year = yy;
		
		if(mm == 4 || mm == 6 || mm == 9 || mm == 11) {
			if(dd > 30 || dd < 1) {
				day = 1;
			}
			else {
				day = dd;
			}
		}
		else {
			if(dd < 1 || dd > 31) {
				day = 1;
			}
			else {
				day = dd;
			}
		}
		if(mm == 2 && !isLeap(yy)) {
			if(dd == 29) {
				day = 1;
			}
			else {
				day = dd;
			}
		}
		else if(mm == 2 && isLeap(yy)) {
			if(dd < 1 || dd > 29) {
				day = 1;
			}
			else {
				day = dd;
			}
		}
		
		if(mm < 1 || mm > 12) {
			month = 1;
		}
		else {
			month = mm;
		}
		
	}
	

}
