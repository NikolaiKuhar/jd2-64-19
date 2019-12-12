package by.it.academy.comics.service;

import by.it.academy.comics.model.Product;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class ProductServiceImpl implements ProductService {

    private static final ProductService INSTANCE = new ProductServiceImpl();

    private final List<Product> products;

    private AtomicLong id = new AtomicLong();
    private ProductServiceImpl() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Product name 1", 10.0,0,8.0));
        products.add(new Product(2L, "Product name 1", 30.0,1,8.5));

    }

    public static ProductService getService() {
        return INSTANCE;
    }



    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public void addNewProduct(Product product) {
        product.setId(id.incrementAndGet());
        products.add(product);
    }
    @Override
    public void deleteProduct(Long id){
        for (int i = 0; i < products.size(); i++) {
          if  (products.get(i).getId().equals(id)){
              products.remove(i);
              break;
          }
        }
    }
    @Override
    public void updateProduct(Product newProduct){
        for (int i = 0; i < products.size(); i++) {
            Product oldProduct = products.get(i);
            if  (oldProduct.getId().equals(newProduct.getId())) {
                oldProduct.setName(newProduct.getName());
                oldProduct.setPrice(newProduct.getPrice());
                oldProduct.setCount(newProduct.getCount());
                oldProduct.setRating(newProduct.getRating());
                break;
            }
        }

    }
}

