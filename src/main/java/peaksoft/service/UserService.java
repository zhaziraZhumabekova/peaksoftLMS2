package peaksoft.service;

import peaksoft.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long userId);
    void addUser(User user);
    void updateUser(Long userId,User user);
    void deleteUser(User user);
}
