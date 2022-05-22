package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Laborant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaborantRepository extends JpaRepository<Laborant,Long> {
}
