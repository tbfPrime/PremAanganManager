/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.ui;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import premaanganmanager.base.controller.background.FamilyInfo;
import premaanganmanager.base.controller.background.Religion;
import premaanganmanager.base.controller.background.Student;
import premaanganmanager.base.controller.ui.UIControl;
import premaanganmanager.configurable.Labels;

/**
 *
 * @author Trevor Fernandes
 */
public class AddController {
    private AppContainer appContainer;
    private Student student;
    private Religion religion;
    private FamilyInfo familyInfo1;
    private FamilyInfo familyInfo2;
    private FamilyInfo familyInfo3;
    private FamilyInfo familyInfo4;
    private FamilyInfo familyInfo5;
    private FamilyInfo familyInfo6;
    
    private String photoFileExtension = "";
   
    // FXML fields
    // Add
    @FXML
    private Button addStudentButton, addTeacherButton, addBatchButton, addClassButton, addCourseButton, addSubjectButton, addTimetableButton, addAttendanceButton;
    @FXML
    private Button addBackButton, addSaveButton;
    
    // Help
    @FXML
    private HBox addHelpHeaderHBox;
    @FXML 
    private VBox addHelpVBox;
    @FXML
    private StackPane addHelpStackPane;
    @FXML
    private Pane addHelpPane;
    @FXML
    private Text addHelpHeader;
    
    // Add Student
    @FXML
    private Text addStudentFirstName, addStudentMiddleName, addStudentLastName, addStudentAddress, addStudentEmail, addStudentDOB;
    @FXML
    private Text addStudentPlaceOfBirth, addStudentReligion, addStudentOtherReligion, addStudentCourse, addStudentEmergencyContactPerson, addStudentEmergencyContactTelNo;
    @FXML
    private Text addStudentEducationalBackground, addStudentLanguages, addStudentHobbies;
    @FXML
    private Text addStudentFamilyMemberName1, addStudentFamilyMemberRelationship1, addStudentFamilyMemberAge1, addStudentFamilyMemberOccupation1, addStudentFamilyMemberOccupationalAddress1, addStudentFamilyMemberOccupationalTelNo1;        
    @FXML
    private Text addStudentFamilyMemberName2, addStudentFamilyMemberRelationship2, addStudentFamilyMemberAge2, addStudentFamilyMemberOccupation2, addStudentFamilyMemberOccupationalAddress2, addStudentFamilyMemberOccupationalTelNo2;
    @FXML
    private Text addStudentFamilyMemberName3, addStudentFamilyMemberRelationship3, addStudentFamilyMemberAge3, addStudentFamilyMemberOccupation3, addStudentFamilyMemberOccupationalAddress3, addStudentFamilyMemberOccupationalTelNo3;        
    @FXML
    private Text addStudentFamilyMemberName4, addStudentFamilyMemberRelationship4, addStudentFamilyMemberAge4, addStudentFamilyMemberOccupation4, addStudentFamilyMemberOccupationalAddress4, addStudentFamilyMemberOccupationalTelNo4;        
    @FXML
    private Text addStudentFamilyMemberName5, addStudentFamilyMemberRelationship5, addStudentFamilyMemberAge5, addStudentFamilyMemberOccupation5, addStudentFamilyMemberOccupationalAddress5, addStudentFamilyMemberOccupationalTelNo5;        
    @FXML
    private Text addStudentFamilyMemberName6, addStudentFamilyMemberRelationship6, addStudentFamilyMemberAge6, addStudentFamilyMemberOccupation6, addStudentFamilyMemberOccupationalAddress6, addStudentFamilyMemberOccupationalTelNo6;        
    @FXML
    private Text addStudentReferenceNo, addStudentEnrollmentNo, addStudentPlace, addStudentDate, addStudentPhoto, addStudentPersonalDetails, addStudentOfficeUseOnly, addStudentFamilyDetails, addStudentEmergencyContact;
    
    @FXML
    private TextField addStudentFirstNameField, addStudentMiddleNameField, addStudentLastNameField, addStudentAddressField, addStudentEmailField, addStudentPlaceOfBirthField;
    @FXML
    private TextField addStudentOtherReligionField, addStudentEmergencyContactPersonField, addStudentEmergencyContactTelNoField, addStudentEducationalBackgroundField, addStudentLanguagesField, addStudentHobbiesField;
    @FXML
    private TextField addStudentFamilyMemberNameField1, addStudentFamilyMemberRelationshipField1, addStudentFamilyMemberAgeField1, addStudentFamilyMemberOccupationField1, addStudentFamilyMemberOccupationalAddressField1, addStudentFamilyMemberOccupationalTelNoField1;
    @FXML
    private TextField addStudentFamilyMemberNameField2, addStudentFamilyMemberRelationshipField2, addStudentFamilyMemberAgeField2, addStudentFamilyMemberOccupationField2, addStudentFamilyMemberOccupationalAddressField2, addStudentFamilyMemberOccupationalTelNoField2;
    @FXML
    private TextField addStudentFamilyMemberNameField3, addStudentFamilyMemberRelationshipField3, addStudentFamilyMemberAgeField3, addStudentFamilyMemberOccupationField3, addStudentFamilyMemberOccupationalAddressField3, addStudentFamilyMemberOccupationalTelNoField3;
    @FXML
    private TextField addStudentFamilyMemberNameField4, addStudentFamilyMemberRelationshipField4, addStudentFamilyMemberAgeField4, addStudentFamilyMemberOccupationField4, addStudentFamilyMemberOccupationalAddressField4, addStudentFamilyMemberOccupationalTelNoField4;
    @FXML
    private TextField addStudentFamilyMemberNameField5, addStudentFamilyMemberRelationshipField5, addStudentFamilyMemberAgeField5, addStudentFamilyMemberOccupationField5, addStudentFamilyMemberOccupationalAddressField5, addStudentFamilyMemberOccupationalTelNoField5;
    @FXML
    private TextField addStudentFamilyMemberNameField6, addStudentFamilyMemberRelationshipField6, addStudentFamilyMemberAgeField6, addStudentFamilyMemberOccupationField6, addStudentFamilyMemberOccupationalAddressField6, addStudentFamilyMemberOccupationalTelNoField6;
    @FXML
    private TextField addStudentReferenceNoField, addStudentEnrollmentNoField, addStudentPlaceField;

    @FXML
    private Button addStudentPhotoButton;
    
    @FXML
    private DatePicker addStudentDOBDatePicker, addStudentDateDatePicker;
    
    @FXML 
    private ComboBox addStudentReligionComboBox, addStudentCourseComboBox;
    
