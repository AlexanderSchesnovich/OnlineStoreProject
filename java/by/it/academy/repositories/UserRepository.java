package by.it.academy.repositories;

import by.it.academy.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByLogin(String login);

    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT u FROM users u")
    Optional<List<User>> getAll();
}