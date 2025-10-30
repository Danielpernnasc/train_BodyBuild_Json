package com.treino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.treino.domain")                    // <-- só entidades do domínio
@EnableJpaRepositories(basePackages = "com.treino.infrastructure") // <-- repositórios verdadeiros
public class ShapeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShapeApplication.class, args);
    }
}
