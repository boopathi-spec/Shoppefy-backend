package com.productDept.productApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dept_id;


    public int getDept_id() {
        return dept_id;
    }

    public Department() {
    }

    public Department(String deptName) {

        this.deptName = deptName;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }
//    @Column(name = "deptName")
    private String deptName;


    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Department(List<Product> products) {
        this.products = products;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
    @JsonManagedReference
   private List<Product> products;



    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> add(Product product){
        if(products == null ) products = new ArrayList<>();
        products.add(product);
        return  products;
    }

}
