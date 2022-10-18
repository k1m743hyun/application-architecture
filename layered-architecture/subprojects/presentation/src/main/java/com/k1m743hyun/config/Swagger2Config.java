package com.k1m743hyun.config;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger2Config {

    private static final String API_NAME = "Member";

    private static final String API_DESCRIPTION = "API 명세서(스펙)";

    private static final String API_VERSION = "1.0.0";

    /**
     * localhost:8080/swagger-ui.html
     * @return
     */

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .consumes(this.getConsumeContentType())
            .produces(this.getProduceContentType())
            .apiInfo(this.apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.k1m743hyun"))
            .paths(PathSelectors.any())
            .build();
    }

    private Set<String> getConsumeContentType() {

        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/xml;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");

        return consumes;
    }

    private Set<String> getProduceContentType() {

        Set<String> produces = new HashSet<>();
        produces.add("application/json");
        produces.add("application/xml");

        return produces;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title(API_NAME)
            .description(API_DESCRIPTION)
            .version(API_VERSION)
            .build();
    }
}
