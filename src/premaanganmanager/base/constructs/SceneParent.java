/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.constructs;

import java.net.URL;
import javafx.scene.Scene;
import premaanganmanager.base.controller.UIControl;

/**
 *
 * @author Trevor Fernandes
 */
public abstract class SceneParent {
    
    // public abstract methods
    public abstract Scene getScene();
    public abstract void sceneReady();
    public abstract void updateScene();
    
    // public methods
    public String getDebugCSSPath(){
        return SceneParent.class.getResource(UIControl.getCSSDir() + "Debug.css").toExternalForm();
    }
    
    public URL getBlankBorderPaneScene(){
        return SceneParent.class.getResource(UIControl.getFXMLDir() + "BlankBorderPaneScene.fxml");
    }
}
