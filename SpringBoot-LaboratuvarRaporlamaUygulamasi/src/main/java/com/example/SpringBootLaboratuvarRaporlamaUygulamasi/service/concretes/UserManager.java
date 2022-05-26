package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.concretes;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.User;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.UserRepository;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserManager implements UserService {

    @Autowired
    private UserRepository userRepository ;
    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username,password);
        return user;
    }
}
