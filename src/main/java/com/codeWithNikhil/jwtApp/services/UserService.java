package com.codeWithNikhil.jwtApp.services;

import com.codeWithNikhil.jwtApp.model.User;
import com.codeWithNikhil.jwtApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    public String saveUser(User user) {
        userRepo.save(user);
        return "user successfully registered";
    }

    public String verify(User user) {
        User u1 = userRepo.findByUsername(user.getUsername());
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(auth.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }else {
            return "failed";
        }

    }

}
