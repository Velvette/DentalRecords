/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mainconnect.ConnectToDatabase;

/**
 *
 * @author Jedd Gopez
 */

public class TableUtilities {
    
    public void getList(int rep,String searchText,JTable viewTable,int numberOfColumns,String defaultQuery,String searchQuery)
    {
        ConnectToDatabase connectDatabase = new ConnectToDatabase();
        DBUtilities tableUtils = new DBUtilities();
        
        String tempQuery = "";
        if(rep==0) {
            tempQuery = defaultQuery;
        }
        else if(rep==1) {
            tempQuery = defaultQuery + " " + searchQuery;
        }

	Statement statementQuery = null;       
	connectDatabase.connect();
	Connection connection = connectDatabase.getConnection();
                
	try {
            statementQuery = connection.createStatement();
        }
                
	catch (SQLException e) {
            e.printStackTrace();
        }
		
	ResultSet rs;
	try {
            rs = statementQuery.executeQuery(tempQuery);
            try {
                tableUtils.updateTableModelData((DefaultTableModel) viewTable.getModel(), rs, numberOfColumns);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        catch (SQLException e) {
            e.printStackTrace();
	}
        finally {
            connectDatabase.disconnect();
            try { 
                statementQuery.close();
            }
            catch(Exception e) {
                
            }
        }        
    }
    
}
