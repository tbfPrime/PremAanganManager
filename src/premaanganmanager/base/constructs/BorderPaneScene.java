/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.constructs;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.base.controller.UIControl;

/**
 *
 * @author Trevor Fernandes
 */
abstract public class BorderPaneScene extends SceneParent{
    
    private Scene activeScene, tempScene;
    private BorderPane root;
        
    public enum positionTag{
        TOP, LEFT, RIGHT, CENTER, BOTTOM
    }
    
    // Public functions
    public abstract void createDefaultScene();
    
    /**
     * Creates a blank BorderPane Scene
     * @param width
     * @param height
     */
    public void setScene(double width, double height){
        try{
            Utility.log("BorderPaneScene | setScene | creating blank Scene");
            root = new FXMLLoader(getBlankBorderPaneScene()).load();
            if(UIControl.debugMode){ 
                root.getStylesheets().add(getDebugCSSPath()); 
                root.setId("FillScene");
            }
            tempScene = new Scene(root, width, height);
        } catch(Exception e){
            Utility.errorLog("BorderPaneScene | setScene | Error: " + e);
            Logger.getLogger(BorderPaneScene.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Creates BorderPane Scene from provided @param
     * @param fxmlContent 
     * @param width 
     * @param height 
     */
    public void setScene(FXMLLoader fxmlContent, double width, double height){
        try{
            Utility.log("BorderPaneScene | setScene | creating new Scene from " + fxmlContent);
            root = fxmlContent.load();
            if(UIControl.debugMode){ 
                root.getStylesheets().add(getDebugCSSPath()); 
                root.setId("FillScene");
            }
            tempScene = new Scene(root, width, height);
        } catch(Exception e){
            Utility.errorLog("Screen | setScene | Error: " + e);
            Logger.getLogger(BorderPaneScene.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Overloaded setCenter to take FXMLLoaders as argument
     * @param fxmlContent
     */
    public void setCenter(FXMLLoader fxmlContent){
        try{
            Utility.log("BorderPaneScene | setCenter from fxml: " + fxmlContent);
            AnchorPane content = fxmlContent.load();
            if(UIControl.debugMode){ 
                content.getStylesheets().add(getDebugCSSPath()); 
                content.setId("FillCenter");
            }
            root.setCenter(content);
        } catch(Exception e){
            Utility.errorLog("BorderPaneScene | setCenter | Error: " + e);
            Logger.getLogger(BorderPaneScene.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Overloaded setCenter to take BorderPane as argument
     * @param content 
     */
    public void setCenter(BorderPane content){
        try{
            Utility.log("BorderPaneScene | setCenter from BorderPane: " + content);
            if(UIControl.debugMode){ 
                content.getStylesheets().add(getDebugCSSPath()); 
                content.setId("FillCenter");
            }
            root.setCenter(content);
        } catch(Exception e){
            Utility.errorLog("BorderPaneScene | setCenter from BorderPane | Error: " + e);
            Logger.getLogger(BorderPaneScene.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void setTop(FXMLLoader fxmlContent){
        try{
            Utility.log("BorderPaneScene | setTop from fxml: " + fxmlContent);
            AnchorPane content = fxmlContent.load();
            if(UIControl.debugMode){ 
                content.getStylesheets().add(getDebugCSSPath()); 
                content.setId("FillTop");
            }
            root.setTop(content);
        } catch(Exception e){
            Utility.errorLog("BorderPaneScene | setTop | Error: " + e);
            Logger.getLogger(BorderPaneScene.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void setLeft(FXMLLoader fxmlContent){
        try{
            Utility.log("BorderPaneScene | setLeft from fxml: " + fxmlContent);
            AnchorPane content = fxmlContent.load();
            if(UIControl.debugMode){ 
                content.getStylesheets().add(getDebugCSSPath()); 
                content.setId("FillLeft");
            }
            root.setLeft(content);
        } catch(Exception e){
            Utility.errorLog("BorderPaneScene | setLeft | Error: " + e);
            Logger.getLogger(BorderPaneScene.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Loads FXMLLoader in the specified position.
     * @param tag
     * @param fxmlContent 
     */
    public void setFXMLLoaderContent(positionTag tag, FXMLLoader fxmlContent){
        Utility.log("BorderPaneScene | setFXMLLoaderContent | content: " + fxmlContent);
        try{
            AnchorPane content = fxmlContent.load();
            if(UIControl.debugMode){ 
                content.getStylesheets().add(getDebugCSSPath()); 
                content.setId("FillLeft");
            }
            switch(tag){
                case TOP: root.setTop(content); break;
                case BOTTOM: root.setBottom(content); break;
                case LEFT: root.setLeft(content); break;
                case RIGHT: root.setRight(content); break;
                case CENTER: root.setCenter(content); break; 
            }
        } catch(Exception e){
            Utility.errorLog("BorderPaneScene | setFXMLLoaderContent | Error: " + e);
            Logger.getLogger(BorderPaneScene.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Sets a Parent or its subclass in the specified position.
     * @param tag
     * @param content 
     */
    public void setContent(positionTag tag, Parent content){
        Utility.log("BorderPaneScene | setContent | content: " + content);
        try{
            if(UIControl.debugMode){ content.getStylesheets().add(getDebugCSSPath()); }
            switch(tag){
                case TOP: if(UIControl.debugMode){ content.setId("FillTop"); } root.setTop(content); break;
                case BOTTOM: if(UIControl.debugMode){ content.setId("FillBottom"); } root.setBottom(content); break;
                case LEFT: if(UIControl.debugMode){ content.setId("FillLeft"); } root.setLeft(content); break;
                case RIGHT: if(UIControl.debugMode){ content.setId("FillRight"); } root.setRight(content); break;
                case CENTER: if(UIControl.debugMode){ content.setId("FillCenter"); } root.setCenter(content); break; 
            }
        } catch(Exception e){
            Utility.errorLog("BorderPaneScene | setContent | Error: " + e);
            Logger.getLogger(BorderPaneScene.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Utility method to load FXML content into specified BorderPane
     * @param tag
     * @param fxmlContent 
     * @param root 
     */
    public void loadBorderPaneUtility(positionTag tag, BorderPane root, FXMLLoader fxmlContent){
        Utility.log("BorderPaneScene | loadBorderPaneUtility | fxmlContent: " + fxmlContent);
        
        try{
            AnchorPane content = fxmlContent.load();
            if(UIControl.debugMode){ content.getStylesheets().add(getDebugCSSPath()); }
            switch(tag){
                case TOP: if(UIControl.debugMode){ content.setId("FillTop"); } root.setTop(content); break;
                case BOTTOM: if(UIControl.debugMode){ content.setId("FillBottom"); } root.setBottom(content); break;
                case LEFT: if(UIControl.debugMode){ content.setId("FillLeft"); } root.setLeft(content); break;
                case RIGHT: if(UIControl.debugMode){ content.setId("FillRight"); } root.setRight(content); break;
                case CENTER: if(UIControl.debugMode){ content.setId("FillCenter"); } root.setCenter(content); break; 
            }
        } catch(Exception e){
            Utility.errorLog("BorderPaneScene | loadBorderPaneUtility | Error: " + e);
            Logger.getLogger(BorderPaneScene.class.getName()).log(Level.SEVERE, null, e);
        }
    }   
    
    @Override
    public Scene getScene(){
        if(tempScene != null){ activeScene = tempScene; }
        tempScene = null;
        return activeScene;
    }
    
    @Override
    public void sceneReady(){
        Utility.log("BorderPaneScene | sceneReady");
    }
    
    @Override
    public void updateScene(){
        Utility.log("BorderPaneScene | updateScene");
    }
}
