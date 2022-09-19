package at.fhtw.swen3;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.openapitools", "at.fhtw.swen3.services" , "at.fhtw.swen3.configuration"})
public class OpenApiGeneratorApplication {

    public static void main(String[] args) {
        /*
        Starts the application
        You probably saw that one coming
        It's nothing special
        and definitely not worth writing this much of a comment for
         */
        SpringApplication.run(OpenApiGeneratorApplication.class, args);
    }

    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}