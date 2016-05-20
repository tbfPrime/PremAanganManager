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
import javafx.scene.Parent;
import javafx.scene.Scene;
import premaanganmanager.base.controller.ui.UIControl;

/**
 *
 * @author Trevor Fernandes
 */
public class AppContainer {
    private UIControl uiControl;
    private Scene appContainerScene;
    
    // Contructor with params
    public AppContainer(UIControl uiControl){
        this.uiControl = uiControl;
    }
    
    public Scene setAppContainer(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/AppContainer.fxml"));
            loader.setController(this);
            Parent root = loader.load();
            appContainerScene = new Scene(root);
            return appContainerScene;
//            loginScene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setLoginGuestAdminScene | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
