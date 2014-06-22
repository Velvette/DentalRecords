/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainconnect;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ProcessQuery {
    
    public void accessInputDatabase(String query)
    {
        ConnectToDatabase getParameters = new ConnectToDatabase();
        Connection con = null;
        
        String dbUrl = getParameters.getDbUrl();
        String name = getParameters.getName();
        String password = getParameters.getPassword();
        String dbDriver = getParameters.getDbDriver();
        
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection (dbUrl, name, password);
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Database Update: Success", "Updating database", JOptionPane.INFORMATION_MESSAGE);
        }
        
        catch(ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Database not updated", "Error", JOptionPane.ERROR_MESSAGE); 
        }

        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Database not updated", "Error", JOptionPane.ERROR_MESSAGE); 
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProcessQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
