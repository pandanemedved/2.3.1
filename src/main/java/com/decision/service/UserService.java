package com.decision.service;

import com.decision.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {

    void save(User user);

    User findById(Long id);

    void delete(Long id);

    List<User> findAll();
}
