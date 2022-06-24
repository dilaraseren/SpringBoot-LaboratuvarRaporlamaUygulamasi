package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "laborants")
@Getter
@Setter
public class Laborant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "hospital_number")
    private Long hospitalNumber;

    @Column(name = "is_Active")
    private boolean isActive;

}
