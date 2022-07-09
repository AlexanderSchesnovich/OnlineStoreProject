package by.it.academy.controllers;

import by.it.academy.dtos.CreationUserRequest;
import by.it.academy.entities.User;
import by.it.academy.services.OnlineStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final OnlineStore store;

    @PostMapping(value = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid CreationUserRequest request) {
        store.createUser(request);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUsers() {
        final List<User> users = store.getUsers();
        return users.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable(name = "id") Long id) {
        store.deleteUser(id);
    }

    @PutMapping(value = "/users")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody User user) {
        store.updateUser(user);
    }

    @GetMapping(value = "/users/{login}")
    public ResponseEntity<User> getUserByLogin(@PathVariable(name = "login") String login) {
        Optional<User> user = store.getUserByLogin(login);
        return user
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
