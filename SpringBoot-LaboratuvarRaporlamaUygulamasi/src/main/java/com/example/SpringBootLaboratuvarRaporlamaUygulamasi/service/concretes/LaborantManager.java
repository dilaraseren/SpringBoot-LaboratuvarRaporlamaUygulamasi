package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.concretes;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Laborant;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.LaborantRepository;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.LaborantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaborantManager implements LaborantService {
    @Autowired
    private LaborantRepository laborantRepository;

    @Override
    public List<Laborant> getAllLaborants() {
        return laborantRepository.findAll();
    }

    @Override
    public void saveLaborants(Laborant laborant) {
        this.laborantRepository.save(laborant);
    }

    @Override
    public Laborant getLaborantById(long id) {
        Optional<Laborant> optional=laborantRepository.findById(id);
        Laborant laborant=null;
        if (optional.isPresent()){
            laborant=optional.get();
        }
        else{
            throw new RuntimeException("Employee not found for id :: "+id);
        }
        return laborant;
    }

    @Override
    public void deleteLaborantById(long id) {
    this.laborantRepository.deleteById(id);
    }
}
