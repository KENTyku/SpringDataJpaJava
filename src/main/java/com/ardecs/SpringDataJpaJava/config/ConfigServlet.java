package com.ardecs.SpringDataJpaJava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
//@EnableSwagger2
@EnableWebMvc
@ComponentScan("com.ardecs.SpringDataJpaJava")
//унаследовавшись от  класса WebMvcConfigurerAdapter мы получим возможность сконфигурировать
// ResourceLocations(расположение статических ресурсов)
public class ConfigServlet extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //указываем расположение статических ресурсов(css, image, js и другие)
        registry.addResourceHandler("/WEB-INF/resources/**").addResourceLocations("/resources/");
//указываем обработчик ресурса swagger
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//указываем обработчик jar файлов для swagger
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    //определяем бин резолвера для представлений
    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }


}
