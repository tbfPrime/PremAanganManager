package premaanganmanager.configurable;

import premaanganmanager.configurable.scenes.LoginScene;
import premaanganmanager.configurable.scenes.ManagerScene;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.base.controller.UIControl;

public class SceneContainer extends UIControl{
    private Settings.screenTag activeScreenTag;
    private LoginScene loginScene;
    private ManagerScene managerScene;
    
    public SceneContainer(){
        setCSSDir(Settings.getCSSDir());
        setFXMLDir(Settings.getFXMLDir());
        setComponentCSSFilename(Settings.getComponentCSSFilename());
        setButtonFontSize(Settings.getDefaultButtonFontSize());
    }

    // public methods    
    @Override
    public void initializeStage(){
        displayScreen(Settings.screenTag.LOGIN_GUEST_ADMIN);
    }
    public Settings.screenTag getActiveScreenTag(){ return activeScreenTag; }
    public void createLoginScene(){
        Utility.log("SceneContainer | createLoginScene");
        loginScene = new LoginScene(this);
        setActiveScene(loginScene);
    }
    public void createManagerScene(){
        Utility.log("SceneContainer | createAppScene");
        managerScene = new ManagerScene(this);
        managerScene.launchDefaultScreen();
    }
    public boolean isUserDataSaved(){
        if(Settings.getFlagDataUnsaved()){
            if(LocalUtility.alertConfirmation(Labels.labelTag.ALERT_UNSAVED_DATA.getLabel())){ 
                if(getActiveScene().equals(managerScene)){ managerScene.flushScreenData(); }
                return true;
            } else{ Utility.log("SceneContainer | displayScreen | No action taken. Exiting."); return false; }
        }
        return true;
    }
    public boolean displayScreen(Settings.screenTag tag){
        if(tag.equals(activeScreenTag)){ Utility.log("SceneContainer | displayScreen | No Change in tag. Exiting."); return false; }
        if(!isUserDataSaved()){ return false; }
        getPropertyChangeSupport().firePropertyChange("screenTag", activeScreenTag, tag);
        activeScreenTag = tag;
        
        switch(tag){
            case LOGIN_GUEST_ADMIN: 
                if(getActiveScene() == null || !getActiveScene().equals(loginScene)){ createLoginScene(); }
                loginScene.setLoginGuestAdminScreen();
                break;
            case LOGIN_ADMIN: 
                if(getActiveScene() == null || !getActiveScene().equals(loginScene)){ createLoginScene(); }
                loginScene.setLoginAdminScreen();
                break;
            case HOME:
                managerScene.setHomeScreen();
                break;
            case ADD:
                managerScene.setAddScreen();
                break;
            case BROWSE: 
                managerScene.setBrowseScreen();
                break;
            case SEARCH: 
                managerScene.setSearchScreen();
                break;
            case SETTINGS: 
                managerScene.setSettingsScreen();
                break;
            case ADD_STUDENT:
                managerScene.setAddStudentScreen();
                break;
            case ADD_TEACHER:
                managerScene.setAddTeacherScreen();
                break;
//            case ADD_BATCH:
////                sceneContainer.screenContainer.manager.activeScreenContainer.setAddScreen();
//                break;
//            case ADD_CLASS:
////                sceneContainer.screenContainer.manager.activeScreenContainer.setAddScreen();
//                break;
//            case ADD_COURSE:
////                sceneContainer.screenContainer.manager.activeScreenContainer.setAddScreen();
//                break;
//            case ADD_SUBJECT:
////                sceneContainer.screenContainer.manager.activeScreenContainer.setAddScreen();
//                break;
//            case ADD_TIMETABLE:
////                sceneContainer.screenContainer.manager.activeScreenContainer.setAddScreen();
//                break;
//            case ADD_ATTENDANCE:
////                sceneContainer.screenContainer.manager.activeScreenContainer.setAddScreen();
//                break;
        }
        return true;
    }
}
