package gymms.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class javaconnect {

    public static Connection connectdb() { 
        Connection con = null;
        String currentdir = System.getProperty("user.dir");
        try {
            con = DriverManager.getConnection("jdbc:derby:"+currentdir+"\\Gymms", "IS2560", "IS2560");
            System.out.println("Connect successfully ! ");
            return con;
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return null;
    }/*
    public static Connection connectdb() { 
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Gymms", "IS2560", "IS2560");
            System.out.println("Connect successfully ! ");
            return con;
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return null;
    }
    */
}
