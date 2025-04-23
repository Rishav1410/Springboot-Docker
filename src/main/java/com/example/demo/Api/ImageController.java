package com.example.demo.Api;

import com.example.demo.Data.Domain.Image;
import com.example.demo.Services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;


import java.util.List;
import java.util.Optional;
import java.io.IOException;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    private final ImageService imageService;

    @Autowired  
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            Image image = new Image();
            image.setName(file.getOriginalFilename());
            image.setContent(file.getBytes());
            Image saved = imageService.saveImage(image);
            return ResponseEntity.ok(saved.getId());

        }
        catch(Exception e )
        {
            return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id) {
            Optional<Image> imageOptional = imageService.getImageById(id);
            if (imageOptional.isPresent()) {
            Image image = imageOptional.get();
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // or detect dynamically
                    .body(image.getContent());
            } 
            else {
                return ResponseEntity.notFound().build();
            }

        
        
    }

}
