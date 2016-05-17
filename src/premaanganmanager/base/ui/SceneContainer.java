// Sample java class to test inter-operability of java call files

package premaanganmanager.base.ui;


import javafx.scene.Scene;
import premaanganmanager.base.controller.ui.UIControl;

public class SceneContainer{
    private UIControl o_UIControl;
    
    // list of all scene objects
    public Login login;
    
    //Constructor
    public SceneContainer(UIControl o_UIControl){
        this.o_UIControl = o_UIControl;
        login = new Login(this.o_UIControl);
    }
}
