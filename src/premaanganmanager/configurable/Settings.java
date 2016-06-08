/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable;

import java.util.List;
import javafx.stage.Screen;
import premaanganmanager.base.controller.background.*;
import premaanganmanager.base.controller.ui.UIControl;

/**
 *
 * @author Trevor Fernandes
 */
public class Settings {
    public Labels labels;
    
    public double appWidth;
    public double appHeight;
    
    public String photosDir;
    public String placeHoldersDir;
    public String pngDir;
    
    public String tempPhotoFileName;
    public String placeHolderStudentPhoto;
    
    public String png_addStudent;
    public String png_addTeacher;
    public String png_addSubject;
    public String png_addAttendance;
    public String png_addCourse;
    public String png_addBatch;
    public String png_addClass;
    public String png_addTimetable;
    
    public String png_menuHome;
    public String png_menuAdd;
    public String png_menuBrowse;
    public String png_menuSearch;
    public String png_menuSettings;
    
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
        
        appWidth = Screen.getPrimary().getVisualBounds().getWidth() * 0.6;
        appHeight = Screen.getPrimary().getVisualBounds().getHeight() * 0.7;
        
        photosDir = "photos";
        placeHoldersDir = "resources\\placeholders";
        pngDir = "resources\\png";
        
        placeHolderStudentPhoto = "addStudentPhotoPlaceHolder.jpg";
        tempPhotoFileName = "tempPhoto";
        
        png_addStudent = "AddStudent.png";
        png_addTeacher = "AddTeacher.png";
        png_addSubject = "AddSubject.png";
        png_addAttendance = "AddAttendance.png";
        png_addCourse = "AddCourse.png";
        png_addBatch = "AddBatch.png";
        png_addClass = "AddClass.png";
        png_addTimetable = "AddTimetable.png";
        
        png_menuHome = "MenuHome.png";
        png_menuAdd = "MenuAdd.png";
        png_menuBrowse = "MenuBrowse.png";
        png_menuSearch = "MenuSearch.png";
        png_menuSettings = "MenuSettings.png";
        
        System.out.println("Settings | initializeApplicationVariables | appWidth: " + appWidth + " | appHeight: " + appHeight);
                
        uiControl.closeDBObjects();
    }
    
    public double getAppWidth(){ return appWidth; }
    
    public double getAppHeight(){ return appHeight; }
    
    public final void setDefaultValuesToAllLabels(){
        List<ApplicationLabels> labels = uiControl.uiModel.fetchAllLabels();
        
        for(ApplicationLabels tempLabels : labels){
            this.labels.setLabel(Labels.labelTag.valueOf(tempLabels.getTag()),tempLabels.getValue());
        }
    }
}
