package net.petriv.terminal.runapp;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("net.petriv.terminal.dao")
@ComponentScan(basePackages = { "net.petriv.terminal.*" })
@EntityScan("net.petriv.terminal.model")
@SpringBootApplication
public class Runner {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {

        SpringApplication.run(Runner.class, args);

        logger.info("Application server started ");
    }
}
