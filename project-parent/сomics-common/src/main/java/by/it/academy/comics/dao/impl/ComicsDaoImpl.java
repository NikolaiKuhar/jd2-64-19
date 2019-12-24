package by.it.academy.comics.dao.impl;

import by.it.academy.comics.dao.ComicsDao;
import by.it.academy.comics.model.Comics;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComicsDaoImpl extends AbstractDao implements ComicsDao {
    private static final ComicsDaoImpl INSTANCE = new ComicsDaoImpl();

    public static final String INSERT_COMICS = "INSERT INTO comics (name, price, count, rating) VALUE (?,?,?,?)";
    public static final String SELECT_COMICS_BY_ID = "SELECT * FROM comics WHERE id = ?";
    public static final String SELECT_ALL_COMICS = "SELECT * FROM comics";
    public static final String UPDATE_COMICS = "UPDATE comics  SET name = ? , price = ?, count = ?, rating = ? WHERE id = ?";
    public static final String DELETE_COMICS_BY_ID = "DELETE FROM student WHERE id = ?";

    private ComicsDaoImpl() {
        super(LoggerFactory.getLogger(ComicsDaoImpl.class));
    }

    public static ComicsDao getInstance() {
        return INSTANCE;
    }


    @Override
    public Long create(Comics comics) throws SQLException {
        ResultSet resultSet = null;
        Long result = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_COMICS, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, comics.getName());
            statement.setDouble(2, comics.getPrice());
            statement.setInt(3, comics.getCount());
            statement.setDouble(4, comics.getRating());

            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();

            while (resultSet.next()) {
                result = resultSet.getLong(1);
            }
        } finally {
            closeQuietly(resultSet);
        }
        return result;
    }


    @Override
    public Optional<Comics> read(Long id) throws SQLException {
        ResultSet resultSet = null;
        Optional<Comics> result = Optional.empty();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_COMICS_BY_ID)) {

            statement.setObject(1, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                result = Optional.of(mapComics(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return result;
    }


    @Override
    public int update(Comics comics) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_COMICS)) {

            statement.setString(1, comics.getName());
            statement.setDouble(2, comics.getPrice());
            statement.setInt(3, comics.getCount());
            statement.setDouble(4, comics.getRating());
            statement.setLong(5, comics.getId());

            return statement.executeUpdate();
        }
    }

    @Override
    public int delete(Long id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_COMICS_BY_ID)) {
            statement.setObject(1, id);
            return statement.executeUpdate();
        }
    }

    @Override
    public List<Comics> getAll() throws SQLException {
        ResultSet resultSet = null;
        List<Comics> result = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_COMICS)) {

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(mapComics(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return result;
    }

    private Comics mapComics(ResultSet resultSet) throws SQLException {
        long userId = resultSet.getLong("id");
        String name = resultSet.getString("name");
        Double price = resultSet.getDouble("price");
        Integer count = resultSet.getInt("count");
        Double rating = resultSet.getDouble("rating");
        return new Comics(userId, name, price, count, rating);
    }
}
