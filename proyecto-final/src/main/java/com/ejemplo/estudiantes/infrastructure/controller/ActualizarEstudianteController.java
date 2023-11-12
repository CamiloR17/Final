package com.ejemplo.estudiantes.infrastructure.controller;

import com.ejemplo.estudiantes.application.ActualizarEstudianteService;
import com.ejemplo.estudiantes.domain.Estudiante;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("estudiantes")
@RequiredArgsConstructor
public class ActualizarEstudianteController {

    private final ActualizarEstudianteService updateStudent;

    @PutMapping(value = "/{id}")
    public Estudiante updateStudent(@PathVariable("id") Long id, @RequestBody Estudiante estudiante) {
        log.info("Actualizar estudiante...");
        return updateStudent.updateStudent(id, estudiante);
    }
}
