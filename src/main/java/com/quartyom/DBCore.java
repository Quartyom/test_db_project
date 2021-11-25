package com.quartyom;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

public class DBCore {
    public String url, username, password;

    public <T> ArrayList dbRead(String query, Class <T> t_class) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        int columns = resultSet.getMetaData().getColumnCount();

        var resultList = new ArrayList<T>();

        while(resultSet.next()){

            T obj = t_class.newInstance();

            for (int i = 1; i <= columns; i++){
                String field_name = resultSet.getMetaData().getColumnName(i);
                Object field_value = resultSet.getObject(i);;

                Field field = t_class.getField(field_name);
                //field.setAccessible(true);
                field.set(obj, field_value);
            }

            resultList.add(obj);
        }

        return resultList;
    }

    public ResultSet getResultSet(String query) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public ArrayList<Integer> dbGetId(String query) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = getResultSet(query);

        var result = new ArrayList<Integer>();
        while(resultSet.next()){

            result.add(resultSet.getInt("id"));
        }
        return result;
    }

    public int dbWrite(String query) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

        // Для Insert, Update, Delete
        int result = statement.executeUpdate(query);

        return result;
    }

    public <T> T serialize(ResultSet res, Class <T> t_class){
        return null;
    }
}
