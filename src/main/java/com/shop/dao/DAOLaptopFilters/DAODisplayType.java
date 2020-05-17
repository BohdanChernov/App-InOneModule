package com.shop.dao.DAOLaptopFilters;

import com.shop.models.laptop.laptopDetails.DisplayType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAODisplayType extends JpaRepository<DisplayType, String> {
}
