package com.shop.models.laptop;

import com.shop.models.laptop.laptopDetails.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private Integer price;
    private Integer quantity;

    @ManyToOne
    private DisplayDiagonal displayDiagonal;
    @ManyToOne
    private DisplayResolution displayResolution;
    @ManyToOne
    private DisplayType displayType;
    @ManyToOne
    private LaptopManufacturer laptopManufacturer;

    @OneToMany(mappedBy = "photoOwner")
    private List<LaptopPhoto> photo;

    @ManyToOne
    private ProcessorType processorType;
    @ManyToOne
    private RAMSize ramSize;
    @ManyToOne
    private RAMType ramType;
    @ManyToOne
    private StorageType storageType;
    @ManyToOne
    private StorageSize storageSize;

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", displayDiagonal=" + displayDiagonal +
                ", displayResolution=" + displayResolution +
                ", displayType=" + displayType +
                ", laptopManufacturer=" + laptopManufacturer +
                ", photo=" + photo +
                ", processorType=" + processorType +
                ", ramSize=" + ramSize +
                ", ramType=" + ramType +
                ", storageType=" + storageType +
                '}';
    }

}
