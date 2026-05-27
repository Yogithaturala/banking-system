package bankingsystem.service;

import bankingsystem.entity.User;
import bankingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // save user (signup)
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // find user by email (login)
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}