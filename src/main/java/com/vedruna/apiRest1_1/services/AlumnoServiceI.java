package com.vedruna.apiRest1_1.services;

import java.util.List;

import com.vedruna.apiRest1_1.dto.AlumnoDTO;
import com.vedruna.apiRest1_1.dto.ContactoDTO;
import com.vedruna.apiRest1_1.persistance.models.Alumno;

public interface AlumnoServiceI {
    List<AlumnoDTO> showAllAlumnos();
    AlumnoDTO showAlumnoByName(String name);
    ContactoDTO getContactoByAlumnoId(Integer id);
    void saveAlumno(Alumno alumno);
    void deleteAlumno(Integer id);
}
