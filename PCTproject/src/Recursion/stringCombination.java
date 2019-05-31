package Recursion;

import java.util.ArrayList;

public class stringCombination {
	public static void main(String args[]) {
		String wildCard = "1*11*00*1*";
		char[] values = wildCard.toCharArray();
		ArrayList<Character> vals = new ArrayList<Character>();
		int i=0;
		while(i<values.length) {
			vals.add(values[i]);
			i++;
		}
		recursivePrint(vals,new String());
	}

	private static void recursivePrint(ArrayList<Character> vals,String a) {
		 
		
		if(vals.size()<=0) {
			System.out.println(a);
			return;
		}else {
			
			if(vals.get(0).equals('*')) {
				System.out.println("splitted: "+vals);
				vals.remove(0);
				String temp1=a,temp2=a;
				temp1+='0'; 
				recursivePrint(vals,temp1);
				temp2+='1';
				recursivePrint(vals,temp2);
				
				
			}
			
			a+=vals.get(0); 
			vals.remove(0);
			recursivePrint(vals,a);
			
			
			 
			
		}
		
		
	}

	 
}
