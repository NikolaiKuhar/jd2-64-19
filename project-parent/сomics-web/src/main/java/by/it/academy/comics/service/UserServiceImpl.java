package by.it.academy.comics.service;

import by.it.academy.comics.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl {
    private Map<String, User> users = new HashMap<>();

    public UserServiceImpl() {
        users.put("admin", new User("admin","12345"));
    }




    public User getUser(String userName, String password){
        User user = users.get(userName);
        if (user != null && user.getPassword().equals(password)){
            return user;

        }
        return null;
    }
}
