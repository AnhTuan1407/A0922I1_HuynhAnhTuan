package com.example.repository;

import com.example.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{

    static List<Product> productList;

    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Tu lanh", 1200000, "Tiet Kiem Dien", "SamSung"));
        productList.add(new Product(2, "Ti vi", 8000000, "4k", "Sony"));
        productList.add(new Product(3, "May Giat", 7500000, "Giat Nhanh", "Panasonic"));
        productList.add( new Product(4, "Lap top", 18000000, "Gaming", "ROG"));
        productList.add(new Product(5, "Dieu Hoa", 9800000, "Tiet Kiem Dien", "SamSung"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }


    @Override
    public Product findById(int id) {
        Product product = new Product();
        for (Product p : productList)
        {
            if (p.getId() == id){
                product = p;
            }
        }
        return product;
    }

    @Override
    public void update(int id, Product product) {
        productList.set(id - 1, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id - 1);
    }
}
