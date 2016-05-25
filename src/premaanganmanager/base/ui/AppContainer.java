/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import premaanganmanager.base.controller.ui.UIControl;
import premaanganmanager.configurable.Labels;

/**
 *
 * @author Trevor Fernandes & Eugenia Bernate Thomas
 */
public class AppContainer {
    public UIControl uiControl;
    public HomeController homeController;
    public BrowseController browseController;
    
    
    private Scene appContainerScene;
    private BorderPane root;
    
    @FXML
    private Button menuHomeButton, menuBrowseButton, menuAddButton, menuSearchButton, menuSettingsButton;
    
    @FXML
    private Text headerText;
    
    @FXML
    private ComboBox logoutComboBox;
    
    // Contructor with params
    public AppContainer(UIControl uiControl){
        this.uiControl = uiControl;
        
        homeController = new HomeController();
        browseController = new BrowseController();
    }
    
    public enum screenTag{
        HOME, BROWSE, ADD, SEARCH, SETTINGS
    }
    
    @FXML
    public void homeButtonAction(){
        System.out.println("AppContainer | homeButtonAction");
        displayScreen(screenTag.HOME);
    }
    
    @FXML
    public void browseButtonAction(){
        System.out.println("AppContainer | browseButtonAction");
        displayScreen(screenTag.BROWSE);
    }

    @FXML
    public void logoutComboBoxButtonAction(){
        System.out.println("AppContainer | logoutComboBoxButtonAction | Value: " + logoutComboBox.getValue().toString());
        if(logoutComboBox.getValue().toString().equalsIgnoreCase(uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_SWITCH_ADMIN))){
            uiControl.setLoginAdminOnlyScene();
        } else if(logoutComboBox.getValue().toString().equalsIgnoreCase(uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_LOGOUT))){
            uiControl.setLoginGuestAdminScene();
        }
    }
    
    @FXML
    public void addButtonAction(){
        System.out.println("AppContainer | addButtonAction");
//        displayScreen(screenTag.ADD);
    }
    
    @FXML
    public void searchButtonAction(){
        System.out.println("AppContainer | searchButtonAction");
//        displayScreen(screenTag.SEARCH);
    }
    
    @FXML
    public void settingsButtonAction(){
        System.out.println("AppContainer | settingsButtonAction");
//        displayScreen(screenTag.SETTINGS);
    }
    
    // Main Screen Display wrapper
    public void displayScreen(screenTag tag){
        switch(tag){
            case HOME: setHomeScreen(); break;
            case BROWSE: setBrowseScreen(); break;
        }
    }
    
    public Scene setAppContainer(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/AppContainer.fxml"));
            loader.setController(this);
            root = loader.load();
            appContainerScene = new Scene(root);
            setLogOutComboBox();
            setHomeLabels();
            return appContainerScene;
//            loginScene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setLoginGuestAdminScene | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    //private functions
    private void setHomeLabels(){
        menuHomeButton.setText(uiControl.settings.labels.getLabel(Labels.labelTag.MENU_HOME));
        menuBrowseButton.setText(uiControl.settings.labels.getLabel(Labels.labelTag.MENU_BROWSE));
        menuAddButton.setText(uiControl.settings.labels.getLabel(Labels.labelTag.MENU_ADD));
        menuSearchButton.setText(uiControl.settings.labels.getLabel(Labels.labelTag.MENU_SEARCH));
        menuSettingsButton.setText(uiControl.settings.labels.getLabel(Labels.labelTag.MENU_SETTINGS));
        headerText.setText(uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_TITLE));
        logoutComboBox.setPromptText(uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_LOGOUT));
    }
    
    private void setLogOutComboBox(){
        logoutComboBox.getItems().addAll(
                uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_SWITCH_ADMIN),
                uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_LOGOUT));
    }
    
    private void setHomeScreen(){
        root.setCenter(homeController.setHome());
    }
    
    private void setBrowseScreen(){
        root.setCenter(browseController.setBrowseHome());
    }
}
