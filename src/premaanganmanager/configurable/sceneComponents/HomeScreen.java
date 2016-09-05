/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import javafx.fxml.FXMLLoader;
import premaanganmanager.base.controller.Utility;

/**
 *
 * @author Trevor Fernandes
 */
public class HomeScreen extends SimpleScreen implements FootControlInterface{

    // public methods
    @Override
    public FXMLLoader getContent(){
        FXMLLoader content = new FXMLLoader(Utility.getPathFXML("HomeScreen.fxml"));
        content.setController(this);
        return content;
    }
    
    @Override
    public void save(){
        Utility.log(">>>>>>>>>>>>>>>>>> Home Save");
    }
    @Override
    public void back(){
        Utility.log(">>>>>>>>>>>>>>>>>> Home back");
    }
}
