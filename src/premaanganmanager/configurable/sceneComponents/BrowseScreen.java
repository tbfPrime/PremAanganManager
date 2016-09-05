/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import javafx.fxml.FXMLLoader;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.scenes.ManagerScene;

/**
 *
 * @author TBF
 */
public class BrowseScreen extends SimpleScreen implements FootControlInterface {
    private ManagerScene managerScene;
    
    public BrowseScreen(ManagerScene managerScene){
        this.managerScene = managerScene;
    }
    
    // public methods
    @Override
    public FXMLLoader getContent(){
        FXMLLoader content = new FXMLLoader(Utility.getPathFXML("BrowseScreen.fxml"));
        content.setController(this);
        return content;
    }
}
