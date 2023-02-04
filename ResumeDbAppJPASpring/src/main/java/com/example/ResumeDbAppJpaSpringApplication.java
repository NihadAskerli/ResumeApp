package com.example;

import com.example.repo.UserRepo;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResumeDbAppJpaSpringApplication {

    public static void main(String[] args) {

        SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);

    }

    @Autowired
    private UserService userService;

    @Bean
    public CommandLineRunner runner() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

//          userService.getAll()
            }
        };
        return clr;
    }
}


