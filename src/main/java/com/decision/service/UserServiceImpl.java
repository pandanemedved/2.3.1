package com.decision.service;

import com.decision.dao.UserDao;
import com.decision.entity.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public User findById(Long id) {
        User findUser = userDao.findById(id);
        if (findUser == null) {
            throw new EntityNotFoundException("Пользователь с таким ID" + id + " не найден");
        }
        return findUser;
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        User updateUser = findById(user.getId());
        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());
        userDao.updateUser(updateUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        User deleteUser = findById(id);
        userDao.delete(deleteUser.getId());
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDao.findAll();
    }
}
