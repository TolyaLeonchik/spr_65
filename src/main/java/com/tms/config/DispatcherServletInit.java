package com.tms.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /** классы, которые поднимают нужные нам бины */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;    //сначало null а потом после поднятия приложения Spring'ом то перестает им быть (САМ)
    }

    /** классы c настройками, где хранится ViewResolver */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class}; //класс настроек
    }

    /** на какие url отвечаем */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};   // отрабатывает на все запросы
    }
}
