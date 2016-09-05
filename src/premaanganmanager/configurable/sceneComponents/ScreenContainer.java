/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import premaanganmanager.configurable.SceneContainer;
import premaanganmanager.configurable.scenes.LoginScene;

/**
 *
 * @author Trevor Fernandes
 */
public class ScreenContainer {
    public SceneContainer sceneContainer;
    
    public LoginScene loginScene;
    public ManagerScene11111 manager;
    
    // Constructor
    public ScreenContainer(SceneContainer sceneContainer){
        this.sceneContainer = sceneContainer;
    }
    
    public void initializeLoginScreen(){
        loginScene = new LoginScene(sceneContainer);
    }
    
    public void initializeAppScreen(){
//        manager = new ManagerScene11111(sceneContainer);
    }
}
