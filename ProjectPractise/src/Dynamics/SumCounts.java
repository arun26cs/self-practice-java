package Dynamics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class SumCounts {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int finSum = Integer.parseInt(sc.nextLine());
		int n=Integer.parseInt(sc.nextLine());
		String numString = sc.nextLine();
		ArrayList<Integer> items = new ArrayList<Integer>();
		HashMap<Integer, Integer> keysAndSum = new HashMap<Integer, Integer>();
		String[] strLets = numString.split(" ");
		int i=0;
		while(i<strLets.length) {
			items.add(Integer.parseInt(strLets[i]));
			i++;
		}
		items.add(0);
		Collections.sort(items);
		i=0;
		
		//storing max sum
		for(int it:items) {
			Set<Integer> keys = keysAndSum.keySet();
			if(keys.contains(it)) {
				int temp = keysAndSum.get(it);
				temp+=it;
				keysAndSum.put(it,temp);
			}else {
				keysAndSum.put(it,it);
			}
			
		}
		ArrayList<Integer> columns = new ArrayList<Integer>(); 
		for(i=0;i<=finSum;i++) {

			columns.add(i);
		}
		//dynamic array init

		ArrayList<ArrayList<Integer>> dynArray = new ArrayList<ArrayList<Integer>>();
		
		//first row
		ArrayList<Integer> tempar = new ArrayList<Integer>();
		for(i=0;i<=finSum;i++) {

			tempar.add(0);
		}
		dynArray.add(tempar);//first row to be 0
		
		//all rows init<<nit c++ to do this>>
		/*for(int it:items) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(i=0;i<=finSum;i++) {

				temp.add(0);
			}
			dynArray.add(temp);
		}*/
		
		//populate dynArray
		i=1;
		//int k=1;//dyn array loc
		int totalskip = 0;
		int prevItem=0;
		while(i<items.size()) {
			if(prevItem==items.get(i)) {
				//incase of dup values its calculated here
				totalskip=totalskip+items.get(i);
			}else {
				//incase of new value is assigned here
				totalskip=items.get(i);
			}
			ArrayList<Integer> tempArrList = new ArrayList<Integer>();
			for(int j=0;j<columns.size();j++) {
				//skip till < totalskip
				if(columns.get(j)<totalskip) {
					//add top value
					tempArrList.add(dynArray.get(i-1).get(j));
				}else if(columns.get(j)==totalskip) {
					//add top value +1
					tempArrList.add(dynArray.get(i-1).get(j)+1);
				}else {
					//add top value + difference value (j-i)
					tempArrList.add(dynArray.get(i-1).get(j)+dynArray.get(i-1).get(columns.get(j)-items.get(i)));
				}
			}
			dynArray.add(tempArrList);
			prevItem=items.get(i);
			if(i==4) {
				System.out.println();
			}
			i++;
			
		}
		System.out.println();
	}
}
