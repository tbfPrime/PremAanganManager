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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
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
    private String photoFileExtension = "";
   
    // FXML fields
    // Add
    @FXML
    private Button addStudentButton, addTeacherButton, addBatchButton, addClassButton, addCourseButton, addSubjectButton, addTimetableButton, addAttendanceButton;
    
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
    private Text addStudentEnrollmentNo, addStudentPlace, addStudentDate, addStudentPhoto, addStudentPersonalDetails, addStudentOfficeUseOnly, addStudentFamilyDetails, addStudentEmergencyContact;
    
    @FXML
    private TextField addStudentFirstNameField, addStudentMiddleNameField, addStudentLastNameField, addStudentAddressField, addStudentEmailField, addStudentPlaceOfBirthField;
    @FXML
    private TextField addStudentFirstOtherReligionField, addStudentEmergencyContactPersonField, addStudentEmergencyContactTelNoField, addStudentEducationalBackgroundField, addStudentLanguagesField, addStudentHobbiesField;
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
    private TextField addStudentEnrollmentNoField, addStudentPlaceField;
    
    @FXML
    private DatePicker addStudentDOBDatePicker, addStudentDateDatePicker;
    
    @FXML 
    private ComboBox addStudentReligionComboBox, addStudentCourseComboBox;
    
    @FXML 
    private ImageView addStudentPhotoView;

    @FXML
    private Button addStudentBackButton, addStudentSaveButton, addStudentPhotoButton;
    
    @FXML
    private HBox addStudentPersonalDetailsHBox, addStudentOfficeUseOnlyHBox, addStudentFamilyDetailsHBox, addStudentEmergencyContactHBox;
    
    // FXML methods
    // Add
    @FXML
    private void addStudentButtonAction(){
        appContainer.displayScreen(AppContainer.screenTag.ADD_STUDENT);
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
            setAddScreenMenuLabels();
            return addBase;
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setAddScreenMenu | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public AnchorPane setAddStudentScreen(){
        try {
            student = new Student();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/AddStudent.fxml"));
            loader.setController(this);
            AnchorPane addBase = loader.load();
            setDefaultStudentPhotoView();
            setAddStudentPropertyID();
            addBase.getStylesheets().add(AddController.class.getResource("AddStudent.css").toExternalForm());
            setAddStudentScreenLabels();
            return addBase;
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setAddStudentScreen | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    // Private Functions
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
            if(appContainer.uiControl.uiModel.saveStudentForm(student)){
                System.out.println("AddController | saveStudentRecord | Value of Student ID: " + student.getStudentId());
                savePhotoFile();
                String alertStudentName = addStudentFirstNameField.getText() + (addStudentMiddleNameField.getText().isEmpty() ? "" : " " + addStudentMiddleNameField.getText()) + (addStudentLastNameField.getText().isEmpty() ? "" : " " + addStudentLastNameField.getText());
                if(appContainer.uiControl.alert(UIControl.alertType.INFO, appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ALERT_MESSAGE_STUDENT_SAVE_SUCCESS).replace("?", alertStudentName))){ addStudentBackAction(); }
                else{ addStudentBackAction(); }
            }else{ appContainer.uiControl.alert(UIControl.alertType.ERROR_SAVE, ""); }
        }
        else{ System.out.println("AddController | saveStudentRecord | Validation of student form failed. Exiting without saving."); }
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

    private boolean validateStudentForm(){
        System.out.println("AddController | validateStudentForm");
        
        boolean flagFieldsEmpty = false;
        
        if(addStudentFirstNameField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | FirstName empty."); appContainer.uiControl.alert(UIControl.alertType.WARNING_FIELD_IS_EMPTY,appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FIRST_NAME)); return false; }
        else{ student.setFirstName(addStudentFirstNameField.getText()); }
        
        if(addStudentMiddleNameField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | MiddleName empty."); flagFieldsEmpty = true; }
        else{ student.setMiddleName(addStudentMiddleNameField.getText()); }
        
        if(addStudentLastNameField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | LastName empty."); flagFieldsEmpty = true; }
        else{ student.setLastName(addStudentLastNameField.getText()); }
        
        if(addStudentAddressField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | Address empty."); flagFieldsEmpty = true; }
        else{ student.setAddress(addStudentAddressField.getText()); }
        
        if(addStudentEmail.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | E-Mail empty."); flagFieldsEmpty = true; } // Validate for email format
        else{ student.setEmailId(addStudentEmail.getText()); }
        
        if(addStudentDOBDatePicker.getValue() == null){ System.out.println("AddController | validateStudentForm | DOB empty."); flagFieldsEmpty = true; } // Validate for Date format
        else{ student.setDob(addStudentDOBDatePicker.getValue().toString()); }
        
        
//        student.setPlaceOfBirth(addStudentPlaceOfBirthField.getText());
//        student.setEducationalBackground(addStudentEducationalBackgroundField.getText());
//        student.setLanguages(addStudentLanguagesField.getText());
//        student.setHobbies(addStudentHobbiesField.getText());
//        
//        student.setEmergencyContactPerson(addStudentEmergencyContactPersonField.getText());
//        student.setEmergencyContactNumber(Integer.parseInt(addStudentEmergencyContactTelNoField.getText()));
//        

        if(flagFieldsEmpty){ 
            if(appContainer.uiControl.alert(UIControl.alertType.CONFIRMATION_FIELD_IS_EMPTY,addStudentFirstName.getText())){ return true; }
            else{ System.out.println("AddController | validateStudentForm | Please fill up the remaining fields before saving."); return false; }
        } else { return true; }
//        
//        System.out.println(
//                "-------" + "\n" +
//                "Student firstName: " + student.getFirstName() + "\n" + 
//                "Student middleName: " + student.getMiddleName() + "\n" + 
//                "Student lastName: " + student.getLastName() + "\n" + 
//                "Student DOB: " + student.getDob() + "\n" + 
//                "-------"
//        );
//        
//        return true;
    }
    
    private void setAddStudentPropertyID(){
        addStudentPersonalDetailsHBox.setId("BasicInfoHBox");
        addStudentEmergencyContactHBox.setId("BasicInfoHBox");
        addStudentFamilyDetailsHBox.setId("BasicInfoHBox");
        addStudentOfficeUseOnlyHBox.setId("BasicInfoHBox");
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
        addStudentPhotoButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_PASSPORT_PHOTO));
        
        addStudentPersonalDetails.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_PERSONAL_DETAILS));
        addStudentFirstName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FIRST_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentMiddleName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_MIDDLE_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentLastName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_LAST_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentAddress.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_ADDRESS) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentEmail.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMAIL) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentDOB.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_DATE_OF_BIRTH) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentPlaceOfBirth.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_PLACE_OF_BIRTH) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentReligion.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_RELIGION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentOtherReligion.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_OTHER_RELIGION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentEducationalBackground.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EDUCATIONAL_BACKGROUND) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentLanguages.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_LANGUAGES) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentHobbies.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_HOBBIES) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        
        addStudentEmergencyContact.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT));
        addStudentEmergencyContactPerson.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT_PERSON) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentEmergencyContactTelNo.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT_TEL_NO) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        
        addStudentFamilyDetails.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_DETAILS));
        addStudentFamilyMemberName1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberAge1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberRelationship1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupation1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupationalAddress1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupationalTelNo1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        
        addStudentFamilyMemberName2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberAge2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberRelationship2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupation2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupationalAddress2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupationalTelNo2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        
        addStudentFamilyMemberName3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberAge3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberRelationship3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupation3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupationalAddress3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupationalTelNo3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        
        addStudentFamilyMemberName4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberAge4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberRelationship4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupation4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupationalAddress4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupationalTelNo4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        
        addStudentFamilyMemberName5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberAge5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberRelationship5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupation5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupationalAddress5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupationalTelNo5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        
        addStudentFamilyMemberName6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberAge6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberRelationship6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupation6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupationalAddress6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentFamilyMemberOccupationalTelNo6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        
        addStudentOfficeUseOnly.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_OFFICE_USE_ONLY));
        addStudentEnrollmentNo.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_ENROLLMENT_NUMBER) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentPlace.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_PLACE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
        addStudentDate.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_DATE) + appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.LABEL_END));
    }
}
