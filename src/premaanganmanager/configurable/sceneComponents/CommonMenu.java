/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import premaanganmanager.base.components.CustomToggleButton1;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Settings;
import premaanganmanager.configurable.scenes.ManagerScene;

/**
 *
 * @author Trevor Fernandes
 */
public class CommonMenu {
    private final ManagerScene managerScene;
    private Settings.screenTag [] menuTag;
    @FXML
    private CustomToggleButton1 menuButton1, menuButton3, menuButton2, menuButton4, menuButton5;
    
    public CommonMenu(ManagerScene managerScene){
        this.managerScene = managerScene;
        FXMLLoader content = new FXMLLoader(Utility.getPathFXML("CommonMenu.fxml"));
        content.setController(this);
        managerScene.setLeft(content);
        menuTag = Settings.getMenuTags();
        setGraphics();
        setLabels();
    }
    
    // public methods
    public void launchDefault(){
        Utility.log("CommomMenu | launchDefault");
        displayScreen(menuTag[0]);
    }
    
    // private methods
    @FXML
    private void menuButton1Action(){
        displayScreen(menuTag[0]);
    }
    @FXML
    private void menuButton2Action(){
        displayScreen(menuTag[1]);
    }
    @FXML
    private void menuButton3Action(){
        displayScreen(menuTag[2]);
    }
    @FXML
    private void menuButton4Action(){
        displayScreen(menuTag[3]);
    }
    @FXML
    private void menuButton5Action(){
        displayScreen(menuTag[4]);
    }
    
    private void setGraphics(){
        Path graphicPath;
        double graphicTextGap = 0;
        double graphicOpacity = 0.7;
        
        graphicPath = Paths.get(Settings.getPNGDir(),Settings.getPNGMenuHome());
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            menuButton1.setGraphic(graphic);
            menuButton1.setContentDisplay(ContentDisplay.TOP);
            menuButton1.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(Settings.getPNGDir(),Settings.getPNGMenuAdd());
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            menuButton2.setGraphic(graphic);
            menuButton2.setContentDisplay(ContentDisplay.TOP);
            menuButton2.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(Settings.getPNGDir(),Settings.getPNGMenuBrowse());
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            menuButton3.setGraphic(graphic);
            menuButton3.setContentDisplay(ContentDisplay.TOP);
            menuButton3.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(Settings.getPNGDir(),Settings.getPNGMenuSearch());
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            menuButton4.setGraphic(graphic);
            menuButton4.setContentDisplay(ContentDisplay.TOP);
            menuButton4.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(Settings.getPNGDir(),Settings.getPNGMenuSettings());
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            menuButton5.setGraphic(graphic);
            menuButton5.setContentDisplay(ContentDisplay.TOP);
            menuButton5.setGraphicTextGap(graphicTextGap);
        }
    }
    
    private void displayScreen(Settings.screenTag tag){
        menuButton1.setSelected(false);
        menuButton3.setSelected(false);
        menuButton2.setSelected(false);
        menuButton4.setSelected(false);
        menuButton5.setSelected(false);
        
        managerScene.getSceneContainer().displayScreen(tag);
        
        if(tag.equals(menuTag[0])){ menuButton1.setSelected(true); }
        else if(tag.equals(menuTag[1])){ menuButton2.setSelected(true); }
        else if(tag.equals(menuTag[2])){ menuButton3.setSelected(true); }
        else if(tag.equals(menuTag[3])){ menuButton4.setSelected(true); }
        else if(tag.equals(menuTag[4])){ menuButton5.setSelected(true); }
    }
    private void setLabels(){
        menuButton1.setText(menuTag[0].getTitle());
        menuButton2.setText(menuTag[1].getTitle());
        menuButton3.setText(menuTag[2].getTitle());
        menuButton4.setText(menuTag[3].getTitle());
        menuButton5.setText(menuTag[4].getTitle());
    }
}
