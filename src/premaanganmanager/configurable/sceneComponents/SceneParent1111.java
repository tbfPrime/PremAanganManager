/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.base.controller.UIControl;
import premaanganmanager.configurable.AppSettings;

/**
 *
 * @author Trevor Fernandes
 */
abstract public class SceneParent1111 {
    private Scene activeScene, tempScene;
    private BorderPane root;
    
//    UIControl uiControl;
//    
//    // Contructor
//    public SceneParent1111(UIControl uiControl){
//        this.uiControl = uiControl;
//    }
    
    // Public functions
    public void setScene(){
        try{
            Utility.log("SceneParent | setScene | creating blank Scene");
            root = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/design/fxml/BlankScene.fxml")).load();
            if(UIControl.debugMode){ 
                root.getStylesheets().add(SceneParent1111.class.getResource("Debug.css").toExternalForm()); 
                root.setId("FillScene");
            }
//            tempScene = new Scene(root, AppSettings.getAppWidth(), AppSettings.getAppHeight());
        } catch(Exception e){
            Utility.errorLog("Screen | setScene | Error: " + e);
            Logger.getLogger(SceneParent1111.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void setScene(FXMLLoader fxmlContent){
        try{
            Utility.log("SceneParent | setScene | creating new Scene from " + fxmlContent);
            root = fxmlContent.load();
            if(UIControl.debugMode){ 
                root.getStylesheets().add(SceneParent1111.class.getResource("Debug.css").toExternalForm()); 
                root.setId("FillScene");
            }
//            tempScene = new Scene(root, AppSettings.getAppWidth(), AppSettings.getAppHeight());
        } catch(Exception e){
            Utility.errorLog("Screen | setScene | Error: " + e);
            Logger.getLogger(SceneParent1111.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Overloaded setCenter to take FXMLLoaders as argument
     * @param fxmlContent
     */
    public void setCenter(FXMLLoader fxmlContent){
        try{
            Utility.log("SceneParent | setCenter from fxml: " + fxmlContent);
            AnchorPane content = fxmlContent.load();
            if(UIControl.debugMode){ 
                content.getStylesheets().add(SceneParent1111.class.getResource("Debug.css").toExternalForm()); 
                content.setId("FillCenter");
            }
            root.setCenter(content);
        } catch(Exception e){
            Utility.errorLog("SceneParent | setCenter | Error: " + e);
            Logger.getLogger(SceneParent1111.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Overloaded setCenter to take BorderPane as argument
     * @param content 
     */
    public void setCenter(BorderPane content){
        try{
            Utility.log("SceneParent | setCenter from BorderPane: " + content);
            if(UIControl.debugMode){ 
                content.getStylesheets().add(SceneParent1111.class.getResource("Debug.css").toExternalForm()); 
                content.setId("FillCenter");
            }
            root.setCenter(content);
        } catch(Exception e){
            Utility.errorLog("SceneParent | setCenter from BorderPane | Error: " + e);
            Logger.getLogger(SceneParent1111.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void setTop(FXMLLoader fxmlContent){
        try{
            Utility.log("SceneParent | setTop from fxml: " + fxmlContent);
            AnchorPane content = fxmlContent.load();
            if(UIControl.debugMode){ 
                content.getStylesheets().add(SceneParent1111.class.getResource("Debug.css").toExternalForm()); 
                content.setId("FillTop");
            }
            root.setTop(content);
        } catch(Exception e){
            Utility.errorLog("SceneParent | setTop | Error: " + e);
            Logger.getLogger(SceneParent1111.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void setLeft(FXMLLoader fxmlContent){
        try{
            Utility.log("SceneParent | setLeft from fxml: " + fxmlContent);
            AnchorPane content = fxmlContent.load();
            if(UIControl.debugMode){ 
                content.getStylesheets().add(SceneParent1111.class.getResource("Debug.css").toExternalForm()); 
                content.setId("FillLeft");
            }
            root.setLeft(content);
        } catch(Exception e){
            Utility.errorLog("SceneParent | setLeft | Error: " + e);
            Logger.getLogger(SceneParent1111.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    abstract public void createDefaultScene();
    
    public Scene getActiveScene(){
        if(tempScene != null){ activeScene = tempScene; }
        tempScene = null;
        return activeScene;
    }
}
