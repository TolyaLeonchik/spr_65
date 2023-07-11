package com.tms;

import com.tms.aop.AspectTestClass;
import com.tms.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringStart {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring-settings.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class); // аннотации

        //АОП
//        AspectTestClass aspectTestClass = context.getBean("aspectTestClass", AspectTestClass.class);
//        aspectTestClass.printOne();
//        aspectTestClass.returnTen();

        //первый запуск
        //Employee employee = context.getBean("employee-bean", Employee.class);
        //Employee employee1 = context.getBean("employee-bean", Employee.class);
        //System.out.println(employee.getHrManager().name);
        //((ConfigurableApplicationContext) context).close(); //не обязашка, для отработки destroy
    }

    //bean - ручное создание объекта для спринга, которым он будет пользоваться (используется если
    //нужно достать или помеенять и тд класс, к которому мы не имеем доступа
    /*@Bean(value = "employee")
    public static Employee employeeBean() {
        return new Employee();
    }*/
}
