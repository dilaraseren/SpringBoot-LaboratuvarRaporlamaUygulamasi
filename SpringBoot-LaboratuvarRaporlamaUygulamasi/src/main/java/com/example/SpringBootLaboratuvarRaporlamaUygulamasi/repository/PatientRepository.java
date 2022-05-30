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
    List<Patient> findAllPatient();

    @Modifying
    @Transactional
    @Query("update Patient i set i.isActive =true "+
    "where i.id= :id")
    void deletePatientById(long id);

  /*  //search
    @Query(value = "select * from patient s where s.name like %:keyword% or s.surname like %:keyword% or s.nationalIdentity like %:keyword%", nativeQuery = true)
    List<Patient> search(String name, String  surname, String  nationalIdentity,String keyword);*/
}
