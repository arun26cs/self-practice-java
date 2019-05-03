import java.util.ArrayList;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		//boolean anagram[][];
		ArrayList<Character> finS1 = new ArrayList<Character>();
		ArrayList<Character> finS2 = new ArrayList<Character>();
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		str1=str1.trim();
		str2=str2.trim();
		String s1[] = str1.split(" ");
		String s2[] = str2.split(" ");
		//char finS1[];
		for(String s:s1) {
			if(s!=null||!s.isEmpty()) {
				char s11[]=s.trim().toCharArray();
				int k=0;
				//finS1=new char[s11.length];
				for(int i=0;i<s11.length;i++) {
					if(s11[i]>='a'&&s11[i]<='z'||s11[i]>='A'&&s11[i]<='Z') {
						finS1.add(s11[i]); 
					}
				}
			}
		}
		
		for(String s:s2) {
			if(s!=null||!s.isEmpty()) {
				char s11[]=s.trim().toCharArray();
				int k=0;
				//finS1=new char[s11.length];
				for(int i=0;i<s11.length;i++) {
					if(s11[i]>='a'&&s11[i]<='z'||s11[i]>='A'&&s11[i]<='Z') {
						finS2.add(s11[i]); 
					}
				}
			}
		}
		//
		//logic dynamic
		Character anagram[][]=new Character[finS1.size()][finS2.size()]; //one extra row alone for top row false flag
		boolean setted=false;
		for(int row=0;row<finS1.size();row++) {
			for(int col=0;col<finS2.size();col++) {
				if(row==0) {
					if(finS1.get(row)!=finS2.get(col)) {
						anagram[row][col]='f';
					}else {
						if(!setted) {
							anagram[row][col]='t';
							setted=true;
						}else {
							anagram[row][col]='f';
						}
						
					}
				}else {
				
					//after first row
					if(finS1.get(row)!=finS2.get(col)) {
						anagram[row][col]=anagram[row-1][col];
					}else {//in equals case either true of skip
						if(anagram[row-1][col]=='f') {
							anagram[row][col]='t';
						}else if(anagram[row-1][col]=='s') {
							anagram[row][col]='s';
						}else {
							anagram[row][col]='s';
						}
					}
				}
			}
			
		}
		
		//display table
		for(int row=0;row<finS1.size();row++) {
			for(int col=0;col<finS2.size();col++) {
				System.out.print(anagram[row][col]);
			}
			System.out.println();
		}
		
		boolean printed=false;
		for(int col=0;col<finS2.size();col++) {
			if(anagram[finS1.size()-1][col]=='f') {
				System.out.println("No");
				printed=true;
				break;
			}  
		}
		if(!printed) {
			System.out.println("Yes");
		}
		
		System.out.println();
	}
}
