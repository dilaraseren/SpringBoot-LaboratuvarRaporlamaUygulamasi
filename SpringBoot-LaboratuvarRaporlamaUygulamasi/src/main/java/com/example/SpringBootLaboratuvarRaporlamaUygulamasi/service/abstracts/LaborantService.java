package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Laborant;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;

import java.util.List;

public interface LaborantService {
    List<Laborant> getAllLaborants();
    void saveLaborants(Laborant laborant);
    Laborant getLaborantById(long id);
    void deleteLaborantById(long id);
}
