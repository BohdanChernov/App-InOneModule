package com.shop.dao.DAOLaptopFilters;

import com.shop.models.laptop.laptopDetails.ProcessorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAOProcessorType extends JpaRepository<ProcessorType, String> {
}
