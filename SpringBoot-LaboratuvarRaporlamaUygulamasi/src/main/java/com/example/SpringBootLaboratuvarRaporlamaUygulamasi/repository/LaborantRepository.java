package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Laborant;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LaborantRepository extends JpaRepository<Laborant,Long> {

    @Query("SELECT u FROM Laborant u WHERE u.isActive = false")
    List<Laborant> findAllLaborant();

    @Modifying
    @Transactional
    @Query("update Laborant i set i.isActive =true "+
            "where i.id= :id")
    void deleteLaborantById(long id);
}
