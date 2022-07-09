package by.it.academy.services;

import by.it.academy.dtos.CreationUserRequest;
import by.it.academy.entities.User;
import by.it.academy.entities.UserStatus;
import by.it.academy.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserApiService implements UserService{
    private final UserRepository userRepository;

    public void createUser(CreationUserRequest request) {
        userRepository.save(buildUser(request));
    }

    public List<User> getUsers() {
        return userRepository.getAll().orElse(Collections.emptyList());
    }

    public void updateUser(User user) {
        userRepository.saveAndFlush(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public User buildUser(CreationUserRequest request){
        User user = User.builder()
                .login(request.getLogin())
                .password(request.getPassword())
                .userType(request.getUserType())
                .userStatus(UserStatus.ACTIVE)
                .build();
        return user;
    }
}