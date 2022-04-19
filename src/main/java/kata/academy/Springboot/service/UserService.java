package kata.academy.Springboot.service;

import kata.academy.Springboot.model.User;


import java.util.List;


public interface UserService {
    public void addUser(User user);

    public User getUserById(Long id);

    public User updateUser(User user);

    public void removeUserById(Long id);

    public List<User> listUsers();
}