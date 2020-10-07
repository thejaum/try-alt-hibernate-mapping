package com.malfer.trynewways.domain.service;

import com.malfer.trynewways.domain.model.User;
import com.malfer.trynewways.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user){
        return userRepository.save(user);
    }
}
