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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import premaanganmanager.base.controller.background.Student;
import premaanganmanager.base.controller.ui.UIControl;
import premaanganmanager.configurable.Labels;

/**
 *
 * @author Trevor Fernandes
 */
public class AddController {
    
    private AppContainer appContainer;
   
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
    private Button addStudentBackButton, addStudentSaveButton;
    
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
        appContainer.displayScreen(AppContainer.screenTag.ADD);
    }
    @FXML
    private void addStudentSaveAction(){
        System.out.println("AddController | addStudentSaveAction");
        saveStudentRecord();
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/AddStudent.fxml"));
            loader.setController(this);
            AnchorPane addBase = loader.load();
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
    private void saveStudentRecord(){
        System.out.println("AddController | saveStudentRecord");
        Student student = new Student();
        
        if(validateStudentForm(student)){ appContainer.uiControl.uiModel.saveStudentForm(student); }
        else{ System.out.println("AddController | saveStudentRecord | Validation of student form failed. Exiting without saving."); }
    }

    private boolean validateStudentForm(Student student){
        System.out.println("AddController | validateStudentForm");
        
        boolean flagFieldsEmpty = false;
        
        if(addStudentFirstNameField.getText().isEmpty()){ System.out.println("AddController | validateStudentForm | FirstName empty."); appContainer.uiControl.alert(UIControl.alertType.WARNING_FIELD_IS_EMPTY,addStudentFirstName.getText()); return false; }
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
        }
        
        System.out.println(
                "-------" + "\n" +
                "Student firstName: " + student.getFirstName() + "\n" + 
                "Student middleName: " + student.getMiddleName() + "\n" + 
                "Student lastName: " + student.getLastName() + "\n" + 
                "Student DOB: " + student.getDob() + "\n" + 
                "-------"
        );
        
        return true;
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
        
        addStudentPersonalDetails.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_PERSONAL_DETAILS));
        addStudentFirstName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FIRST_NAME));
        addStudentMiddleName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_MIDDLE_NAME));
        addStudentLastName.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_LAST_NAME));
        addStudentAddress.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_ADDRESS));
        addStudentEmail.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMAIL));
        addStudentDOB.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_DATE_OF_BIRTH));
        addStudentPlaceOfBirth.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_PLACE_OF_BIRTH));
        addStudentReligion.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_RELIGION));
        addStudentOtherReligion.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_OTHER_RELIGION));
        addStudentEducationalBackground.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EDUCATIONAL_BACKGROUND));
        addStudentLanguages.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_LANGUAGES));
        addStudentHobbies.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_HOBBIES));
        addStudentEmergencyContact.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT));
        addStudentEmergencyContactPerson.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT_PERSON));
        addStudentEmergencyContactTelNo.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT_TEL_NO));
        addStudentFamilyDetails.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_DETAILS));
        
        addStudentFamilyMemberName1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME));
        addStudentFamilyMemberAge1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE));
        addStudentFamilyMemberRelationship1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP));
        addStudentFamilyMemberOccupation1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION));
        addStudentFamilyMemberOccupationalAddress1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS));
        addStudentFamilyMemberOccupationalTelNo1.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO));
        
        addStudentFamilyMemberName2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME));
        addStudentFamilyMemberAge2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE));
        addStudentFamilyMemberRelationship2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP));
        addStudentFamilyMemberOccupation2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION));
        addStudentFamilyMemberOccupationalAddress2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS));
        addStudentFamilyMemberOccupationalTelNo2.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO));
        
        addStudentFamilyMemberName3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME));
        addStudentFamilyMemberAge3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE));
        addStudentFamilyMemberRelationship3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP));
        addStudentFamilyMemberOccupation3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION));
        addStudentFamilyMemberOccupationalAddress3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS));
        addStudentFamilyMemberOccupationalTelNo3.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO));
        
        addStudentFamilyMemberName4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME));
        addStudentFamilyMemberAge4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE));
        addStudentFamilyMemberRelationship4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP));
        addStudentFamilyMemberOccupation4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION));
        addStudentFamilyMemberOccupationalAddress4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS));
        addStudentFamilyMemberOccupationalTelNo4.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO));
        
        addStudentFamilyMemberName5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME));
        addStudentFamilyMemberAge5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE));
        addStudentFamilyMemberRelationship5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP));
        addStudentFamilyMemberOccupation5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION));
        addStudentFamilyMemberOccupationalAddress5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS));
        addStudentFamilyMemberOccupationalTelNo5.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO));
        
        addStudentFamilyMemberName6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME));
        addStudentFamilyMemberAge6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE));
        addStudentFamilyMemberRelationship6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP));
        addStudentFamilyMemberOccupation6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION));
        addStudentFamilyMemberOccupationalAddress6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS));
        addStudentFamilyMemberOccupationalTelNo6.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO));
        
        addStudentOfficeUseOnly.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_OFFICE_USE_ONLY));
        addStudentEnrollmentNo.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_ENROLLMENT_NUMBER));
        addStudentPlace.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_PLACE));
        addStudentDate.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_DATE));
    }
}
