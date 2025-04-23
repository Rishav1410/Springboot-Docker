package com.example.demo.Services;

import com.example.demo.Data.Domain.Image;
import java.util.List;
import java.util.Optional;

public interface ImageService {
    Image saveImage(Image image);
    Optional<Image> getImageById(String id);
    
}
