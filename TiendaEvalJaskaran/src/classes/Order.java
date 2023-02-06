/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Shajinder
 */
public class Order {

    private String idOrder;

    private ArrayList<String> products;

    public Order() {
        this.idOrder = UUID.randomUUID().toString().substring(0, 5);
        this.products = new ArrayList<>();
    }

    public void addProduct(String productName) {
        this.products.add(productName);
    }

    public String getIdOrder() {
        return idOrder;
    }

    public ArrayList<String> getProductName() {
        return products;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public void setProductName(ArrayList<String> productName) {
        this.products = productName;
    }

    @Override
    public String toString() {
        return "Orders{" + "idOrder=" + idOrder + ", productName=" + products + '}';
    }

}
