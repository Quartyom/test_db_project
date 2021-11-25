package com.quartyom;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        var dbmanager = new DBManager();
        dbmanager.readFromConfig();

        // очистка таблиц (появится когда-нибудь)

        int result = 1;
        /*result &= dbmanager.db.dbWrite(" INSERT INTO Being (id, name, is_alive) VALUES (1, 'John', 1); ");
        result &= dbmanager.db.dbWrite(" INSERT INTO HumanBase (id, is_male, age, being_id) VALUES (1, 1, 30, 1); ");
        result &= dbmanager.db.dbWrite(" INSERT INTO Doctor (id, experience_in_years, human_id) VALUES (1, 3, 1); ");
        System.out.println(result != 0 ? "success" : "failure");

        result = 1;
        result &= dbmanager.db.dbWrite(" INSERT INTO Being (id, name, is_alive) VALUES (2, 'Emily', 1); ");
        result &= dbmanager.db.dbWrite(" INSERT INTO HumanBase (id, is_male, age, being_id) VALUES (2, 0, 27, 2); ");
        result &= dbmanager.db.dbWrite(" INSERT INTO Trader (id, goods_uniqueness, human_id) VALUES (2, 0.8, 2); ");
        System.out.println(result != 0 ? "success" : "failure");*/

        dbmanager.print_all_beings();
        dbmanager.print_all_humans();
        dbmanager.print_all_doctors();
        dbmanager.print_all_traders();



        /*ResultSet rs = dbmanager.db.getResultSet("SELECT * FROM HumanBase");

        int columns = rs.getMetaData().getColumnCount();
        while(rs.next()){
            for (int i = 1; i <= columns; i++){
                System.out.print(rs.getMetaData().getColumnName(i)+ rs.getObject(i).toString() +" ");
            }
            System.out.println();
        }*/

    }
}