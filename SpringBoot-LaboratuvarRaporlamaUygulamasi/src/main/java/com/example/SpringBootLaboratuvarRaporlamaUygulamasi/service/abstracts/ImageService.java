package com.example.SpringBootLaboratuvarRaporlamaUygulamasi.service.abstracts;


import com.example.SpringBootLaboratuvarRaporlamaUygulamasi.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface ImageService {
     Image store(MultipartFile file) throws IOException;
     Image getFile(Long id);
     Stream<Image> getAllFiles();
}
