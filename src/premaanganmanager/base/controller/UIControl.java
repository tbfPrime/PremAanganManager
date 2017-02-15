/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.controller;

import premaanganmanager.configurable.sceneComponents.StageContainer;
import premaanganmanager.configurable.SceneContainer;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import premaanganmanager.base.constructs.BorderPaneScene;
import premaanganmanager.base.constructs.SceneParent;
import premaanganmanager.configurable.*;
/**
 *
 * @author Trevor Fernandes
 */
public abstract class UIControl implements PropertyChangeListener{

    // public member variables
    public static boolean debugMode = false;
    
    // private member variables
    private Stage applicationStage;
    private SceneParent activeScene;
    private static String dirCSS;
    private static String dirFXML;
    private static String componentCSSFilename;
    private static int buttonFontSize;
    private static boolean guestMode;
    
    // public abstract methods
    public abstract void initializeStage();
    
    // public methods
    public static void setCSSDir(String path){ dirCSS = path; }
    public static String getCSSDir(){ return dirCSS; }
    public static void setFXMLDir(String path){ dirFXML = path; }
    public static String getFXMLDir(){ return dirFXML; }
    public static void setComponentCSSFilename(String filename){ componentCSSFilename = filename; }
    public static String getComponentCssFilename(){ return componentCSSFilename; }
    public static void setButtonFontSize(int fontSize){ buttonFontSize = fontSize; }
    public static int getButtonFontSize(){ return buttonFontSize; }
    public void setActiveScene(SceneParent scene){ activeScene = scene; }
    public SceneParent getActiveScene(){ return activeScene; }
    public Stage getActiveStage(){ return applicationStage; }
    public void setApplicationTitle(String value){ applicationStage.setTitle(value); }
    public void start(Stage applicationStage){
        this.applicationStage = applicationStage;
        initializeStage();
        applicationStage.show();
    }
    
    /**
     * Loads a new scene into @applicationStage
     * 
     * @param scene 
     */
    public void loadScene(SceneParent scene){
        activeScene = scene;
        applicationStage.setScene(activeScene.getScene());
        activeScene.sceneReady();
    }

