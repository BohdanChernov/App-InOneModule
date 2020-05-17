package com.shop.models.laptop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchSpecification implements Specification<Laptop> {
    private String searchQuery;

    @Override
    public Predicate toPredicate(Root<Laptop> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        Predicate model = getModelPredicate(root, criteriaBuilder);
        Predicate displayDiagonal = getDisplayDiagonalPredicate(root, criteriaBuilder);
        Predicate displayResolution = getDisplayResolutionPredicate(root, criteriaBuilder);
        Predicate displayType = getDisplayTypePredicate(root, criteriaBuilder);
        Predicate laptopManufacturer = getManufacturerPredicate(root, criteriaBuilder);
        Predicate processorType = getProcessorTypePredicate(root, criteriaBuilder);
        Predicate ramSize = getRamSizePredicate(root, criteriaBuilder);
        Predicate ramType = getRamTypePredicate(root, criteriaBuilder);
        Predicate storageSize = getStorageSizePredicate(root, criteriaBuilder);
        Predicate storageType = getStorageTypePredicate(root, criteriaBuilder);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(model);
        predicates.add(displayDiagonal);
        predicates.add(displayResolution);
        predicates.add(displayType);
        predicates.add(laptopManufacturer);
        predicates.add(processorType);
        predicates.add(ramSize);
        predicates.add(ramType);
        predicates.add(storageSize);
        predicates.add(storageType);

        return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
    }

    public Predicate getModelPredicate(Root<Laptop> root, CriteriaBuilder criteriaBuilder){
        Path rootPath = root.get("model");
        Expression<String> rootPathExpression = criteriaBuilder.lower(rootPath.as(String.class));
        String searchQueryLowerCase = searchQuery.toLowerCase();
        Predicate predicate = criteriaBuilder.like(rootPathExpression, "%"+searchQueryLowerCase+"%");
        return predicate;
    }

    public Predicate getDisplayDiagonalPredicate(Root<Laptop> root, CriteriaBuilder criteriaBuilder){
        Path rootPath = root.get("displayDiagonal").get("value");
        Expression<String> rootPathExpression = criteriaBuilder.lower(rootPath.as(String.class));
        String searchQueryLowerCase = searchQuery.toLowerCase();
        Predicate predicate = criteriaBuilder.like(rootPathExpression, "%"+searchQueryLowerCase+"%");
        return predicate;
    }

    public Predicate getDisplayResolutionPredicate(Root<Laptop> root, CriteriaBuilder criteriaBuilder){
        Path rootPath = root.get("displayResolution").get("value");
        Expression<String> rootPathExpression = criteriaBuilder.lower(rootPath.as(String.class));
        String searchQueryLowerCase = searchQuery.toLowerCase();
        Predicate predicate = criteriaBuilder.like(rootPathExpression, "%"+searchQueryLowerCase+"%");
        return predicate;
    }

    public Predicate getDisplayTypePredicate(Root<Laptop> root, CriteriaBuilder criteriaBuilder){
        Path rootPath = root.get("displayType").get("value");
        Expression<String> rootPathExpression = criteriaBuilder.lower(rootPath.as(String.class));
        String searchQueryLowerCase = searchQuery.toLowerCase();
        Predicate predicate = criteriaBuilder.like(rootPathExpression, "%"+searchQueryLowerCase+"%");
        return predicate;
    }

    public Predicate getManufacturerPredicate(Root<Laptop> root, CriteriaBuilder criteriaBuilder){
        Path rootPath = root.get("laptopManufacturer").get("value");
        Expression<String> rootPathExpression = criteriaBuilder.lower(rootPath.as(String.class));
        String searchQueryLowerCase = searchQuery.toLowerCase();
        Predicate predicate = criteriaBuilder.like(rootPathExpression, "%"+searchQueryLowerCase+"%");
        return predicate;
    }

    public Predicate getProcessorTypePredicate(Root<Laptop> root, CriteriaBuilder criteriaBuilder){
        Path rootPath = root.get("processorType").get("value");
        Expression<String> rootPathExpression = criteriaBuilder.lower(rootPath.as(String.class));
        String searchQueryLowerCase = searchQuery.toLowerCase();
        Predicate predicate = criteriaBuilder.like(rootPathExpression, "%"+searchQueryLowerCase+"%");
        return predicate;
    }

    public Predicate getRamSizePredicate(Root<Laptop> root, CriteriaBuilder criteriaBuilder){
        Path rootPath = root.get("ramSize").get("value");
        Expression<String> rootPathExpression = criteriaBuilder.lower(rootPath.as(String.class));
        String searchQueryLowerCase = searchQuery.toLowerCase();
        Predicate predicate = criteriaBuilder.like(rootPathExpression, "%"+searchQueryLowerCase+"%");
        return predicate;
    }

    public Predicate getRamTypePredicate(Root<Laptop> root, CriteriaBuilder criteriaBuilder){
        Path rootPath = root.get("ramType").get("value");
        Expression<String> rootPathExpression = criteriaBuilder.lower(rootPath.as(String.class));
        String searchQueryLowerCase = searchQuery.toLowerCase();
        Predicate predicate = criteriaBuilder.like(rootPathExpression, "%"+searchQueryLowerCase+"%");
        return predicate;
    }

    public Predicate getStorageSizePredicate(Root<Laptop> root, CriteriaBuilder criteriaBuilder){
        Path rootPath = root.get("storageSize").get("value");
        Expression<String> rootPathExpression = criteriaBuilder.lower(rootPath.as(String.class));
        String searchQueryLowerCase = searchQuery.toLowerCase();
        Predicate predicate = criteriaBuilder.like(rootPathExpression, "%"+searchQueryLowerCase+"%");
        return predicate;
    }

    public Predicate getStorageTypePredicate(Root<Laptop> root, CriteriaBuilder criteriaBuilder){
        Path rootPath = root.get("storageType").get("value");
        Expression<String> rootPathExpression = criteriaBuilder.lower(rootPath.as(String.class));
        String searchQueryLowerCase = searchQuery.toLowerCase();
        Predicate predicate = criteriaBuilder.like(rootPathExpression, "%"+searchQueryLowerCase+"%");
        return predicate;
    }

}