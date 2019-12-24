package by.it.academy.comics.service.impl;

import by.it.academy.comics.model.User;
import by.it.academy.comics.service.UserService;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class UserServiceImpl implements UserService {


    private static final UserService INSTANCE = new UserServiceImpl();
    private final Map<String, User> users = new ConcurrentHashMap<>();

    private UserServiceImpl() {
        users.put("arthas", new User("arthas", "arthas123", "admin"));
        users.put("thrall", new User("thrall", "thrall123", "user"));
    }

    public static UserService getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<User> findUser(String login, String password) {
        User user = users.get(login);
        if (user != null && password.equals(user.getPassword())) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}
