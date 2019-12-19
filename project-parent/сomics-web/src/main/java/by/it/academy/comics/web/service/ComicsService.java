package by.it.academy.comics.web.service;

import by.it.academy.comics.web.model.Comics;

import java.util.List;

public interface ComicsService  {
    List<Comics> getAllComics();

    void addNewComics(Comics comics);
    void deleteComics(Long id);
    void updateComics(Comics comics);
}
