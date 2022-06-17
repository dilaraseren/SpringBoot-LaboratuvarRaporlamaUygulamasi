package com.example.SpringBootLaboratuvarRaporlamaUygulamasi;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.User;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat; //assertion program durumunu izler hata yönetimini sağlar.

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository repository;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("laborant@gmail.com");
        user.setPassword("laborant");
        user.setFirstName("laborant");
        user.setLastName("laborant");

        User savedUser = repository.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }
}
