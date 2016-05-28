/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Trevor Fernandes
 */
public class AddController {
    
    private AppContainer appContainer;
   
    @FXML
    private Button addToDBButton;
    
    @FXML
    private void addToDBAction(){
        System.out.println("AddController | addToDBAction");
        appContainer.uiControl.uiModel.pushToDummyTable();
    }
    
    public AddController(AppContainer appContainer){
        this.appContainer = appContainer;
    }
    
    public AnchorPane setAdd(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/Add.fxml"));
            loader.setController(this);
            AnchorPane addBase = loader.load();
            return addBase;
//            loginScene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setAdd | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
