package com.forever.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author WJX
 * @date 2021/4/15 10:32
 */
@EnableScheduling
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.forever.provider"})
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
