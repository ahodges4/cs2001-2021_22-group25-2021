package com.example.Food4Everyone.repository;

import com.example.Food4Everyone.model.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> 
{
    UserInfo findByUsername(String username);
}
