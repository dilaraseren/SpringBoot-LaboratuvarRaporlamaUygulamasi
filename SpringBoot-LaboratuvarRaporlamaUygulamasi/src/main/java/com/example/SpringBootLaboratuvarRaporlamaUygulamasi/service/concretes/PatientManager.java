package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.concretes;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.dto.PatientFilterDto;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.PatientRepository;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientManager implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAllPatient();
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

        this.patientRepository.deletePatientById(id);
    }

    @Override
    public List<Patient> getFilterPatient(PatientFilterDto patientFilterDto) {
        String name = patientFilterDto.getName();
        String surname = patientFilterDto.getSurname();
        String nationalIdentity = patientFilterDto.getNationalIdentity();

        List<Patient> patientFilter = patientRepository.findFilterPatient( name, surname,nationalIdentity);
        return patientFilter;
    }

    /*@Override
    public List<Patient> searchPatient(String name,String surname,String nationalIdentity,String keyword) {
        return patientRepository.search(name,surname,nationalIdentity,keyword);
    }*/

    /*@Override
    public List<Patient> searchPatient(Patient patient) {
        String name=patient.getName();
        String surname=patient.getSurname();
        String nationalIdentity=patient.getNationalIdentity();
        List<Patient> SearchApplicant=patientRepository.search(name,surname,nationalIdentity);
        return SearchApplicant;
    }*/

}
