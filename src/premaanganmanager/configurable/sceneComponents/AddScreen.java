/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import premaanganmanager.base.components.CustomButton;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Settings;
import premaanganmanager.configurable.scenes.ManagerScene;

/**
 *
 * @author Trevor Fernandes
 */
public class AddScreen extends SimpleScreen implements FootControlInterface{
    protected String photoFileExtension = "";
    protected ManagerScene managerScene;
    
    public AddScreen(ManagerScene managerScene){
        this.managerScene = managerScene;
    }
    
    // public methods
    @Override
    public FXMLLoader getContent(){
        FXMLLoader content = new FXMLLoader(Utility.getPathFXML("AddScreen.fxml"));
        content.setController(this);
        return content;
    }
    @Override
    public void initializeScreen(){
        setGraphics();
        setLabels();
    }
    
    // protected methods
    protected Path getPhotoPath(){
        Utility.log("AddScreen | getPhotoPath");
        FileChooser photoFileChooser = new FileChooser();
        Utility.configureFileChooserForImages(photoFileChooser);
        File photoFile = photoFileChooser.showOpenDialog(managerScene.getSceneContainer().getActiveStage());
        Utility.log("AddScreen | getPhotoPath | photoFile: " + photoFile.getPath());
        photoFileExtension = Utility.getFileExtensionFromString(photoFile.getPath());
        Path copyTo = Paths.get(Settings.getPhotoDir(),(Settings.getTempPhotoFilename() + "." + photoFileExtension));
        try{
            Files.copy(photoFile.toPath(),copyTo,StandardCopyOption.REPLACE_EXISTING);
            Utility.log("AddScreen | getPhotoPath | copy successful");
            return copyTo;
        } catch(Exception e){
            Utility.errorLog("AddScreen | getPhotoPath | Error: " + e);
            return null;
        }
    }
    protected void setPhotoView(ImageView photoView, Path photoPath){
        Utility.log("AddScreen | setPhotoView");
        try{
            photoView.setImage(new Image(photoPath.toUri().toURL().toString()));
            photoView.setPreserveRatio(true);
            photoView.setSmooth(true);
            photoView.setCache(true);
        } catch(Exception e){
            Utility.errorLog("AddScreen | setPhotoView | Error: " + e);
        }
    }
    protected void savePhotoFile(String filename){
        if(photoFileExtension.isEmpty()){ Utility.log("AddScreen | savePhotoFile | No Photo File to save."); }
        else{
            Path fromPhotoFilePath = Paths.get(Settings.getPhotoDir(),(Settings.getTempPhotoFilename() + "." + photoFileExtension));
            Path toPhotoFilePath = Paths.get(Settings.getPhotoDir(),(filename + "." + photoFileExtension));
            File fromPhotoFile = new File(fromPhotoFilePath.toAbsolutePath().toString());
            File toPhotoFile = new File(toPhotoFilePath.toAbsolutePath().toString());
            if(fromPhotoFile.exists()){ 
                if(fromPhotoFile.renameTo(toPhotoFile)){ Utility.log("AddScreen | savePhotoFile | Rename successful."); } 
            }
        }
    }
    
    // private members
    @FXML
    private CustomButton addStudentButton, addTeacherButton, addBatchButton, addClassButton, addCourseButton, addSubjectButton, addTimetableButton, addAttendanceButton;
    @FXML
    private void addStudentAction(){
        if(!managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_STUDENT)){ Utility.errorLog("AddScreen | addStudentAction | Error."); };
    }
    @FXML
    private void addTeacherAction(){
        if(!managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_TEACHER)){ Utility.errorLog("AddScreen | addTeacherAction | Error."); };
    }
    @FXML
    private void addBatchAction(){
        if(!managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_BATCH)){ Utility.errorLog("AddScreen | addBatchAction | Error."); };
    }
    @FXML
    private void addClassAction(){
        if(!managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_CLASS)){ Utility.errorLog("AddScreen | addClassAction | Error."); };
    }
    @FXML
    private void addCourseAction(){
        if(!managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_COURSE)){ Utility.errorLog("AddScreen | addCourseAction | Error."); };
    }
    @FXML
    private void addSubjectAction(){
        if(!managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_SUBJECT)){ Utility.errorLog("AddScreen | addSubjectAction | Error."); };
    }
    @FXML
    private void addTimetableAction(){
        if(!managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_TIMETABLE)){ Utility.errorLog("AddScreen | addTimetableAction | Error."); };
    }
    @FXML
    private void addAttendanceAction(){
        if(!managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_ATTENDANCE)){ Utility.errorLog("AddScreen | addAttendanceAction | Error."); };
    }
    @Override
    public void back(){
        Utility.log("AddScreen | back");
        if(!managerScene.getSceneContainer().isUserDataSaved()){ return; }
        managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD);;
    }
    private void setGraphics(){
        Path graphicPath;
        double graphicTextGap = 30;
        double graphicOpacity = 0.7;
        
        graphicPath = Paths.get(Settings.getPNGDir(),Settings.getPNGAddStudent());
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addStudentButton.setGraphic(graphic);
            addStudentButton.setContentDisplay(ContentDisplay.TOP);
            addStudentButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(Settings.getPNGDir(),Settings.getPNGAddTeacher());
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addTeacherButton.setGraphic(graphic);
            addTeacherButton.setContentDisplay(ContentDisplay.TOP);
            addTeacherButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(Settings.getPNGDir(),Settings.getPNGAddSubject());
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addSubjectButton.setGraphic(graphic);
            addSubjectButton.setContentDisplay(ContentDisplay.TOP);
            addSubjectButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(Settings.getPNGDir(),Settings.getPNGAddAttendance());
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addAttendanceButton.setGraphic(graphic);
            addAttendanceButton.setContentDisplay(ContentDisplay.TOP);
            addAttendanceButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(Settings.getPNGDir(),Settings.getPNGAddCourse());
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addCourseButton.setGraphic(graphic);
            addCourseButton.setContentDisplay(ContentDisplay.TOP);
            addCourseButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(Settings.getPNGDir(),Settings.getPNGAddBatch());
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addBatchButton.setGraphic(graphic);
            addBatchButton.setContentDisplay(ContentDisplay.TOP);
            addBatchButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(Settings.getPNGDir(),Settings.getPNGAddClass());
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addClassButton.setGraphic(graphic);
            addClassButton.setContentDisplay(ContentDisplay.TOP);
            addClassButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(Settings.getPNGDir(),Settings.getPNGAddTimetable());
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addTimetableButton.setGraphic(graphic);
            addTimetableButton.setContentDisplay(ContentDisplay.TOP);
            addTimetableButton.setGraphicTextGap(graphicTextGap);
        }
    }
    public void setSectionID(HBox [] sectionHBox){
        for(HBox unitSectionHBox : sectionHBox){ unitSectionHBox.setId("sectionBG"); }
    }
    private void setLabels(){
        addStudentButton.setText(Settings.screenTag.ADD_STUDENT.getTitle());
        addTeacherButton.setText(Settings.screenTag.ADD_TEACHER.getTitle());
        addSubjectButton.setText(Settings.screenTag.ADD_TEACHER.getTitle());
        addAttendanceButton.setText(Settings.screenTag.ADD_TEACHER.getTitle());
        addCourseButton.setText(Settings.screenTag.ADD_TEACHER.getTitle());
        addBatchButton.setText(Settings.screenTag.ADD_TEACHER.getTitle());
        addClassButton.setText(Settings.screenTag.ADD_TEACHER.getTitle());
        addTimetableButton.setText(Settings.screenTag.ADD_TEACHER.getTitle());
    }
}
