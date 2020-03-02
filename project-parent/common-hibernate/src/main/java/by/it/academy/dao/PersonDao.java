package by.it.academy.dao;

import by.it.academy.entity.PersonEntity;

public interface PersonDao {


    void create(PersonEntity pe);

    void update(PersonEntity pe);

    void read(long id);

    void delete(PersonEntity pe);


}
