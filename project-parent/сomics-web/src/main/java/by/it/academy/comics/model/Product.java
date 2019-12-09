package by.it.academy.comics.model;

import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private Double price;
    private int count;
    private Double rating;

    public Product() {
    }

    public Product(Long id, String name, Double price, int count, Double rating ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return count == product.count &&
                id.equals(product.id) &&
                name.equals(product.name) &&
                price.equals(product.price) &&
                rating.equals(product.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, count, rating);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", rating=" + rating +
                '}';
    }
}
