package com.example.Food4Everyone.Service;

import java.util.List;

import com.example.Food4Everyone.Dto.UserRegistration;
import com.example.Food4Everyone.model.UserInfo;

import org.springframework.security.core.userdetails.UserDetailsService;




public interface UserInfoService extends UserDetailsService 
{
    UserInfo save(UserRegistration registration);
    List<UserInfo> getAll();
}
