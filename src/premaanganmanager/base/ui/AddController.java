/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import premaanganmanager.base.controller.background.Student;
import premaanganmanager.configurable.Labels;

/**
 *
 * @author Trevor Fernandes
 */
public class AddController {
    
    private AppContainer appContainer;
   
    // Add
    @FXML
    private Button addToDBButton, addStudentButton, addTeacherButton, addBatchButton, addClassButton, addCourseButton, addSubjectButton, addTimetableButton, addAttendanceButton;
    
    // Add Student
    @FXML
    private Button addStudentBackButton, addStudentSaveButton;
    
    @FXML
    private Text addStudentFirstName, addStudentMiddleName, addStudentLastName;
    
    @FXML
    private TextField addStudentFirstNameField, addStudentMiddleNameField, addStudentLastNameField;
    
    @FXML
    private void addToDBAction(){
        System.out.println("AddController | addToDBAction");
        appContainer.uiControl.uiModel.pushToDummyTable();
    }
    
    @FXML
    private void addStudentButtonAction(){
        appContainer.displayScreen(AppContainer.screenTag.ADD_STUDENT);
    }
    
    @FXML
    private void addStudentBackAction(){
        appContainer.displayScreen(AppContainer.screenTag.ADD);
    }
    
    @FXML
    private void addStudentSaveAction(){
        System.out.println("AddController | addStudentSaveAction");
        saveStudentRecord();
    }
    
    public AddController(AppContainer appContainer){
        this.appContainer = appContainer;
    }
    
    public AnchorPane setAddScreenMenu(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/AddScreenMenu.fxml"));
            loader.setController(this);
            AnchorPane addBase = loader.load();
            setAddScreenMenuLabels();
            return addBase;
//            loginScene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setAddScreenMenu | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public AnchorPane setAddStudentScreen(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/AddStudent.fxml"));
            loader.setController(this);
            AnchorPane addBase = loader.load();
            setAddStudentScreenLabels();
            return addBase;
//            loginScene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setAddStudentScreen | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    private void setAddScreenMenuLabels(){
        addStudentButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT));
        addTeacherButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_TEACHER));
        addSubjectButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_SUBJECT));
        addAttendanceButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_ATTENDANCE));
        addCourseButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_COURSE));
        addBatchButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_BATCH));
        addClassButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_CLASS));
        addTimetableButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_TIMETABLE));
    }
    
    private void setAddStudentScreenLabels(){
        addStudentBackButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BACK));
        addStudentSaveButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.SAVE));
        addStudentFirstName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FIRST_NAME));
        addStudentMiddleName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_MIDDLE_NAME));
        addStudentLastName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_LAST_NAME));
    }
    
    private void saveStudentRecord(){
        System.out.println("AddController | saveStudentRecord");
        appContainer.uiControl.uiModel.saveStudentForm(getStudentRecordFromUI());
    }
    
    private Student getStudentRecordFromUI(){
        System.out.println("AddController | getStudentRecordFromUI");
        
        Student student = new Student();
        
        student.setFirstName(addStudentFirstNameField.getText());
        student.setMiddleName(addStudentMiddleNameField.getText());
        student.setLastName(addStudentLastNameField.getText());
        
        return student;
    }
}
