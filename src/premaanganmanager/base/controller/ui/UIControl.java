/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.controller.ui;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
    
    public enum alertType{ INFO, WARNING, WARNING_FIELD_IS_EMPTY, ERROR, CONFIRMATION, CONFIRMATION_FIELD_IS_EMPTY }
    
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
        stageContainer.currentStage.setTitle(settings.labels.getLabel(Labels.labelTag.APPLICATION_TITLE));
        setLoginGuestAdminScene();
    }
    
    public void logoutToAdminScreen(){
        System.out.println("UIControl | logoutToAdminScreen()");
        closeDBObjects();
        setLoginAdminOnlyScene();
    }
    
    public void logoutToGuestAdminScreen(){
        System.out.println("UIControl | logoutToGuestAdminScreen");
        closeDBObjects();
        setLoginGuestAdminScene();
    }
    
    public void setLoginGuestAdminScene(){
        stageContainer.setApplicationScene(sceneContainer.login.setLoginGuestAdminScene()); 
    }
    
    public void setLoginAdminOnlyScene(){
        stageContainer.setApplicationScene(sceneContainer.login.setLoginAdminOnlyScene());
    }
    
    public void setAppContainer(){
        createDBObjects();
        stageContainer.setApplicationScene(sceneContainer.appContainer.setAppContainer());
        sceneContainer.appContainer.displayScreen(AppContainer.screenTag.HOME);
    }
    
    public void closeDBObjects(){
        uiModel.closeDBObjects();
    }
    
    public void createDBObjects(){
        uiModel.createDBObjects();
    }
    
    public boolean alert(alertType type, String message){
        Alert alert;
        
        switch (type) {
            case INFO:
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle(settings.labels.getLabel(Labels.labelTag.ALERT_INFO));
                alert.setContentText(message);
                break;
            case WARNING:
                alert = new Alert(AlertType.WARNING);
                alert.setTitle(settings.labels.getLabel(Labels.labelTag.ALERT_WARNING));
                alert.setContentText(message);
                break;
            case WARNING_FIELD_IS_EMPTY:
                alert = new Alert(AlertType.WARNING);
                alert.setTitle(settings.labels.getLabel(Labels.labelTag.ALERT_WARNING));
                alert.setContentText(message + " " + settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_IS_EMPTY));
                break;
            case ERROR:
                alert = new Alert(AlertType.ERROR);
                alert.setTitle(settings.labels.getLabel(Labels.labelTag.ALERT_ERROR));
                alert.setContentText(message);
                break;
            case CONFIRMATION_FIELD_IS_EMPTY:
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle(settings.labels.getLabel(Labels.labelTag.ALERT_CONFIRMATION));
                alert.setContentText(settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_CONFIRM_FIELD_EMPTY));
                break;
            default:
                alert = new Alert(AlertType.NONE);
                alert.setContentText(message);
                break;
        }
        
        alert.setHeaderText(null);
        
        
        Optional<ButtonType> result = alert.showAndWait();
        
        return (result.get() == ButtonType.OK);
    }
}
