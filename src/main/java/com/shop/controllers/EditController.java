package com.shop.controllers;

import com.shop.dao.DAOLaptopFilters.*;
import com.shop.dao.DAOLaptopInterface;
import com.shop.models.laptop.Laptop;
import com.shop.models.laptop.laptopDetails.*;
import com.shop.services.DeleteEmptyCharacteristics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class EditController {

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

    @Autowired
    private DeleteEmptyCharacteristics deleteEmptyCharacteristics;

    @GetMapping("/clear")
    public String clearCharacteristics(){
        deleteEmptyCharacteristics.checkAllFields();
        return "edit";
    }

    @GetMapping("/delete")
    public String deleteLaptop(@RequestParam String model, @RequestParam String manufacturer){
        Optional<Laptop> laptop = daoLaptopInterface.findByLaptopManufacturerAndModel(new LaptopManufacturer(manufacturer), model);
        daoLaptopInterface.delete(laptop.get());
        deleteEmptyCharacteristics.checkAllFields();
        return "laptops";
    }

    @GetMapping("/edit")
    public String getEditPage() {
        return "edit";
    }

    @PostMapping("/edit")
    public String postEditPage(ModelMap model, String laptopModel, @RequestParam(required = false) String manufacturer, @RequestParam(required = false) String modelOflaptop,
                               @RequestParam(required = false) String processor, @RequestParam(required = false) String displayDiagonal, @RequestParam(required = false) String displayResolution,
                               @RequestParam(required = false) String displayType, @RequestParam(required = false) String ramSize, @RequestParam(required = false) String ramType, @RequestParam(required = false) String storageType,
                               @RequestParam(required = false) String storageSize, @RequestParam(required = false) String price) {
        Laptop laptop = daoLaptopInterface.findByModel(laptopModel).get();

        if(modelOflaptop!=null){
            laptop.setModel(modelOflaptop);
        }

        if (manufacturer != null) {
            LaptopManufacturer laptopManufacturerNew = daoLaptopManufacturer.save(new LaptopManufacturer(manufacturer));
            laptop.setLaptopManufacturer(laptopManufacturerNew);
        }

        if(processor!=null){
            ProcessorType processorTypeNew = daoProcessorType.save(new ProcessorType(processor));
            laptop.setProcessorType(processorTypeNew);
        }

        if (price!=null){
            String string = price.replaceAll("[^0-9\\.]", "");
            laptop.setPrice(Integer.parseInt(string));
        }


        if (displayDiagonal!=null){
            DisplayDiagonal displayDiagonalNew = daoDisplayDiagonal.save(new DisplayDiagonal(displayDiagonal));
            laptop.setDisplayDiagonal(displayDiagonalNew);
        }

        if(displayResolution!=null){
            DisplayResolution displayResolutionNew = daoDisplayResolution.save(new DisplayResolution(displayResolution));
            laptop.setDisplayResolution(displayResolutionNew);
        }

        if(displayType!=null){
            DisplayType displayTypeNew = daoDisplayType.save(new DisplayType(displayType));
            laptop.setDisplayType(displayTypeNew);
        }


        if (ramSize!=null) {
            RAMSize ramSizeNew = daoramSize.save(new RAMSize(ramSize));
            laptop.setRamSize(ramSizeNew);
        }

        if (ramType !=null) {
            RAMType ramTypeNew = daoramType.save(new RAMType(ramType));
            laptop.setRamType(ramTypeNew);
        }


        if (storageType!=null) {
            StorageType storageTypeNew = daoStorageType.save(new StorageType(storageType));
            laptop.setStorageType(storageTypeNew);
        }


        if (storageSize!=null) {
            StorageSize storageSizeNew = daoStorageSize.save(new StorageSize(storageSize));
            laptop.setStorageSize(storageSizeNew);
        }

            daoLaptopInterface.save(laptop);

        deleteEmptyCharacteristics.checkAllFields();

        model.addAttribute("product", laptop);

        return "edit";
    }
}
