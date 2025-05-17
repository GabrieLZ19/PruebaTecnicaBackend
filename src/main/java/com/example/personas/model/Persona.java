package com.example.personas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Persona {
    
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private boolean hasInsurance;
    private List<Pelicula> favouriteMovies = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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
