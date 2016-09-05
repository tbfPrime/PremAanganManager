/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

This is a sample edit made to demo the commit function of git
 */
package premaanganmanager.configurable;

import javafx.application.Application;
import javafx.stage.Stage;
import premaanganmanager.base.controller.Utility;

public class PremAanganManager extends Application{
    
    @Override
    public void start(Stage applicationStage){
        Utility.log("PremAanganManager | start | applicationStage to be created and displayed.");
        new SceneContainer().start(applicationStage);
        
//        applicationStage = new UIControl().getStageContainer().getActiveStage(); //getApplicationStage();
//        applicationStage.show();
    }
    
    public static void launchApplication(String args[]){
        launch(args);
    }
    
    public static void main(String args[]){
        launchApplication(args);
    }
}
