package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Laborant;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LaborantService {
    List<Laborant> getAllLaborant();
    void saveLaborants(Laborant laborant);
    Laborant getLaborantById(long id);
    void deleteLaborantById(long id);

    List<Laborant> getSearchLaborant(String search);

    Page<Laborant> findPage(int pageNo, int pageSize, String sortField, String sortDirection);


}
