package GraphVoidNumbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class DataGraph {

	HashMap<String, ArrayList<String>> Graph=new HashMap<String, ArrayList<String>>();
	HashMap<String, Data> masterDataMap = new HashMap<String, Data>();//we cn alwasy get the keys object from here from on
	public static void main(String[] args) {
		DataGraph dg = new DataGraph();
		Scanner sc = new Scanner(System.in);
		int linenum = Integer.parseInt(sc.nextLine());
		int i=0;
		while(i<linenum) {
			String lines = sc.nextLine();
			String[] dataparts = lines.split(" ");
			dg.mapEntryToDataGraph(dataparts);
			i++;
		}
		//create a map
		System.out.println(dg.masterDataMap);
		//add edges
		dg.addEdges("a","b");
		dg.addEdges("b","c");
		dg.addEdges("a","d");
		dg.addEdges("c","d");
		dg.addEdges("c","f");
		dg.addEdges("d","g");
		dg.addEdges("d","e");
		dg.addEdges("g","h");
		dg.addEdges("e","h"); 
		
		System.out.println(dg.Graph);
		//traverse map
		//DFS
		dg.DFSTravel("a");
		//BFS
		dg.DFSTravel("f");
		//BFS
		dg.BFSTravel("a");
		
	}
	private void BFSTravel(String startNode) {//just changed stack to queue thats it
		ArrayList<String> visitedlist = new ArrayList<String>();
		Queue<String> curStack= new LinkedList<String>();
		
		curStack.add(startNode);
		while(!curStack.isEmpty()) {
			String node = curStack.remove();
			System.out.println(masterDataMap.get(node).name+" "+masterDataMap.get(node).id);
			visitedlist.add(node);
			ArrayList<String> adjNodes = Graph.get(node);
			//add to list
			int i=0;
			while(i<adjNodes.size()) {
				if(!visitedlist.contains(adjNodes.get(i))&&!curStack.contains(adjNodes.get(i))) {//if not already visited then only add
					//above if cond avoids cycle and avoids curstack dups
					curStack.add(adjNodes.get(i)); 
				}
				i++;
			}
			System.out.println(curStack+" "+visitedlist);
		}
		
	}
	private void DFSTravel(String startNode) {
		ArrayList<String> visitedlist = new ArrayList<String>();
		Stack<String> curStack= new Stack<String>();
		
		curStack.push(startNode);
		while(!curStack.isEmpty()) {
			String node = curStack.pop();
			System.out.println(masterDataMap.get(node).name+" "+masterDataMap.get(node).id);
			visitedlist.add(node);
			ArrayList<String> adjNodes = Graph.get(node);
			//add to list
			int i=0;
			while(i<adjNodes.size()) {
				if(!visitedlist.contains(adjNodes.get(i))&&!curStack.contains(adjNodes.get(i))) {//if not already visited then only add
					//above if cond avoids cycle and avoids curstack dups
					curStack.push(adjNodes.get(i)); 
				}
				i++;
			}
			System.out.println(curStack+" "+visitedlist);
		}
		
		
	}
	private void addEdges(String fromString, String toString) {
		// if new node create the node add the edges else get the node and add the arraylist
 
		if(Graph.get(fromString)==null) {
			Graph.put(fromString,new ArrayList<String>());
			Graph.get(fromString).add(toString);
		}else {
			Graph.get(fromString).add(toString);
		}
		
		if(Graph.get(toString)==null) {
			Graph.put(toString,new ArrayList<String>());
			Graph.get(toString).add(fromString);
		}else {
			Graph.get(toString).add(fromString);
		}
	}
	private void mapEntryToDataGraph(String[] dataparts) {
		Set<String > keys = masterDataMap.keySet();
		if(!keys.contains(dataparts[0])) {
			masterDataMap.put(dataparts[0], new Data(dataparts[0], Integer.parseInt(dataparts[1])));
		}
		
	}
}

class Data{
	String name;
	int id;
	public Data(String name,int id) {
		this.name=name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}