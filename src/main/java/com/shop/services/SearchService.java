package com.shop.services;

import com.shop.models.laptop.SearchSpecification;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    public static SearchSpecification getPage(String searchQuery) {

//        LaptopCriteria laptopCriteria = new LaptopCriteria();
//        laptopCriteria.getDisplayDiagonals().add(new DisplayDiagonal(searchQuery));
//        laptopCriteria.getDisplayResolutions().add(new DisplayResolution(searchQuery));
//        laptopCriteria.getDisplayTypes().add(new DisplayType(searchQuery));
//        laptopCriteria.getLaptopManufacturers().add(new LaptopManufacturer(searchQuery));
//        laptopCriteria.getProcessorTypes().add(new ProcessorType(searchQuery));
//        laptopCriteria.getRamSizes().add(new RAMSize(searchQuery));
//        laptopCriteria.getRamTypes().add(new RAMType(searchQuery));
//        laptopCriteria.getStorageSizes().add(new StorageSize(searchQuery));
//        laptopCriteria.getStorageTypes().add(new StorageType(searchQuery));

        SearchSpecification searchSpecification = new SearchSpecification(searchQuery);


        return searchSpecification;

    }


}
