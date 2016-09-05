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
import premaanganmanager.configurable.Labels;

/**
 *
 * @author Trevor Fernandes
 */
public class HomeController {
    private final AppContainer appContainer;
    
    // Constructor
    public HomeController(AppContainer appContainer){
        this.appContainer = appContainer;
    }
    
    // Private Functions.
    public AnchorPane setHome(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/Home.fxml"));
            loader.setController(this);
            AnchorPane homeBase = loader.load();
            setHomeScreenLabels();
            return homeBase;
        } catch (IOException e) {
            Utility.log("Error | AppContainer | setHome | " + e);
            Logger.getLogger(P_Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    // Private Functions.
    private void setHomeScreenLabels(){
        appContainer.setHeaderText(appContainer.uiControl.p_settings.labels.getLabel(Labels.labelTag.HEADER_WELCOME_TITLE));
    }
}
