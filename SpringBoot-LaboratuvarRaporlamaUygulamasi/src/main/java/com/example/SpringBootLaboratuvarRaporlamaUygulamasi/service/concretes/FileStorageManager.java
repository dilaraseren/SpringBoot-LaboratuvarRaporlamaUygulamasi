package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.concretes;

import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Image;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.repository.ImageRepository;
import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileStorageManager implements ImageService {
    @Autowired
    private ImageRepository imageRepository;


    public Image store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Image image = new Image(fileName, file.getContentType(), file.getBytes());
        return imageRepository.save(image);
    }


    public Image getFile(Long id) {
        return imageRepository.findById(id).get();
    }

    public Stream<Image> getAllFiles() {
        return imageRepository.findAll().stream();
    }
}
