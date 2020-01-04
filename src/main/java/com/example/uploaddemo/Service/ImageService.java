package com.example.uploaddemo.Service;

import com.example.uploaddemo.Model.Image;
import com.example.uploaddemo.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository=imageRepository;
    }

    public List<Image> getAll(){
        return imageRepository.findAll();
    }
}
