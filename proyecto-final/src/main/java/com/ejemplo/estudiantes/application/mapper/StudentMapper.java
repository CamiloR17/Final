package com.ejemplo.estudiantes.application.mapper;


import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {


    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    EstudianteEntity mapToEntity(Estudiante estudiante);

    Estudiante mapToDomain(EstudianteEntity estudianteEntity);
}
