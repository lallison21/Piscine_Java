package app;

import printer.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		Printer printer = context.getBean("prefix", Printer.class);
		printer.print ("Hello!") ;
	}
}
