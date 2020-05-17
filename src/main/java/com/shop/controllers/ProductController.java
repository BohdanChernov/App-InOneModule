package com.shop.controllers;

import com.shop.models.laptop.Laptop;
import com.shop.dao.DAOLaptopInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private DAOLaptopInterface daoLaptopInterface;

    @PostMapping("/product")
    public String productPageA(ModelMap model, @RequestParam String idOfProduct) {
        Optional<Laptop> product = daoLaptopInterface.findById(Long.parseLong(idOfProduct));
        model.addAttribute("product", product.get());
        return "product";
    }
}
