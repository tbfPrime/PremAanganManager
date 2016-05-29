/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.controller.background;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Trevor Fernandes
 */
public class SqliteConnector {
    
    public static Connection connector(){
        try{
            java.lang.Class.forName("org.sqlite.JDBC");
            Connection dbCon = DriverManager.getConnection("jdbc:sqlite:PremAanganManager.sqlite");
            return dbCon;
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
