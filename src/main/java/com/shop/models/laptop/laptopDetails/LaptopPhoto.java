package com.shop.models.laptop.laptopDetails;

import com.shop.models.laptop.Laptop;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "laptop_photo")
public class LaptopPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String location;
    @ManyToOne
    Laptop photoOwner;

    @Override
    public String toString() {
        return "LaptopPhoto{" +
                "id=" + id +
                ", location='" + location + '\'' +
                '}';
    }
}
