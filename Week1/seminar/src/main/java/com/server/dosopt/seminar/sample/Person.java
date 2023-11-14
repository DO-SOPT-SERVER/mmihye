package com.server.dosopt.seminar.sample;

import lombok.Builder;
import lombok.Getter;
import org.springframework.boot.SpringApplication;

@Getter
public class Person {

    private String firstName;
    private String lastName;

    @Builder
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
