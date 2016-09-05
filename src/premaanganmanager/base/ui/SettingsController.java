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
import premaanganmanager.base.controller.Utility;

/**
 *
 * @author Trevor Fernandes
 */
public class SettingsController {
    public AnchorPane setSettings(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/Settings.fxml"));
            loader.setController(this);
            AnchorPane settingsBase = loader.load();
            return settingsBase;
//            loginScene.getStylesheets().add(P_Login.class.getResource("P_Login.css").toExternalForm());
        } catch (IOException e) {
            Utility.log("Error | AppContainer | setSettings | " + e);
            Logger.getLogger(P_Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }   
}
