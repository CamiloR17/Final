package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EliminiarEstudianteService {

    private final EstudianteRepository studentRepository;

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
