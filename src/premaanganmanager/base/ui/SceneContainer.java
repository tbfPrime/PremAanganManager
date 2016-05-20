// Sample java class to test inter-operability of java call files

package premaanganmanager.base.ui;


import javafx.scene.Scene;
import premaanganmanager.base.controller.ui.UIControl;

public class SceneContainer{
    private UIControl uiControl;
    
    // list of all scene objects
    public Login login;
    public AppContainer appContainer;
    
    //Constructor
    public SceneContainer(UIControl o_UIControl){
        this.uiControl = o_UIControl;
        
        login = new Login(this.uiControl);
        appContainer = new AppContainer(this.uiControl);
    }
}
