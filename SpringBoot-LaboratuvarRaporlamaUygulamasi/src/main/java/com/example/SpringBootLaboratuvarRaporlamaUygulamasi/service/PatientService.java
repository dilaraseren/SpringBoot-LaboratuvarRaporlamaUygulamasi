package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {


    @Autowired
    private PatientRepository patientRepository;


    public List<Patient> getAllPatient() {
        return patientRepository.findAllPatients();
    }


    public void savePatients(Patient patient) {
        this.patientRepository.save(patient);
    }


    public Patient getPatientById(long id) {
        Optional<Patient> optional = patientRepository.findById(id);
        Patient patient = null;
        if (optional.isPresent()) {
            patient = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id :: " + id);
        }
        return patient;
    }


    public void deletePatientById(long id) {

        this.patientRepository.deletePatientById(id);
    }


    public List<Patient> getSearchPatient(String search) {

        List<Patient> listPatient = patientRepository.findPatientByKeyword(search);
        return listPatient;
    }


    public Page<Patient> findPage(int pageNo, int pageSize, String sortField, String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return patientRepository.findAll(pageable);
    }


}
