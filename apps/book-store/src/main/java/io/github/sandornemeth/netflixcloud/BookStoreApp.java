package io.github.sandornemeth.netflixcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BookStoreApp {
    public static void main(String[] args) {
        SpringApplication.run(BookStoreApp.class, args);
    }
}
