
public class Program {
	
	static void bubbleSort(int arr[]) {
		boolean isSwapped = false;
		int size = arr.length;
		for(int idx = 0; idx < size - 1; idx++) {
			isSwapped = false;
			for(int idx2 = 0; idx2 < size - idx - 1; idx2++) {
				if(arr[idx2] > arr[idx2+1]) {
					int temp = arr[idx2+1];
					arr[idx2+1] = arr[idx2];
					arr[idx2] = temp;
					isSwapped = true;
				}
			}
			if(!isSwapped) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		//Question 1:
//		ComplexNumber[] c_arr = new ComplexNumber[5];
//		for(int idx = 0; idx < 5; idx++) {
//			System.out.println("Enter Number1 and Number2: ");
//			int number1 = ConsoleInput.getInteger();
//			int number2 = ConsoleInput.getInteger();
//			c_arr[idx] = new ComplexNumber();
//			c_arr[idx].number1 = number1;
//			c_arr[idx].number2 = number2;
//		}
//		
//		System.out.println("Output of all 5:");
//		for(int idx = 0; idx < 5; idx++) {
//			System.out.println(c_arr[idx].computeComplexNumber());			
//		}
//		System.out.println();
		
		//Question 2
		System.out.println("Enter Size Of Array");
		int size = ConsoleInput.getInteger();
		int arr[] = new int[size];
		
		System.out.println("Enter elements of array:");
		for(int idx = 0; idx < size; idx++) {
			arr[idx] = ConsoleInput.getInteger();
		}
		bubbleSort(arr);
		System.out.println("Show elements of array:");
		for(int idx = 0; idx < size; idx++) {
			System.out.print(arr[idx] + " ");
		}
		
		System.out.println();
		//Question 3
		int sum = 0;
		for(int idx = 0; idx < size; idx++) {
			sum += arr[idx];
		}
		System.out.println("Sum of elements:" + sum);
		
		System.out.println();
		//Question 4
		double average = sum/size;
		System.out.println("Average of elements:" + average);
		
		System.out.println();
		//Question 5
		int copyarr[] = new int[size];
		for(int idx = 0; idx < size; idx++) {
			copyarr[idx] = arr[idx];
		}
		
		System.out.println("Show elements of Copy array:");
		for(int idx = 0; idx < size; idx++) {
			System.out.print(copyarr[idx] + " ");
		}
		
		System.out.println();
		
		//Question 6
		bubbleSort(arr);
		int min_val = arr[0];
		int max_val = arr[size-1];
		System.out.println("Max Value:" + max_val);
		System.out.println("Min Value:" + min_val);
		
		//1 2 3 4 5
		//5 2 3 4 1
		//5 4 3 2 1
		//Question 7
		for(int idx = 0; idx < size/2; idx++) {
			int idx_to_swap = size-idx-1;
			int temp = arr[idx];
			arr[idx] = arr[idx_to_swap];
			arr[idx_to_swap] = temp;
		}
		
		System.out.println("Show elements of Reversed array:");
		for(int idx = 0; idx < size; idx++) {
			System.out.print(arr[idx] + " ");
		}
		
		//Question 8
		for(int idx = 0; idx < size-1; idx++) {
			if(arr[idx] == arr[idx+1]) {
				System.out.println("Found Duplicate Element:" + arr[idx]);
			}
		}
		
		System.out.println();
		//Question 9
		System.out.println("Enter elements of First Array:");
		int arr2[] = new int[size];
		for(int idx = 0; idx < size; idx++) {
			arr2[idx] = ConsoleInput.getInteger();
		}
		
		System.out.println("Enter elements of Second Array:");
		int arr3[] = new int[size];
		for(int idx = 0; idx < size; idx++) {
			arr3[idx] = ConsoleInput.getInteger();
		}
		
		bubbleSort(arr2);
		bubbleSort(arr3);
		
		for(int idx = 0; idx < size; idx++) {
			if(arr2[idx] == arr3[idx]) {
				System.out.println("Found Common Element: " + arr2[idx]);
			}
		}
		

	}

}
