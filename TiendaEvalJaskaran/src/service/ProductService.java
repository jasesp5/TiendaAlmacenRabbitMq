/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import classes.Product;
import java.util.ArrayList;
import repository.ProductRepository;

/**
 *
 * @author Shajinder
 */
public class ProductService {

    private ProductRepository productRepository;

    public ProductService() {
        this.productRepository = new ProductRepository();
    }

    /**
     * Function to save the product
     *
     * @param product Product
     */
    public void save(Product product) {
        this.productRepository.save(product);
    }

    /**
     * Function to get all the products
     *
     * @return all the products
     */
    public ArrayList<Product> findAll() {
        return this.productRepository.findAll();
    }

    /**
     * Function to get all the products with stock more than one
     *
     * @return all the stocks with more than or equal one stock
     */
    public ArrayList<Product> findAllWithStockAvailable() {
        return this.productRepository.findAllWithStockAvailable();
    }

    /**
     * Function to check if the products exists
     *
     * @param name String
     * @return boolean
     */
    public boolean ifExists(String name) {
        return this.productRepository.ifExists(name);
    }

    public void updateStock(String name) {
        this.productRepository.updateStock(name);
    }

}
