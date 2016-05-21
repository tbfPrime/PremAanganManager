/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.controller.ui;

import javafx.stage.Stage;
import premaanganmanager.base.ui.*;
import premaanganmanager.configurable.*;
/**
 *
 * @author Trevor Fernandes
 */
public class UIControl {
    public UIModel uiModel;
    public SceneContainer sceneContainer;
    public StageContainer stageContainer;
    public Settings settings;
    
    // Constructor
    public UIControl(PremAanganManager o_MainController){
        uiModel = new UIModel();
        settings = new Settings(this);
        sceneContainer = new SceneContainer(this);
        stageContainer = new StageContainer(this);
        
        initializeApplicationStage();
    }    
    
    // Public functions
    public Stage getApplicationStage(){ return stageContainer.getApplicationStage(); }
    
    public void initializeApplicationStage(){
        stageContainer.currentStage.setTitle(settings.labels.getLabel(Labels.labelTag.APPLICATIONTITLE));
        setLoginGuestAdminScene();
    }
    
    public void setLoginGuestAdminScene(){
        stageContainer.setApplicationScene(sceneContainer.login.setLoginGuestAdminScene()); 
    }
    
    public void setLoginAdminOnlyScene(){
        stageContainer.setApplicationScene(sceneContainer.login.setLoginAdminOnlyScene());
    }
    
    public void setAppContainer(){
        stageContainer.setApplicationScene(sceneContainer.appContainer.setAppContainer());
        sceneContainer.appContainer.displayScreen(AppContainer.screenTag.HOME);
    }
}
