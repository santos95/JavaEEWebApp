package com.sortiz.webapp.headers.service;

import com.sortiz.webapp.headers.model.Product;

import java.util.Arrays;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    @Override
    public List<Product> getList() {
        return Arrays.asList(
                new Product(1L, "Play Station 5", "Console", 550),
                new Product(2L, "Xbox Series X", "Console", 500),
                new Product(3L, "Adidas Samba", "Shoes", 60),
                new Product(4L, "MrBeastBurger", "Food", 10)
        );
    }
}
