package com.test.contactapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Swapnil Bagadia
 */
@EnableSwagger2
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
@EnableCaching
public class ContactConfiguration {

    @Value("${swagger.enabled}")
    private boolean isSwaggerEnabled;

    @Bean
    public Docket swaggerSettings() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(isSwaggerEnabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.test.contactapp"))
                .paths(PathSelectors.any())
                .build();
    }

}
