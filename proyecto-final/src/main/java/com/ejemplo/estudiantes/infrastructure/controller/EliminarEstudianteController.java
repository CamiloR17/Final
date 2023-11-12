package com.ejemplo.estudiantes.infrastructure.controller;

import com.ejemplo.estudiantes.application.EliminiarEstudianteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("estudiantes")
@RequiredArgsConstructor
public class EliminarEstudianteController {

    private final EliminiarEstudianteService studentService;

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        log.info("Eliminando estudiante...");
        studentService.deleteStudent(id);
    }
}
