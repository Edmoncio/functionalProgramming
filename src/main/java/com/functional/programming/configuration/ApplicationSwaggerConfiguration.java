package com.functional.programming.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
@Import(SpringDataRestConfiguration.class)
public class ApplicationSwaggerConfiguration {


//This is not useful any more if we use swagger groups
//    @Bean
//    Docket testApiDocumentation(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }


//TODO: move this values into properties configuration
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Functional Programming API")
                        .version("V1")
                        .description("Here we have examples to test different methods implemented with functional" +
                                " programming and structured programming, in order to be able to see de differences between those")
                        .contact(new Contact()
                                .name("Edmoncio")
                                .url("https://github.com/Edmoncio")
                                .email("edmoncio@gmail.com"))
                        /*.license(new License()
                                .name("No license")
                                .url("No license url"))*/);
    }

    @Bean
    public GroupedOpenApi functionalApi() {
        return GroupedOpenApi.builder()
                .group("Functional")
                .pathsToMatch("/functional-programming/**")
                .build();
    }

    @Bean
    public GroupedOpenApi structuredApi() {
        return GroupedOpenApi.builder()
                .group("Structured")
                .pathsToMatch("/structured-programming/**")
                .build();
    }

}
