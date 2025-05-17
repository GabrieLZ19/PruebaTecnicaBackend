package com.example.personas.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.personas.model.Pelicula;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PersonaDTO {

    private Long id;

    @NotBlank 
    private String firstname;

    @NotBlank
    private String lastname;
    
    @NotNull
    private LocalDate birthdate;

    private boolean hasInsurance;

    private List<Pelicula> favouriteMovies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public List<Pelicula> getFavouriteMovies() {
        return favouriteMovies;
    }

    public void setFavouriteMovies(List<Pelicula> favouriteMovies) {
        this.favouriteMovies = favouriteMovies;
    }
}
