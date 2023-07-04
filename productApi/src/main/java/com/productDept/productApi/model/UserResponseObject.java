package com.productDept.productApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserResponseObject {
    private int userId;



    //    @Column(name = "userName")
    private String userName;
    //    @Column(name = "email")
    private String email;
    //    @Column(name = "password")
    private String password;
    private String roles ;

    //Constructor
    public UserResponseObject(int userId, String userName, String email, String password,String roles) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
