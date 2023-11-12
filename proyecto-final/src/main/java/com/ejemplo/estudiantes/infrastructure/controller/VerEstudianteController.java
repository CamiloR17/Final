package com.ejemplo.estudiantes.infrastructure.controller;

import com.ejemplo.estudiantes.application.VerEstudianteService;
import com.ejemplo.estudiantes.domain.Estudiante;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("estudiantes")
@RequiredArgsConstructor
public class VerEstudianteController {

    private final VerEstudianteService studentService;

    @GetMapping
    public List<Estudiante> getStudent() {
        log.info("Se están pidiendo todos los estudiantes");
        return studentService.getStudents();
    }

    @GetMapping(value = "/{id}")
    public Estudiante getStudent(@PathVariable(name = "id") Long id) {
        log.info("Pidiendo estudiante");
        return studentService.getStudent(id);
    }




}
