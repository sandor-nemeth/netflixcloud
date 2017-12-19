package io.github.sandornemeth.netflixcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RatingStoreApp {
    public static void main(String[] args) {
        SpringApplication.run(RatingStoreApp.class, args);
    }
}
