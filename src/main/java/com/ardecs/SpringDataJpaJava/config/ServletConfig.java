package com.ardecs.SpringDataJpaJava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
//унаследовавшись от  класса WebMvcConfigurerAdapter мы получим возможность сконфигурировать
// ResourceLocations(расположение статических ресурсов)
public class ServletConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //указываем расположение статических ресурсов(css, image, js и другие)
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    //определяем бин резолвера для представлений
    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
//бин резолвера для форм с данными смешанного типа(картинки +текст)
    @Bean (name = "multipartResolver")
    public CommonsMultipartResolver setupMultipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(9000000);
        return resolver;
    }


}
