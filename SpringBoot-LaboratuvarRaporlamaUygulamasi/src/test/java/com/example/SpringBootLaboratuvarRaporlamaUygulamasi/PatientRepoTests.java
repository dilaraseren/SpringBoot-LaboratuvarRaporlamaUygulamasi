package com.example.SpringBootLaboratuvarRaporlamaUygulamasi;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Patient;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.PatientRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PatientRepoTests {

    @Autowired
    PatientRepository patientRepository;

    @Test
    public void getListPatientTest() {
        List<Patient> patientList = patientRepository.findAll();
        Assertions.assertThat(patientList.size()).isGreaterThan(0);
    }

   /* @Test
    public void getPatientTest() {
        Patient patient = patientRepository.findById(1).get();
        Assertions.assertThat(patient.getId()).isEqualTo(1);
    }*/

}
