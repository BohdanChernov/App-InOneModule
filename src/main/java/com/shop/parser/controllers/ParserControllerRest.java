package com.shop.parser.controllers;


import com.shop.models.laptop.Laptop;
import com.shop.models.laptop.laptopDetails.LaptopPhoto;
import com.shop.parser.parser.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ParserControllerRest {

    @Autowired
    ParserService parserService;

    @GetMapping("/parserRest")
    public String getParser() {
        return "parserRest";
    }

    @PostMapping("/parserRest")
    @ResponseBody
    public ResponseEntity<Laptop> postParser(ModelMap modelMap, @RequestParam String url) {
        Laptop laptop = parserService.getMapCharacteristics(url);
        System.out.println(laptop);
        List<LaptopPhoto> photos = parserService.getListPhotos(url, laptop);
        System.out.println(photos);
        laptop.setPhoto(photos);
        modelMap.addAttribute("laptop", laptop);
        ResponseEntity<Laptop> responseEntity = new ResponseEntity<Laptop>(laptop, HttpStatus.OK);
        return responseEntity;
    }

}
