package com.java.springboot.security;

import com.java.springboot.model.Admin;
import com.java.springboot.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AdminSecurityService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Admin admin = adminRepository.findByEmail(email);
       if(admin == null){
           throw new UsernameNotFoundException("User not Found");
       }
        return new AdminSecurity(admin);
    }
}
