package org.java.spring;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware,Shape{

	Point point1;
	Point point2;
	Point point3;

	private ApplicationContext context;
	//Triangle t;

	public void setContext() {
		//t=(Triangle)context.getBean("Triangle");
		point1=(Point)context.getBean("point1");
		point2=(Point)context.getBean("point2");
		point3=(Point)context.getBean("point3");
	}
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
		System.out.println(getPoint1().getX()+" "+getPoint1().getY());
		System.out.println(getPoint2().getX()+" "+getPoint2().getY());
		System.out.println(getPoint3().getX()+" "+getPoint3().getY());
	}
	
	public void incrXY() {
		++point1.x; ++point1.y;
		++point2.x; ++point2.y;
		++point3.x; ++point3.y;
	}



	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("setting newly");
		this.context=context;
		setContext();
	}
}
