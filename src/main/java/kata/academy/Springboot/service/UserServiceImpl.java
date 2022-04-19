package kata.academy.Springboot.service;

import kata.academy.Springboot.model.User;
import kata.academy.Springboot.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void removeUserById(Long id) {
        userDao.removeUserById(id);
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
