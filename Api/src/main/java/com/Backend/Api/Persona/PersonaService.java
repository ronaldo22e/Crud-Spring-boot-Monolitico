package com.Backend.Api.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    private final PersonaRepository personaRepo;

    @Autowired
    public PersonaService(PersonaRepository personaRepo) {
        this.personaRepo = personaRepo;
    }

    public void createPersona(persona persona) {
        if (persona.getNombre() != null && persona.getGenero() != null && persona.getDescripcion() != null) {
            personaRepo.save(persona);
        } else {
            throw new IllegalArgumentException("Los campos nombre, género y descripción no pueden ser nulos");
        }
    }

    public List<persona> obtenerTodasLasPersonas() {
        return personaRepo.findAll();
    }

    public void eliminar(Long id) {
        personaRepo.deleteById(id);
    }

    public Optional<persona> obtenerPersonaPorId(Long id) {
        return personaRepo.findById(id);
    }

    public void actualizarPersona(Long id, persona personaActualizada) {
        Optional<persona> personaExistente = personaRepo.findById(id);

        if (personaExistente.isPresent()) {
            persona persona = personaExistente.get();
            persona.setNombre(personaActualizada.getNombre());
            persona.setGenero(personaActualizada.getGenero());
            persona.setDescripcion(personaActualizada.getDescripcion());

            personaRepo.save(persona);
        } else {
            throw new IllegalArgumentException("No se encontró la persona con ID: " + id);
        }
    }
}
