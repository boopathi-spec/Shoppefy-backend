package com.productDept.productApi.model;


public class ResponseObject {
    private int productId;
    private String productName;
    private String productBrand;
    private float productPrice;
    private int deleteItem;
    private String deptName;

    public ResponseObject(int productId, String productName, String productBrand, float productPrice, String deptName,int deleteItem) {
        this.productId = productId;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productPrice = productPrice;
        this.deptName = deptName;
        this.deleteItem = deleteItem;
    }

    public ResponseObject() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int product_id) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getDeptName() {
        return deptName;
    }

    public int getDeleteItem() {
        return deleteItem;
    }

    public void setDeleteItem(int deleteItem) {
        this.deleteItem = deleteItem;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
