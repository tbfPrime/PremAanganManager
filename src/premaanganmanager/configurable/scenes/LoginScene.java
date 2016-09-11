/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.scenes;

import premaanganmanager.base.constructs.BorderPaneScene;
import premaanganmanager.base.controller.UIControl;
import premaanganmanager.base.controller.UIModel;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Labels;
import premaanganmanager.configurable.SceneContainer;
import premaanganmanager.configurable.Settings;
import premaanganmanager.configurable.sceneComponents.LoginAdmin;
import premaanganmanager.configurable.sceneComponents.LoginCommons;
import premaanganmanager.configurable.sceneComponents.LoginGuestAdmin;
import premaanganmanager.configurable.sceneComponents.SceneInterface;

/**
 *
 * @author Trevor Fernandes
 */
public class LoginScene extends BorderPaneScene implements SceneInterface{
    public final SceneInterface SCREENINTERFACE = this;

    private final SceneContainer sceneContainer;
    private LoginCommons loginCommons;
    private LoginGuestAdmin loginGuestAdmin;
    private LoginAdmin loginAdmin;
    
    public LoginScene(SceneContainer sceneContainer){
        this.sceneContainer = sceneContainer;
        createDefaultScene();
    }
    
    // public methods
    public SceneContainer getSceneContainer(){ return sceneContainer; }
    public void setLoginGuestAdminScreen(){ loginGuestAdmin = new LoginGuestAdmin(this); }
    public void setLoginAdminScreen(){ loginAdmin = new LoginAdmin(this); }
    public final void verifyGuestlogin(){
        if(new UIModel().isLoginCorrect(Settings.getGuestUsername(), Settings.getGuestPassword())){ 
            UIControl.setGuestMode(true);
            Settings.setActiveUserTag(Labels.labelTag.GUEST);
            sceneContainer.createManagerScene();
        }
    }
    public final void verifyAdminlogin(String userName, String password){
        if(new UIModel().isLoginCorrect(userName, password)){ 
            Settings.setActiveUserTag(loginAdmin.selectedAdmin.getLabelTag());
            sceneContainer.createManagerScene();
        }
    }

    @Override
    public final void back(){ sceneContainer.displayScreen(Settings.screenTag.LOGIN_GUEST_ADMIN); }
    @Override
    public final void createDefaultScene(){
        Utility.log("LoginScene | createDefaultScreen | creating Login scene");
        setScene(Settings.getAppWidth(),Settings.getAppHeight());
        sceneContainer.loadScene(this);
        Settings.setGuestMode(false);
    }
    @Override
    public final void sceneReady(){
        loginCommons = new LoginCommons(this);
    }
    @Override
    public final void updateScene(){
        loginCommons.setLoginTitleText(sceneContainer.getActiveScreenTag().getTitle());
        loginCommons.setLoginSubtitleText(sceneContainer.getActiveScreenTag().getSubtitle());
        sceneContainer.setApplicationTitle(Labels.labelTag.APPLICATION_TITLE.getLabel() + " - " + sceneContainer.getActiveScreenTag().getTitle());
    }
}
