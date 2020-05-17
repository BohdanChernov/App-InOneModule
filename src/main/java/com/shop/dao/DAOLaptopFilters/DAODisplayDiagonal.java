package com.shop.dao.DAOLaptopFilters;

import com.shop.models.laptop.Laptop;
import com.shop.models.laptop.laptopDetails.DisplayDiagonal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAODisplayDiagonal extends JpaRepository<DisplayDiagonal, String> {
}
