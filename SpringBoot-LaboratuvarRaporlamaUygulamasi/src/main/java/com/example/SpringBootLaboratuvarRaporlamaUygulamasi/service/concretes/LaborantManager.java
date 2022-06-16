package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.concretes;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Laborant;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.LaborantRepository;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.LaborantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaborantManager implements LaborantService {
    @Autowired
    private LaborantRepository laborantRepository;

    @Override
    public List<Laborant> getAllLaborant() {
        return laborantRepository.findAllLaborant();
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
    this.laborantRepository.deleteLaborantById(id);
    }

    @Override
    public List<Laborant> getSearchLaborant(String search) {
        List<Laborant> listLaborants = laborantRepository.findLaborantsByKeyword(search);
        return listLaborants;
    }

    @Override
    public Page<Laborant> findPage(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return laborantRepository.findAll(pageable);
    }


}
