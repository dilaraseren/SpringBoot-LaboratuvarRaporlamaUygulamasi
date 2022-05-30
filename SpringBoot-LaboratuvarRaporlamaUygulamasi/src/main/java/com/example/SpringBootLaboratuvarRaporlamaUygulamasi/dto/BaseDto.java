package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDto implements Serializable {

    private Date reportDate;
}
