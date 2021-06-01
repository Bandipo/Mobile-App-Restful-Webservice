package com.example.mobileappwebservice.congifuguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket questionAndAnswerApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                .useDefaultResponseMessages(true);
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Mobile-app-webService Documentatation ",
                "This is a blog Api",
                "1.0",
                "none-for-now",
                "Bandipo Taiye Olusayo ",
                "Mit License",
                "none-for-now"
        );
    }
}