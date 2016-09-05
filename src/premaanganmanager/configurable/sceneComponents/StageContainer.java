// Sample java class to test inter-operability of java call files

package premaanganmanager.configurable.sceneComponents;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageContainer{
    private Stage primaryAppStage;
    public Stage activeStage;
    
    private enum stageTag{
        PRIMARY
    }
    
    public StageContainer(){
        createStage(stageTag.PRIMARY);
    }
    
    public void setScene(Scene scene){ primaryAppStage.setScene(scene); }
//    public Stage getPrimaryAppStage(){ return primaryAppStage; }
    public Stage getActiveStage(){ return activeStage; }

    // private methods
    private Stage createStage(stageTag tag){
        switch(tag){
            case PRIMARY: 
                if(primaryAppStage == null){ primaryAppStage = new Stage(); } 
                activeStage = primaryAppStage;
                break;
        }
        return activeStage;
    }
}
