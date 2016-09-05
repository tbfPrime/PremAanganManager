/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import premaanganmanager.base.components.CustomButton;
import premaanganmanager.base.components.CustomToggleButton1;
import premaanganmanager.base.constructs.BorderPaneScene;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Labels;
import premaanganmanager.configurable.Settings;
import premaanganmanager.configurable.scenes.LoginScene;

/**
 *
 * @author Trevor Fernandes
 */
public class LoginAdmin {
    public adminTag selectedAdmin;

    @FXML
    private CustomToggleButton1 admin1Button, admin2Button, admin3Button;
    @FXML
    private CustomButton backButton, loginButton;
    @FXML
    private PasswordField passwordField;
    private final LoginScene loginScene;

    public enum adminTag{ 
        ADMIN1(Settings.getAdmin1Username(), Labels.labelTag.ADMIN1), 
        ADMIN2(Settings.getAdmin2Username(), Labels.labelTag.ADMIN2), 
        ADMIN3(Settings.getAdmin3Username(), Labels.labelTag.ADMIN3);
        
        private final String USERNAME;
        private final String LABEL;
        private final Labels.labelTag LABEL_TAG;
        
        adminTag(String username, Labels.labelTag label){ 
            USERNAME = username;
            LABEL_TAG = label;
            LABEL = label.getLabel();
        }
        
        public String getUsername(){ return USERNAME; }
        public String getLabel(){ return LABEL; }
        public Labels.labelTag getLabelTag(){ return LABEL_TAG; }
    }
    
    public LoginAdmin(LoginScene loginScene){
        this.loginScene = loginScene;
        FXMLLoader content = new FXMLLoader(Utility.getPathFXML("LoginAdmin.fxml"));
        content.setController(this);
        loginScene.getSceneContainer().loadSceneComponent(BorderPaneScene.positionTag.CENTER, content);
        setLabels();
    }
    
    // private methods
    @FXML
    private void admin1Action(){
        selectAdminButton(adminTag.ADMIN1);
    }
    @FXML
    private void admin2Action(){
        selectAdminButton(adminTag.ADMIN2);
    }
    @FXML
    private void admin3Action(){
        selectAdminButton(adminTag.ADMIN3);
    }
    @FXML
    private void backAction(){
        loginScene.SCREENINTERFACE.back();
    }
    @FXML
    private void loginAction(){
        loginScene.verifyAdminlogin(selectedAdmin.getUsername(), passwordField.getText());
    }
    private void setLabels(){
        admin1Button.setText(adminTag.ADMIN1.getLabel());
        admin2Button.setText(adminTag.ADMIN2.getLabel());
        admin3Button.setText(adminTag.ADMIN3.getLabel());
        
        passwordField.setPromptText(Labels.labelTag.PASSWORD_PROMPT.getLabel());
        
        backButton.setText(Labels.labelTag.BACK.getLabel());
        loginButton.setText(Labels.labelTag.LOGIN.getLabel());   
    }
    private void selectAdminButton(LoginAdmin.adminTag tag){
        admin1Button.setSelected(false);
        admin2Button.setSelected(false);
        admin3Button.setSelected(false);
        selectedAdmin = tag;
        
        switch(tag){
            case ADMIN1: 
                admin1Button.setSelected(true);
                passwordField.setPromptText(Labels.labelTag.PASSWORD_PROMPT_FOR.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel() + " " + admin1Button.getText());
                break;
            case ADMIN2: 
                admin2Button.setSelected(true);
                passwordField.setPromptText(Labels.labelTag.PASSWORD_PROMPT_FOR.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel() + " " + admin2Button.getText());
                break;
            case ADMIN3: 
                admin3Button.setSelected(true);
                passwordField.setPromptText(Labels.labelTag.PASSWORD_PROMPT_FOR.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel() + " " + admin3Button.getText());
                break;
        }
    }
}
