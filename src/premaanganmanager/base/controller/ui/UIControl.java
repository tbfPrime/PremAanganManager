/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.controller.ui;

import javafx.stage.Stage;
import premaanganmanager.base.ui.SceneContainer;
import premaanganmanager.base.ui.StageContainer;
import premaanganmanager.configurable.*;
/**
 *
 * @author Trevor Fernandes
 */
public class UIControl {
    private SceneContainer o_SceneContainer;
    private StageContainer o_StageContainer;
    private Labels o_Label;
    
    // Public functions
    public UIControl(){
        o_Label = new Labels();
        initializeApplicationVariables();

        o_SceneContainer = new SceneContainer(this);
        o_StageContainer = new StageContainer();
    }
    
    public Stage getApplicationStage(){ return o_StageContainer.getApplicationStage(); }
    public Labels getLabelsReference(){ return o_Label; }
    
    public void initializeApplicationVariables(){
        System.out.println("Initializing Application wide varaibles.");
        o_Label.setDefaultValuesToAllLabels();
    }
    
    public void setLoginScene(){
        try{
            if(o_Label == null){ System.out.println("Labels not initialized."); }
            else{ o_StageContainer.setApplicationScene(o_SceneContainer.getLoginScene()); }
        } catch(Exception e){
            System.out.println("Labels not initialized | " + e);
        }
    }
}
