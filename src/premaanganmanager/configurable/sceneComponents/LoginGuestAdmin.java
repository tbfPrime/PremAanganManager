/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import premaanganmanager.base.components.CustomButton;
import premaanganmanager.base.constructs.BorderPaneScene;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Labels;
import premaanganmanager.configurable.AppSettings;
import premaanganmanager.configurable.scenes.LoginScene;

/**
 *
 * @author Trevor Fernandes
 */
public class LoginGuestAdmin{
    @FXML
    private CustomButton guestButton, adminButton;
    private final LoginScene loginScene;
    
    public LoginGuestAdmin(LoginScene loginScene){
        this.loginScene = loginScene;
        FXMLLoader content = new FXMLLoader(Utility.getPathFXML("LoginGuestAdmin.fxml"));
        content.setController(this);
        loginScene.getSceneContainer().loadSceneComponent(BorderPaneScene.positionTag.CENTER, content);
        setLabels();
    }
    
    // private methods
    @FXML
    private void guestAction(){
        loginScene.verifyGuestlogin();
    }
    @FXML
    private void adminAction(){
        loginScene.getSceneContainer().displayScreen(AppSettings.screenTag.LOGIN_ADMIN);
    }
    private void setLabels(){
        guestButton.setText(Labels.labelTag.GUEST.getLabel());
        adminButton.setText(Labels.labelTag.ADMIN.getLabel());
    }
}
