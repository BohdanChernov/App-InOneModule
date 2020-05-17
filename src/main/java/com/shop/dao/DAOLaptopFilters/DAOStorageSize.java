package com.shop.dao.DAOLaptopFilters;

import com.shop.models.laptop.laptopDetails.StorageSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAOStorageSize extends JpaRepository<StorageSize, String> {
}
