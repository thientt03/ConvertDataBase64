package com.example.demo.service;

import com.example.demo.entities.Convertdata;
import com.example.demo.repository.ConvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Convert;
import javax.transaction.Transactional;
import java.util.Base64;

@Service
@Transactional
public class ConvertService {

    @Autowired
    private ConvertRepository repo;

    public String getBase(String text){
        String str = text;
        String encodedString = Base64.getEncoder().encodeToString(str.getBytes());
        Convertdata convertdata = new Convertdata();
        convertdata.setInputdata(str);
        convertdata.setOutputdata(encodedString);
        repo.save(convertdata);
        return "OK";
    }

    public String getDataConvert(String text){
        return repo.findAllByName(text);
    }
}
