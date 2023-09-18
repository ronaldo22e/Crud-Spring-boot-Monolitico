package com.Backend.Api.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<persona, Long> {
    // No necesitas agregar ningún método aquí, ya que JpaRepository proporciona métodos como findAll(), findById(), etc. automáticamente.
}
