/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.base.controller.UIControl;

/**
 *
 * @author Trevor Fernandes
 */
public class ActiveScreenContainer {
    // public member variables
    public CommonScreenFootControls commonScreenFootControls;
    
    // private member variables
    private final ManagerScene11111 manager;
    private BorderPane root;
    
    private HomeScreen homeScreen;
    private AddScreen addScreen;
    
    // constructor
    public ActiveScreenContainer(ManagerScene11111 manager){
        try{
            root = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/design/fxml/BlankScene.fxml")).load();
//            manager.setCenter(root);
        } catch(IOException e){
            Utility.errorLog("ActiveScreenContainer | IOException | Error: " + e);
        }
        
        this.manager = manager;
        commonScreenFootControls = new CommonScreenFootControls();
        setBottom(commonScreenFootControls.getContent());
    }
    
    // public methods
    public void setHomeScreen(){
//        homeScreen = new HomeScreen(this);
//        setCenter(homeScreen.getContent());
//        manager.commonHeader.initializeHeaderText();
////        commonScreenFootControls.updateControls(UIControl.screenTag.HOME);
//        commonScreenFootControls.setTarget(homeScreen);
    }
    
    public void setAddScreen(){
//        addScreen = new AddScreen(this);
        setCenter(addScreen.getContent());
        commonScreenFootControls.setTarget(addScreen);
    }
    
    public ManagerScene11111 getManager(){ return manager; }
    
    // private methods
    private void setCenter(FXMLLoader fxmlContent){
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
            Logger.getLogger(ActiveScreenContainer.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void setBottom(FXMLLoader fxmlContent){
        try{
            Utility.log("SceneParent | setBottom from fxml: " + fxmlContent);
            AnchorPane content = fxmlContent.load();
            if(UIControl.debugMode){ 
                content.getStylesheets().add(SceneParent1111.class.getResource("Debug.css").toExternalForm()); 
                content.setId("FillBottom");
            }
            root.setBottom(content);
        } catch(Exception e){
            Utility.errorLog("SceneParent | setBottom | Error: " + e);
            Logger.getLogger(ActiveScreenContainer.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
