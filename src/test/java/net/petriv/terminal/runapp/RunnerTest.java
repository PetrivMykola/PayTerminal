package net.petriv.terminal.runapp;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {

    @Test
    void configure() {
        String auth = "dXNlcjpwYXNzd29yZA==";
        System.out.println(new String(Base64.getDecoder().decode(auth)));

        System.out.println(new BCryptPasswordEncoder().encode("password"));
    }

}