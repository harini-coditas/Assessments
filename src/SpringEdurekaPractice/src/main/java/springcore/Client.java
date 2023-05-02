package springcore;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
    public static void main(String[] args) {
        //Object Construction - Done by Developer
        Employee eRef = new Employee();
        eRef.setEid(1);
        eRef.setEname("Harini");
        eRef.setEaddress("Hyd");
        System.out.println("Employee Details: "+eRef);

        //Spring way - IOC
        Resource resource = new ClassPathResource("Spring.xml");
        BeanFactory factory = new XmlBeanFactory(resource); //spring container vch shall parse XML File and construct the objects

        Employee e1 = (Employee) factory.getBean("emp1");
        Employee e2 = factory.getBean("emp2",Employee.class);

        System.out.println(e1);
        System.out.println(e2);
    }
}
