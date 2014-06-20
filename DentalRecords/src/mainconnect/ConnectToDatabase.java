/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainconnect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author admin
 */
public class ConnectToDatabase {
    
    String dbClass = "com.mysql.jdbc.Driver";
    String dbUrl = "jdbc:mysql://localhost:3306/mydb";
    String password = "p@ssword"; // CHANGE PASSWORD
    String name = "root";
    private String dbDriver;
    public Connection connection;
    
    public String getDbClass() {
        return dbClass;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    
    public Connection getConnection()
    {
        return connection;
    }
    
    public void disconnect()
    {
       try
       {
            connection.close();
       } 
       catch (Exception ex)
       {
            ex.printStackTrace();
       }
    }
    
    public void connect()
    {
        try
        {
            Class.forName(dbDriver).newInstance();
            connection = DriverManager.getConnection(dbUrl,name,password);
        }
        catch(Exception e)
        {
                e.printStackTrace();
        }
    }
}
