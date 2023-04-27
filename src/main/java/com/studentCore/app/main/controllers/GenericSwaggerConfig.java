package com.studentCore.app.main.controllers;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * This class is created to configure the
 * SWAGGER 2 for AMS Application.
 * The swagger API
 * http://localhost:8000/swagger-ui.html#/
 */
@Configuration
@EnableSwagger2
public class GenericSwaggerConfig {
        
        @Bean
        public Docket api(){
                return  new
                        Docket(DocumentationType.SWAGGER_2).select()
                        .apis(RequestHandlerSelectors.basePackage("com.studentCore.app.main.controllers"))
                        .paths(PathSelectors.any()).build();
        }
        
        @Bean
        public RestTemplate getAMSRestTemplate(){
                return new RestTemplate();
        }
        
}

