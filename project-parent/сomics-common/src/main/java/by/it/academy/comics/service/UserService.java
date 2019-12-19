package by.it.academy.comics.service;

import by.it.academy.comics.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUser(String login, String password);

}
