package com.example.Food4Everyone.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.example.Food4Everyone.Dto.UserRegistration;
import com.example.Food4Everyone.model.Role;
import com.example.Food4Everyone.model.UserInfo;
import com.example.Food4Everyone.repository.UserInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService 
{

    private UserInfoRepository userInfoRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) 
    {
        super();
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserInfo save(UserRegistration registration) 
    {
        UserInfo user = new UserInfo(registration.getFullName(), registration.getUsername(), registration.getEmail(), registration.getPhone(),
        		passwordEncoder.encode(registration.getPassword()), Arrays.asList(new Role("ROLE_USER")));

        return userInfoRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {

        UserInfo user = userInfoRepository.findByUsername(username);
        if (user == null) 
        {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) 
    {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public List<UserInfo> getAll() 
    {
        return userInfoRepository.findAll();
    }
}
