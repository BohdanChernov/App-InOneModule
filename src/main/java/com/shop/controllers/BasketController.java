package com.shop.controllers;

import com.shop.dao.DAOLaptopInterface;
import com.shop.models.laptop.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
import java.util.*;

@Controller
public class BasketController {

    @Autowired
    DAOLaptopInterface daoLaptopInterface;


    @GetMapping("/getBasketContent")
    public String getBasketContent(ModelMap model, HttpSession httpSession) {
        Set<String> productsList = (Set<String>) httpSession.getAttribute("products");

        Optional<Set<String>> products = null;
        List<Laptop> laptopList = new ArrayList<>();

        if (productsList != null) {
            products = Optional.of(productsList);

            if (!products.isEmpty()) {
                products.get().forEach(s -> {
                    Optional<Laptop> laptop = daoLaptopInterface.findById(Long.valueOf(s));
                    if (!laptop.isEmpty())
                        laptopList.add(laptop.get());
                });
            }
        }

        Integer totalPrice = 0;
        for (Laptop laptop : laptopList) {
            totalPrice += laptop.getPrice();
        }


        model.addAttribute("products", laptopList);
        model.addAttribute("totalPrice", totalPrice);

        return "basketContent";
    }

    @GetMapping("/basket")
    public String getBasket(ModelMap model, HttpSession httpSession) {
        return "basket";
    }

    @PostMapping("/addToBasket")
    public void add(ModelMap model, HttpSession httpSession, @RequestBody(required = false) String id) {

        Set<String> getProducts = (Set<String>) httpSession.getAttribute("products");


        Set<String> products = null;
        if (getProducts == null) {
            products = new HashSet<>();
            products.add(id);
            httpSession.setAttribute("products", products);
        } else {
            products = (Set<String>) httpSession.getAttribute("products");
            products.add(id);
            httpSession.setAttribute("products", products);
        }
        int i = 0;
    }

    @PostMapping("/deleteFromBasket")
    public String delete(ModelMap model, HttpSession httpSession, @RequestBody(required = false) String id) {

        Set<String> products = (Set<String>) httpSession.getAttribute("products");

        products.forEach(s -> {
            if (s.equals(id)) {
                products.remove(s);
            }
        });

        httpSession.setAttribute("products", products);
        int i = 0;

        return "basketContent";
    }
}
