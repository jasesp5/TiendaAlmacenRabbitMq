/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import classes.Order;
import java.util.ArrayList;
import repository.OrderRepository;

/**
 *
 * @author jaska
 */
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService() {
        this.orderRepository = new OrderRepository();
    }

    public void save(Order order) {
        this.orderRepository.save(order);
    }

    /**
     * Function that return all the orders
     *
     * @return Arraylist of with all the orders
     */
    public ArrayList<Order> findAll() {
        return this.orderRepository.findAll();

    }

    /**
     * Function to get an order by his id
     *
     * @param orderId String
     * @return an Order
     */
    public Order findOrderById(String orderId) {
        return this.orderRepository.findOrderById(orderId);
    }

    public void changeState(String idOrder, String newState) {
        this.orderRepository.changeState(idOrder, newState);
    }

}
