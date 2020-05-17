package com.shop.models.laptop;

import com.shop.models.laptop.laptopDetails.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaptopCriteria {
    private List<DisplayDiagonal> displayDiagonals = new ArrayList<>();
    private List<DisplayResolution> displayResolutions = new ArrayList<>();
    private List<DisplayType> displayTypes = new ArrayList<>();
    private List<LaptopManufacturer> laptopManufacturers = new ArrayList<>();
    private List<ProcessorType> processorTypes = new ArrayList<>();
    private List<RAMSize> ramSizes = new ArrayList<>();
    private List<RAMType> ramTypes = new ArrayList<>();
    private List<StorageSize> storageSizes = new ArrayList<>();
    private List<StorageType> storageTypes = new ArrayList<>();
}
