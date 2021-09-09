package com.example.convert.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.util.Base64;

@Service
public class ConvertService {

    public String encodeString(String input) {
        String convertedString = Base64.getEncoder().encodeToString(input.getBytes());
        Gson gson= new GsonBuilder().create();
        return gson.toJson(convertedString);
    }
    public String decodeString(String input) {
        String stringConverted = "";

        try {
            byte[] decodedBytes = Base64.getDecoder().decode(input);
            stringConverted = new String(decodedBytes);
        }catch(IllegalArgumentException e){
            stringConverted = "Loi khong hop le";
        }
        Gson gson= new GsonBuilder().create();
        return gson.toJson(stringConverted);
    }

    public String encodeImageToBase64(MultipartFile file) {
        String base64Image = "";
        try {
            base64Image = Base64.getEncoder().encodeToString(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson= new GsonBuilder().create();
        return gson.toJson(new String(base64Image));
    }

    public static byte[] decodeImageToBase64(String base64String) throws Exception{
        FileWriter fileWriter = new FileWriter(new File("out.txt"));
        fileWriter.write(base64String);
        FileOutputStream stream = new FileOutputStream(new File("out.png"));
        stream.write(Base64.getDecoder().decode(base64String));
        fileWriter.close();

        return new byte[1];
    }


}
