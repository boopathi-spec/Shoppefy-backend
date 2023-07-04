package com.productDept.productApi.Serviceimpl;

import com.productDept.productApi.Exception.NoObjectFound;
import com.productDept.productApi.Repository.ProductRepository;
import com.productDept.productApi.Service.ProductService;
import com.productDept.productApi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceimpl implements ProductService {


    @Autowired
    ProductRepository productRepo;

    @Override
    public Product addproduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product findByProductName(String proName) {
        return productRepo.findByProductName(proName);
    }

    @Override
    public List<Product> findAllProduct() {
        List<Product> list1 = productRepo.findAll();
        return  list1;
    }

    @Override
    public Product deleteProduct( int  productId) {
        int value = 0;
        Product pro = productRepo.findById(productId).get();
        pro.setDeleteItem(value);
        return productRepo.save(pro);
    }





    @Override
    public Product findProductById(int productId) {
        return productRepo.findById(productId).get();
    }
}