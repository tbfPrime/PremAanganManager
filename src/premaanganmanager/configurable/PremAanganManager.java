/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

This is a sample edit made to demo the commit function of git
 */
package premaanganmanager.configurable;

import javafx.application.Application;
import javafx.stage.Stage;
import premaanganmanager.base.controller.ui.*;

public class PremAanganManager extends Application{
    
    @Override
    public void start(Stage applicationStage){
        applicationStage = new UIControl(this).getApplicationStage();
        applicationStage.show();
    }
    
    public static void launchApplication(String args[]){
        launch(args);
    }
    
    public static void main(String args[]){
        launchApplication(args);
    }
}
