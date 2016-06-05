/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable;

import java.util.List;
import premaanganmanager.base.controller.background.*;
import premaanganmanager.base.controller.ui.UIControl;

/**
 *
 * @author Trevor Fernandes
 */
public class Settings {
    public Labels labels;
    public String photosDir;
    public String placeHoldersDir;
    public String tempPhotoFileName;
    public String placeHolderStudentPhoto;
    private UIControl uiControl;
    
    /**
     *
     * Initializes Application wide variables.
     */   
    public Settings(UIControl uiControl){
        this.uiControl = uiControl;
        initializeApplicationVariables();
    }
    
    public void initializeApplicationVariables(){
        System.out.println("Settings | initializeApplicationVariables");
        uiControl.createDBObjects();
        
        labels = new Labels();
        setDefaultValuesToAllLabels();
        
        photosDir = "photos";
        placeHoldersDir = "resources\\placeholders";
        
        placeHolderStudentPhoto = "addStudentPhotoPlaceHolder.jpg";
        tempPhotoFileName = "tempPhoto";
                
        uiControl.closeDBObjects();
    }
    
    public final void setDefaultValuesToAllLabels(){
        List<ApplicationLabels> labels = uiControl.uiModel.fetchAllLabels();
        
        for(ApplicationLabels tempLabels : labels){
            this.labels.setLabel(Labels.labelTag.valueOf(tempLabels.getTag()),tempLabels.getValue());
        }
    }
}
