/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import classes.User;
import java.util.ArrayList;
import repository.UsersRepository;

/**
 *
 * @author Shajinder
 */
public class UserService {

    private UsersRepository userRepository;

    public UserService() {
        this.userRepository = new UsersRepository();
    }

    /**
     * Function to save the user
     *
     * @param user User
     */
    public void save(User user) {
        this.userRepository.save(user);
    }

    /**
     * Functino to get all the users
     *
     * @return all the users
     */
    public ArrayList<User> findAll() {
        return this.userRepository.findAll();
    }

    /**
     * Function to find an user by email
     *
     * @param email String
     * @return user
     */
    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    /**
     * Function to check if the user exists
     *
     * @param email String
     * @return boolean
     */
    public boolean ifExists(String email) {
        return this.userRepository.ifExists(email);
    }

    /**
     * Function to add order to the user
     *
     * @param email String email
     * @param orderId String the id of the order
     */
    public void addOrderToUser(String email, String orderId) {
        this.userRepository.addOrderToUser(email, orderId);
    }
}
