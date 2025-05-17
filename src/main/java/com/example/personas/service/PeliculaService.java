package com.example.personas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.personas.config.AppConfig;
import com.example.personas.model.Pelicula;
import com.example.personas.model.Persona;

@Service
public class PeliculaService {
    
    private final AppConfig config;

    public PeliculaService(AppConfig config) {
        this.config = config;
    }

    public List<Pelicula> getPeliculas(Persona persona){

        return persona.getFavouriteMovies();

    }

    public boolean addPelicula(Persona persona, Pelicula pelicula) {

        if (persona.getFavouriteMovies().size() >= config.getMaxMoviesPerPerson()) {
            return false; 
        }

        return persona.getFavouriteMovies().add(pelicula);
        
    }

    public boolean removePelicula(Persona persona, String titulo) {

        return persona.getFavouriteMovies().removeIf(p-> p.getTitle().equalsIgnoreCase(titulo));
        
    }
}
