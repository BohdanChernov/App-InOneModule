package com.shop.dao.DAOLaptopFilters;

import com.shop.models.laptop.Laptop;
import com.shop.models.laptop.laptopDetails.LaptopPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DAOLaptopPhotos extends JpaRepository<LaptopPhoto, String> {
    Optional<List<LaptopPhoto>> findAllByPhotoOwner(Laptop laptop);
}
