/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import premaanganmanager.configurable.SceneContainer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import premaanganmanager.base.controller.UIControl;

/**
 *
 * @author Trevor Fernandes
 */
public class ScreenParent implements FootControlInterface {
    public UIControl uiControl;
    public SceneContainer sceneContainer;
    
    private Scene activeScene, tempScene;
    private BorderPane root;

    public ScreenParent(SceneContainer sceneContainer){
        this.sceneContainer = sceneContainer;
        uiControl = sceneContainer;
    }
    
    public void setCenter(FXMLLoader fxmlContent){
//        sceneContainer.activeScene.setCenter(fxmlContent);
    }
    
    public void setCenter(BorderPane content){
//        sceneContainer.activeScene.setCenter(content);
    }
    
    public void setTop(FXMLLoader fxmlContent){
//        sceneContainer.activeScene.setTop(fxmlContent);
    }
    
    public void setLeft(FXMLLoader fxmlContent){
//        sceneContainer.activeScene.setLeft(fxmlContent);
    }
    
    public UIControl getUIControl(){ return uiControl; }
}
