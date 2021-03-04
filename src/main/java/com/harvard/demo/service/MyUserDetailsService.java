package com.harvard.demo.service;

import com.harvard.demo.entity.MyUserDetails;
import com.harvard.demo.entity.User;
import com.harvard.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("MyUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = this.userRepository.findByUsername(username);
        return optionalUser
                .map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("The user does not exist in the database."));
    }
}
