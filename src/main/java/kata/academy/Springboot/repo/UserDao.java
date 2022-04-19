package kata.academy.Springboot.repo;

import kata.academy.Springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao  {
    public void addUser(User user);

    public User getUserById(Long id);

    public User updateUser(User user);

    public void removeUserById(Long id);

    public List<User> listUsers();
}
