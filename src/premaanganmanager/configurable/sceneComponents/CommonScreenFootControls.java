/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import java.util.Arrays;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import premaanganmanager.base.components.CustomButton;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Settings;

/**
 *
 * @author Trevor Fernandes
 */
public class CommonScreenFootControls {
    //private members
    private FootControlInterface footControlInterface;
    private controlsTag tagList [];
    private enum controlsTag{
        PRINT, SAVE, BACK
    }

    // public methods
    public FXMLLoader getContent(){
        FXMLLoader content = new FXMLLoader(Utility.getPathFXML("CommonScreenFootControls.fxml"));
        content.setController(this);
        return content;
    }
    
    public void updateControls(Settings.screenTag tag){
        switch(tag){
            case HOME: 
                tagList = new controlsTag[]{controlsTag.BACK};
                break;
            case ADD: 
                tagList = new controlsTag[]{};
                break;
            case BROWSE:
                tagList = new controlsTag[]{controlsTag.PRINT};
                break;
            case SEARCH:
                tagList = new controlsTag[]{controlsTag.BACK,controlsTag.SAVE};
                break;
            case SETTINGS:
                tagList = new controlsTag[]{controlsTag.BACK,controlsTag.SAVE,controlsTag.PRINT};
                break;
            case ADD_STUDENT:
                tagList = new controlsTag[]{controlsTag.BACK,controlsTag.SAVE};
                break;
        }
        updateControlList();
    }
    
    public void setTarget(Object o){
        footControlInterface = (FootControlInterface)o;
    }
    
    // FXML members
    @FXML
    private CustomButton print, save, back;
    @FXML
    private AnchorPane footControlAnchorPane;
    @FXML
    private void backAction(){
        footControlInterface.back();
    }
    @FXML
    private void saveAction(){
        footControlInterface.save();
    }
    @FXML
    private void printAction(){
        footControlInterface.print();
    }
    
    private void updateControlList(){
        hideAllControls();
        
        if(tagList.length > 0){
            footControlAnchorPane.setVisible(true);
            footControlAnchorPane.setManaged(true);
        }
        
        Arrays.stream(tagList).forEach((tag)->{
            switch(tag){
                case PRINT: print.setVisible(true); print.setManaged(true); break;
                case SAVE: save.setVisible(true); save.setManaged(true); break;
                case BACK: back.setVisible(true); back.setManaged(true); break;
            }
        });
    }
    
    private void hideAllControls(){
        print.setVisible(false);
        save.setVisible(false);
        back.setVisible(false);
        
        print.setManaged(false);
        save.setManaged(false);
        back.setManaged(false);
        
        footControlAnchorPane.setVisible(false);
        footControlAnchorPane.setManaged(false);
    }
}
