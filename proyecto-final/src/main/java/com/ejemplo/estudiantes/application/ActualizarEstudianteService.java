package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.application.mapper.StudentMapper;
import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.exception.ResourceNotFoundException;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ActualizarEstudianteService {

    private final EstudianteRepository studentRepository;

    public Estudiante updateStudent(Long id, Estudiante newStudent) {
        EstudianteEntity estudiante = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Usuario %d no encontrado", id)));

        EstudianteEntity entity = EstudianteEntity.builder()
                .id(estudiante.getId())
                .nombre(newStudent.getNombre())
                .apellido(newStudent.getApellido())
                .edad(newStudent.getEdad())
                .build();

        EstudianteEntity entitySave = studentRepository.save(entity);
        return StudentMapper.INSTANCE.mapToDomain(entitySave);
    }
}
