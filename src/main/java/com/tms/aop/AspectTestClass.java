package com.tms.aop;

import com.tms.aop.annotations.AspectAnnotation;
import org.springframework.stereotype.Component;

@Component
public class AspectTestClass {

    @AspectAnnotation       //своя созданная аннотация
    public void printOne() {
        System.out.println("One");
    }

    public int returnTen() {
//        if (true) {
//            throw new ArithmeticException();        // для аннотации @AfterThrowing
//        }
        return 10;
    }
}
