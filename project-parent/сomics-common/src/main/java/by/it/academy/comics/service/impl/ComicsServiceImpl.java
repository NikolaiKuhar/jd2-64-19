package by.it.academy.comics.service.impl;

import by.it.academy.comics.dao.ComicsDao;
import by.it.academy.comics.dao.impl.ComicsDaoImpl;
import by.it.academy.comics.model.Comics;
import by.it.academy.comics.service.ComicsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ComicsServiceImpl implements ComicsService {

    private static final Logger logger = LoggerFactory.getLogger(ComicsServiceImpl.class);
    private static final ComicsService INSTANCE = new ComicsServiceImpl();

    private final ComicsDao comicsDao = ComicsDaoImpl.getInstance();

    private ComicsServiceImpl() {
    }

    public static ComicsService getService() {
        return INSTANCE;
    }



    @Override
    public List<Comics> getAllComics() {
        logger.debug("Get all comics");
        try {
            return comicsDao.getAll();
        } catch (SQLException e) {
            logger.error("Error while getting all comics", e);
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<Comics> getById(Long id) {
        logger.debug("Get comics by id {}", id);
        try {
            Optional<Comics> comics = comicsDao.read(id);
            logger.debug("result {}", comics);
            return comics;
        } catch (SQLException e) {
            logger.error("Error while getting comics by id " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public Comics addNewComics(Comics comics) {
        logger.debug("add new comics {}", comics);
        try {
            Long id = comicsDao.create(comics);
            comics.setId(id);
            logger.debug("result {}", id);
        } catch (SQLException e) {
            logger.error("Error while creating comics " + comics, e);
        }
        return comics;
    }
    @Override
    public void deleteComics(Long id){
        logger.debug("deleting comics id = {}", id);
        try {
            int delete = comicsDao.delete(id);
            logger.debug("result {}", delete);
        } catch (SQLException e) {
            logger.error("Error while deleting comics id=" + id, e);
        }
    }
    @Override
    public Comics updateComics(Comics comics){
        logger.debug("updating comics {}", comics);
        try {
            int update = comicsDao.update(comics);
            logger.debug("result {}", update);
        } catch (SQLException e) {
            logger.error("Error while updating comics " + comics, e);
        }
        return comics;
    }
}

