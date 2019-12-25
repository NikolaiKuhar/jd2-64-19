package by.it.academy.comics.service;

import by.it.academy.comics.model.Comics;

import java.util.List;
import java.util.Optional;

public interface ComicsService  {
    List<Comics> getAllComics();

    Optional<Comics> getById(Long id);

    Comics addNewComics(Comics comics);
    void deleteComics(Long id);
    Comics updateComics(Comics comics);
}
