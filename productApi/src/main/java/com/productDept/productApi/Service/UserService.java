package com.productDept.productApi.Service;

import com.productDept.productApi.model.UserInfo;
import com.productDept.productApi.model.UserResponseObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserInfo addUser(UserInfo userInfo);

    List<UserInfo> getAllUser ();
}
