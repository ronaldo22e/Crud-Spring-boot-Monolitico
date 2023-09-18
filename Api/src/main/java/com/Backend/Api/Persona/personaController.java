package com.Backend.Api.Persona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/Api/personas")

public class personaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/listar")
    public ModelAndView listarPersonas() {
        List<persona> personas = personaService.obtenerTodasLasPersonas();
        ModelAndView modelAndView = new ModelAndView("lista_personas");
        modelAndView.addObject("personas", personas);
        return modelAndView;
    }

    @GetMapping("/nuevo")
    public ModelAndView mostrarFormularioNuevaPersona() {
        ModelAndView modelAndView = new ModelAndView("formulario_persona");
        modelAndView.addObject("persona", new persona());
        return modelAndView;
    }

    @PostMapping("/guardar")
    public ModelAndView guardarPersona(@ModelAttribute persona persona) {
        personaService.createPersona(persona);
        return new ModelAndView("redirect:/Api/personas/listar");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView mostrarFormularioEditarPersona(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("formulario_persona");
        Optional<persona> persona = personaService.obtenerPersonaPorId(id);
        if (persona.isPresent()) {
            modelAndView.addObject("persona", persona.get());
        } else {
            modelAndView.setViewName("redirect:/personas/listar");
        }
        return modelAndView;
    }

    @GetMapping("/eliminar/{id}")
public ModelAndView eliminarPersona(@PathVariable Long id) {
    personaService.eliminar(id);
    return new ModelAndView("redirect:/Api/personas/listar");
}
@PostMapping("/actualizar/{id}")
public ModelAndView actualizarPersona(@PathVariable Long id, @ModelAttribute persona personaActualizada) {
    personaService.actualizarPersona(id, personaActualizada);
    return new ModelAndView("redirect:/Api/personas/listar");
}

}

