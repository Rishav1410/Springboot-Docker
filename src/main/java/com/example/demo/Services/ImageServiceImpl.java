package com.example.demo.Services;

import com.example.demo.Data.Domain.Image;
import com.example.demo.Data.Repository.ImageRepository;
import com.example.demo.Services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    
    @Autowired  
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Optional<Image> getImageById(String id) {
        return imageRepository.findById(id);
    }
}


