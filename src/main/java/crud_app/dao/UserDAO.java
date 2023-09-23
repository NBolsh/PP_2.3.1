package crud_app.dao;

import crud_app.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    List<User> getAllUsers();
    void deleteUser(int id);
    User findUserById(int id);
}

