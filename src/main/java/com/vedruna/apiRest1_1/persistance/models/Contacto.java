package com.vedruna.apiRest1_1.persistance.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="infocontacto")
public class Contacto implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idinfocontacto")
    private int contactoId;

    @Column(name="direccion")
    private String address;

    @Column(name="telefono")
    private int phone;

    @OneToOne
    @JoinColumn(name="alumnos_idalumno", referencedColumnName = "idalumno")
    private Alumno alumno;

}
