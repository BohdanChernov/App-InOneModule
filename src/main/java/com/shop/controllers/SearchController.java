package com.shop.controllers;

import com.shop.dao.DAOLaptopFilters.*;
import com.shop.dao.DAOLaptopInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class SearchController {
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
    private DAOProcessorType daoProcessorType;
    @Autowired
    private DAORAMSize daoramSize;
    @Autowired
    private DAORAMType daoramType;
    @Autowired
    private DAOStorageSize daoStorageSize;
    @Autowired
    private DAOStorageType daoStorageType;

    @GetMapping("/search")
    public String mainPage(ModelMap model, @RequestParam String search) {


        return "laptops";
    }
}
