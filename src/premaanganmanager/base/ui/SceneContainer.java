// Sample java class to test inter-operability of java call files

package premaanganmanager.base.ui;


import javafx.scene.Scene;
import premaanganmanager.base.controller.ui.UIControl;

public class SceneContainer{
    private UIControl o_UIControl;
    
    // list of all scene objects
    private Login o_loginScene;
    
    // Public function
    public SceneContainer(UIControl o_UIControl){
        this.o_UIControl = o_UIControl;
        o_loginScene = new Login(this.o_UIControl);
    }
    public Scene getLoginScene(){ return o_loginScene.getLoginScene(); }
}