    @FXML 
    private ImageView addStudentPhotoView;
    
    @FXML
    private HBox addStudentPersonalDetailsHBox, addStudentOfficeUseOnlyHBox, addStudentFamilyDetailsHBox, addStudentEmergencyContactHBox;
    
    // Help Student
    @FXML
    private Text addStudentHelpBody;
    
    // Add Teacher
    @FXML
    private Text addTeacherPersonalDetails, addTeacherEmergencyContact, addTeacherOfficeUseOnly;
    @FXML
    private Text addTeacherFirstName, addTeacherMiddleName, addTeacherLastName;
    @FXML
    private Text addTeacherAddress, addTeacherEmail, addTeacherDOB;
    @FXML
    private Text addTeacherEmergencyContactPerson, addTeacherEmergencyContactTelNo;
    @FXML
    private Text addTeacherSalary, addTeacherDateOfResignation, addTeacherPlace, addTeacherDate;
    
    @FXML
    private TextField addTeacherFirstNameField, addTeacherMiddleNameField, addTeacherLastNameField;
    @FXML
    private TextField addTeacherAddressField, addTeacherEmailField;
    @FXML
    private TextField addTeacherEmergencyContactPersonField, addTeacherEmergencyContactTelNoField;
    @FXML
    private TextField addTeacherSalaryField, addTeacherPlaceField;
    
    @FXML
    private Button addTeacherPhotoButton;
    
    @FXML
    private DatePicker addTeacherDateOfBirthPicker, addTeacherDateOfResignationPicker, addTeacherDatePicker;

    @FXML 
    private ImageView addTeacherPhotoView;
    
    @FXML
    private HBox addTeacherPersonalDetailsHBox, addTeacherEmergencyContactHBox, addTeacherOfficeUseOnlyHBox;
    
    // Help Student
    @FXML
    private Text addTeacherHelpBody;
    
    // FXML methods
    // Add
    @FXML
    private void addStudentButtonAction(){
        appContainer.displayScreen(AppContainer.screenTag.ADD_STUDENT);
    }
    @FXML
    private void addTeacherButtonAction(){
        appContainer.displayScreen(AppContainer.screenTag.ADD_TEACHER);
    }
    
    // Add Student
    @FXML
    private void addStudentBackAction(){
        flushDataOnExitFromAddStudent();
        appContainer.displayScreen(AppContainer.screenTag.ADD);
    }
    @FXML
    private void addStudentSaveAction(){
        System.out.println("AddController | addStudentSaveAction");
        saveStudentRecord();
    }
    @FXML
    private void addStudentPhotoAction(){
        System.out.println("AddController | addStudentPhotoAction");
        getStudentPhoto();
    }
    
