package org.java.spring;
import org.springframework.aop.framework.autoproxy.BeanFactoryAdvisorRetrievalHelper;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String args[]) {
		//BeanFactory is interface .. xml file in the root node
		//BeanFactory beanf = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//ApplicationContext is interfeace .. xml file in class path so moved to src folder
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Shape shape=(Shape)context.getBean("Triangle-alias");
		//Shape myTriangle=(Shape)beanf.getBean("Triangle");
		shape.draw();
		
		shape=(Shape)context.getBean("circle");
		shape.draw();
		//try initiating the value of the variable in a class which is a property of the class
//		myTriangle.incrXY();
//		System.out.println("Second time display");
//		myTriangle.draw();
//		myTriangle=(Triangle)context.getBean("Triangle-alias");
//		System.out.println("After new context call getbean mytriangle value");
//		myTriangle.draw();
//		System.out.println("After new context call getbean mytriangle value");
//		myTriangle.draw();
	}
}
