package com.ardecs.SpringDataJpaJava.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    // Этот метод должен содержать конфигурации которые инициализируют бины всего нашего приложения
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    // Тут добавляем конфигурацию, в которой инициализируем ViewResolver
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }

    //настройка обработки запросов сервлетом диспетчером
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}