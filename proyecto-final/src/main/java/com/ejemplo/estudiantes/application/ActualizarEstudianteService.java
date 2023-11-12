package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.application.mapper.StudentMapper;
import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ActualizarEstudianteService {

    private final EstudianteRepository studentRepository;

    public Estudiante updateStudent(Long id) {
        EstudianteEntity estudiante = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la entidad con ID: " + id));

//        EstudianteEntity entity = EstudianteEntity.builder()
//                .id(estudiante.getId())
//                .nombre(estudiante.getNombre())
//                .apellido(estudiante.getApellido())
//                .edad(estudiante.getEdad())
//                .build();

        EstudianteEntity entitySave = studentRepository.save(estudiante);
        return StudentMapper.INSTANCE.mapToDomain(entitySave);
    }
}
