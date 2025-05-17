package com.example.personas.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.personas.config.AppConfig;
import com.example.personas.model.Persona;

@Service
public class PersonaService {
    
    private final Map<Long, Persona> personaDB= new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();
    private final AppConfig config;

    public PersonaService(AppConfig config) {
        this.config = config;
    }
    public List<Persona> getAll(){

        return personaDB.values().stream()
                .sorted(Comparator.comparing(Persona::getLastName)
                        .thenComparing(Persona::getFirstName))
                .collect(Collectors.toList());
    }

    public Optional<Persona> getById(Long id) {
        return Optional.ofNullable(personaDB.get(id));
    }

    public List<Persona> searchByName(String name) {
        return personaDB.values().stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public Persona create (Persona persona){

        persona.setId(idCounter.incrementAndGet());
        personaDB.put(persona.getId(), persona);
        return persona;
    }

    public Optional<Persona> update(Long id, Persona persona) {
        if (!personaDB.containsKey(id)) {
            return Optional.empty();
        }
        persona.setId(id);
        personaDB.put(id, persona);
        return Optional.of(persona);
    }

    public boolean delete(Long id) {
        return personaDB.remove(id) != null;
    }

  
}
