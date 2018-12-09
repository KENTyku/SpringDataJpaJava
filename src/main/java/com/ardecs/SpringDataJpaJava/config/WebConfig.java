package com.ardecs.SpringDataJpaJava.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    // Этот метод должен содержать конфигурации которые инициализируют бины всего нашего приложения
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ConfigApp.class};
//        return null;
    }
    // Тут добавляем конфигурацию, в которой инициализируем ViewResolver
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ConfigServlet.class};
//        return null;
    }
//настройка обработки запросов сервлетом диспетчером
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}