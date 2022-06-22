package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Laborant;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.LaborantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaborantService  {
    @Autowired
    private LaborantRepository laborantRepository;


    public List<Laborant> getAllLaborant() {
        return laborantRepository.findAllLaborant();
    }


    public void saveLaborants(Laborant laborant) {
        this.laborantRepository.save(laborant);
    }


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


    public void deleteLaborantById(long id) {
    this.laborantRepository.deleteLaborantById(id);
    }


    public List<Laborant> getSearchLaborant(String search) {
        List<Laborant> listLaborants = laborantRepository.findLaborantsByKeyword(search);
        return listLaborants;
    }


    public Page<Laborant> findPage(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return laborantRepository.findAll(pageable);
    }


}
