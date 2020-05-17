package com.shop.dao;

import com.shop.models.laptop.Laptop;
import com.shop.models.laptop.laptopDetails.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface DAOLaptopInterface extends JpaRepository<Laptop, Long>, JpaSpecificationExecutor<Laptop> {
    Optional<Laptop> findById(Long id);
    Optional<Laptop> findByModel(String model);
    Optional<Laptop> findByLaptopManufacturerAndModel(LaptopManufacturer manufacturer, String model);
    Optional<List<Laptop>> findAllByDisplayDiagonal(DisplayDiagonal displayDiagonal);
    Optional<List<Laptop>> findAllByDisplayResolution(DisplayResolution displayResolution);
    Optional<List<Laptop>> findAllByDisplayType(DisplayType displayType);
    Optional<List<Laptop>> findAllByLaptopManufacturer(LaptopManufacturer laptopManufacturer);
    Optional<List<Laptop>> findAllByProcessorType(ProcessorType processorType);
    Optional<List<Laptop>> findAllByRamSize(RAMSize ramSize);
    Optional<List<Laptop>> findAllByRamType(RAMType ramType);
    Optional<List<Laptop>> findAllByStorageSize(StorageSize storageSize);
    Optional<List<Laptop>> findAllByStorageType(StorageType storageType);
}
