/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import classes.Order;
import java.util.ArrayList;
import repository.OrderRepository;

/**
 *
 * @author Shajinder
 */
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService() {
        this.orderRepository = new OrderRepository();
    }

    /**
     * Function to save to the order
     *
     * @param order Order
     */
    public void save(Order order) {
        this.orderRepository.save(order);
    }

    /**
     * Function to get all the orders
     *
     * @return all the orders
     */
    public ArrayList<Order> findAll() {
        return this.orderRepository.findAll();

    }

}
