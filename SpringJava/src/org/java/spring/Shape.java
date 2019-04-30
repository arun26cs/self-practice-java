package org.java.spring;

public class Shape {

	private Shape shape;
	private char type;
	private int height;
	public int getHeight() {
		return height;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public void setShape(Shape shape) {
		this.shape=shape;
	}
	
	public Shape getShape() {
		return this.shape;
	}
	
	public void draw() {
		
	}
	
}
