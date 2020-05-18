package com.shop.parser.parser;

import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserServiceSubsidiary {

    private Document document;
    private String urlToParse;

    public ParserServiceSubsidiary(Document document) {
        this.document = document;
    }

    public ParserServiceSubsidiary(String urlToParse) {
        this.urlToParse = urlToParse;
    }


    public String findModel() {
        String model = "no information";
//        Elements modelToParse = document.select("span.product-tabs__heading_color_gray");
        Elements modelToParse = document.select("h2.detail-title");
        Pattern ptrn11 = Pattern.compile("^Ноутбук\\s\\w*");
        Matcher matcher11 = ptrn11.matcher(modelToParse.text());
        if (matcher11.find()) {
            String toRemove = matcher11.group(0);
            System.out.println(toRemove);
            model = modelToParse.text().replace(toRemove, "").replace(" Суперцена!!!", "").trim();
        }

        System.out.println("MODEL:" + model);
        return model;
    }

    public String findPrice() {
        String price = "0";


        Elements scriptElements = document.getElementsByTag("script");


        String priceToParse = null;
        for (Element element :scriptElements ){
            for (DataNode node : element.dataNodes()) {
                String string = node.getWholeData();
                if (string.contains("productPriceLocal")){
                    priceToParse = string;
                    break;
                }

            }
        }



//        Elements priceToParse = document.select("p.product-carriage__price");
//        Pattern ptrn9 = Pattern.compile("\\w[^\\₴]*");
//        Matcher matcher9 = ptrn9.matcher(priceToParse.text());

        System.out.println(priceToParse);
        Pattern ptrn9 = Pattern.compile("\"productPriceLocal\":\"\\d+");
        Matcher matcher9 = ptrn9.matcher(priceToParse);


        if (matcher9.find()) {
            price = matcher9.group(0).trim().replace(" ", "");
            System.out.println("PRICE TEMP: " + price);
        }

//        System.out.println(document);

        System.out.println("PRICE: " + price);
        return price;
    }

    public String findDisplayDiagonal() {
        String displayDiagonal = "no information";
        Elements diagonalAndResolution = document.select("a[href*=20861]");
        Pattern ptrn1 = Pattern.compile("^\\d*.\\d*");
        Matcher matcher1 = ptrn1.matcher(diagonalAndResolution.text());
        if (matcher1.find()) {
            displayDiagonal = matcher1.group(0).replace("\"", "");
        }

        System.out.println("DIAGONAL: " + displayDiagonal);
        return displayDiagonal;
    }

    public String findDisplayResolution() {
        String displayResolution = "no information";
        Elements diagonalAndResolution = document.select("a[href*=20861]");
        Pattern ptrn2 = Pattern.compile("\\d*[x]\\d*");
        Matcher matcher2 = ptrn2.matcher(diagonalAndResolution.text());
        if (matcher2.find()) {
            displayResolution = matcher2.group(0);
        }

        System.out.println("RESOLUTION: " + displayResolution);
        return displayResolution;
    }

    public String findDisplayType() {
        String displayType = "no information";
        Elements displayTypeToParse = document.select("span:contains(RAM)");
        Pattern ptrn8 = Pattern.compile("\\s[a-zA-Z][^\\(]*");
        Matcher matcher8 = ptrn8.matcher(displayTypeToParse.text());
        if (matcher8.find()) {
            displayType = matcher8.group(0).trim();
        }

        System.out.println("DISPLAYTYPE: " + displayType);
        return displayType;
    }

    public String findManufacturer() {
        String manufacturer = "no information";
//        Elements brandToPars = document.select("span.product-tabs__heading_color_gray");
        Elements brandToPars = document.select("h2.detail-title");
        Pattern ptrn10 = Pattern.compile("\\w+");
        Matcher matcher10 = ptrn10.matcher(brandToPars.text());
        if (matcher10.find()) {
            manufacturer = matcher10.group(0);
        }

        System.out.println("MANUFACTURER: " + manufacturer);
        return manufacturer;
    }

    public String findProcessorType() {
        String processorType = "no information";
        Elements processor = document.select("a[href*=processor]");
        Pattern ptrn3 = Pattern.compile("\\w[^\\(]*");
        Matcher matcher3 = ptrn3.matcher(processor.text());
        if (matcher3.find()) {
            processorType = matcher3.group(0).trim();
        }

        System.out.println("PROCESSOR: " + processorType);
        return processorType;
    }

    public String findRamSize() {
        String ramSize = "no information";
        Elements ramS = document.select("a[href*=20863]");
        Pattern ptrn4 = Pattern.compile("\\d*");
        Matcher matcher4 = ptrn4.matcher(ramS.text());
        if (matcher4.find()) {
            ramSize = matcher4.group(0);
        }

        System.out.println("RAMSIZE: " + ramSize);
        return ramSize;
    }

    public String findRamType() {
        String ramType = "no information";
        Elements ramTypeToParse = document.select("span:contains(DDR)");
        Pattern ptrn7 = Pattern.compile("\\w*");
        Matcher matcher7 = ptrn7.matcher(ramTypeToParse.text());
        if (matcher7.find()) {
            ramType = matcher7.group(0);
        }

        System.out.println("RAMTYPE: " + ramType);
        return ramType;
    }

    public String findStorageSize() {
        String storageSize = "no information";
        Elements storageTypeAndSize = document.select("a[href*=20882]");
        Pattern ptrn6 = Pattern.compile("\\d*");
        Matcher matcher6 = ptrn6.matcher(storageTypeAndSize.text());
        if (matcher6.find()) {
            storageSize = matcher6.group(0);
        }

        System.out.println("STORAGESIZE: " + storageSize);
        return storageSize;
    }

    public String findStorageType() {
        String storageType = "no information";
        Elements storageTypeAndSize = document.select("a[href*=20882]");
        Pattern ptrn5 = Pattern.compile("\\s\\w.*");
        Matcher matcher5 = ptrn5.matcher(storageTypeAndSize.text());
        if (matcher5.find()) {
            storageType = matcher5.group(0).trim();
        }

        System.out.println("STORAGETYPE: " + storageType);
        return storageType;
    }

    public List<String> findPhotos() {
        List<String> pathes = new ArrayList<>();

//        System.setProperty("webdriver.chrome.driver", "http://selenium:4444/wd/hub");
//        System.setProperty("webdriver.chrome.driver", "http://localhost:4444/wd/hub");
        System.setProperty("webdriver.chrome.driver", "/app/.chromedriver/bin/chromedriver");

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        URL url = null;
        try {
//            url = new URL("http://selenium:4444/wd/hub");
            url = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
//        WebDriver driver = new RemoteWebDriver(url, options);


        // START OF TEST CODE

//        String GOOGLE_CHROME_BIN = "/app/.apt/opt/google/chrome/google-chrome";

//        options.setBinary(GOOGLE_CHROME_BIN);
//        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);

        // END OF TEST CODE


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(urlToParse);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 25; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
            js.executeScript("window.scrollBy(0,500)");
        }

        List<WebElement> list = driver.findElements(By.className("product-photos__picture"));

        for (WebElement webElement : list) {
            String path = webElement.getAttribute("src");
            pathes.add(path);
        }

        for (String s : pathes) {
            if (s.endsWith(".svg")) {
                pathes = this.findPhotos();
                break;
            }
        }

        driver.close();

        return pathes;
    }
}
