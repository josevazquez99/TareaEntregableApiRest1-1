package com.vedruna.apiRest1_1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.apiRest1_1.dto.AlumnoDTO;
import com.vedruna.apiRest1_1.dto.ContactoDTO;
import com.vedruna.apiRest1_1.persistance.models.Alumno;
import com.vedruna.apiRest1_1.services.AlumnoServiceI;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/v1/alumno")
@CrossOrigin
public class AlumnoController {

    @Autowired
    private AlumnoServiceI alumnoMngmnt;
    
    @GetMapping
    public List<AlumnoDTO> getAllAlumnos() {
        return alumnoMngmnt.showAllAlumnos();
    }

    @GetMapping("/name/{name}")
    public AlumnoDTO showUserByUsername(@PathVariable String name) {
        return alumnoMngmnt.showAlumnoByName(name);
    }

    @GetMapping("/contact/{id}")
    public ContactoDTO getContactoByAlumnoId(@PathVariable int id) {
        return alumnoMngmnt.getContactoByAlumnoId(id);
    }



    @PostMapping("/insert")
    public String postUser(@RequestBody Alumno alumno) {
        alumnoMngmnt.saveAlumno(alumno);

        return "Alumno saved";
    }

    
    @DeleteMapping("delete/{id}")
    public String deleteAlumno(@PathVariable Integer id) {
        alumnoMngmnt.deleteAlumno(id);
        
        return "Alumno deleted";
    }

}
