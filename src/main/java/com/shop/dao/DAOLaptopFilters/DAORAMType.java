package com.shop.dao.DAOLaptopFilters;

import com.shop.models.laptop.laptopDetails.RAMType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAORAMType extends JpaRepository<RAMType, String> {
}
