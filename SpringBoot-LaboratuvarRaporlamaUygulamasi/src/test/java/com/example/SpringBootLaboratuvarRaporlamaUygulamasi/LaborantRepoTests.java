package com.example.SpringBootLaboratuvarRaporlamaUygulamasi;


import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Laborant;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.LaborantRepository;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.PatientRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LaborantRepoTests {

    @Autowired
    LaborantRepository laborantRepository;

    @Test
    public void getListLaborantTest() {
        List<Laborant> laborantList = laborantRepository.findAll();
        Assertions.assertThat(laborantList.size()).isGreaterThan(0);
    }


}
