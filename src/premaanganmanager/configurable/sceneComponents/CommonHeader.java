/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import premaanganmanager.base.components.CustomText;
import premaanganmanager.base.components.CustomToggleButton1;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Labels;
import premaanganmanager.configurable.Settings;
import premaanganmanager.configurable.scenes.ManagerScene;

/**
 *
 * @author Trevor Fernandes
 */
public class CommonHeader {
    // private member variables
    private final ManagerScene managerScene;
    
    // constructor
    public CommonHeader(ManagerScene managerScene){
        this.managerScene = managerScene;
        FXMLLoader content = new FXMLLoader(Utility.getPathFXML("CommonHeader.fxml"));
        content.setController(this);
        managerScene.setTop(content);
        setLabels();
        setStyling();
    }
    
    // public methods
    public void setHeaderText(String value){ headerText.setText(value); }
    public void initializeHeaderText(){ headerText.setText(managerScene.getSceneContainer().getActiveScreenTag().getSubtitle()); }
    
    // private methods
    // FXML members
    @FXML
    private CustomToggleButton1 helpButton;
    @FXML
    private CustomText headerText;
    @FXML
    private ComboBox logoutComboBox;
    @FXML
    private AnchorPane headerPane;
    @FXML
    private void helpAction(){
    }
    @FXML
    private void logoutAction(){
        if(logoutComboBox.getValue().toString().equalsIgnoreCase(Labels.labelTag.HEADER_SWITCH_ADMIN.getLabel())){
            managerScene.getSceneContainer().displayScreen(Settings.screenTag.LOGIN_ADMIN);
        } else if(logoutComboBox.getValue().toString().equalsIgnoreCase(Labels.labelTag.HEADER_LOGOUT.getLabel())){
            managerScene.getSceneContainer().displayScreen(Settings.screenTag.LOGIN_GUEST_ADMIN);
        }
    }
    
    private void setLabels(){
        helpButton.setText(Labels.labelTag.HEADER_HELP.getLabel());
        logoutComboBox.getItems().addAll(
                Labels.labelTag.HEADER_SWITCH_ADMIN.getLabel(),
                Labels.labelTag.HEADER_LOGOUT.getLabel());
        logoutComboBox.setPromptText(Settings.getActiveUserTag().getLabel());
    }
    
    private void setStyling(){
        headerPane.getStylesheets().add(Utility.getPathCSS("Common.css"));
        headerPane.getStyleClass().add("greyFill");
    }
}
