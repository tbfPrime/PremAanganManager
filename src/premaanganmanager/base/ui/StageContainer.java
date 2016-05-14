// Sample java class to test inter-operability of java call files

package premaanganmanager.base.ui;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageContainer{
    private Stage applicationStage = new Stage();
    
    public void setApplicationScene(Scene scene){ applicationStage.setScene(scene); }
    
    public Stage getApplicationStage(){ return applicationStage; }
}
