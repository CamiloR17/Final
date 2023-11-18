package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.application.mapper.StudentMapper;
import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.exception.ResourceNotFoundException;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VerEstudianteService {

    private final EstudianteRepository studentRepository;

    public List<Estudiante> getStudents() {
        return studentRepository.findAll().stream()
                .map(estudianteEntity ->
                    Estudiante.builder()
                            .id(estudianteEntity.getId())
                            .edad(estudianteEntity.getEdad())
                            .nombre(estudianteEntity.getNombre())
                            .apellido(estudianteEntity.getApellido())
                            .build())
                .collect(Collectors.toList());
    }

    public Estudiante getStudent(Long id) {

        EstudianteEntity estudianteEntity = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Usuario %d no encontrado", id)));

        return StudentMapper.INSTANCE.mapToDomain(estudianteEntity);
    }


}
