package com.shop.controllers;

import com.shop.dao.DAOLaptopFilters.*;
import com.shop.dao.DAOLaptopInterface;
import com.shop.models.laptop.Laptop;
import com.shop.models.laptop.LaptopCriteria;
import com.shop.models.laptop.LaptopSpecification;
import com.shop.models.laptop.SearchSpecification;
import com.shop.models.laptop.laptopDetails.*;
import com.shop.services.SearchService;
import com.shop.services.dto.JsonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class MainController {

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

    @GetMapping(value = {"/laptops", "/"})
    public String mainPage(ModelMap model) {

        List<DisplayDiagonal> displayDiagonals = daoDisplayDiagonal.findAll();
        Collections.sort(displayDiagonals, Comparator.comparing(DisplayDiagonal::getValue));
        model.addAttribute("displayDiagonals", displayDiagonals);

        List<DisplayResolution> displayResolutions = daoDisplayResolution.findAll();
        Collections.sort(displayResolutions, Comparator.comparing(DisplayResolution::getValue));
        model.addAttribute("displayResolutions", displayResolutions);

        List<DisplayType> displayTypes = daoDisplayType.findAll();
        Collections.sort(displayTypes, Comparator.comparing(DisplayType::getValue));
        model.addAttribute("displayTypes", displayTypes);

        List<LaptopManufacturer> laptopManufacturers = daoLaptopManufacturer.findAll();
        Collections.sort(laptopManufacturers, Comparator.comparing(LaptopManufacturer::getValue));
        model.addAttribute("laptopManufacturers", laptopManufacturers);

        List<ProcessorType> processorTypes = daoProcessorType.findAll();
        Collections.sort(processorTypes, Comparator.comparing(ProcessorType::getValue));
        model.addAttribute("processorTypes", processorTypes);

        List<RAMSize> ramSizes = daoramSize.findAll();
        Collections.sort(ramSizes, Comparator.comparing(RAMSize::getValue));
        model.addAttribute("ramSizes", ramSizes);

        List<RAMType> ramTypes = daoramType.findAll();
        Collections.sort(ramTypes, Comparator.comparing(RAMType::getValue));
        model.addAttribute("ramTypes", ramTypes);

        List<StorageSize> storageSizes = daoStorageSize.findAll();
        Collections.sort(storageSizes, Comparator.comparing(StorageSize::getValue));
        model.addAttribute("storageSizes", storageSizes);

        List<StorageType> storageTypes = daoStorageType.findAll();
        Collections.sort(storageTypes, Comparator.comparing(StorageType::getValue));
        model.addAttribute("storageTypes", storageTypes);

        LaptopCriteria laptopCriteria = new LaptopCriteria();
        model.addAttribute("laptopCriteria", laptopCriteria);

        return "laptops";
    }

    @PostMapping("/getContent")
    public String getLapt(ModelMap model, @RequestBody(required = false) JsonDTO jsonDTO) {

        LaptopSpecification laptopSpecification = new LaptopSpecification(jsonDTO.getLaptopCriteria());

        Pageable pageableASC = PageRequest.of(jsonDTO.getPageNumber(), 12, Sort.by("price").ascending());
        Pageable pageableDESC = PageRequest.of(jsonDTO.getPageNumber(), 12, Sort.by("price").descending());
        Pageable pageableSort = jsonDTO.getSort().equals("highPrice") ? pageableDESC : pageableASC;

        Page<Laptop> page = null;

        if (jsonDTO.getSearchQuery().equals("null"))
            page = daoLaptopInterface.findAll(laptopSpecification, pageableSort);
        else {
            SearchSpecification searchSpecificatin = SearchService.getPage(jsonDTO.getSearchQuery());
            page = daoLaptopInterface.findAll(searchSpecificatin, pageableSort);
            model.addAttribute("laptopCriteria", jsonDTO.getLaptopCriteria());
            model.addAttribute("sortPrice", jsonDTO.getSort());
            model.addAttribute("page", page);
            model.addAttribute("url", "/laptops");

            return "main";
        }

        if (page.getContent().size() == 0) {
            pageableASC = PageRequest.of(0, 12, Sort.by("price").ascending());
            pageableDESC = PageRequest.of(0, 12, Sort.by("price").descending());
            pageableSort = jsonDTO.getSort().equals("highPrice") ? pageableDESC : pageableASC;
            page = daoLaptopInterface.findAll(laptopSpecification, pageableSort);
        }

        model.addAttribute("laptopCriteria", jsonDTO.getLaptopCriteria());
        model.addAttribute("sortPrice", jsonDTO.getSort());
        model.addAttribute("page", page);
        model.addAttribute("url", "/laptops");

        return "main";
    }


    @GetMapping("/contacts")
    public String contactsPage(ModelMap model) {
        return "contacts";
    }

    @GetMapping("/feedback")
    public String feedbackPage(ModelMap model) {
        return "feedback";
    }

    @GetMapping("/delivery")
    public String deliveryPage(ModelMap model) {
        return "delivery";
    }
}
