package com.example.personas.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.personas.model.Pelicula;
import com.example.personas.model.Persona;
import com.example.personas.service.PeliculaService;
import com.example.personas.service.PersonaService;

@RestController
@RequestMapping("/personas/{id}/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;
    private final PersonaService personaService;

    public PeliculaController(PeliculaService peliculaService, PersonaService personaService) {
        this.peliculaService = peliculaService;
        this.personaService = personaService;
    }
    
    @GetMapping
    public ResponseEntity<List<Pelicula>> getPeliculas(@PathVariable Long id) {
        return personaService.getById(id)
                .map(persona -> ResponseEntity.ok(peliculaService.getPeliculas(persona)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> addPelicula(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        return personaService.getById(id)
                .map(persona -> {
                    boolean added = peliculaService.addPelicula(persona, pelicula);
                    if (added) {
                        return ResponseEntity.status(201).body(pelicula);
                    } else {
                        return ResponseEntity.status(400).body("No se puede agregar más películas a esta persona.");
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{titulo}")
    public ResponseEntity<?> removePelicula(@PathVariable Long id, @PathVariable String titulo) {
        return personaService.getById(id)
                .map(persona -> {
                    boolean removed = peliculaService.removePelicula(persona, titulo);
                    if (removed) {
                        return ResponseEntity.ok("Película eliminada correctamente.");
                    } else {
                        return ResponseEntity.status(404).body("Película no encontrada.");
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
