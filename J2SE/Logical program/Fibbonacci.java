import java.util.Scanner;

class Fibbonacci{
	static int[] createFib(int num){
		int[] arr = new int[num];
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2 ; i < num; i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		int num = sc.nextInt();
		int[] arr = createFib(num);
		int sum = 0;
		System.out.print("Fibbonacci series: ");
		for(int i = 0 ; i < num ; i++)
		{
			System.out.print(arr[i]);
		}
		System.out.println();
		
		for(int i = 1; i < num;){
			sum += arr[i];
			i = i+2;
		}
		
		System.out.println("sum : "+sum);
	}
}