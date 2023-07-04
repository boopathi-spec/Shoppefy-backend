package com.productDept.productApi.Repository;

import com.productDept.productApi.model.Department;
import com.productDept.productApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByProductName(String productName);

}
