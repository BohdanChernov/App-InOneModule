package com.shop.dao.DAOLaptopFilters;

import com.shop.models.laptop.laptopDetails.RAMSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAORAMSize extends JpaRepository<RAMSize, String> {
}
