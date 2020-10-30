package ru.itis.repositories;

import ru.itis.models.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {
    Optional<User> findByUsername(String username);
    boolean validate(String username, String password);
}
