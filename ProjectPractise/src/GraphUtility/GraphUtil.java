package GraphUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class GraphUtil {

	HashMap<String, Queue<String>> graph = new HashMap<String, Queue<String>>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		GraphUtil gu = new GraphUtil();
		int i=0;
		while(i<n) {
			String line = sc.nextLine();
			String[] nodes = line.split(" ");
			gu.addEdge(nodes[0],nodes[1]);
			i++;
		}
		System.out.println(gu.detectCycle(gu.graph));
		System.out.println();
		
		
	}
	private int detectCycle(HashMap<String, Queue<String>> graph) {
		int cyclecount =0;
		 Set<String> keys = graph.keySet();
		 ArrayList<String> vertices = new ArrayList<String>();
		 vertices.addAll(keys);
		 boolean allNodeVisitedinList=false;
		 ArrayList<String> black = new ArrayList<String>();
		 Stack<String> grey = new Stack<String>();
		 grey.add(vertices.get(0));
		 vertices.remove(0);
		 ArrayList<String> cycle = new ArrayList<String>();
		 while(!grey.isEmpty()) {
			 allNodeVisitedinList=false;
			 String start = grey.peek();
			 Queue<String> list = graph.get(start);
			 //Iterator<String> it = list.iterator();
			 String neighbour = new String();
			 while(list.size()>0) {//break or till new found and added or till exhausted
				 String node = list.remove();
				 if(!black.contains(node)) {
					 
					 allNodeVisitedinList=false;
					 neighbour=node;
					 if(grey.contains(neighbour)) {
						 //duplicate cycle
						 cyclecount++;
						 cycle.add(start);
					 }else {
						 grey.add(node);
						 break;
					 }
					 
					 
				 } //else its in visited black list
				 else {
					 allNodeVisitedinList=true;
				 }
			 }
			 if(list.size()<=0 && grey.contains(start)) {
				 allNodeVisitedinList=true;
			 }
			 graph.put(start, list);
			 if(allNodeVisitedinList) {
				 black.add(grey.peek());
				 grey.pop();
			 }
			 System.out.println(cyclecount);
		 }
		return cyclecount;
	}
	private void addEdge(String u, String v) {
		Set<String> keys = graph.keySet();
		if(keys.contains(u)) {
			Queue<String> vals = graph.get(u);
			vals.add(v);
			graph.put(u, vals);
		}else {
			Queue<String> vals = new LinkedList<String>();
			vals.add(v);
			graph.put(u, vals);
		}
	}
}
