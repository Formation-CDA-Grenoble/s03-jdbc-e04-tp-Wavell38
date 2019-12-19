package app;

import java.lang.reflect.ParameterizedType;
import java.sql.*;

abstract class DefaultManager <Manager extends DefaultManager <Manager>> {
    
    public Object[] findAll() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<Manager> persistentClass = (Class<Manager>)
            ((ParameterizedType)getClass().getGenericSuperclass())
            .getActualTypeArguments()[0];
        String className = getClass().getName();
        ResultSet resultSet = DBManager.sendQuery(
            "SELECT * FROM `"+ className +"`"
        );
        Object[] results = new Object[resultSet.getRow()];
        int i = 0;
        while(resultSet.next()) {
            results[i] = Class.forName(className).getFields().getClass();
            i++;
        }
        return results;
    }

    // Load the Class. Must use fully qualified name here!
Class clazz = Class.forName("com.crossedstreams.thingy.Foo");

// I need an array as follows to describe the signature
Class[] parameters = new Class[] {String.class, String.class};

// Now I can get a reference to the right constructor
Constructor constructor = clazz.getConstructor(parameters);

// And I can use that Constructor to instantiate the class
Object o = constructor.newInstance(new Object[] {"one", "two"});

// To prove it's really there...
System.out.println(o);

    public static Object find(int id) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = getClass().getName();
        ResultSet resultSet = DBManager.sendQuery(
            "SELECT * FROM `"+ className +"` WHERE `id` = "+id+""
        );
        Object result = null;
        while(resultSet.next()) {
            result = Class.forName(className).newInstance();
        }
        return result;
    }

    public void delete(int id) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = getClass().getName();
        DBManager.sendQuery(
            "DELETE FROM `"+className+"` WHERE `id` = "+id+""
        );
    }

    public void deleteAll() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = getClass().getName();
        DBManager.sendQuery(
            "DELETE FROM `"+className+"`"
        );
    }
}