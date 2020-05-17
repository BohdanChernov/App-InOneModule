package com.shop.services.dto;

import com.shop.models.laptop.LaptopCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonDTO {
    LaptopCriteria laptopCriteria;
    Integer pageNumber;
    Integer size;
    String sort;
    String searchQuery;
}
