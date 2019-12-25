package by.it.academy.comics.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<C> {

    Long create(C c) throws SQLException;

    Optional<C> read(Long id) throws SQLException;

    int update(C c) throws SQLException;

    int delete(Long id) throws SQLException;

    List<C> getAll() throws SQLException;

}