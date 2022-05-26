package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReportRepository  extends JpaRepository<Report,Long> {
    @Query("SELECT u FROM Report u WHERE u.isActive = false")
    List<Report> findAllReport();

    @Modifying
    @Transactional
    @Query("update Report i set i.isActive =true "+
            "where i.id= :id")
    void deleteReportById(long id);

    @Query("SELECT u FROM Report u order by u.reportDate desc") //tarih sorgusu sıralama
    List<Report> listDateReport();

    
}
