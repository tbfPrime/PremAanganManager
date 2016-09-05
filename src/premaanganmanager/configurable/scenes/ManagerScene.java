/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.scenes;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import premaanganmanager.base.constructs.BorderPaneScene;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Labels;
import premaanganmanager.configurable.SceneContainer;
import premaanganmanager.configurable.Settings;
import premaanganmanager.configurable.sceneComponents.*;

/**
 *
 * @author Trevor Fernandes
 */
public class ManagerScene extends BorderPaneScene{
    private SceneContainer sceneContainer;
    
    private CommonMenu commonMenu;
    private CommonHeader commonHeader;
    private CommonScreenFootControls commonScreenFootControls;
    private BorderPane screen;
    
    private SimpleScreen simpleScreen;
    private HomeScreen homeScreen;
    
    private AddScreen addScreen;
    private AddStudentScreen addStudentScreen;
    
    private BrowseScreen browseScreen;
    private SearchScreen searchScreen;
    private SettingsScreen settingsScreen;
    
    public ManagerScene(SceneContainer sceneContainer){
        this.sceneContainer = sceneContainer;
        createDefaultScene();
    }
    
    // public methods
    public SceneContainer getSceneContainer(){ return sceneContainer; }
    public CommonHeader getCommonHeader(){ return commonHeader; }
    public CommonMenu getCommonMenu(){ return commonMenu; }
    public CommonScreenFootControls getCommonScreenFootControls(){ return commonScreenFootControls; }
    public void launchDefaultScreen(){ commonMenu.launchDefault(); }
    public void setHomeScreen(){
        Utility.log("ManagerScene | setHomeScreen");
        homeScreen = new HomeScreen();
        setScreen(homeScreen);
    }
    public void setAddScreen(){
        Utility.log("ManagerScene | setAddScreen");
        addScreen = new AddScreen(this);
        setScreen(addScreen);
    }
    public void setBrowseScreen(){
        Utility.log("ManagerScene | setBrowseScreen");
        browseScreen = new BrowseScreen(this);
        setScreen(browseScreen);
    }
    public void setSearchScreen(){
        Utility.log("ManagerScene | setSearchScreen");
        searchScreen = new SearchScreen(this);
        setScreen(searchScreen);
    }
    public void setSettingsScreen(){
        Utility.log("ManagerScene | setSettingsScreen");
        settingsScreen = new SettingsScreen(this);
        setScreen(settingsScreen);
    }
    public void setAddStudentScreen(){
        Utility.log("ManagerScene | setAddStudentScreen");
        addStudentScreen = new AddStudentScreen(this);
        setScreen(addStudentScreen);
    }
    
    @Override
    public final void createDefaultScene(){
        Utility.log("ManagerScene | createDefaultScreen");
        setScene(Settings.getAppWidth(),Settings.getAppHeight());
        sceneContainer.loadScene(this);
    }
    @Override
    public void sceneReady(){
        Utility.log("ManagerScene | sceneReady");
        commonMenu = new CommonMenu(this);
        commonHeader = new CommonHeader(this);
        commonScreenFootControls = new CommonScreenFootControls();

        try{
            screen = new FXMLLoader(Utility.getPathFXML("BlankBorderPaneScene.fxml")).load();
        } catch(IOException e){
            Utility.errorLog("ManagerScene | sceneReady | IOException | Error: " + e);
        }        
    }
    @Override
    public final void updateScene(){
        Utility.log("Manager | updateScene | Tag: " + sceneContainer.getActiveScreenTag());
        commonHeader.setHeaderText(sceneContainer.getActiveScreenTag().getSubtitle());
        commonScreenFootControls.updateControls(sceneContainer.getActiveScreenTag());
        sceneContainer.setApplicationTitle(Labels.labelTag.APPLICATION_TITLE.getLabel() + " - " + sceneContainer.getActiveScreenTag().getTitle());
        simpleScreen.initializeScreen();
    }
    
    // private methods
    private void setScreen(SimpleScreen simpleScreen){
        Utility.log("ManagerScene | setScreen");
        this.simpleScreen = simpleScreen;
        
        this.simpleScreen.setCSSFilename(sceneContainer.getActiveScreenTag().getCSS());
        screen.getStylesheets().add(Utility.getPathCSS(this.simpleScreen.getCSSFilename()));
        
        loadBorderPaneUtility(positionTag.CENTER, screen, simpleScreen.getContent());
        loadBorderPaneUtility(positionTag.BOTTOM, screen, commonScreenFootControls.getContent());
        
        commonScreenFootControls.setTarget(simpleScreen);
        sceneContainer.loadSceneComponent(positionTag.CENTER, screen);
    }
}
