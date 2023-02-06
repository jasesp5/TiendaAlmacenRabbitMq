/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import classes.Order;
import java.util.ArrayList;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

/**
 *
 * @author Shajinder
 */
public class OrderRepository {

    private DataBase dataBase;

    public OrderRepository() {
        this.dataBase = new DataBase();
    }

    /**
     * Function to save an order
     *
     * @param order Order
     */
    public void save(Order order) {
        ODB odb = this.dataBase.openDataBase();
        odb.store(order);
        this.dataBase.closeDataBase(odb);
    }

    /**
     * Function to get all the orders
     *
     * @return all the orders
     */
    public ArrayList<Order> findAll() {
        ArrayList<Order> orders = new ArrayList<>();
        ODB odb = this.dataBase.openDataBase();
        Objects<Order> objects = odb.getObjects(Order.class);
        while (objects.hasNext()) {
            Order order = objects.next();
            orders.add(order);
        }
        this.dataBase.closeDataBase(odb);
        return orders;
    }

}
