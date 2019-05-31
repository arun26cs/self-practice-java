package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SequenceNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> Intlist = new ArrayList<Integer>();
		int n=Integer.parseInt(sc.nextLine().trim());
		for(int i=0;i<n;i++){
			Intlist.add(Integer.parseInt(sc.nextLine().trim()));
		}
		for(int i=0;i<n;i++){
			int T=Intlist.get(i);
			printSeq(T);
			System.out.println();
		}
	}

	private static void printSeq(int t) {
		if(t>0) {
			System.out.print(t+" ");
			printSeq(t-1);
			//above line is called till t==0 then when t==0 it has nothing more so it goes next line which is print
			//System.out.print(t+" ");
		}
		
	}
}
