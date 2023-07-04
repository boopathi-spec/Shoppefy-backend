package com.productDept.productApi.Serviceimpl;

import com.productDept.productApi.Repository.UserInfoRepository;
import com.productDept.productApi.Service.UserService;
import com.productDept.productApi.model.UserInfo;
import com.productDept.productApi.model.UserResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserInfoRepository repository;
    @Override
    public UserInfo addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return repository.save(userInfo);
    }

    @Override
    public List<UserInfo> getAllUser() {
        return repository.findAll();
    }
}
