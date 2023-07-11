package com.tms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableAspectJAutoProxy     //активирует АОП
@ComponentScan("com.tms")       //с какой папки начинать вычитывать все классы
@Configuration                  //которые будут использоваться для настройки, где мы будем создавать свои бины
public class SpringConfig {

    @Bean
    public InternalResourceViewResolver viewResolverInit() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");   // /WEB-INF/HelloMVC.jsp
        return viewResolver;
    }

}
