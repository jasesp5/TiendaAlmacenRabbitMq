/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import classes.Product;
import java.util.ArrayList;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author Shajinder
 */
public class ProductRepository {

    private final int MINUS_STOCK = 1;

    private DataBase dataBase;

    public ProductRepository() {
        this.dataBase = new DataBase();
    }

    /**
     * Function to save the product
     *
     * @param product Product
     */
    public void save(Product product) {
        ODB odb = this.dataBase.openDataBase();
        odb.store(product);
        this.dataBase.closeDataBase(odb);
    }

    /**
     * Function to get all the products
     *
     * @return all the products
     */
    public ArrayList<Product> findAll() {
        ArrayList<Product> products = new ArrayList<>();
        ODB odb = this.dataBase.openDataBase();
        Objects<Product> objects = odb.getObjects(Product.class);
        while (objects.hasNext()) {
            Product product = objects.next();
            products.add(product);
        }
        this.dataBase.closeDataBase(odb);
        return products;
    }

    /**
     * Function to get the products which are only available
     *
     * @return all the products available
     */
    public ArrayList<Product> findAllWithStockAvailable() {
        ArrayList<Product> products = new ArrayList<>();
        ODB odb = this.dataBase.openDataBase();
        IQuery query = new CriteriaQuery(Product.class, Where.ge("stock", 1));

        Objects<Product> objects = odb.getObjects(query);
        while (objects.hasNext()) {
            Product product = objects.next();
            products.add(product);
        }
        this.dataBase.closeDataBase(odb);
        return products;
    }

    /**
     * Function to check if the products exists
     *
     * @param name String
     * @return boolean
     */
    public boolean ifExists(String name) {
        ODB odb = this.dataBase.openDataBase();
        IQuery query = new CriteriaQuery(Product.class, Where.equal("name", name));
        Objects<Product> objects = odb.getObjects(query);
        this.dataBase.closeDataBase(odb);
        if (objects.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Function to update the stock
     *
     * @param name String name of the product
     */
    public void updateStock(String name) {
        ODB odb = this.dataBase.openDataBase();
        IQuery query = new CriteriaQuery(Product.class, Where.equal("name", name));
        Objects<Product> objects = odb.getObjects(query);
        Product product = (Product) odb.getObjects(query).getFirst();
        int stock = product.getStock() - MINUS_STOCK;
        product.setStock(stock);
        odb.store(product);
        this.dataBase.closeDataBase(odb);
    }

}
