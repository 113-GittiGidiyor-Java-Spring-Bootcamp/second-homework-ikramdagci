package com.ikramdagci.secondhomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication

public class SecondHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondHomeworkApplication.class, args);
    }

}
