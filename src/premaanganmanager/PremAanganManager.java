// JavaFX test program
package premaanganmanager;

import premaanganmanager.configurable.MainController;

public class PremAanganManager {    
    public static void main(String args[]){
        System.out.println("PremAanganManager | main called.");
        
        new MainController().launchApplication(args);
    }
}