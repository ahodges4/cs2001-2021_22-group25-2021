package com.example.Food4Everyone.Dto;

public class UserRegistration 
{
    private String fullName;
    private String username;
    private String email;
    private String phone;
    private String password;

    public UserRegistration() 
    {

    }

    public UserRegistration(String fullName, String username, String email, String phone, String password) 
    {
        super();
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getFullName() 
    {
        return fullName;
    }

    public void setFullName(String fullName) 
    {
        this.fullName = fullName;
    }

    public String getUsername()
    {
    	return username;
    }
    
    public void setUsername(String username)
    {
    	this.username = username;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }
    
    public String getPhone()
    {
    	return phone;
    }
    
    public void setPhone(String phone)
    {
    	this.phone = phone;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }
}

