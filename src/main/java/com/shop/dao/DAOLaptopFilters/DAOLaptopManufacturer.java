package com.shop.dao.DAOLaptopFilters;

import com.shop.models.laptop.laptopDetails.LaptopManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAOLaptopManufacturer extends JpaRepository<LaptopManufacturer, String> {
}
