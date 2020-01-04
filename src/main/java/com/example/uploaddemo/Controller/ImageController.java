package com.example.uploaddemo.Controller;

import com.example.uploaddemo.Model.Image;
import com.example.uploaddemo.Repository.ImageRepository;
import com.example.uploaddemo.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api/")
public class ImageController {
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    ImageService imageService;

    @PostMapping("ocr")
    public void postImg(@RequestParam("image") MultipartFile file)
    {
        try {
            if (file == null) {
                System.out.println("null file");
            }else
            {
                byte[] imageBytes = file.getBytes();
                String fileDirPath = "C:\\Users\\Home\\Documents\\Android Image Upload To Spring\\images";
                File fileDir = new File(fileDirPath);
                File dest = new File(fileDir,  file.getOriginalFilename());
                file.transferTo(dest);
                Image image=new Image(fileDir.toString());
                imageRepository.save(image);

            }
        }catch (Exception e)
        {
            System.out.println("exception");
        }
    }
}
