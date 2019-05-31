package Recursion;

import java.util.Scanner;

public class PCT1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long number=Long.parseLong(sc.nextLine().trim());
		checkDigit(number);
	}

	private static void checkDigit(long number) {
		//System.out.println(validCheck(number,1));
		int total=validCheck(number,1);
		if(total%10==0) {
			System.out.print("Valid");
		}else {
			int rem=total%10;
			System.out.print("Invalid "+rem);
		}
		
	}

	private static int validCheck(long number,int times) {
		// TODO Auto-generated method stub
		int total=0,retval=0;
		int sum=(int) (number%10);
		System.out.println("L: "+sum);
		if(number<=0) {
			return 0;
		}else {
			if(times==2) {
				sum=sum*2;
				int split=0;
				while(sum>=10) {
					split=split+(sum%10);
					sum=sum/10;
				}
				sum=sum+split;
				retval=validCheck(number/10,1);
			}else {
				retval=validCheck(number/10,2);
			}
			System.out.println("s: "+sum);
		}
		
		total=retval+sum;
		return total;
	}
}
