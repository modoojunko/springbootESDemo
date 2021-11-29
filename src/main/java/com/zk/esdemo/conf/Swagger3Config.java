package com.zk.esdemo.conf;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration

public class Swagger3Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return  new ApiInfoBuilder()
                .title("springboot data案例之elasticsearch")
                .description("springboot data elasticsearch案例,免费提供学习使用，如用于商业请遵循LICENSE")
                .version("1.0")
                .contact(new Contact("人在撸码","","alexee_zhu@foxmail.com"))
                .build();
    }

}
