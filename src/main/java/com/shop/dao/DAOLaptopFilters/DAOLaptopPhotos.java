package com.shop.dao.DAOLaptopFilters;

import com.shop.models.laptop.laptopDetails.LaptopPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAOLaptopPhotos extends JpaRepository<LaptopPhoto, String> {
}
