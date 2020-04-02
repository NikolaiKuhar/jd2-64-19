package by.it.academy.comics.dao;

import by.it.academy.comics.model.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserDao extends DAO<User> {

    Optional<User> getByUserName(String userName) throws SQLException;

}