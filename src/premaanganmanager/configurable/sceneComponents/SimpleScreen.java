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
 * @author TBF
 */
public class SimpleScreen {
    private String cssFilename;
    
    public FXMLLoader getContent(){
        Utility.log("SimpleScreen | getContent");
        FXMLLoader content = new FXMLLoader(Utility.getPathFXML("SimpleScreen.fxml"));
        content.setController(this);
        return content;
    }
    public void initializeScreen(){
        Utility.log("SimpleScreen | initializeScreen");
    }
    
    /**
     * API to assign css filename for the screen
     * @param cssFilename 
     */
    public void setCSSFilename(String cssFilename){ this.cssFilename = cssFilename; }
    public String getCSSFilename(){ return cssFilename; }
}
