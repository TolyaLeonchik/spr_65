package com.tms.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Aspect     //говорит о том что класс будет аспектом
@Component
public class MyFirstAspect {
    //Pointcut - срез Join point'ов
    //Advice - в какой момент выполнения методов

    @Pointcut(value = "execution(public * com.tms.aop.*.*())") //где происходит срез
    void emptyMethod() {        //должен быть пустой!!!
    }

    @After("emptyMethod()")     //момент времени advice
    public void checkPointcut() {
        System.out.println("Pointcut work!");
    }

    //@Before()     перед выполнением метода
    //@After()      после выполнения метода
    //@Around()     перед и после выполнения метода
    //@AfterThrowing    после выбрасывания ошибки
    //@AfterReturning   после "возврата какого-либо значения" (все методы кроме void)

    @Before(value = "@annotation(com.tms.aop.annotations.AspectAnnotation)") //если несколько аннотаций, прописываются через ||
    public void startTimeEvent(JoinPoint joinPoint) {      //joinPoint - точка где работает аспект
        System.out.println(LocalTime.now() + " " + joinPoint.getSignature().getName() +  " method start working...");
        //joinPoint.getSignature(). - функция, в которой можно прописывать какие логи нужно выводить
    }

    @After(value = "execution(public * com.tms.aop.*.*())")     //execution - для точной настройки, более продвинутой
            //первая * - тип возвращаемого объекта, вторая * - это путь к опред классу, третья * - опред методы
    public void endTimeEvent(JoinPoint joinPoint) {      //joinPoint - точка где работает аспект
        System.out.println(LocalTime.now() + " " + joinPoint.getSignature().getName() +  " method finish working...");
        //joinPoint.getSignature(). - функция, в которой можно прописывать какие логи нужно выводить
    }

//    @Around(value = "within(com.tms.aop.*)")
//    public Object aroundExampleMethod(ProceedingJoinPoint joinPoint) throws Throwable { //класс Object тк Around не дружит с примитивами, в нашем случае int
//        System.out.println("Method started " + joinPoint.getSignature().getName());
//        Object returnValue = joinPoint.proceed();        //для обработки до и после
//        System.out.println("Method finished " + joinPoint.getSignature().getName());
//        return returnValue;
//    }

    @Around(value = "within(com.tms.aop.AspectTestClass)")
    public Object aroundExampleMethod(ProceedingJoinPoint joinPoint) throws Throwable { //класс Object тк Around не дружит с примитивами, в нашем случае int
        LocalTime startTime = LocalTime.now();
        Object returnValue = joinPoint.proceed();
        LocalTime endTime = LocalTime.now();
        System.out.println("Method worked " + (endTime.getNano() - startTime.getNano()));
        return returnValue;
    }

    @AfterThrowing(value = "within(com.tms.aop.*)", throwing = "err") //throwing и Throwable (их названия переменных) дожны совпадать
    public void printAfterThrow(Throwable err){
        System.out.println(LocalTime.now() + " " + err.toString());
    }

    @AfterReturning(value = "within(com.tms.aop.*)", returning = "retValue")
    public void returned(Object retValue) {                                 //Object - тк хз что будет возвращаться
        System.out.println("Print return value from aspect: " + retValue);
    }
}
