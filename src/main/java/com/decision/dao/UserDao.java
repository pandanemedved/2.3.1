package com.decision.dao;

import com.decision.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    void save(User user);

    User findById(Long id);

    void delete(Long id);

    List<User> findAll();
}
