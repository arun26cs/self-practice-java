package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		String s = sc.nextLine().trim();
		ArrayList<Character> clist = new ArrayList<Character>();
		char[] a=s.toCharArray();
		for(int i=0;i<a.length;i++) {
			clist.add(a[i]);
		}
		reverseStr(0,clist);
	}

	private static void reverseStr(int pos,ArrayList<Character> clist) {
		if(pos<clist.size()) {
			int curPos=pos;
			pos=pos+1;
			reverseStr(pos,clist);
			System.out.print(clist.get(curPos));
		}
		
		
	}
}
