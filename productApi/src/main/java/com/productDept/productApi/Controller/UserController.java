package com.productDept.productApi.Controller;

import com.productDept.productApi.Service.UserService;
import com.productDept.productApi.model.UserInfo;
import com.productDept.productApi.model.UserResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/userAdd")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/add")
    public ResponseEntity<UserInfo> addUser(@RequestBody UserResponseObject userResponseObject){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userResponseObject.getUserName());
        userInfo.setEmail(userResponseObject.getEmail());
        userInfo.setPassword(userResponseObject.getPassword());
        userInfo.setRoles(userResponseObject.getRoles());
        return new ResponseEntity<UserInfo>(userService.addUser(userInfo), HttpStatus.OK);

    }

    @PostMapping("/loginCheck")
    public ResponseEntity<String> loginFunction(){
        System.out.println("is triggerd");
        return ResponseEntity.ok("OK");
    }
}
