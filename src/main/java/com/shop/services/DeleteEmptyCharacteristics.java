package com.shop.services;

import com.shop.dao.DAOLaptopFilters.*;
import com.shop.dao.DAOLaptopInterface;
import com.shop.models.laptop.Laptop;
import com.shop.models.laptop.laptopDetails.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeleteEmptyCharacteristics {

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
    private DAORAMSize daoRamSize;
    @Autowired
    private DAORAMType daoRamType;
    @Autowired
    private DAOStorageSize daoStorageSize;
    @Autowired
    private DAOStorageType daoStorageType;

    public void checkAllFields(){
        daoDisplayDiagonal.findAll().forEach(displayDiagonal -> checkDisplayDiagonals(displayDiagonal));
        daoDisplayResolution.findAll().forEach(displayResolution -> checkDisplayResolutions(displayResolution));
        daoDisplayType.findAll().forEach(displayType -> checkDisplayTypes(displayType));
        daoLaptopManufacturer.findAll().forEach(laptopManufacturer -> checkLaptopManufacturers(laptopManufacturer));
        daoProcessorType.findAll().forEach(processorType -> checkProcessorTypes(processorType));
        daoRamSize.findAll().forEach(ramSize -> checkRamSizes(ramSize));
        daoRamType.findAll().forEach(ramType -> checkRamTypes(ramType));
        daoStorageSize.findAll().forEach(storageSize -> checkStorageSize(storageSize));
        daoStorageType.findAll().forEach(storageType -> checkStorageType(storageType));
    }

    public void checkDisplayDiagonals(DisplayDiagonal displayDiagonal){
        Optional<List<Laptop>> laptops = daoLaptopInterface.findAllByDisplayDiagonal(displayDiagonal);
        if(laptops.isEmpty())
            daoDisplayDiagonal.delete(displayDiagonal);
    }

    public void checkDisplayResolutions(DisplayResolution displayResolution){
        Optional<List<Laptop>> laptops = daoLaptopInterface.findAllByDisplayResolution(displayResolution);
        if(laptops.isEmpty())
            daoDisplayResolution.delete(displayResolution);
    }

    public void checkDisplayTypes(DisplayType displayType){
        Optional<List<Laptop>> laptops = daoLaptopInterface.findAllByDisplayType(displayType);
        if(laptops.isEmpty())
            daoDisplayType.delete(displayType);
    }

    public void checkLaptopManufacturers(LaptopManufacturer laptopManufacturer){
        Optional<List<Laptop>> laptops = daoLaptopInterface.findAllByLaptopManufacturer(laptopManufacturer);
        if(laptops.isEmpty())
            daoLaptopManufacturer.delete(laptopManufacturer);
    }

    public void checkProcessorTypes(ProcessorType processorType){
        Optional<List<Laptop>> laptops = daoLaptopInterface.findAllByProcessorType(processorType);
        if(laptops.isEmpty())
            daoProcessorType.delete(processorType);
    }

    public void checkRamSizes(RAMSize ramSize){
        Optional<List<Laptop>> laptops = daoLaptopInterface.findAllByRamSize(ramSize);
        if(laptops.isEmpty())
            daoRamSize.delete(ramSize);
    }

    public void checkRamTypes(RAMType ramType){
        Optional<List<Laptop>> laptops = daoLaptopInterface.findAllByRamType(ramType);
        if(laptops.isEmpty())
            daoRamType.delete(ramType);
    }

    public void checkStorageSize(StorageSize storageSize){
        Optional<List<Laptop>> laptops = daoLaptopInterface.findAllByStorageSize(storageSize);
        if(laptops.isEmpty())
            daoStorageSize.delete(storageSize);
    }

    public void checkStorageType(StorageType storageType){
        Optional<List<Laptop>> laptops = daoLaptopInterface.findAllByStorageType(storageType);
        if(laptops.isEmpty())
            daoStorageType.delete(storageType);
    }

}
