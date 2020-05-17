package com.shop.models.laptop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaptopSpecification implements Specification<Laptop> {
    private LaptopCriteria laptopCriteria;

    @Override
    public Predicate toPredicate(Root<Laptop> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        Predicate displayDiagonal = criteriaBuilder.in(root.get("displayDiagonal")).value(laptopCriteria.getDisplayDiagonals());
        Predicate displayResolution = criteriaBuilder.in(root.get("displayResolution")).value(laptopCriteria.getDisplayResolutions());
        Predicate displayType = criteriaBuilder.in(root.get("displayType")).value(laptopCriteria.getDisplayTypes());
        Predicate laptopManufacturer = criteriaBuilder.in(root.get("laptopManufacturer")).value(laptopCriteria.getLaptopManufacturers());
        Predicate processorType = criteriaBuilder.in(root.get("processorType")).value(laptopCriteria.getProcessorTypes());
        Predicate ramSize = criteriaBuilder.in(root.get("ramSize")).value(laptopCriteria.getRamSizes());
        Predicate ramType = criteriaBuilder.in(root.get("ramType")).value(laptopCriteria.getRamTypes());
        Predicate storageSize = criteriaBuilder.in(root.get("storageSize")).value(laptopCriteria.getStorageSizes());
        Predicate storageType = criteriaBuilder.in(root.get("storageType")).value(laptopCriteria.getStorageTypes());

        List<Predicate> predicates = new ArrayList<>();
        if (laptopCriteria.getDisplayDiagonals().size() != 0) predicates.add(displayDiagonal);
        if (laptopCriteria.getDisplayResolutions().size() != 0) predicates.add(displayResolution);
        if (laptopCriteria.getDisplayTypes().size() != 0) predicates.add(displayType);
        if (laptopCriteria.getLaptopManufacturers().size() != 0) predicates.add(laptopManufacturer);
        if (laptopCriteria.getProcessorTypes().size() != 0) predicates.add(processorType);
        if (laptopCriteria.getRamSizes().size() != 0) predicates.add(ramSize);
        if (laptopCriteria.getRamTypes().size() != 0) predicates.add(ramType);
        if (laptopCriteria.getStorageSizes().size() != 0) predicates.add(storageSize);
        if (laptopCriteria.getStorageTypes().size() != 0) predicates.add(storageType);

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}