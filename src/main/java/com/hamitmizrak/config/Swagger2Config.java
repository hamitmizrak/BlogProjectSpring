package com.hamitmizrak.config;

import java.time.LocalDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    // http://localhost:8080
    // http://localhost:8080/swagger-ui.html
    // http://localhost:8080/explorer/index.html#uri=/

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("title:Hamit Mızrak 15 Haziran 2021")
                .description("description:Spring Boot").termsOfServiceUrl("http://www.hamitmizrak.com.tr")
                .license("license:for Spring Boot  HamitMizrak")
                .contact(new Contact("Hamit", "http://www.hamitmizrak.com", "hamitmizrak@gmail.com")).version("1.0.0")
                .build();
    }

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.hamitmizrak.ui.rest")).build().pathMapping("/")
                .useDefaultResponseMessages(false).directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class);
    }
}
