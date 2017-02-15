/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import premaanganmanager.base.components.CustomToggleButton1;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.AppSettings;
import premaanganmanager.configurable.scenes.ManagerScene;

/**
 *
 * @author Trevor Fernandes
 */
public class CommonMenu {
    private final ManagerScene managerScene;
    private AppSettings.screenTag [] menuTag;
    private CustomToggleButton1 previousActiveMenuButton;
    @FXML
    private List<CustomToggleButton1> menuButton;
    
    public CommonMenu(ManagerScene managerScene){
        this.managerScene = managerScene;
        FXMLLoader content = new FXMLLoader(Utility.getPathFXML("CommonMenu.fxml"));
        content.setController(this);
        managerScene.setLeft(content);
        menuTag = AppSettings.getMenuTags();
        setGraphics();
        setLabels();
    }
    
    // public methods
    public void launchDefault(){
        Utility.log("CommomMenu | launchDefault | index: " + AppSettings.getDefaultMenuIndex());
        displayScreen(AppSettings.getDefaultMenuIndex());
    }
    
    // private methods
    @FXML
    private void menuButton1Action(){
        displayScreen(1);
    }
    @FXML
    private void menuButton2Action(){
        displayScreen(2);
    }
    @FXML
    private void menuButton3Action(){
        displayScreen(3);
    }
    @FXML
    private void menuButton4Action(){
        displayScreen(4);
    }
    @FXML
    private void menuButton5Action(){
        displayScreen(5);
    }
    private void setGraphics(){
        Path [] graphicPath = {
            Paths.get(AppSettings.getPNGDir(),AppSettings.getPNGMenuHome()),
            Paths.get(AppSettings.getPNGDir(),AppSettings.getPNGMenuAdd()),
            Paths.get(AppSettings.getPNGDir(),AppSettings.getPNGMenuBrowse()),
            Paths.get(AppSettings.getPNGDir(),AppSettings.getPNGMenuSearch()),
            Paths.get(AppSettings.getPNGDir(),AppSettings.getPNGMenuSettings())
        };
        double graphicTextGap = 0;
        double graphicOpacity = 0.7;

        int index = 0;
        for(CustomToggleButton1 button : menuButton){
            if(new File(graphicPath[index].toUri()).exists()){
                ImageView graphic = new ImageView(graphicPath[index++].toUri().toString());
                graphic.setOpacity(graphicOpacity);
                button.setGraphic(graphic);
                button.setContentDisplay(ContentDisplay.TOP);
                button.setGraphicTextGap(graphicTextGap);
            }            
        }
    }
    private void displayScreen(int index){
        for(CustomToggleButton1 button : menuButton){ button.setSelected(false); }
        index--;
        AppSettings.screenTag tag = menuTag[index];
        if(managerScene.getSceneContainer().displayScreen(tag)){ previousActiveMenuButton = menuButton.get(index); }
        previousActiveMenuButton.setSelected(true);
    }
    private void setLabels(){
        int index = 0;
        for(CustomToggleButton1 button : menuButton){ button.setText(menuTag[index++].getTitle()); }
    }
}
