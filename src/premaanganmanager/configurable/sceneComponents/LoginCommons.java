/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.scenes.LoginScene;

/**
 *
 * @author Trevor Fernandes
 */
public class LoginCommons{
    public LoginCommons(LoginScene loginScene){
        FXMLLoader content = new FXMLLoader(Utility.getPathFXML("LoginCommons.fxml"));
        content.setController(this);
        loginScene.setTop(content);
        setStyling();
    }

    // public methods
    public void setLoginTitleText(String value){ loginTitle.setText(value); }
    public void setLoginSubtitleText(String value){ loginSubtitle.setText(value); }
    
    // private methods
    @FXML
    private AnchorPane loginCommonAnchorsPane;
    @FXML
    private Text loginTitle, loginSubtitle;
    private void setStyling(){
        loginCommonAnchorsPane.getStylesheets().add(Utility.getPathCSS("Common.css"));
        loginCommonAnchorsPane.getStyleClass().add("greyFill");
    }
}
