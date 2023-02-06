/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import classes.User;
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
public class UsersRepository {

    private DataBase dataBase;

    public UsersRepository() {
        this.dataBase = new DataBase();
    }

    /**
     * Function to save the user
     *
     * @param user User
     */
    public void save(User user) {
        ODB odb = this.dataBase.openDataBase();
        odb.store(user);
        this.dataBase.closeDataBase(odb);
    }

    /**
     * Function to get all the users
     *
     * @return ArrayList of users
     */
    public ArrayList<User> findAll() {
        ArrayList<User> users = new ArrayList<>();
        ODB odb = this.dataBase.openDataBase();
        Objects<User> objects = odb.getObjects(User.class);
        while (objects.hasNext()) {
            User user = objects.next();
            users.add(user);
        }
        this.dataBase.closeDataBase(odb);
        return users;
    }

    /**
     * Functino that finds an user by his email
     *
     * @param email String email
     * @return an user
     */
    public User findUserByEmail(String email) {
        ODB odb = this.dataBase.openDataBase();
        IQuery query = new CriteriaQuery(User.class, Where.equal("email", email));
        User user = (User) odb.getObjects(query).getFirst();
        this.dataBase.closeDataBase(odb);
        return user;
    }

    /**
     * Function that check whether the email exists or not
     *
     * @param email String
     * @return boolean
     */
    public boolean ifExists(String email) {
        ODB odb = this.dataBase.openDataBase();
        IQuery query = new CriteriaQuery(User.class, Where.equal("email", email));
        Objects<User> objects = odb.getObjects(query);
        this.dataBase.closeDataBase(odb);
        if (objects.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Function that aedd the order to the user
     *
     * @param email String
     * @param orderId String
     */
    public void addOrderToUser(String email, String orderId) {
        ODB odb = this.dataBase.openDataBase();
        IQuery query = new CriteriaQuery(User.class, Where.equal("email", email));
        Objects<User> objects = odb.getObjects(query);
        User user = (User) odb.getObjects(query).getFirst();
        user.addOrder(orderId);
        odb.store(user);
        this.dataBase.closeDataBase(odb);
    }

}
