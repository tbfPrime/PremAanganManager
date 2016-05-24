/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.controller.ui;

import premaanganmanager.base.controller.background.*;
import java.sql.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
//import javax.
/**
 *
 * @author Trevor Fernandes
 */
public class UIModel {
    private SqliteConnector o_SqliteConnector;
    private Connection o_Connection;
    private EntityManagerFactory emf;
    private EntityManager em;
    
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
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        String query = "select * from users where username = ? and password = ?";
        try{
            preparedStatement = o_Connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            result = preparedStatement.executeQuery();
            
            if(result.next()){ System.out.println("Login successful | username: " + username); return true; }
            else{ System.out.println("Login unSuccessful | username: " + username); return false; }
        } catch(Exception e){
            System.err.println("UIModel | isLoginCorrect | Error: " + e);
            return false;
        } finally{
            preparedStatement.close();
            result.close();
        }
    }
    
    
    public List<ApplicationLabels> fetchAllLabels(){
        System.out.println("UIModel | fetchAllLabels");
        
        emf = Persistence.createEntityManagerFactory("PremAanganManagerPU");
        em = emf.createEntityManager();
        
        Query rq = em.createNamedQuery("ApplicationLabels.findAll");
        List<ApplicationLabels> result = rq.getResultList();
        return result;
    }
    
    public void closeDBObjects(){
        em.close();
        emf.close();
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
