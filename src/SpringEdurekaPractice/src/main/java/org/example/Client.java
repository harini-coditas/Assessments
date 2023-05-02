package org.example;

import com.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {

        //TRADITIONAL WAY
//        Employee employee = new Employee();
//        employee.setEid(101);
//        employee.setEname("Harini");
//        employee.setEsalary(50000);
//
//        System.out.println(employee);

        //Inversion of control(IOC)
        //1. Add jar files for spring core
        //2.configure java object in xml file
        //3.using spring IOC Container, e.g Bean Factory or ApplicationContext to get the objects constructed by them
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        Employee e1 = (Employee) context.getBean("emp1");
        Employee e2 = context.getBean("emp2",Employee.class);

        System.out.println("-------Spring IOC in Action---------");
        System.out.println(e1);
        System.out.println(e2);
      }
}
