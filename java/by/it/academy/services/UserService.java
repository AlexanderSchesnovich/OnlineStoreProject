package by.it.academy.services;

import by.it.academy.dtos.CreationUserRequest;
import by.it.academy.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(CreationUserRequest request);
    List<User> getUsers();
    void updateUser(User user);
    void deleteUser(Long id);
    Optional<User> getUserByLogin(String login);
}
