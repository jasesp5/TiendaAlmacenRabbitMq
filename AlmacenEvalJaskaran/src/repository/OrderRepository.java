/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import classes.Order;
import java.util.ArrayList;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author jaska
 */
public class OrderRepository {

    private DataBase dataBase;

    public OrderRepository() {
        this.dataBase = new DataBase();
    }

    /**
     * Function that saves en Order in the Database
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
     * @return Arraylist of orders
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

    /**
     * Function that returns an orders by id
     *
     * @param orderId String
     * @return an Order
     */
    public Order findOrderById(String orderId) {
        ODB odb = this.dataBase.openDataBase();
        IQuery query = new CriteriaQuery(Order.class, Where.equal("idOrder", orderId));
        Order order = (Order) odb.getObjects(query).getFirst();
        this.dataBase.closeDataBase(odb);
        return order;
    }

    /**
     * Function that changes the state of the order
     *
     * @param idOrder String
     * @param newState String
     */
    public void changeState(String idOrder, String newState) {
        ODB odb = this.dataBase.openDataBase();
        IQuery query = new CriteriaQuery(Order.class, Where.equal("idOrder", idOrder));
        Order order = (Order) odb.getObjects(query).getFirst();
        order.setState(newState);
        odb.store(order);
        this.dataBase.closeDataBase(odb);
    }
}
