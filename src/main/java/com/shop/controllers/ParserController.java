package com.shop.controllers;

import com.shop.dao.DAOLaptopFilters.*;
import com.shop.dao.DAOLaptopInterface;
import com.shop.models.laptop.Laptop;
import com.shop.models.laptop.laptopDetails.LaptopManufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class ParserController {

    @Autowired
    private DAOLaptopInterface daoLaptopInterface;
    @Autowired
    private DAODisplayDiagonal daoDisplayDiagonal;
    @Autowired
    private DAODisplayResolution daoDisplayResolution;
    @Autowired
    private DAODisplayType daoDisplayType;
    @Autowired
    private DAOLaptopManufacturer daoLaptopManufacturer;
    @Autowired
    private DAOLaptopPhotos daoLaptopPhotos;
    @Autowired
    private DAOProcessorType daoProcessorType;
    @Autowired
    private DAORAMSize daoramSize;
    @Autowired
    private DAORAMType daoramType;
    @Autowired
    private DAOStorageSize daoStorageSize;
    @Autowired
    private DAOStorageType daoStorageType;

    @GetMapping("/parser")
    public String getParse() {
        return "parser";
    }

    @PostMapping("/parser")
    public String postParse(String[] laptopLinks) {
        List<String> laptopArray = Arrays.asList(laptopLinks);

        laptopArray.forEach(s -> {
            if (!s.equals("")) {
                parseLaptop(s);
            }
        });

        return "parser";
    }


    public void parseLaptop(String url) {

//        final String parserUrl = "http://localhost:8080/parserRest";
        final String parserUrl = "https://app-shop-all-modules.herokuapp.com/parserRest";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("url", url);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Laptop> responseEntity = restTemplate.postForEntity(parserUrl, request, Laptop.class);
        Laptop laptop = responseEntity.getBody();

        LaptopManufacturer manufacturer = laptop.getLaptopManufacturer();
        String model = laptop.getModel();

        Optional<Laptop> laptopInDataBase = daoLaptopInterface.findByLaptopManufacturerAndModel(manufacturer, model);

        if (laptopInDataBase.isEmpty()) {
            daoDisplayDiagonal.save(laptop.getDisplayDiagonal());
            daoDisplayResolution.save(laptop.getDisplayResolution());
            daoDisplayType.save(laptop.getDisplayType());
            daoLaptopManufacturer.save(laptop.getLaptopManufacturer());
            daoProcessorType.save(laptop.getProcessorType());
            daoramSize.save(laptop.getRamSize());
            daoramType.save(laptop.getRamType());
            daoStorageSize.save(laptop.getStorageSize());
            daoStorageType.save(laptop.getStorageType());

            daoLaptopInterface.save(laptop);

            laptop.getPhoto().forEach(laptopPhoto -> {
                laptopPhoto.setPhotoOwner(laptop);
                daoLaptopPhotos.save(laptopPhoto);
            });
        }
    }
}
