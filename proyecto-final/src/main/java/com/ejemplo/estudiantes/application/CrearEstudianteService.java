package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.application.mapper.StudentMapper;
import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrearEstudianteService {

    private final EstudianteRepository estudianteRepository;

    public Estudiante crearEstudiante(Estudiante estudiante) {

        EstudianteEntity entity = StudentMapper.INSTANCE.mapToEntity(estudiante); // mapeo del builder

        EstudianteEntity entitySave = estudianteRepository.save(entity);

        return StudentMapper.INSTANCE.mapToDomain(entitySave);
    }
}
