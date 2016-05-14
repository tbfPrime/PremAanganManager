// Sample java class to test inter-operability of java call files

package premaanganmanager.base.ui;


import javafx.scene.Scene;
import premaanganmanager.base.controller.ui.UIControl;

public class SceneContainer{
    private UIControl o_UIControl;
    
    // list of all scene objects
    private Login o_loginScene;
    
    //Constructor
    public SceneContainer(UIControl o_UIControl){
        this.o_UIControl = o_UIControl;
        o_loginScene = new Login(this.o_UIControl);
    }
    
    // Public function
    public Scene setLoginGuestAdminScene(){ return o_loginScene.setLoginGuestAdminScene(); }
    public Scene setLoginAdminOnlyScene(){ return o_loginScene.setLoginAdminOnlyScene(); }
//    public void createLoginGuestAdminScene(){ o_loginScene.createLoginAdminOnlyScene(); }
}
