package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.concretes;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.PatientRepository;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientManager implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void savePatients(Patient patient) {
        this.patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(long id) {
        Optional<Patient> optional=patientRepository.findById(id);
        Patient patient=null;
        if (optional.isPresent()){
            patient=optional.get();
        }
        else{
            throw new RuntimeException("Employee not found for id :: "+id);
        }
        return patient;
    }

    @Override
    public void deletePatientById(long id) {
        this.patientRepository.deleteById(id);
    }
}
