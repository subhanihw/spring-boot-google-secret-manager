package com.nobita.microservices.samplerestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SampleRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleRestApiApplication.class, args);
    }

}
