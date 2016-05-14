// JavaFX test program
package premaanganmanager;

import premaanganmanager.configurable.MainController;

public class PremAanganManager {
//    @Override
//    public void start(Stage stage1){
//               
//        GridPane gridpane1 = new GridPane();
//        
//        StageContainer stg1 = new StageContainer();
//        SceneContainer sc1 = new SceneContainer();
//        
//        Scene scene1 = new Scene(gridpane1, 800, 600);
//        
//        stg1.printDemo();
//        sc1.printDemo();
//       
//        stage1.setTitle("Prem Aangan Manager 1.0");
//        stage1.setScene(scene1);
//        stage1.show();
//    }
    
    public static void main(String args[]){
        System.out.println("PremAanganManager | main called.");
        
        new MainController().launchApplication(args);
    }
}