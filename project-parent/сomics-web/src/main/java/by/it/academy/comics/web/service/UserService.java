package by.it.academy.comics.web.service;

import by.it.academy.comics.web.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUser(String login, String password);

}
