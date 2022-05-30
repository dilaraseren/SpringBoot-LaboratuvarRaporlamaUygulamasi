package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    void savePatients(Patient patient);
    Patient getPatientById(long id);
    void deletePatientById(long id);
    /*List<Patient> searchPatient(String name,String surname,String nationalIdentity,String keyword);*/

}
