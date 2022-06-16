package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Query("SELECT u FROM Patient u WHERE u.isActive = false")
    List<Patient> findAllPatients();

    @Modifying
    @Transactional
    @Query("update Patient i set i.isActive =true "+
    "where i.id= :id")
    void deletePatientById(long id);

    @Query(value = "SELECT * FROM patients m WHERE m.name LIKE %:keyword% ", nativeQuery = true)
    List<Patient> findPatientByKeyword(@Param("keyword") String keyword);



}
