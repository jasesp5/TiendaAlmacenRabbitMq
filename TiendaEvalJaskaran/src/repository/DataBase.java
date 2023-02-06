/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author Shajinder
 */
public class DataBase {

    /**
     * Function to open the database
     *
     * @return the database opened
     */
    public ODB openDataBase() {
        ODB odb = ODBFactory.open("tienda.db");
        return odb;
    }

    /**
     * Function to close the database
     *
     * @param odb
     */
    public void closeDataBase(ODB odb) {
        odb.close();
    }

}
