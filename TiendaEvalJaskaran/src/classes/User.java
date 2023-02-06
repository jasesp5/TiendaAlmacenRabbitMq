/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author Shajinder
 */
public class User {

    private String name;

    private String email;

    private ArrayList<String> orderid;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.orderid = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getOrderid() {
        return orderid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrderid(ArrayList<String> orderid) {
        this.orderid = orderid;
    }

    @Override
    public String toString() {
        return "Users{" + "name=" + name + ", email=" + email + ", orderid=" + orderid + '}';
    }

    public void addOrder(String orderId) {
        this.orderid.add(orderId);
    }

}
