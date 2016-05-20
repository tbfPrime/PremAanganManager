// Sample java class to test inter-operability of java call files

package premaanganmanager.base.ui;

import javafx.scene.Scene;
import javafx.stage.Stage;
import premaanganmanager.base.controller.ui.UIControl;

public class StageContainer{
    private UIControl uiControl;
    private Stage applicationStage;
    
    public Stage currentStage;
    
    public StageContainer(UIControl uiControl){
        this.uiControl = uiControl;
        applicationStage = new Stage();
        currentStage = applicationStage;
    }
    
    public void setApplicationScene(Scene scene){ applicationStage.setScene(scene); }
    
    public Stage getApplicationStage(){ return applicationStage; }
}
