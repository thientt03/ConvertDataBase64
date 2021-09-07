package com.example.demo.controller;

import com.example.demo.service.ConvertService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConvertRestController {

    @Autowired
    public ConvertService service;

    @RequestMapping(path = "/convert-data")
    public String getData(@RequestParam("inputdata") String inputdata){
        Gson gson = new Gson();
        return gson.toJson(service.getDataConvert(inputdata));
    }

    @ResponseBody
    @PostMapping(path = "/convert-data")
    public String convertData(@RequestParam("inputdata") String  inputdata){
        service.getBase(inputdata);
        Gson gson = new Gson();
        return gson.toJson(service.getDataConvert(inputdata));
    }
}
