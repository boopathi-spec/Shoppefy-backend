package com.productDept.productApi.Controller;

import com.productDept.productApi.Service.DeptService;
import com.productDept.productApi.Service.ProductService;
import com.productDept.productApi.model.Department;
import com.productDept.productApi.model.Product;
import com.productDept.productApi.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/postProduct")
public class ProductController {
    public ProductController() {
        System.out.println("default constructor triggered");
    }

    @Autowired
    ProductService productserve;

    @Autowired
    private DeptService deptserve;


    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody ResponseObject responseObject) {

        String productName = responseObject.getProductName();
        String productBrand = responseObject.getProductBrand();
        float productPrice = responseObject.getProductPrice();
        int deletedValue = responseObject.getDeleteItem();
        String deptName = responseObject.getDeptName();

        Department tempDept = deptserve.findByDeptName(deptName);

        Product tempProduct = new Product();
        tempProduct.setProductName(productName);
        tempProduct.setProductBrand(productBrand);
        tempProduct.setProductPrice(productPrice);
        tempProduct. setDeleteItem(deletedValue);

        String tempDeptName = responseObject.getDeptName();

        if (tempDept == null) {
            tempDept = new Department(tempDeptName);
            deptserve.addDepartment(tempDept); // Save the department first
        }

        tempDept.add(tempProduct); // Now add the product to the department
        tempProduct.setDepartment(tempDept); // Set the department for the product

        // Save the product to the database
        productserve.addproduct(tempProduct);

       // return tempProduct;
        return new ResponseEntity<Product>(productserve.addproduct(tempProduct),HttpStatus.CREATED);
    }

    @PostMapping("/{productId}")
   public  ResponseEntity<Product> updateCustomer(@PathVariable("productId") int ProductId,@RequestBody ResponseObject responseObject) {


             Product product1 = productserve.findProductById(ProductId);


        if (product1 != null) {
            product1.setProductName(responseObject.getProductName());

            product1.setProductBrand(responseObject.getProductBrand());
            product1.setProductPrice(responseObject.getProductPrice());
            product1.setDeleteItem(responseObject.getDeleteItem());
            String deptName = responseObject.getDeptName();
            Department tempDept = deptserve.findByDeptName(deptName);
            if (tempDept == null) {
                // If the department doesn't exist, create a new one
                tempDept = new Department(deptName);
                // Save the new department
                deptserve.addDepartment(tempDept);
            }
            product1.setDepartment(tempDept);
            return new ResponseEntity<Product>(productserve.addproduct(product1), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("productId") int ProductId){
      return new ResponseEntity<Product>(productserve.deleteProduct(ProductId),HttpStatus.OK);
    }

    @GetMapping("/productlist")
   public List<Product> findAllProducts(){
        List<Product> list1 = productserve.findAllProduct();
        List<Product> productList = new ArrayList<>();
        for (Product product:list1
             ) {
            if(product.getDeleteItem()==1){
                productList.add(product);
            }
        }
        return productList;
    }
    @GetMapping("/{productName}")
    public ResponseEntity<Product> getProduct(@PathVariable("productName") String productname){
        return new ResponseEntity<Product>(productserve.findByProductName(productname),HttpStatus.OK);
    }
}
