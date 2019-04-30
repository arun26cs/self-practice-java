

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class GraphStr {

	HashMap<String, HashMap<String, Integer>> graphStr = new HashMap<String, HashMap<String,Integer>>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GraphStr gs = new GraphStr();
		int n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++) {
			String line=sc.nextLine();
			String[] splitLine = line.split(" ");
			List<String> val = new ArrayList<String>();
			val.add(splitLine[1]);
			val.add(splitLine[2]);
			Collections.sort(val);
			String strVal =new String();
			strVal+=val.get(0);
			strVal+=val.get(1);
			gs.addEdge(gs.graphStr,splitLine[0],strVal);
		}
		System.out.println();
	}
	private void addEdge(HashMap<String, HashMap<String, Integer>> graphStr2, String key, String strVal) {
		// TODO Auto-generated method stub
		if(graphStr2.containsKey(key)) {
			if(graphStr2.get(key).containsKey(strVal)) {
				int count=graphStr2.get(key).get(strVal);
				count++;
				graphStr2.get(key).put(strVal,count);
			}
			else {
				graphStr2.get(key).put(strVal,1);
			}
		}else {
			HashMap<String , Integer> temp=new HashMap<String, Integer>();
			temp.put(strVal,1);
			graphStr2.put(key, temp);
		}
	}
     
}

//class Vertex{
//    String name;
//    int id;
//    int count;
//    public Vertex() {
//        
//    }
//    public Vertex(String name) {
//        this.name=name; 
//    }
//}