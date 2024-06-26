package com.example.demo.jsonplaceholder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JSONPlaceHolderConfiguration {
    @Bean("jsonplaceholder")
    CommandLineRunner runner(JSONPlaceholderClient jsonPlaceholderClient) {
        return args -> {
            System.out.println("https://jsonplaceholder.typicode.com/posts");
            System.out.println(jsonPlaceholderClient.getPosts().size());
            System.out.println();
            System.out.println("https://jsonplaceholder.typicode.com/post");
            System.out.println(jsonPlaceholderClient.getPost(1));
        };
    }
}
