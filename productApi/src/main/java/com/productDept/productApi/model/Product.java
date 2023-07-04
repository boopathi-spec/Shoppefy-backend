package com.productDept.productApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
//@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "product_id")
    private int productId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

//    @Column(name = "product_name")
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

//    @Column(name = "product_brand")
    private String productBrand;

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }


//    @Column(name = "product_price")
    private float productPrice;

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

//    @Column(name = "deletedItem")
    private  int deleteItem;

    public int getDeleteItem() {
        return deleteItem;
    }

    public void setDeleteItem(int deleteItem) {
        this.deleteItem = deleteItem;
    }

    @ManyToOne()
    @JoinColumn(name = "dept_id")
    @JsonBackReference
    private Department department;



    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public Product(int productId, String productName, String productBrand, float productPrice,int deleteItem, Department department) {
        this.productId = productId;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productPrice = productPrice;
        this.department = department;
        this.deleteItem = deleteItem;
    }
    public Product(){}
}
