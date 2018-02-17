package net.petriv.terminal.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("net.petriv.terminal.dao")
@ComponentScan(basePackages = { "net.petriv.terminal.*" })
@EntityScan("net.petriv.terminal.model")
@SpringBootApplication
public class RunApp {

    public static void main(String[] args) {
        SpringApplication.run(RunApp.class, args);
    }
}
