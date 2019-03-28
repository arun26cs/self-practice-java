package GraphVoidNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class NameGraph {

	HashMap<String, ArrayList<String>> nameGraph = new HashMap<String, ArrayList<String>>();
	HashMap<Character, ArrayList<String>> namemap=new HashMap<Character, ArrayList<String>>();
	public static void main(String[] args) {
		NameGraph ng = new NameGraph();
		Scanner sc = new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		ArrayList<String> names = new ArrayList<String>();
		while(n>0) {
			String name=sc.nextLine();
			ng.addToMap(name.charAt(0),name);
			names.add(name);
			n--;
		}
		Collections.sort(names);
		int i =1;
		char prevchar = names.get(i).charAt(0);
		while(i<names.size()) {
			if(prevchar==names.get(i).charAt(0)) {
				ng.loopAdding(names.get(i),names.get(i-1));
				//ng.addEdge(names.get(i),names.get(i-1));
			}else {//add node upon change for prev and curr inorder that prev may be skipped also at times if already there
				ng.addNode(names.get(i-1),names.get(i));
			}
			prevchar=names.get(i).charAt(0);
			i++;
		}
		ng.makepair();
		System.out.println(ng.nameGraph);
	}
	private void makepair() {
		Set<String> keys = nameGraph.keySet();
		ArrayList<String> finalList = new ArrayList<String>();
		for(String name:keys) {
			ArrayList<String> nlist = nameGraph.get(name);
			int i=0;
			if(nlist.size()==0) {
				finalList.add(name);
				//System.out.println(name);
			}
			while(i<nlist.size()) {
				if(!name.equalsIgnoreCase(nlist.get(i))){
					finalList.add(name+" "+nlist.get(i));
					//System.out.println(name+" "+nlist.get(i));
				}
				i++;
			}
		}
		Collections.sort(finalList);
		for(int i=0;i<finalList.size();i++) {
			System.out.println(finalList.get(i));
		}
		//System.out.println(finalList);
		
	}
	private void loopAdding(String from, String to) {
		char startAt = from.charAt(0);
		ArrayList<String> names = namemap.get(startAt);
		int i=0;
		while(i<names.size()) {
			addEdge(from, names.get(i));
			addEdge(to, names.get(i));
			i++;
		} 
	}
	private void addToMap(char charAt, String name) {
		if(namemap.get(charAt)==null) {
			namemap.put(charAt, new ArrayList<String>());
			namemap.get(charAt).add(name);
		}else {
			namemap.get(charAt).add(name);
		}
		
	}
	private void addNode(String prev, String curr) {
		if(nameGraph.get(prev)==null) {
			nameGraph.put(prev, new ArrayList<String>()); 
		} 
		if(nameGraph.get(curr)==null) {
			nameGraph.put(curr, new ArrayList<String>()); 
		} 
	}
	private void addEdge(String from, String to) {
		//check if already present dont add
		
		if(nameGraph.get(from)==null) {
			nameGraph.put(from, new ArrayList<String>());
			nameGraph.get(from).add(to);
		}else {
			ArrayList<String> nlist = nameGraph.get(from);
			if(!nlist.contains(to)) {
				nameGraph.get(from).add(to);
			}
			
		}
		
		if(nameGraph.get(to)==null) {
			nameGraph.put(to, new ArrayList<String>());
			nameGraph.get(to).add(from);
		}else {
			ArrayList<String> nlist = nameGraph.get(to);
			if(!nlist.contains(from)) {
				nameGraph.get(to).add(from);
			} 
		} 
		
		
	}
}
