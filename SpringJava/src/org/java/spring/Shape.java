package org.java.spring;

public class Shape {

	private Shape shape;
	private char type;
	private int height;
	public Shape(char type) {
		this.type=type;
	}
	
	public Shape(int height) {
		this.height=height;
	}
	
	
	public Shape(char type,int height) {
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

//	public void setShape(Shape shape) {
//		this.shape=shape;
//	}
	
	public Shape getShape() {
		return this.shape;
	}
	
	public void draw() {
		
	}
	
}
