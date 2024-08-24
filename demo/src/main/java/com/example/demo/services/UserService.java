package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Retailer;
import com.example.demo.model.UserPrincipal;
import com.example.demo.repo.RetailerRepo;

import jakarta.ws.rs.NotFoundException;

@Service
public class UserService implements UserDetailsService{

@Autowired
private RetailerRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Retailer u=repo.getByRetailerUsername(username);
        if(u==null){
        throw new NotFoundException("user not found");
        }

       return new UserPrincipal(u);
    }

}
