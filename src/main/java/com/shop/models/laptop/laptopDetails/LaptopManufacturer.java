package com.shop.models.laptop.laptopDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "laptop_manufacturer")
public class LaptopManufacturer {
    @Id
    private String value;
}
