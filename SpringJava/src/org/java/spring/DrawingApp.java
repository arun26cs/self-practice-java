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
		Triangle myTriangle=(Triangle)context.getBean("Triangle-alias");
		//Shape myTriangle=(Shape)beanf.getBean("Triangle");
		myTriangle.draw();
		//try initiating the value of the variable in a class which is a property of the class
		
	}
}
