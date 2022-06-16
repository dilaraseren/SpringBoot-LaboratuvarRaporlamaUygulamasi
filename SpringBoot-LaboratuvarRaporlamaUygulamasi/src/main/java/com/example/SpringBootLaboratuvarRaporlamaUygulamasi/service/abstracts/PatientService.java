package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatient();
    void savePatients(Patient patient);
    Patient getPatientById(long id);
    void deletePatientById(long id);

    List<Patient> getSearchPatient(String search);

    Page<Patient> findPage(int pageNo, int pageSize, String sortField, String sortDirection);


}
