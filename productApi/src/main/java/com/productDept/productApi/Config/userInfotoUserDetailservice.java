package com.productDept.productApi.Config;

import com.productDept.productApi.Repository.UserInfoRepository;
import com.productDept.productApi.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class userInfotoUserDetailservice implements UserDetailsService {

    @Autowired
    UserInfoRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserInfo> user = repository.findByUserName(username);
                return user.map(UserInfoToUserDetail::new)
                        .orElseThrow(()-> new UsernameNotFoundException("user is not found"+username));
    }
}
