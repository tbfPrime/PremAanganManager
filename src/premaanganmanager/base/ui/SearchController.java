/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Trevor Fernandes
 */
public class SearchController {
    public AnchorPane setSearch(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/Search.fxml"));
            loader.setController(this);
            AnchorPane searchBase = loader.load();
            return searchBase;
//            loginScene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setSearch | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }   
}