    @FXML
    private void addStudentDOBDatePickerAction(){
        System.out.println("AddController | addStudentDOBDatePickerAction");
        if(addStudentDOBDatePicker.getValue() != null){
            Date selectedDate = new Date(addStudentDOBDatePicker.getValue().getYear(), addStudentDOBDatePicker.getValue().getMonthValue(), addStudentDOBDatePicker.getValue().getDayOfMonth());
            Date minDate = new Date(appContainer.uiControl.settings.getDOBMinYear(), appContainer.uiControl.settings.getDOBMinMonth(), appContainer.uiControl.settings.getDOBMinDate());
            Date maxDate = new Date(appContainer.uiControl.settings.getDOBMaxYear(), appContainer.uiControl.settings.getDOBMaxMonth(), appContainer.uiControl.settings.getDOBMaxDate());
            
            if(selectedDate.getTime() < minDate.getTime() || selectedDate.getTime() > maxDate.getTime()){
                appContainer.uiControl.alert(UIControl.alertType.WARNING,appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_DOB_FORMAT_INCORRECT));
                addStudentDOBDatePicker.getEditor().clear();
            }
        } else{ System.err.println("AddController | addStudentDOBDatePickerAction | No Value set in DatePicker to take action."); }
    }
    
    @FXML
    private void addStudentReligionComboBoxAction(){
        System.out.println("AddController | addStudentReligionComboBoxAction | value: " + addStudentReligionComboBox.getValue());
        addStudentOtherReligionField.setDisable(true);
        if(addStudentReligionComboBox.getValue().toString().equalsIgnoreCase(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_NEW_RELIGION))){
            addStudentOtherReligionField.setDisable(false);
        } else{ religion.setReligionId(getReligionID()); }
    }
    
    // Constructor
    public AddController(AppContainer appContainer){
        this.appContainer = appContainer;
    }
    
    // Public Functions
    public AnchorPane setAddScreenMenu(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/AddScreenMenu.fxml"));
            loader.setController(this);
            AnchorPane addBase = loader.load();
            setAddScreenMenuData();
            return addBase;
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
            setAddStudentScreenData();
            addBase.getStylesheets().add(AddController.class.getResource("AddStudent.css").toExternalForm());
            return addBase;
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setAddStudentScreen | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public AnchorPane setAddTeacherScreen(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/AddTeacher.fxml"));
            loader.setController(this);
            AnchorPane addBase = loader.load();
            setAddTeacherScreenData();
            addBase.getStylesheets().add(AddController.class.getResource("AddStudent.css").toExternalForm());
            return addBase;
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setAddTeacherScreen | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public void showHelp(boolean show){
        System.out.println("AddController | showHelp | " + show);
        if(show){
            appContainer.uiControl.setHelpStyle(addHelpPane, addHelpVBox, addHelpHeaderHBox);
        }
        addHelpStackPane.setVisible(show);
    }
    
    // Private Functions
    private void setAddScreenMenuData(){
        setAddScreenMenuGraphics();
        setAddSCreenMenuStyling();
        setAddScreenMenuLabels();
    }
    
    private void setAddStudentScreenData(){
        student = new Student();
        religion = new Religion();
        familyInfo1 = new FamilyInfo();
        familyInfo2 = new FamilyInfo();
        familyInfo3 = new FamilyInfo();
        familyInfo4 = new FamilyInfo();
        familyInfo5 = new FamilyInfo();
        familyInfo6 = new FamilyInfo();
        
        setAddStudentFormConditions();
        setReligionData();
        setDefaultStudentPhotoView();
        setAddStudentPropertyID();
        setAddStudentStyling();
        setAddStudentScreenLabels();
    }
    
    private void setAddTeacherScreenData(){
        setAddTeacherScreenLabels();
    }
    
    private void setAddScreenMenuGraphics(){
        Path graphicPath;
        double graphicTextGap = 30;
        double graphicOpacity = 0.7;
        
        graphicPath = Paths.get(appContainer.uiControl.settings.pngDir,appContainer.uiControl.settings.png_addStudent);
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addStudentButton.setGraphic(graphic);
            addStudentButton.setContentDisplay(ContentDisplay.TOP);
            addStudentButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(appContainer.uiControl.settings.pngDir,appContainer.uiControl.settings.png_addTeacher);
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addTeacherButton.setGraphic(graphic);
            addTeacherButton.setContentDisplay(ContentDisplay.TOP);
            addTeacherButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(appContainer.uiControl.settings.pngDir,appContainer.uiControl.settings.png_addSubject);
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addSubjectButton.setGraphic(graphic);
            addSubjectButton.setContentDisplay(ContentDisplay.TOP);
            addSubjectButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(appContainer.uiControl.settings.pngDir,appContainer.uiControl.settings.png_addAttendance);
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addAttendanceButton.setGraphic(graphic);
            addAttendanceButton.setContentDisplay(ContentDisplay.TOP);
            addAttendanceButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(appContainer.uiControl.settings.pngDir,appContainer.uiControl.settings.png_addCourse);
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addCourseButton.setGraphic(graphic);
            addCourseButton.setContentDisplay(ContentDisplay.TOP);
            addCourseButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(appContainer.uiControl.settings.pngDir,appContainer.uiControl.settings.png_addBatch);
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addBatchButton.setGraphic(graphic);
            addBatchButton.setContentDisplay(ContentDisplay.TOP);
            addBatchButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(appContainer.uiControl.settings.pngDir,appContainer.uiControl.settings.png_addClass);
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addClassButton.setGraphic(graphic);
            addClassButton.setContentDisplay(ContentDisplay.TOP);
            addClassButton.setGraphicTextGap(graphicTextGap);
        }
        
        graphicPath = Paths.get(appContainer.uiControl.settings.pngDir,appContainer.uiControl.settings.png_addTimetable);
        if(new File(graphicPath.toUri()).exists()){
            ImageView graphic = new ImageView(graphicPath.toUri().toString());
            graphic.setOpacity(graphicOpacity);
            addTimetableButton.setGraphic(graphic);
            addTimetableButton.setContentDisplay(ContentDisplay.TOP);
            addTimetableButton.setGraphicTextGap(graphicTextGap);
        }
    }
    
    private void setAddSCreenMenuStyling(){
        appContainer.uiControl.setButtonStyle(addStudentButton);
        appContainer.uiControl.setButtonStyle(addTeacherButton);
        appContainer.uiControl.setButtonStyle(addSubjectButton);
        appContainer.uiControl.setButtonStyle(addAttendanceButton);
        appContainer.uiControl.setButtonStyle(addCourseButton);
        appContainer.uiControl.setButtonStyle(addBatchButton);
        appContainer.uiControl.setButtonStyle(addClassButton);
        appContainer.uiControl.setButtonStyle(addTimetableButton);
    }

    private void setAddStudentFormConditions(){
        addStudentOtherReligionField.setDisable(true);
        
        addStudentEmergencyContactTelNoField.disableProperty().bind(addStudentEmergencyContactPersonField.textProperty().isEmpty());
        
        addStudentFamilyMemberAgeField1.disableProperty().bind(addStudentFamilyMemberNameField1.textProperty().isEmpty());
        addStudentFamilyMemberRelationshipField1.disableProperty().bind(addStudentFamilyMemberNameField1.textProperty().isEmpty());
        addStudentFamilyMemberOccupationField1.disableProperty().bind(addStudentFamilyMemberNameField1.textProperty().isEmpty());
        addStudentFamilyMemberOccupationalAddressField1.disableProperty().bind(addStudentFamilyMemberNameField1.textProperty().isEmpty());
        addStudentFamilyMemberOccupationalTelNoField1.disableProperty().bind(addStudentFamilyMemberNameField1.textProperty().isEmpty());
        addStudentFamilyMemberAgeField1.disableProperty().bind(addStudentFamilyMemberNameField1.textProperty().isEmpty());
        
        addStudentFamilyMemberNameField2.disableProperty().bind(addStudentFamilyMemberNameField1.textProperty().isEmpty());
        addStudentFamilyMemberAgeField2.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField2.disabledProperty(), addStudentFamilyMemberNameField2.textProperty().isEmpty()));
        addStudentFamilyMemberRelationshipField2.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField2.disabledProperty(), addStudentFamilyMemberNameField2.textProperty().isEmpty()));
        addStudentFamilyMemberOccupationField2.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField2.disabledProperty(), addStudentFamilyMemberNameField2.textProperty().isEmpty()));
        addStudentFamilyMemberOccupationalAddressField2.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField2.disabledProperty(), addStudentFamilyMemberNameField2.textProperty().isEmpty()));
        addStudentFamilyMemberOccupationalTelNoField2.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField2.disabledProperty(), addStudentFamilyMemberNameField2.textProperty().isEmpty()));

        addStudentFamilyMemberNameField3.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField2.disabledProperty(), addStudentFamilyMemberNameField2.textProperty().isEmpty()));
        addStudentFamilyMemberAgeField3.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField3.disabledProperty(), addStudentFamilyMemberNameField3.textProperty().isEmpty()));
        addStudentFamilyMemberRelationshipField3.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField3.disabledProperty(), addStudentFamilyMemberNameField3.textProperty().isEmpty()));
        addStudentFamilyMemberOccupationField3.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField3.disabledProperty(), addStudentFamilyMemberNameField3.textProperty().isEmpty()));
        addStudentFamilyMemberOccupationalAddressField3.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField3.disabledProperty(), addStudentFamilyMemberNameField3.textProperty().isEmpty()));
        addStudentFamilyMemberOccupationalTelNoField3.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField3.disabledProperty(), addStudentFamilyMemberNameField3.textProperty().isEmpty()));        

        addStudentFamilyMemberNameField4.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField3.disabledProperty(), addStudentFamilyMemberNameField3.textProperty().isEmpty()));
        addStudentFamilyMemberAgeField4.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField4.disabledProperty(), addStudentFamilyMemberNameField4.textProperty().isEmpty()));
        addStudentFamilyMemberRelationshipField4.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField4.disabledProperty(), addStudentFamilyMemberNameField4.textProperty().isEmpty()));
        addStudentFamilyMemberOccupationField4.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField4.disabledProperty(), addStudentFamilyMemberNameField4.textProperty().isEmpty()));
        addStudentFamilyMemberOccupationalAddressField4.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField4.disabledProperty(), addStudentFamilyMemberNameField4.textProperty().isEmpty()));
        addStudentFamilyMemberOccupationalTelNoField4.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField4.disabledProperty(), addStudentFamilyMemberNameField4.textProperty().isEmpty()));        

        addStudentFamilyMemberNameField5.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField4.disabledProperty(), addStudentFamilyMemberNameField4.textProperty().isEmpty()));
        addStudentFamilyMemberAgeField5.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField5.disabledProperty(), addStudentFamilyMemberNameField5.textProperty().isEmpty()));
        addStudentFamilyMemberRelationshipField5.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField5.disabledProperty(), addStudentFamilyMemberNameField5.textProperty().isEmpty()));
        addStudentFamilyMemberOccupationField5.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField5.disabledProperty(), addStudentFamilyMemberNameField5.textProperty().isEmpty()));
        addStudentFamilyMemberOccupationalAddressField5.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField5.disabledProperty(), addStudentFamilyMemberNameField5.textProperty().isEmpty()));
        addStudentFamilyMemberOccupationalTelNoField5.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField5.disabledProperty(), addStudentFamilyMemberNameField5.textProperty().isEmpty()));        

        addStudentFamilyMemberNameField6.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField5.disabledProperty(), addStudentFamilyMemberNameField5.textProperty().isEmpty()));
        addStudentFamilyMemberAgeField6.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField6.disabledProperty(), addStudentFamilyMemberNameField6.textProperty().isEmpty()));
        addStudentFamilyMemberRelationshipField6.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField6.disabledProperty(), addStudentFamilyMemberNameField6.textProperty().isEmpty()));
        addStudentFamilyMemberOccupationField6.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField6.disabledProperty(), addStudentFamilyMemberNameField6.textProperty().isEmpty()));
        addStudentFamilyMemberOccupationalAddressField6.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField6.disabledProperty(), addStudentFamilyMemberNameField6.textProperty().isEmpty()));
        addStudentFamilyMemberOccupationalTelNoField6.disableProperty().bind(Bindings.or(addStudentFamilyMemberNameField6.disabledProperty(), addStudentFamilyMemberNameField6.textProperty().isEmpty()));                
    }
    
    private void setReligionData(){
        System.out.println("AddController | setReligionData");
        ObservableList<Religion> list = FXCollections.observableArrayList(appContainer.uiControl.uiModel.fetchAllReligion());
        
        addStudentReligionComboBox.setItems(list);
        addStudentReligionComboBox.getItems().add(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_NEW_RELIGION));
    }
    
    private void setDefaultStudentPhotoView(){
        try{
            System.out.println("AddController | setDefaultStudentPhotoView");
            Path defaultStudentPhotoPath = Paths.get(appContainer.uiControl.settings.placeHoldersDir, appContainer.uiControl.settings.placeHolderStudentPhoto);
            addStudentPhotoView.setImage(new Image(defaultStudentPhotoPath.toUri().toURL().toString()));
            addStudentPhotoView.setPreserveRatio(true);
            addStudentPhotoView.setSmooth(true);
            addStudentPhotoView.setCache(true);
        } catch(Exception e){
            System.err.println("AddController | setStudentPhotoView | Error: " + e);
        }
    }
        
    private void setAddStudentPropertyID(){
        addStudentPersonalDetailsHBox.setId("BasicInfoHBox");
        addStudentEmergencyContactHBox.setId("BasicInfoHBox");
        addStudentFamilyDetailsHBox.setId("BasicInfoHBox");
        addStudentOfficeUseOnlyHBox.setId("BasicInfoHBox");
    }

    private void setAddStudentStyling(){
        appContainer.uiControl.setHelpStyle(addHelpPane, addHelpVBox, addHelpHeaderHBox);
    }
    
    private Integer getReligionID(){
        System.out.println("AddController | getReligionID");
        Religion selectedReligion = (Religion)addStudentReligionComboBox.getItems().get(addStudentReligionComboBox.getSelectionModel().getSelectedIndex());
        return selectedReligion.getReligionId();
    }
    
    private void getStudentPhoto(){
        System.out.println("AddController | getStudentPhoto");
        FileChooser addStudentPhotoFileChooser = new FileChooser();
        appContainer.uiControl.configureFileChooserForImages(addStudentPhotoFileChooser);
        File addStudentPhotoFile = addStudentPhotoFileChooser.showOpenDialog(appContainer.uiControl.getApplicationStage());
        System.out.println("addStudentPhotoFile: " + addStudentPhotoFile.getPath());
        
        photoFileExtension = getFileExtensionFromString(addStudentPhotoFile.getPath());
        Path copyTo = Paths.get(appContainer.uiControl.settings.photosDir, (appContainer.uiControl.settings.tempPhotoFileName + "." + photoFileExtension));
        try{
            Files.copy(addStudentPhotoFile.toPath(),copyTo,StandardCopyOption.REPLACE_EXISTING);
            setStudentPhotoView(copyTo.toUri());
            System.out.println("AddController | getStudentPhoto | copy successful");
        } catch(Exception e){
            System.err.println("AddController | getStudentPhoto | Error: " + e);
        }
    }
    
    private void setStudentPhotoView(URI uri){
        try{
            System.out.println("AddController | setStudentPhotoView | URI: " + uri.toURL().toString());
            addStudentPhotoView.setImage(new Image(uri.toURL().toString()));
            addStudentPhotoView.setPreserveRatio(true);
            addStudentPhotoView.setSmooth(true);
            addStudentPhotoView.setCache(true);
        } catch(Exception e){
            System.err.println("AddController | setStudentPhotoView | Error: " + e);
        }
    }
    
    private String getFileExtensionFromString(String filePath){
        System.out.println("AddController | getFileExtensionFromString | filePath: " + filePath);
        int i = filePath.lastIndexOf(".");
        if(i > 0){ return filePath.substring(i+1); }
        else{ System.out.println("AddController | getFileExtensionFromString | Incorrect filePath format."); return ""; }
    }
    
    private void flushDataOnExitFromAddStudent(){
        if(photoFileExtension.isEmpty()){ System.out.println("AddController | flushDataOnExitFromAddStudent | No Photo File to flush."); }
        else{
            Path tempPhotoFilePath = Paths.get(appContainer.uiControl.settings.photosDir, (appContainer.uiControl.settings.tempPhotoFileName + "." + photoFileExtension));
            File tempPhotoFile = new File(tempPhotoFilePath.toAbsolutePath().toString());
            if(tempPhotoFile.exists()){ tempPhotoFile.delete(); }
        }
    }
    
    private void saveStudentRecord(){
        System.out.println("AddController | saveStudentRecord");
        
        if(validateStudentForm()){
            if(saveReligionRecord() && appContainer.uiControl.uiModel.saveStudentForm(student) && saveFamilyInfo()){
                System.out.println("AddController | saveStudentRecord | Value of Student ID: " + student.getStudentId());
                savePhotoFile();
                String alertStudentName = addStudentFirstNameField.getText() + (addStudentMiddleNameField.getText().isEmpty() ? "" : " " + addStudentMiddleNameField.getText()) + (addStudentLastNameField.getText().isEmpty() ? "" : " " + addStudentLastNameField.getText());
                if(appContainer.uiControl.alert(UIControl.alertType.INFO, appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_STUDENT_SAVE_SUCCESS).replace("?", alertStudentName))){ addStudentBackAction(); }
                else{ addStudentBackAction(); }
            } else{ appContainer.uiControl.alert(UIControl.alertType.ERROR_SAVE, ""); }
        } else{ System.out.println("AddController | saveStudentRecord | Validation of student form failed. Exiting without saving."); }
    }
    
    private boolean saveReligionRecord(){
        if(addStudentOtherReligionField.isDisabled()){
            if(addStudentReligionComboBox.getValue() == null || addStudentReligionComboBox.getValue().toString().isEmpty()){ System.out.println("AddController | saveReligionRecord | No religion selected. Exiting."); }
            else{ 
                System.out.println("AddController | saveReligionRecord | Saving religion id: " +  getReligionID() + " to student object."); 
                student.setReligionId(getReligionID());
            }
        } else{
            if(addStudentOtherReligionField.getText().isEmpty()){ System.out.println("AddController | saveReligionRecord | No value to save from Other Religion field. Exiting"); }
            else{ 
                System.out.println("Value of addStudentOtherReligionField: " + addStudentOtherReligionField.getText());
                religion.setReligionName(addStudentOtherReligionField.getText()); 
                if(appContainer.uiControl.uiModel.saveReligion(religion)){ 
                    System.out.println("AddController | saveReligionRecord | New Religion saved successfully."); 
                    student.setReligionId(religion.getReligionId());
                } else{ System.out.println("AddController | saveReligionRecord | Error saving new religion record. Exiting"); return false; }
            }
        }
        return true;
    }
    
    private void savePhotoFile(){
        if(photoFileExtension.isEmpty()){ System.out.println("AddController | savePhotoFile | No Photo File to save."); }
        else{
            Path fromPhotoFilePath = Paths.get(appContainer.uiControl.settings.photosDir, (appContainer.uiControl.settings.tempPhotoFileName + "." + photoFileExtension));
            Path toPhotoFilePath = Paths.get(appContainer.uiControl.settings.photosDir, (appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_STUDENT_PHOTO_PREFIX) + student.getStudentId() + "." + photoFileExtension));
            File fromPhotoFile = new File(fromPhotoFilePath.toAbsolutePath().toString());
            File toPhotoFile = new File(toPhotoFilePath.toAbsolutePath().toString());
            if(fromPhotoFile.exists()){ 
                if(fromPhotoFile.renameTo(toPhotoFile)){ System.out.println("AddController | savePhotoFile | Rename successful."); } 
            }
        }
    }

    private boolean saveFamilyInfo(){
        if(familyInfo1.getName() != null){
            if(!appContainer.uiControl.uiModel.saveStudentFamilyInfo(familyInfo1, student)){ System.err.println("AddController | saveFamilyInfo | Error saving family info 1. Exiting."); return false; }
            
            if(familyInfo2.getName() != null){
                if(!appContainer.uiControl.uiModel.saveStudentFamilyInfo(familyInfo2, student)){ System.err.println("AddController | saveFamilyInfo | Error saving family info 2. Exiting."); return false; }
                    
                if(familyInfo3.getName() != null){
                    if(!appContainer.uiControl.uiModel.saveStudentFamilyInfo(familyInfo3, student)){ System.err.println("AddController | saveFamilyInfo | Error saving family info 3. Exiting."); return false; }
                    
                    if(familyInfo4.getName() != null){
                        if(!appContainer.uiControl.uiModel.saveStudentFamilyInfo(familyInfo4, student)){ System.err.println("AddController | saveFamilyInfo | Error saving family info 4. Exiting."); return false; }
                        
                        if(familyInfo5.getName() != null){
                            if(!appContainer.uiControl.uiModel.saveStudentFamilyInfo(familyInfo5, student)){ System.err.println("AddController | saveFamilyInfo | Error saving family info 5. Exiting."); return false; }
                            
                            if(familyInfo6.getName() != null){
                                if(!appContainer.uiControl.uiModel.saveStudentFamilyInfo(familyInfo6, student)){ System.err.println("AddController | saveFamilyInfo | Error saving family info 6. Exiting."); return false; }
                            }
                        }
                    }
                }
            }
        } else { System.err.println("AddController | saveFamilyInfo | No family info to save."); }
        return true;
    }
    
    private boolean validateStudentForm(){
        System.out.println("AddController | validateStudentForm");
        
        boolean flagFieldsEmpty = false;
        
        if(addStudentFirstNameField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | FirstName empty."); appContainer.uiControl.alert(UIControl.alertType.WARNING_FIELD_IS_EMPTY,appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FIRST_NAME)); return false; }
        else{ student.setFirstName(addStudentFirstNameField.getText()); }
        
        if(addStudentMiddleNameField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | MiddleName empty."); flagFieldsEmpty = true; }
        else{ student.setMiddleName(addStudentMiddleNameField.getText()); }
        
        if(addStudentLastNameField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | LastName empty."); flagFieldsEmpty = true; }
        else{ student.setLastName(addStudentLastNameField.getText()); }

        // Validate for Date format
        if(photoFileExtension.isEmpty()){ System.out.println("AddController | validateStudentForm | DOB empty."); flagFieldsEmpty = true; }
        else{ student.setStudentPhotoId(photoFileExtension); }
        
        if(addStudentAddressField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Address empty."); flagFieldsEmpty = true; }
        else{ student.setAddress(addStudentAddressField.getText()); }
        
        // Validate for email format
        if(addStudentEmailField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | E-Mail empty."); flagFieldsEmpty = true; } 
        else{ 
            if(validateEmail(addStudentEmailField.getText())){ student.setEmailId(addStudentEmailField.getText()); }
            else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_EMAIL_FORMAT_INCORRECT)); return false; }
        }
        
        // Validate for Date format
        if(addStudentDOBDatePicker.getValue() == null){ System.out.println("AddController | validateStudentForm | DOB empty."); flagFieldsEmpty = true; } 
        else{ student.setDob(addStudentDOBDatePicker.getValue().toString()); }
        
        if(addStudentPlaceOfBirthField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Place of Birth empty."); flagFieldsEmpty = true; }
        else{ student.setPlaceOfBirth(addStudentPlaceOfBirthField.getText()); }
        
        // Validate for Religion
        if(religion.getReligionId() == null){ System.out.println("AddController | validateStudentForm | No religion selected from list. Trying to save from Other religion."); flagFieldsEmpty = true; }
        else{ student.setReligionId(religion.getReligionId()); }
        
        if(addStudentEducationalBackgroundField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Educational Background empty."); flagFieldsEmpty = true; }
        else{ student.setEducationalBackground(addStudentEducationalBackgroundField.getText()); }

        if(addStudentLanguagesField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Languages empty."); flagFieldsEmpty = true; }
        else{ student.setLanguages(addStudentLanguagesField.getText()); }
        
        if(addStudentHobbiesField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Hobbies empty."); flagFieldsEmpty = true; }
        else{ student.setHobbies(addStudentHobbiesField.getText()); }
        
        // Validate for Emergency Contacts
        if(addStudentEmergencyContactPersonField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Emergency Contact Person empty."); flagFieldsEmpty = true; }
        else{ 
            student.setEmergencyContactPerson(addStudentEmergencyContactPersonField.getText());
            
            if(addStudentEmergencyContactTelNoField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Place of Birth empty."); flagFieldsEmpty = true; }
            else{ 
                if(appContainer.uiControl.isNumeric(addStudentEmergencyContactTelNoField.getText())){ student.setEmergencyContactNumber(addStudentEmergencyContactTelNoField.getText()); }
                else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,(addStudentEmergencyContactTelNo.getText() + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT))); return false; }
            }
        }
        
        // Validate for 6 Family Members
        if(addStudentFamilyMemberNameField1.getText() != null && !addStudentFamilyMemberNameField1.getText().isEmpty()){
            familyInfo1.setName(addStudentFamilyMemberNameField1.getText());
            
            if(addStudentFamilyMemberRelationshipField1.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Relationship 1 empty."); flagFieldsEmpty = true; }
            else{ familyInfo1.setRelationship(addStudentFamilyMemberRelationshipField1.getText()); }
            
            if(addStudentFamilyMemberAgeField1.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Age 1 empty."); flagFieldsEmpty = true; }
            else{ 
                if(appContainer.uiControl.isNumeric(addStudentFamilyMemberAgeField1.getText())){ familyInfo1.setAge(appContainer.uiControl.convertStringToInteger(addStudentFamilyMemberAgeField1.getText())); }
                else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,(addStudentFamilyMemberAge1.getText() + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT))); return false; }
            }
            
            if(addStudentFamilyMemberOccupationField1.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupation 1 empty."); flagFieldsEmpty = true; }
            else{ familyInfo1.setOccupation(addStudentFamilyMemberOccupationField1.getText()); }
            
            if(addStudentFamilyMemberOccupationalAddressField1.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupational Address 1 empty."); flagFieldsEmpty = true; }
            else{ familyInfo1.setOccupationalAddress(addStudentFamilyMemberOccupationalAddressField1.getText()); }
            
            if(addStudentFamilyMemberOccupationalTelNoField1.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupational Tel. No. 1 empty."); flagFieldsEmpty = true; }
            else{
                if(appContainer.uiControl.isNumeric(addStudentFamilyMemberOccupationalTelNoField1.getText())){ familyInfo1.setContactNumber(addStudentFamilyMemberOccupationalTelNoField1.getText()); }
                else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,(addStudentFamilyMemberOccupationalTelNo1.getText() + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT))); return false; }
            }
            
            if(addStudentFamilyMemberNameField2.getText() != null && !addStudentFamilyMemberNameField2.getText().isEmpty()){
                familyInfo2.setName(addStudentFamilyMemberNameField2.getText());
                
                if(addStudentFamilyMemberRelationshipField2.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Relationship 2 empty."); flagFieldsEmpty = true; }
                else{ familyInfo2.setRelationship(addStudentFamilyMemberRelationshipField2.getText()); }
                
                if(addStudentFamilyMemberAgeField2.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Age 2 empty."); flagFieldsEmpty = true; }
                else{
                    if(appContainer.uiControl.isNumeric(addStudentFamilyMemberAgeField2.getText())){ familyInfo2.setAge(appContainer.uiControl.convertStringToInteger(addStudentFamilyMemberAgeField2.getText())); }
                    else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,(addStudentFamilyMemberAge2.getText() + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT))); return false; }
                }
                
                if(addStudentFamilyMemberOccupationField2.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupation 2 empty."); flagFieldsEmpty = true; }
                else{ familyInfo2.setOccupation(addStudentFamilyMemberOccupationField2.getText()); }
                
                if(addStudentFamilyMemberOccupationalAddressField2.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupational Address 2 empty."); flagFieldsEmpty = true; }
                else{ familyInfo2.setOccupationalAddress(addStudentFamilyMemberOccupationalAddressField2.getText()); }
                
                if(addStudentFamilyMemberOccupationalTelNoField2.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupational Tel. No. 2 empty."); flagFieldsEmpty = true; }
                else{
                    if(appContainer.uiControl.isNumeric(addStudentFamilyMemberOccupationalTelNoField2.getText())){ familyInfo2.setContactNumber(addStudentFamilyMemberOccupationalTelNoField2.getText()); }
                    else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,(addStudentFamilyMemberOccupationalTelNo2.getText() + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT))); return false; }
                }
                
                if(addStudentFamilyMemberNameField3.getText() != null && !addStudentFamilyMemberNameField3.getText().isEmpty()){
                    familyInfo3.setName(addStudentFamilyMemberNameField3.getText());
                    
                    if(addStudentFamilyMemberRelationshipField3.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Relationship 3 empty."); flagFieldsEmpty = true; }
                    else{ familyInfo3.setRelationship(addStudentFamilyMemberRelationshipField3.getText()); }
                    
                    if(addStudentFamilyMemberAgeField3.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Age 3 empty."); flagFieldsEmpty = true; }
                    else{
                        if(appContainer.uiControl.isNumeric(addStudentFamilyMemberAgeField3.getText())){ familyInfo3.setAge(appContainer.uiControl.convertStringToInteger(addStudentFamilyMemberAgeField3.getText())); }
                        else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,(addStudentFamilyMemberAge3.getText() + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT))); return false; }
                    }
                    
                    if(addStudentFamilyMemberOccupationField3.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupation 3 empty."); flagFieldsEmpty = true; }
                    else{ familyInfo3.setOccupation(addStudentFamilyMemberOccupationField3.getText()); }
                    
                    if(addStudentFamilyMemberOccupationalAddressField3.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupational Address 3 empty."); flagFieldsEmpty = true; }
                    else{ familyInfo3.setOccupationalAddress(addStudentFamilyMemberOccupationalAddressField3.getText()); }
                    
                    if(addStudentFamilyMemberOccupationalTelNoField3.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupational Tel. No. 3 empty."); flagFieldsEmpty = true; }
                    else{
                        if(appContainer.uiControl.isNumeric(addStudentFamilyMemberOccupationalTelNoField3.getText())){ familyInfo3.setContactNumber(addStudentFamilyMemberOccupationalTelNoField3.getText()); }
                        else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,(addStudentFamilyMemberOccupationalTelNo3.getText() + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT))); return false; }
                    }
                    
                    if(addStudentFamilyMemberNameField4.getText() != null && !addStudentFamilyMemberNameField4.getText().isEmpty()){
                        familyInfo4.setName(addStudentFamilyMemberNameField4.getText());
                        
                        if(addStudentFamilyMemberRelationshipField4.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Relationship 4 empty."); flagFieldsEmpty = true; }
                        else{ familyInfo4.setRelationship(addStudentFamilyMemberRelationshipField4.getText()); }
                        
                        if(addStudentFamilyMemberAgeField4.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Age 4 empty."); flagFieldsEmpty = true; }
                        else{
                            if(appContainer.uiControl.isNumeric(addStudentFamilyMemberAgeField4.getText())){ familyInfo4.setAge(appContainer.uiControl.convertStringToInteger(addStudentFamilyMemberAgeField4.getText())); }
                            else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,(addStudentFamilyMemberAge4.getText() + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT))); return false; }
                        }
                        
                        if(addStudentFamilyMemberOccupationField4.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupation 4 empty."); flagFieldsEmpty = true; }
                        else{ familyInfo4.setOccupation(addStudentFamilyMemberOccupationField4.getText()); }
                        
                        if(addStudentFamilyMemberOccupationalAddressField4.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupational Address 4 empty."); flagFieldsEmpty = true; }
                        else{ familyInfo4.setOccupationalAddress(addStudentFamilyMemberOccupationalAddressField4.getText()); }
                        
                        if(addStudentFamilyMemberOccupationalTelNoField4.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupational Tel. No. 4 empty."); flagFieldsEmpty = true; }
                        else{
                            if(appContainer.uiControl.isNumeric(addStudentFamilyMemberOccupationalTelNoField4.getText())){ familyInfo4.setContactNumber(addStudentFamilyMemberOccupationalTelNoField4.getText()); }
                            else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,(addStudentFamilyMemberOccupationalTelNo4.getText() + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT))); return false; }
                        }
                        
                        if(addStudentFamilyMemberNameField5.getText() != null && !addStudentFamilyMemberNameField5.getText().isEmpty()){
                            familyInfo5.setName(addStudentFamilyMemberNameField5.getText());
                            
                            if(addStudentFamilyMemberRelationshipField5.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Relationship 5 empty."); flagFieldsEmpty = true; }
                            else{ familyInfo5.setRelationship(addStudentFamilyMemberRelationshipField5.getText()); }
                            
                            if(addStudentFamilyMemberAgeField5.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Age 5 empty."); flagFieldsEmpty = true; }
                            else{
                                if(appContainer.uiControl.isNumeric(addStudentFamilyMemberAgeField5.getText())){ familyInfo5.setAge(appContainer.uiControl.convertStringToInteger(addStudentFamilyMemberAgeField5.getText())); }
                                else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,(addStudentFamilyMemberAge5.getText() + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT))); return false; }
                            }
                            
                            if(addStudentFamilyMemberOccupationField5.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupation 5 empty."); flagFieldsEmpty = true; }
                            else{ familyInfo5.setOccupation(addStudentFamilyMemberOccupationField5.getText()); }
                            
                            if(addStudentFamilyMemberOccupationalAddressField5.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupational Address 5 empty."); flagFieldsEmpty = true; }
                            else{ familyInfo5.setOccupationalAddress(addStudentFamilyMemberOccupationalAddressField5.getText()); }
                            
                            if(addStudentFamilyMemberOccupationalTelNoField5.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupational Tel. No. 5 empty."); flagFieldsEmpty = true; }
                            else{
                                if(appContainer.uiControl.isNumeric(addStudentFamilyMemberOccupationalTelNoField5.getText())){ familyInfo5.setContactNumber(addStudentFamilyMemberOccupationalTelNoField5.getText()); }
                                else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,(addStudentFamilyMemberOccupationalTelNo5.getText() + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT))); return false; }
                            }
                            
                            if(addStudentFamilyMemberNameField6.getText() != null && !addStudentFamilyMemberNameField6.getText().isEmpty()){
                                familyInfo6.setName(addStudentFamilyMemberNameField6.getText());
                                
                                if(addStudentFamilyMemberRelationshipField6.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Relationship 6 empty."); flagFieldsEmpty = true; }
                                else{ familyInfo6.setRelationship(addStudentFamilyMemberRelationshipField6.getText()); }
                                
                                if(addStudentFamilyMemberAgeField6.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Age 6 empty."); flagFieldsEmpty = true; }
                                else{
                                    if(appContainer.uiControl.isNumeric(addStudentFamilyMemberAgeField6.getText())){ familyInfo6.setAge(appContainer.uiControl.convertStringToInteger(addStudentFamilyMemberAgeField6.getText())); }
                                    else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,(addStudentFamilyMemberAge6.getText() + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT))); return false; }
                                }
                                
                                if(addStudentFamilyMemberOccupationField6.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupation 6 empty."); flagFieldsEmpty = true; }
                                else{ familyInfo6.setOccupation(addStudentFamilyMemberOccupationField6.getText()); }
                                
                                if(addStudentFamilyMemberOccupationalAddressField6.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupational Address 6 empty."); flagFieldsEmpty = true; }
                                else{ familyInfo6.setOccupationalAddress(addStudentFamilyMemberOccupationalAddressField6.getText()); }
                                
                                if(addStudentFamilyMemberOccupationalTelNoField6.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Occupational Tel. No. 6 empty."); flagFieldsEmpty = true; }
                                else{
                                    if(appContainer.uiControl.isNumeric(addStudentFamilyMemberOccupationalTelNoField6.getText())){ familyInfo6.setContactNumber(addStudentFamilyMemberOccupationalTelNoField6.getText()); }
                                    else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,(addStudentFamilyMemberOccupationalTelNo6.getText() + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT))); return false; }
                                }
                            }
                        }
                    }
                }
            }
        } else { flagFieldsEmpty = true; }
        
        if(addStudentReferenceNoField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Reference No. field empty."); flagFieldsEmpty = true; }
        else{
            if(validateReferenceNo(addStudentReferenceNoField.getText())){ student.setReferenceNumber(addStudentReferenceNoField.getText()); }
            else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,(addStudentReferenceNo.getText() + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT))); return false; }
        }
        
        if(addStudentEnrollmentNoField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Enrollment No. field empty."); flagFieldsEmpty = true; }
        else{
            if(validateEnrollmentNo(addStudentEnrollmentNoField.getText())){ student.setEnrollmentNumber(addStudentEnrollmentNoField.getText()); }
            else{ appContainer.uiControl.alert(UIControl.alertType.WARNING,(addStudentEnrollmentNo.getText() + " " + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT))); return false; }
        }
        
        if(addStudentPlaceField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Place empty."); appContainer.uiControl.alert(UIControl.alertType.WARNING_FIELD_IS_EMPTY,appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_PLACE)); return false; }
        else{ student.setPlace(addStudentPlaceField.getText()); }
        
        if(addStudentDateDatePicker.getValue() == null){ System.err.println("AddController | validateStudentForm | Student form date is empty."); appContainer.uiControl.alert(UIControl.alertType.WARNING_FIELD_IS_EMPTY, (appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_DATE))); return false; }
        else{ student.setDate(addStudentDateDatePicker.getValue().toString()); }

        if(flagFieldsEmpty){ 
            if(appContainer.uiControl.alert(UIControl.alertType.CONFIRMATION_FIELD_IS_EMPTY,addStudentFirstName.getText())){ return true; }
            else{ System.out.println("AddController | validateStudentForm | Please fill up the remaining fields before saving."); return false; }
        } else { return true; }
    }
    
    private boolean validateEmail(String value){
        System.out.println("AddController | validateEmail | value: " + value);
        String emailPattern = "(.)(.*)([@])(.)(.*)([.])(.)(.*)";
        Pattern p = Pattern.compile(emailPattern);
        
        Matcher m = p.matcher(value);
        if(m.find()){ return true; }
        return false;
    }
    
    private boolean validateReferenceNo(String value){
        System.out.println("AddController | validateReferenceNo");
        String referenceNoPattern = "(^\\D\\d{10}$)";
        Pattern p = Pattern.compile(referenceNoPattern);
        Matcher m = p.matcher(value);
        
        if(m.find()){ return true; }
        return false;
    }
    
    private boolean validateEnrollmentNo(String value){
        System.out.println("AddController | validateEnrollmentNo | value: " + value);
        String enrollmentNoPattern = "(^\\d{12}$)";
        Pattern p = Pattern.compile(enrollmentNoPattern);
        Matcher m = p.matcher(value);
        
        if(m.find()){ return true; }
        return false;
    }
    
    private void setAddScreenMenuLabels(){
        appContainer.setHeaderText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_ADD_TITLE));
        
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
        appContainer.setHeaderText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.HEADER_ADD_STUDENT_TITLE));
        
        addBackButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BACK));
        addSaveButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.SAVE));
        addStudentPhotoButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_PHOTO));
        
        addStudentPersonalDetails.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_PERSONAL_DETAILS));
        addStudentFirstName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FIRST_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentMiddleName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_MIDDLE_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentLastName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_LAST_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentAddress.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_ADDRESS) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentEmail.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMAIL) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentDOB.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_DATE_OF_BIRTH) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentPlaceOfBirth.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_PLACE_OF_BIRTH) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentReligion.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_RELIGION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentOtherReligion.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_OTHER_RELIGION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentEducationalBackground.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EDUCATIONAL_BACKGROUND) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentLanguages.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_LANGUAGES) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentHobbies.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_HOBBIES) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        
        addStudentEmergencyContact.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT));
        addStudentEmergencyContactPerson.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT_PERSON) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentEmergencyContactTelNo.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT_TEL_NO) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        
        addStudentFamilyDetails.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_DETAILS));
        addStudentFamilyMemberName1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberAge1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberRelationship1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupation1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupationalAddress1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupationalTelNo1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        
        addStudentFamilyMemberName2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberAge2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberRelationship2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupation2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupationalAddress2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupationalTelNo2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        
        addStudentFamilyMemberName3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberAge3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberRelationship3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupation3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupationalAddress3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupationalTelNo3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        
        addStudentFamilyMemberName4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberAge4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberRelationship4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupation4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupationalAddress4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupationalTelNo4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        
        addStudentFamilyMemberName5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberAge5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberRelationship5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupation5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupationalAddress5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupationalTelNo5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        
        addStudentFamilyMemberName6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberAge6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberRelationship6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupation6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupationalAddress6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentFamilyMemberOccupationalTelNo6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        
        addStudentOfficeUseOnly.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_OFFICE_USE_ONLY));
        addStudentReferenceNo.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_REFERENCE_NUMBER) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentEnrollmentNo.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_ENROLLMENT_NUMBER) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentPlace.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_PLACE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        addStudentDate.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_DATE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_SEPERATOR));
        
        addHelpHeader.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.HELP));
        addStudentHelpBody.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.HELP_ADD_STUDENT));
    }
    
    private void setAddTeacherScreenLabels(){
        addTeacherPersonalDetails.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_TEACHER_PERSONAL_DETAILS));
        addTeacherEmergencyContact.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_TEACHER_EMERGENCY_CONTACT));
        addTeacherOfficeUseOnly.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_TEACHER_OFFICE_USE_ONLY));
        
        addTeacherFirstName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_TEACHER_FIRST_NAME));
        addTeacherMiddleName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_TEACHER_MIDDLE_NAME));
        addTeacherLastName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_TEACHER_LAST_NAME));
        addTeacherAddress.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_TEACHER_ADDRESS));
        addTeacherEmail.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_TEACHER_EMAIL));
        addTeacherDOB.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_TEACHER_DATE_OF_BIRTH));
    }
}
