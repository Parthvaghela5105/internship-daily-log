//Program to create an interface Sortable with a method sort() that sorts an array of integers in ascending order. 
//Create two classes BubbleSort and SelectionSort that implement the Sortable interface and provide their own implementations of the sort() method.


interface Sortable{
	void sort(int[] arr);
}

class BubbleSort implements Sortable{
	public void sort(int[] arr){
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 1; j < arr.length - i ; j++)
			{
				if(arr[j] < arr[j-1])
				{
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
	}
}

class SelectionSort implements Sortable{
	public void sort(int[] arr){
		for(int i = 0 ; i < arr.length ; i++){
			int min = i;
			for(int j = i ; j < arr.length ; j++){
				if(arr[min] > arr[j]){
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
}

class Sorting{
	public static void main(String[] args){
		int arr[] = {7,6,5,4,3,2,1};
		
//		BubbleSort b = new BubbleSort();
//		b.sort(arr);
//		print(arr);

		SelectionSort ss = new SelectionSort();
		ss.sort(arr);
		print(arr);
		
	}
	
	static void print(int[] arr){
		System.out.print("Printing the array: ");
		for(int n: arr){
			System.out.print(n);
		}
		
		System.out.println();
	}
}