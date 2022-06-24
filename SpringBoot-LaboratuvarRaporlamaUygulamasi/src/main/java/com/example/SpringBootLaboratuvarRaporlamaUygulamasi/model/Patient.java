package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "national_identity")
    private String nationalIdentity;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "age")
    private Integer age;

    @Column(name = "is_Active")
    private boolean isActive;



}
