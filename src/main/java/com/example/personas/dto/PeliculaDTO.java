package com.example.personas.dto;

import jakarta.validation.constraints.NotBlank;

public class PeliculaDTO {
    
    @NotBlank
    private String title;

    @NotBlank
    private String genre;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
