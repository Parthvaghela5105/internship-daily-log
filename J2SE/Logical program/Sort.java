class Sort{
	
	static void sort(int[] arr){
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
	
	static void printArr(int[] arr){
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args){
		int[] arr = {5 , 3 , 4 , 2, 10};
		System.out.println("Array before sorting");
		printArr(arr);
		sort(arr);
		System.out.println("Array After sorting");
		printArr(arr);
	}
}