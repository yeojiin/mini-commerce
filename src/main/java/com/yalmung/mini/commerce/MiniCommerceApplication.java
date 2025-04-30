package com.yalmung.mini.commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MiniCommerceApplication {

    public static void main(String[] args) {

        System.out.println("=== args ===");
        for (String arg : args) {
            System.out.println(arg);
        }


        SpringApplication.run(MiniCommerceApplication.class, args);
        System.out.print("시작 성공!!!!!!!!!!");
    }

}
