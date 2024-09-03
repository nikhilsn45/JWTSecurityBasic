package com.codeWithNikhil.jwtApp.services;

import com.codeWithNikhil.jwtApp.model.User;
import com.codeWithNikhil.jwtApp.model.UserPrincipal;
import com.codeWithNikhil.jwtApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepo.findByUsername(username);
        if (user==null){
            System.out.println("User not found in database");
            throw new UsernameNotFoundException("User not found!!!!!");
        }

        return new UserPrincipal(user);
    }
}
