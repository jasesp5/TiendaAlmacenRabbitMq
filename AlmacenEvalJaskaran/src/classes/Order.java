/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author jaska
 */
public class Order {

    private String idOrder;

    private ArrayList<String> products;

    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public void setProductName(ArrayList<String> productName) {
        this.products = productName;
    }

    public void addProduct(String productName) {
        this.products.add(productName);
    }

    public String getIdOrder() {
        return idOrder;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "idOrder = ," + idOrder + ", products =," + products + ", state = " + state + '}';
    }

}
