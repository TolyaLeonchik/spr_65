package com.tms;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton") //(prototype) - отменяет синглтон(пример employee & employee1)
@Component(value = "employee-bean")      //разрешает спрингу управлять объектами employee (через Component спринг
//сам создает и сам использует
public class Employee {
    private Integer id;
    private String username;
    private Integer age;
    //@Autowired                //место, куда можно ставить(ООЧ ПЛОХОЕ) (не отработает из-за жизн.цикла бина(будет работать в жепе, далеко не сразу) = null)
    private HRManager hrManager;

    @Autowired          //место, куда можно ставить (СЮДА НАДА НАД КОНСТРУКТАРАМИ) - засовывает 1 бин во второй бин
    public Employee(HRManager hrManager) {
        this.hrManager = hrManager;
    }

    @PostConstruct
    public void init() {
        System.out.println("Init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy method");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

                        //Не ставится сюда!
    public HRManager getHrManager() {
        return hrManager;
    }

    //@Autowired            //место, куда можно ставить
    public void setHrManager(HRManager hrManager) {
        this.hrManager = hrManager;
    }
}
