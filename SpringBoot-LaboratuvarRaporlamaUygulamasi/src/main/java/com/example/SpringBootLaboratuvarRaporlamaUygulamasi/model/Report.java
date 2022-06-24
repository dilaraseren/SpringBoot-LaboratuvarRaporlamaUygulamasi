package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "reports")
@Getter
@Setter
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "report_number")
    private Long reportNumber;

    @Column(name = "illnes_title")
    private String illnesTitle;

    @Column(name = "illnes_description")
    private String illnesDescription;

    @Column(name = "is_Active")
    private boolean isActive;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "media")
    private String media;

    @ManyToOne
    private Laborant laborant;

    @ManyToOne
    private Patient patient;



}
