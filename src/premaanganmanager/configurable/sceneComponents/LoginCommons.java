/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import premaanganmanager.base.constructs.BorderPaneScene;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Settings;
import premaanganmanager.configurable.scenes.LoginScene;

/**
 *
 * @author Trevor Fernandes
 */
public class LoginCommons{

    // constructor
    public LoginCommons(LoginScene loginScene){
        FXMLLoader content = new FXMLLoader(Utility.getPathFXML("LoginCommons.fxml"));
        content.setController(this);
        loginScene.getSceneContainer().loadSceneComponent(BorderPaneScene.positionTag.TOP, content); //setTop(content);
        setStyling();
//        loginScene.getSceneContainer().getPropertyChangeSupport().addPropertyChangeListener(new PropertyChangeListener() {
//            @Override
//            public void propertyChange(PropertyChangeEvent evt) {
//                if("screenTag".equals(evt.getPropertyName())){ 
//                    Settings.screenTag newTag = (Settings.screenTag)evt.getNewValue();
//                    setLoginTitleText(newTag.getTitle());
//                    setLoginSubtitleText(newTag.getSubtitle());
//                }
//            }
//        });
    }

    // public methods
    public void setLoginTitleText(String value){ loginTitle.setText(value); }
    public void setLoginSubtitleText(String value){ loginSubtitle.setText(value); }
    
    // private methods
    // FXML members
    @FXML
    private AnchorPane loginCommonAnchorsPane;
    @FXML
    private Text loginTitle, loginSubtitle;
    
    private void setStyling(){
        loginCommonAnchorsPane.getStylesheets().add(Utility.getPathCSS("Common.css"));
        loginCommonAnchorsPane.getStyleClass().add("greyFill");
    }
}
