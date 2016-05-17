/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.controller.ui;

import premaanganmanager.base.controller.background.SqliteConnector;
import java.sql.*;
/**
 *
 * @author Trevor Fernandes
 */
public class UIModel {
    private SqliteConnector o_SqliteConnector;
    private Connection o_Connection;
    
    /**
     * Constructor to UIModel initializes connection to sqlite database.
     * @return 
     */
    public UIModel(){
        connectToSqliteDB();
    }
    
    /**
     * isDbConnected checks if the database is connected.
     * Returns true if successful and false otherwise.
     * @return 
     */
    public boolean isDbConnected(){
        try{
            return !o_Connection.isClosed();
        } catch(Exception e){
            System.out.println("UIModel | isDbConnected | " + e);
            return false;
        }
    }
    
    public boolean isLoginCorrect(String username, String password) throws SQLException{
        System.out.println("UIModel | isLoginCorrect | username: " + username + " | password: " + password);
        PreparedStatement o_PreparedStatement = null;
        ResultSet o_ResultSet = null;
        String query = "select * from users where username = ? and password = ?";
        try{
            o_PreparedStatement = o_Connection.prepareStatement(query);
            o_PreparedStatement.setString(1, username);
            o_PreparedStatement.setString(2, password);
            
            o_ResultSet = o_PreparedStatement.executeQuery();
            
            if(o_ResultSet.next()){ return true; }
            else{ return false; }
        } catch(Exception e){
            return false;
        } finally{
            o_PreparedStatement.close();
            o_ResultSet.close();
        }
    }
    
    public boolean isValueCorrect(String value) throws SQLException{
        PreparedStatement o_PreparedStatement = null;
        ResultSet o_ResultSet = null;
        String query = "select * from Student where firstname = ?";
        try{
            o_PreparedStatement = o_Connection.prepareStatement(query);
            o_PreparedStatement.setString(1, value);
            
            o_ResultSet = o_PreparedStatement.executeQuery();
            
            if(o_ResultSet.next()){ return true; }
            else{ return false; }
        } catch(Exception e){
            return false;
        } finally{
            o_PreparedStatement.close();
            o_ResultSet.close();
        }
    }
    
    /**
     * connectToSqliteDB creates a connection to sqlite database.
     * @return 
     */
    private void connectToSqliteDB(){
        o_Connection = o_SqliteConnector.connector();        
        if(o_Connection == null){ System.exit(1);}
        else{ System.out.println("Connection Successful!"); }
    }
}
