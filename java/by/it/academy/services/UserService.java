package by.it.academy.services;

import by.it.academy.entities.User;
import by.it.academy.repositories.Repository;
import by.it.academy.repositories.UserRepository;

import java.util.*;

public class UserService {

    private final Repository<User> userRepository = new UserRepository();

    protected void create(User user) {
        String encryptedPassword = encryptPassword(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.create(user);
    }

    protected List<User> getAll() {
        return userRepository.getAll().orElse(Collections.emptyList());
    }

    protected void update(User user) {
        userRepository.update(user);
    }

    protected void delete(Long id) {
        userRepository.delete(id);
    }

    public User getUserByNameAndPassword(String login, String password) {
        Optional<User> user = ((UserRepository) userRepository).getUserByNameAndPassword(login, encryptPassword(password));
        return user.orElse(new User());
    }

    public boolean isRegisteredUser(String login, String password){
        return getUserByNameAndPassword(login, password).equals(new User());
    }
    private String encryptPassword(String password) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(password.getBytes());
    }
}