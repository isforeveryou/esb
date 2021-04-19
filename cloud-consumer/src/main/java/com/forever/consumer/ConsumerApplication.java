package com.forever.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author WJX
 * @date 2021/4/15 14:30
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.forever.consumer"})
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
