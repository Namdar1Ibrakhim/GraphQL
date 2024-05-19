package com.example.graphql.config;

import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphqlConfig {

    @Bean
    public GraphQLScalarType localDateTimeScalar(){ // создаем scalar который описан в types.graphqls
        return GraphQLScalarType.newScalar()
                .name("LocalDateTime")  //указываем имя из types.graphqls
                .description("LocalDateTime scalar") // описание
                .coercing(new LocalDateTimeCoercing()) //класс который будет обрабатывать этот скаляр
                .build();
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer(){ //бин конфигурации куда мы добавим наш скаляр
        return wiringBuilder -> wiringBuilder
                .scalar(localDateTimeScalar())
                .build();
    }
}
