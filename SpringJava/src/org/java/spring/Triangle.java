package org.java.spring;

public class Triangle{

	Point point1;
	Point point2;
	Point point3;
	//from xml the value falls to set() and then returned by get()
	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}

	public Point getPoint3() {
		return point3;
	}

	public void setPoint3(Point point3) {
		this.point3 = point3;
	}

	public void draw() {
		System.out.println("Drwing triangle having point "+ getPoint1().getX()+" and "+ getPoint1().getY());
		System.out.println("Drwing triangle having point "+ getPoint2().getX()+" and "+ getPoint2().getY());
		System.out.println("Drwing triangle having point "+ getPoint3().getX()+" and "+ getPoint3().getY());
	}
}
