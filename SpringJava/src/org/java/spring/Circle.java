package org.java.spring;

public class Circle implements Shape {

	private Point centre;
	
	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}

	@Override
	public void draw() {
		System.out.println("Circle");
		System.out.println(getCentre().getX()+" "+getCentre().getY());
	}

}
