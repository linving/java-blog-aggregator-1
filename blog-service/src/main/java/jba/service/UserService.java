package jba.service;

import jba.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findOne(int id);

    public User findOneWithBlogs(Integer id);

    public void save(User user);

    public User findOneWithBlogs(String name);

    void delete(int id);

    User findOne(String name);
}