    /**
     * Loads component into BorderPaneScene at the @position 
     * 
     * @param position
     * @param content 
     */
    public void loadSceneComponent(BorderPaneScene.positionTag position, FXMLLoader content){
        Utility.log("UIControl | loadSceneComponent | position: " + position + " | FXMLLoader content: " + content);
        try{
            BorderPaneScene scene = (BorderPaneScene)activeScene;
            switch(position){
                case TOP: scene.setTop(content); break;
                case LEFT: scene.setLeft(content); break;
                case CENTER: scene.setCenter(content); break;
            }
            scene.updateScene();
        } catch(Exception e){
            Utility.errorLog("UIControl | loadSceneComponent | position: " + position + " | FXMLLoader content: " + content + " | Error: " + e);
            Logger.getLogger(UIControl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Loads component into BorderPaneScene at the @position 
     * 
     * @param position
     * @param content 
     */
    public void loadSceneComponent(BorderPaneScene.positionTag position, BorderPane content){
        Utility.log("UIControl | loadSceneComponent | position: " + position + " | BorderPane content: " + content);
        try{
            BorderPaneScene scene = (BorderPaneScene)activeScene;
            scene.setContent(BorderPaneScene.positionTag.CENTER, content);
            scene.updateScene();
        } catch(Exception e){
            Utility.errorLog("UIControl | loadSceneComponent | position: " + position + " | BorderPane content: " + content + " | Error: " + e);
            Logger.getLogger(UIControl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    // public member variables
    public UIModel uiModel;
    public SceneContainer sceneContainer;
    public StageContainer stageContainer;
    public AppSettings p_settings;

    public screenTag p_activeScreenTag;
    public String activeUserLabel;
    public static final boolean LOG = true;
    
    public enum alertTag{ 
        INFO, WARNING, WARNING_CUSTOM_MSG, WARNING_FIELD_IS_EMPTY, ERROR, ERROR_SAVE, CONFIRMATION, CONFIRMATION_FIELD_IS_EMPTY 
    }
  
    public enum screenTag {
        LOGIN_GUEST_ADMIN, LOGIN_ADMIN, 
        HOME, 
        ADD, ADD_STUDENT, ADD_TEACHER, ADD_BATCH, ADD_CLASS, ADD_COURSE, ADD_SUBJECT, ADD_TIMETABLE, ADD_ATTENDANCE,
        BROWSE,
        SEARCH,
        SETTINGS;
        
        private String title;
        private String subtitle;
        
        public void setTitle(String title){ this.title = title; }
        public void setSubtitle(String subtitle){ this.subtitle = subtitle; }
        
        public String getTitle(){ return title; }
        public String getSubtitle(){ return subtitle; }
    }
    
    // protected member variables
    
    
    // constructor
//    public UIControl(){
//        uiModel = new UIModel();
//        p_settings = new AppSettings();
//        sceneContainer = new SceneContainer();
//        stageContainer = new StageContainer();
//        
//        setProperties();
//        initializeApplicationStage();
//    }    
    
    // overrided public methods
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Utility.log("UIControl | propertyChange | property name: " + evt.getPropertyName());
    }
    
//    public Stage getApplicationStage(){ return stageContainer.getPrimaryAppStage(); }
    
    // public methods
    public final void initializeApplicationStage(){
        stageContainer.activeStage.setTitle(p_settings.labels.getLabel(Labels.labelTag.APPLICATION_TITLE));
        displayScreen(screenTag.LOGIN_GUEST_ADMIN);
    }
    
    public PropertyChangeSupport getPropertyChangeSupport(){ return propertyChangeSupport; }
    public SceneContainer getSceneContainer(){ return sceneContainer; }
    public StageContainer getStageContainer(){ return stageContainer; }
    
    public void logoutToAdminScreen(){
        Utility.log("UIControl | logoutToAdminScreen()");
//        closeDBObjects();
        setLoginAdminOnlyScene();
    }
    
    public void logoutToGuestAdminScreen(){
        Utility.log("UIControl | logoutToGuestAdminScreen");
//        closeDBObjects();
        setLoginGuestAdminScene();
    }
    
    public void setLoginGuestAdminScene(){
//        stageContainer.setScene(sceneContainer.login.setLoginGuestAdminScene()); 
    }
    
    public void setLoginAdminOnlyScene(){
//        stageContainer.setScene(sceneContainer.login.setLoginAdminOnlyScene());
    }
    
    public void setAppContainer(){
//        createDBObjects();
//        stageContainer.setScene(sceneContainer.appContainer.setAppContainer());
//        sceneContainer.appContainer.displayScreen(AppContainer.screenTag.HOME);
    }
    
    public void displayScreen(screenTag tag){
        if(tag.equals(p_activeScreenTag)){ Utility.log("UIControl | displayScreen | No Change in tag. Exiting."); return; }
        propertyChangeSupport.firePropertyChange("screenTag", p_activeScreenTag, tag);
        p_activeScreenTag = tag;
        
        switch(tag){
            case LOGIN_GUEST_ADMIN: 
//                if(!sceneContainer.sceneEquals(sceneContainer.loginScene)){ sceneContainer.createLoginScene(); loadActiveScene(); }
//                sceneContainer.screenContainer.loginScene.setLoginGuestAdminScreen();
                break;
            case LOGIN_ADMIN: 
//                if(!sceneContainer.sceneEquals(sceneContainer.loginScene)){ sceneContainer.createLoginScene(); loadActiveScene(); }
//                sceneContainer.screenContainer.loginScene.setLoginAdminScreen();
                break;
//            case HOME:
//                if(!sceneContainer.sceneEquals(sceneContainer.managerScene)){ sceneContainer.createManagerScene(); loadActiveScene(); }
//                sceneContainer.screenContainer.manager.activeScreenContainer.setHomeScreen();
//                break;
            case ADD:
//                sceneContainer.screenContainer.manager.activeScreenContainer.setAddScreen();
                break;
            case ADD_STUDENT:
//                sceneContainer.screenContainer.manager.activeScreenContainer.setAddScreen();
                break;
            case ADD_TEACHER:
//                sceneContainer.screenContainer.manager.activeScreenContainer.setAddScreen();
                break;
            case ADD_BATCH:
//                sceneContainer.screenContainer.manager.activeScreenContainer.setAddScreen();
                break;
            case ADD_CLASS:
//                sceneContainer.screenContainer.manager.activeScreenContainer.setAddScreen();
                break;
            case ADD_COURSE:
//                sceneContainer.screenContainer.manager.activeScreenContainer.setAddScreen();
                break;
            case ADD_SUBJECT:
//                sceneContainer.screenContainer.manager.activeScreenContainer.setAddScreen();
                break;
            case ADD_TIMETABLE:
//                sceneContainer.screenContainer.manager.activeScreenContainer.setAddScreen();
                break;
            case ADD_ATTENDANCE:
//                sceneContainer.screenContainer.manager.activeScreenContainer.setAddScreen();
                break;
            case BROWSE: break;
            case SEARCH: break;
            case SETTINGS: break;
        }
    }
    
    public void loadActiveScene(){
        Utility.log("UIControl | setActiveScene");
//        stageContainer.setScene(sceneContainer.activeScene.getActiveScene());
    }
    
//    public void closeDBObjects(){
//        uiModel.closeDBObjects();
//    }
//    
//    public void createDBObjects(){
//        uiModel.createDBObjects();
//    }
    
    public boolean alert(alertTag type, String message){
        Alert alert;
        
        switch (type) {
            case INFO:
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle(p_settings.labels.getLabel(Labels.labelTag.ALERT_INFO));
                alert.setContentText(message);
                break;
            case WARNING:
                alert = new Alert(AlertType.WARNING);
                alert.setTitle(p_settings.labels.getLabel(Labels.labelTag.ALERT_WARNING));
                alert.setContentText(message);
                break;
            case WARNING_FIELD_IS_EMPTY:
                alert = new Alert(AlertType.WARNING);
                alert.setTitle(p_settings.labels.getLabel(Labels.labelTag.ALERT_WARNING));
                alert.setContentText(message + " " + p_settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_IS_EMPTY));
                break;
            case ERROR:
                alert = new Alert(AlertType.ERROR);
                alert.setTitle(p_settings.labels.getLabel(Labels.labelTag.ALERT_ERROR));
                alert.setContentText(message);
                break;
            case ERROR_SAVE:
                alert = new Alert(AlertType.ERROR);
                alert.setTitle(p_settings.labels.getLabel(Labels.labelTag.ALERT_ERROR));
                alert.setContentText(p_settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_ERROR_SAVE));
                break;
            case CONFIRMATION_FIELD_IS_EMPTY:
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle(p_settings.labels.getLabel(Labels.labelTag.ALERT_CONFIRMATION));
                alert.setContentText(p_settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_CONFIRM_FIELD_EMPTY));
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
            Utility.log("UIControl | isNumeric | String is a proper Number: " + Double.parseDouble(value));
            return true;
        } catch(NumberFormatException e){
            Utility.errorLog("UIControl | isNumeric | Error: " + e);
            return false;
        }
    }
    
    public Integer convertStringToInteger(String value){
        try{
            Utility.log("UIControl | convertStringToInteger | value: " + Integer.parseInt(value));
            return Integer.parseInt(value);
        } catch(NumberFormatException e){
            Utility.errorLog("UIControl | convertStringToInteger | Error: " + e);
            return null;
        }        
    }
    
    public long convertStringToLong(String value){
        try{
            Utility.log("UIControl | convertStringToLong | value: " + Long.parseLong(value));
            return Long.parseLong(value);
        } catch(NumberFormatException e){
            Utility.errorLog("UIControl | convertStringToLong | Error: " + e);
            return -1;
        }        
    }
    
    public int getRandomNumber(int min, int max){
        int random = min + (int)(Math.random() * (max - min));
        return random;
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
    
    public void setHelpStyle(Pane pane, VBox bg, HBox header){
        pane.getStylesheets().add(SceneContainer.class.getResource("Common.css").toExternalForm());
        bg.getStylesheets().add(SceneContainer.class.getResource("Common.css").toExternalForm());
        header.getStylesheets().add(SceneContainer.class.getResource("Common.css").toExternalForm());
        
        pane.setId("Help");
        header.setId("HelpHeader");
        
        switch(getRandomNumber(1, 10)){
            case 1: bg.setId("HelpBg1"); break;
            case 2: bg.setId("HelpBg2"); break;
            case 3: bg.setId("HelpBg3"); break;
            case 4: bg.setId("HelpBg4"); break;
            case 5: bg.setId("HelpBg5"); break;
            case 6: bg.setId("HelpBg6"); break;
            case 7: bg.setId("HelpBg7"); break;
            case 8: bg.setId("HelpBg8"); break;
            case 9: bg.setId("HelpBg9"); break;
            case 10: bg.setId("HelpBg10"); break;
        }
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
    
    public static void setGuestMode(boolean value){ guestMode = value; }
    public static boolean isGuestMode(){ return guestMode; }
    
    // private methods
    private void setProperties(){
        propertyChangeSupport.addPropertyChangeListener(this);
    }
}
