package com.example.convert.controller;

import com.example.convert.DataDTO;
import com.example.convert.service.ConvertService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConvertController {

    @Autowired
    public ConvertService service;

    @ResponseBody
    @PostMapping(path = "/encoder")
    public String encodeData(@RequestBody DataDTO input){
        return service.encodeString(input.getInput());
    }

    @ResponseBody
    @PostMapping(path = "/decoder")
    public String decoderData(@RequestBody DataDTO input){
        return service.decodeString(input.getInput());
    }

    @ResponseBody
    @PostMapping(path = "/image")
    public String encodeImage(@RequestParam("imageFile") MultipartFile imageFile) {
        return service.encodeImageToBase64(imageFile);
    }

    @ResponseBody
    @PostMapping(path = "/decode-image")
    public byte[] decodeImage(@RequestBody DataDTO input) throws Exception {
        return service.decodeImageToBase64(input.getInput());
    }

    @ResponseBody
    @PostMapping(path = "/test")
    public ResponseEntity<List<String>> getImage(@RequestBody DataDTO input){
        String extension = FilenameUtils.getExtension("out.png");
        List<String> images = new ArrayList<>();
        images.add("data:image/"+extension+";base64,"+input.getInput());
        return new ResponseEntity<List<String>>(images, HttpStatus.OK);
    }
}
