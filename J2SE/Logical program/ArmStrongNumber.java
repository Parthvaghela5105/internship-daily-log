import java.util.Scanner;

class ArmStrongNumber{
	static boolean arm(int num){
		int temp = num;
		int sum = 0;
		while(temp != 0){
			int rem = temp % 10;
			sum += rem*rem*rem;
			temp /= 10;
			System.out.println(sum);
		}
		if(sum == num){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		int num = sc.nextInt();
		if(arm(num)){
			System.out.println(num+" is armstrong number");
		}else{
			System.out.println(num+" is not armstrong number");
		}
	}
}