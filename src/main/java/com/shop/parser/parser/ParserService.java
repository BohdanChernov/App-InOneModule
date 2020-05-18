package com.shop.parser.parser;

import com.shop.models.laptop.Laptop;
import com.shop.models.laptop.laptopDetails.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParserService {

    public Laptop getMapCharacteristics(String url) {
        Laptop laptop = new Laptop();

        try {
            String forCharacteristics = url.concat("characteristics/");
            Document document = Jsoup.connect(forCharacteristics)
                    .userAgent("Chrome/81.0.4044.113")
                    .referrer("http:www.google.com").timeout(10000).get();

            ParserServiceSubsidiary parserService = new ParserServiceSubsidiary(document);

            laptop.setLaptopManufacturer(new LaptopManufacturer(parserService.findManufacturer()));
            laptop.setProcessorType(new ProcessorType(parserService.findProcessorType()));
            laptop.setDisplayDiagonal(new DisplayDiagonal(parserService.findDisplayDiagonal()));
            laptop.setDisplayResolution(new DisplayResolution(parserService.findDisplayResolution()));
            laptop.setDisplayType(new DisplayType(parserService.findDisplayType()));
            laptop.setRamSize(new RAMSize(parserService.findRamSize()));
            laptop.setRamType(new RAMType(parserService.findRamType()));
            laptop.setStorageType(new StorageType(parserService.findStorageType()));
            laptop.setStorageSize(new StorageSize(parserService.findStorageSize()));
            laptop.setModel(parserService.findModel());
            laptop.setPrice(Integer.valueOf(parserService.findPrice()));
            laptop.setQuantity(10);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("LAPTOP:" + laptop);

        return laptop;
    }

    public List<LaptopPhoto> getListPhotos(String url, Laptop laptop) {
        String forPhotosUrl = url.concat("photo/");
        ParserServiceSubsidiary parserService = new ParserServiceSubsidiary(forPhotosUrl);
        List<String> photos = parserService.findPhotos();

        List<LaptopPhoto> laptopPhotos = new ArrayList<>();
        for (int i = 0; i < photos.size(); i++) {
            if (i != 0) {
                LaptopPhoto photo = new LaptopPhoto();
                photo.setLocation(photos.get(i));
                laptopPhotos.add(photo);
            }
        }

//        photos.forEach(s -> {
//            LaptopPhoto photo = new LaptopPhoto();
//            photo.setLocation(s);
//            laptopPhotos.add(photo);
//        });

        return laptopPhotos;
    }
}
