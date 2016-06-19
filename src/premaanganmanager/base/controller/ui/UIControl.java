/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.controller.ui;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ToggleButton;
import javafx.stage.FileChooser;
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
    
    public enum alertType{ INFO, WARNING, WARNING_CUSTOM_MSG, WARNING_FIELD_IS_EMPTY, ERROR, ERROR_SAVE, CONFIRMATION, CONFIRMATION_FIELD_IS_EMPTY }
    
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
            case ERROR_SAVE:
                alert = new Alert(AlertType.ERROR);
                alert.setTitle(settings.labels.getLabel(Labels.labelTag.ALERT_ERROR));
                alert.setContentText(settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_ERROR_SAVE));
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
        
        DialogPane d = alert.getDialogPane();
        d.getStylesheets().add(getClass().getResource("Alerts.css").toExternalForm());
        d.getStyleClass().add("alertClass");
        alert.setHeaderText(null);
        
        try{
            Optional<ButtonType> result = alert.showAndWait();
            return (result.get() == ButtonType.OK);
        } catch(Exception e){
            return false;
        }
    }
    
    public void configureFileChooserForImages(FileChooser fileChooser){
        fileChooser.setTitle("Boooooooo");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images","*.*"),
                new FileChooser.ExtensionFilter("JPG","*.jpg"),
                new FileChooser.ExtensionFilter("PNG","*.png")
        );
    }
    
    public boolean isNumeric(String value){
        try{
            System.out.println("UIControl | isNumeric | String is a proper Number: " + Double.parseDouble(value));
            return true;
        } catch(NumberFormatException e){
            System.err.println("UIControl | isNumeric | Error: " + e);
            return false;
        }
    }
    
    public Integer convertStringToInteger(String value){
        try{
            System.out.println("UIControl | convertStringToInteger | value: " + Integer.parseInt(value));
            return Integer.parseInt(value);
        } catch(NumberFormatException e){
            System.err.println("UIControl | convertStringToInteger | Error: " + e);
            return null;
        }        
    }
    
    public long convertStringToLong(String value){
        try{
            System.out.println("UIControl | convertStringToLong | value: " + Long.parseLong(value));
            return Long.parseLong(value);
        } catch(NumberFormatException e){
            System.err.println("UIControl | convertStringToLong | Error: " + e);
            return -1;
        }        
    }
    
    public void setButtonStyle(Button button){
        button.getStylesheets().add(SceneContainer.class.getResource("Common.css").toExternalForm());
        
        button.setId("ButtonNormal");
        
        button.setOnMousePressed((event) -> { button.setId("ButtonPressed"); });
        button.setOnMouseEntered((event) -> { button.setId("ButtonHover"); });
        button.setOnMouseExited((event) -> { button.setId("ButtonNormal"); });
        button.setOnMouseReleased((event) -> { button.setId("ButtonNormal"); });
        button.setOnMouseClicked((event) -> { button.setId("ButtonNormal"); });
    }
    
    public void setToggleButtonStyle(ToggleButton button){
        button.getStylesheets().add(SceneContainer.class.getResource("Common.css").toExternalForm());
        
        button.setId("ButtonNormal");
        
        button.setOnMousePressed((event) -> { button.setId("ButtonPressed"); });
        button.setOnMouseReleased((event) -> { button.setId("ButtonSelected"); });
        button.setOnMouseClicked((event) -> { button.setId("ButtonSelected"); });
        button.setOnMouseEntered((event) -> { 
            if(button.isSelected()){ button.setId("ButtonSelectedHover"); }
            else{ button.setId("ButtonHover"); }
        });
        button.setOnMouseExited((event) -> { 
            if(button.isSelected()){ button.setId("ButtonSelected"); }
            else{ button.setId("ButtonNormal"); }
        });
    }
}
