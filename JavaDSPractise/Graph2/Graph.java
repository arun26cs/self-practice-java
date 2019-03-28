package Graph2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	public static void main(String args[]) {
		GraphDs gds = new GraphDs(5);
		gds.addEdges(0,1);
		gds.addEdges(1,2);
		gds.addEdges(2,2);
		gds.addEdges(2,3);
		gds.addEdges(3,4);
		gds.addEdges(1,4);
		gds.bfsTr();
	}

}

class GraphDs{
	LinkedList<Integer> graphds[];
	public GraphDs(int size){
		graphds=new LinkedList[size];
		for(int i=0;i<size;i++) {
			graphds[i]=new LinkedList<Integer>();
		}
		
	}
	public void bfsTr() {
		Queue<Integer> vertexQueue = new LinkedList<Integer>();
		ArrayList<Integer> visited=new ArrayList<Integer>();
		vertexQueue.add(graphds[0].get(0));
		while(!vertexQueue.isEmpty()) {
			int vertex = vertexQueue.remove();
			visited.add(vertex);
			System.out.println(vertex);
			for(int a:graphds[vertex]) {
				if(!visited.contains(a))
				vertexQueue.add(a);
			}
		}
	}
	public void addEdges(int i, int j) {
		graphds[i].add(j);
		graphds[j].add(i);
	}
}