package com.vedruna.apiRest1_1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.apiRest1_1.dto.AlumnoDTO;
import com.vedruna.apiRest1_1.dto.ContactoDTO;
import com.vedruna.apiRest1_1.persistance.models.Alumno;
import com.vedruna.apiRest1_1.persistance.repository.AlumnoRepositoryI;

@Service
public class AlumnoServiceImpl implements AlumnoServiceI {

    @Autowired
    AlumnoRepositoryI alumnoRepo;

    @Override
    public List<AlumnoDTO> showAllAlumnos() {
        List<Alumno> alumnos = alumnoRepo.findAll();
        List<AlumnoDTO> alumnosDTO = new ArrayList<AlumnoDTO>();

        for (Alumno a : alumnos) {
            alumnosDTO.add(new AlumnoDTO(a));
        }

        return alumnosDTO;
    }

    @Override
    public AlumnoDTO showAlumnoByName(String name) {
        return new AlumnoDTO(alumnoRepo.findByname(name));
    }

    @Override
    public void saveAlumno(Alumno alumno) {
        if (alumno.getContacto() != null) {
            alumno.getContacto().setAlumno(alumno);  
        }
        alumnoRepo.save(alumno);
    }
    


    @Override
    public void deleteAlumno(Integer id) {
        alumnoRepo.deleteById(id);    
    }

    @Override
    public ContactoDTO getContactoByAlumnoId(Integer id) {
        Alumno alumno = alumnoRepo.findById(id).orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        return new ContactoDTO(alumno.getContacto());    
    }

    
}
