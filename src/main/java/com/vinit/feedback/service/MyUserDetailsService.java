package com.vinit.feedback.service;

import com.vinit.feedback.dao.UserDao;
import com.vinit.feedback.entity.MyUserDetails;
import com.vinit.feedback.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByFirstName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        System.out.println("User obtained from db: " + user.get().getFullName());
        return user.map(MyUserDetails::new).get();
    }
}
