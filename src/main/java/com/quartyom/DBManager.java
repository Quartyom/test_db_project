package com.quartyom;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
    DBCore db = new DBCore();

    public void readFromConfig(){
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            db.url = property.getProperty("url");
            db.username = property.getProperty("username");
            db.password = property.getProperty("password");

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    public void print_all_beings() throws SQLException, ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        var Beings = db.dbRead("SELECT name, is_alive FROM Being", Being.class);

        if (Beings.size() == 0){
            System.out.println("Array of Beings is empty");
            return;
        }

        for (var item : Beings) {
            Method method = Being.class.getDeclaredMethod("get_full_info");
            method.setAccessible(true);
            System.out.println(method.invoke(item));
        }

    }
    public void print_all_humans() throws SQLException, ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        var Humans = db.dbRead("SELECT name, is_alive, is_male, age FROM Being " +
                        "INNER JOIN HumanBase ON Being.id = HumanBase.being_id ",
                Human.class
        );

        if (Humans.size() == 0){
            System.out.println("Array of Humans is empty");
            return;
        }

        for (var item : Humans) {
            Method method = Human.class.getDeclaredMethod("get_full_info");
            method.setAccessible(true);
            System.out.println(method.invoke(item));
        }
    }
    public void print_all_doctors() throws SQLException, ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        var Doctors = db.dbRead("SELECT name, is_alive, is_male, age, experience_in_years FROM Being " +
                        "INNER JOIN HumanBase ON Being.id = HumanBase.being_id " +
                        "INNER JOIN Doctor ON HumanBase.id = Doctor.human_id",
                Doctor.class
        );

        if (Doctors.size() == 0){
            System.out.println("Array of Doctors is empty");
            return;
        }

        for (var item : Doctors) {
            Method method = Doctor.class.getMethod("get_full_info");
            //method.setAccessible(true);
            System.out.println(method.invoke(item));
        }
    }
    public void print_all_traders() throws SQLException, ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        var Traders = db.dbRead("SELECT name, is_alive, is_male, age, goods_uniqueness FROM Being " +
                        "INNER JOIN HumanBase ON Being.id = HumanBase.being_id " +
                        "INNER JOIN Trader ON HumanBase.id = Trader.human_id",
                Trader.class
        );

        if (Traders.size() == 0){
            System.out.println("Array of Traders is empty");
            return;
        }

        for (var item : Traders) {
            Method method = Trader.class.getDeclaredMethod("get_full_info");
            method.setAccessible(true);
            System.out.println(method.invoke(item));
        }
    }

}
