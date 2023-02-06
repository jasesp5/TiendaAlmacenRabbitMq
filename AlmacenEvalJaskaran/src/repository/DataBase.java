/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author jaska
 */
public class DataBase {

    /**
     * Function to open Database
     *
     * @return Odb
     */
    public ODB openDataBase() {
        ODB odb = ODBFactory.open("almacen.db");
        return odb;
    }

    public void closeDataBase(ODB odb) {
        odb.close();
    }

}
