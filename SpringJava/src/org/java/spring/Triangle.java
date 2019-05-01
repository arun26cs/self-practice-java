package org.java.spring;

import java.util.List;

public class Triangle{

	List<Point> points;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw() {
		for(Point p: points) {
			System.out.println(p.getX()+" "+p.getY());
		}
	}
}
