package com.productDept.productApi.Service;

import com.productDept.productApi.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    Product addproduct(Product product);
//    Optional<Product> findProduct(Product product);
    Product findByProductName(String prodName);
    List<Product> findAllProduct();
   Product deleteProduct(int productId);



   Product findProductById(int productId);
}
