package com.cb.chat_bot_slack.service.impl;


import com.cb.chat_bot_slack.entity.User;
import com.cb.chat_bot_slack.repository.UserRepo;
import com.cb.chat_bot_slack.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserDetailsService , UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepo.findByUsernameOrEmail(username, username);
        if (user == null) {
            throw new UsernameNotFoundException("User not exists by Username");
        }
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        log.info("Authorities2 :{}",authorities);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword() , authorities);
    }

    @Override
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> createUser(User UserDTO) {
        return null;
    }

    @Override
    public ResponseEntity<User> updateUser(Integer UserID, User UserDTO) {
        return null;
    }

    @Override
    public Map<String, Boolean> deleteUser(Integer UserID) {
        return null;
    }

    @Override
    public ResponseEntity<User> searchUser(Integer UserID) {
        return null;
    }
}

