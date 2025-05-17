package com.example.personas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Value("${max.movies.per.person}")
    private int maxMoviesPerPerson;

    public int getMaxMoviesPerPerson() {
        return maxMoviesPerPerson;
    }
}
