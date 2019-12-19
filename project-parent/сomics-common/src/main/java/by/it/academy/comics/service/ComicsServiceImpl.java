package by.it.academy.comics.service;

import by.it.academy.comics.model.Comics;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class ComicsServiceImpl implements ComicsService {

    private static final ComicsService INSTANCE = new ComicsServiceImpl();

    private final List<Comics> goods;

    private AtomicLong id = new AtomicLong(10);
    private ComicsServiceImpl() {
        goods = new ArrayList<>();
        goods.add(new Comics(1L, "Comics name 1", 10.0,0,8.0));
        goods.add(new Comics(2L, "Comics name 2", 30.0,1,8.5));

    }

    public static ComicsService getService() {
        return INSTANCE;
    }



    @Override
    public List<Comics> getAllComics() {
        return new ArrayList<>(goods);
    }

    @Override
    public void addNewComics(Comics comics) {
        comics.setId(id.incrementAndGet());
        goods.add(comics);
    }
    @Override
    public void deleteComics(Long id){
        for (int i = 0; i < goods.size(); i++) {
          if  (goods.get(i).getId().equals(id)){
              goods.remove(i);
              break;
          }
        }
    }
    @Override
    public void updateComics(Comics newComics){
        for (int i = 0; i < goods.size(); i++) {
            Comics oldComics = goods.get(i);
            if  (oldComics.getId().equals(newComics.getId())) {
                oldComics.setName(newComics.getName());
                oldComics.setPrice(newComics.getPrice());
                oldComics.setCount(newComics.getCount());
                oldComics.setRating(newComics.getRating());
                break;
            }
        }

    }
}

