/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import premaanganmanager.base.components.CustomButton;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Labels;
import premaanganmanager.configurable.LocalUtility;
import premaanganmanager.configurable.Settings;
import premaanganmanager.configurable.scenes.ManagerScene;

/**
 *
 * @author Trevor Fernandes
 */
public class AddScreen extends SimpleScreen implements FootControlInterface{
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
    
    // private members
    @FXML
    private CustomButton addStudentButton, addTeacherButton, addBatchButton, addClassButton, addCourseButton, addSubjectButton, addTimetableButton, addAttendanceButton;
    @FXML
    private void addStudentAction(){
        managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_STUDENT);
    }
    @FXML
    private void addTeacherAction(){
        managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_TEACHER);
    }
    @FXML
    private void addBatchAction(){
        managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_BATCH);
    }
    @FXML
    private void addClassAction(){
        managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_CLASS);
    }
    @FXML
    private void addCourseAction(){
        managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_COURSE);
    }
    @FXML
    private void addSubjectAction(){
        managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_SUBJECT);
    }
    @FXML
    private void addTimetableAction(){
        managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_TIMETABLE);
    }
    @FXML
    private void addAttendanceAction(){
        managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD_ATTENDANCE);
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
    private void setLabels(){
        addStudentButton.setText(Labels.labelTag.ADD_STUDENT.getLabel());
        addTeacherButton.setText(Labels.labelTag.ADD_TEACHER.getLabel());
        addSubjectButton.setText(Labels.labelTag.ADD_SUBJECT.getLabel());
        addAttendanceButton.setText(Labels.labelTag.ADD_ATTENDANCE.getLabel());
        addCourseButton.setText(Labels.labelTag.ADD_COURSE.getLabel());
        addBatchButton.setText(Labels.labelTag.ADD_BATCH.getLabel());
        addClassButton.setText(Labels.labelTag.ADD_CLASS.getLabel());
        addTimetableButton.setText(Labels.labelTag.ADD_TIMETABLE.getLabel());
    }
}
