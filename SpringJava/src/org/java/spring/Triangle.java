package org.java.spring;

public class Triangle{

	private Triangle Triangle;
	private char type;
	private int height;
	public Triangle(char type) {
		this.type=type;
	}
	
	public Triangle(int height) {
		this.height=height;
	}
	
	
	public Triangle(char type,int height) {
		this.type=type;
		this.height=height;
	}
	
	
	public int getHeight() {
		return height;
	}

	public char getType() {
		return type;
	}

//	public void setType(char type) {
//		this.type = type;
//	}

//	public void setTriangle(Triangle Triangle) {
//		this.Triangle=Triangle;
//	}
	
	public Triangle getTriangle() {
		return this.Triangle;
	}
	
	public void draw() {
		System.out.println(" Drwing "+getType()+" triangle having height "+ getHeight());
	}
}
