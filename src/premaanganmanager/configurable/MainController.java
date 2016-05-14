/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import premaanganmanager.base.controller.ui.*;

public class MainController extends Application{
    private UIControl o_UIControl;
    private UIModel o_UIModel;
    
    // Contructor for MainController
    public MainController(){
        o_UIControl = new UIControl();
        o_UIModel = new UIModel();
    }
    
    // Public functions
    public UIControl getUIControlReference(){ return o_UIControl; }
    
    @Override
    public void start(Stage applicationStage){        
        applicationStage = o_UIControl.getApplicationStage();
        o_UIControl.setLoginScene();
        
        try {
            if(o_UIModel.isValueCorrect("Sunil")){ System.out.println("Name exists in DB."); }
            else{ System.out.println("Name does not exist in DB."); }
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        applicationStage.setTitle("Prem Aangan Manager 1.0");
        applicationStage.show();
    }
    
    public static void launchApplication(String args[]){
        launch(args);
    }
}
