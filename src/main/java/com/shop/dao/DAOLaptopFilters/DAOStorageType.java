package com.shop.dao.DAOLaptopFilters;

import com.shop.models.laptop.laptopDetails.StorageType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAOStorageType extends JpaRepository<StorageType, String> {
}
