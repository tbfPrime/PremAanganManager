/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import premaanganmanager.base.controller.UIModel;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Labels;
import premaanganmanager.configurable.LocalUtility;
import premaanganmanager.configurable.Settings;
import premaanganmanager.configurable.entity.FamilyInfo;
import premaanganmanager.configurable.entity.Religion;
import premaanganmanager.configurable.entity.Student;
import premaanganmanager.configurable.scenes.ManagerScene;

/**
 *
 * @author TBF
 */
public class AddStudentScreen extends AddScreen {
    private Student student;
    private Religion religion;
    private FamilyInfo familyInfo1;
    private FamilyInfo familyInfo2;
    private FamilyInfo familyInfo3;
    private FamilyInfo familyInfo4;
    private FamilyInfo familyInfo5;
    private FamilyInfo familyInfo6;
    
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
    
    @FXML
    private ScrollPane addStudentScrollPane;
    
    // Help Student
    @FXML
    private Text addStudentHelpBody;
    
    public AddStudentScreen(ManagerScene managerScene){
        super(managerScene);
    }
    
    @Override
    public FXMLLoader getContent(){
        Utility.log("AddStudentScreen | getContent");
        FXMLLoader content = new FXMLLoader(Utility.getPathFXML("AddStudent.fxml"));
        content.setController(this);
        return content;
    }
    @Override
    public void initializeScreen(){
        Utility.log("AddStudentScreen | initializeScreen");
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
        setPhotoView(addStudentPhotoView,Paths.get(Settings.getPlaceHolderDir(),Settings.getPlaceHolderStudentPhoto()));
        setLabels();
        setID();
    }
    @Override
    public void back(){
        Utility.log("AddStudentScreen | back");
        if(!managerScene.getSceneContainer().isUserDataSaved()){ return; }
        managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD);;
    }
    @Override
    public void save(){
        Utility.log("AddStudentScreen | save");
        saveStudentRecord();
    }
    @Override
    public void flushScreenData(){
        if(photoFileExtension.isEmpty()){ Utility.log("AddStudentScreen | flushScreenData | No Photo File to flush."); }
        else{
            Path tempPhotoFilePath = Paths.get(Settings.getPhotoDir(),(Settings.getTempPhotoFilename() + "." + photoFileExtension));
            File tempPhotoFile = new File(tempPhotoFilePath.toAbsolutePath().toString());
            if(tempPhotoFile.exists()){ tempPhotoFile.delete(); }
        }
        addStudentFirstNameField.clear();
        addStudentMiddleNameField.clear();
        addStudentLastNameField.clear();
        addStudentPlaceField.clear();
        addStudentDateDatePicker.setValue(null);
    } 
    
    // private methods
    @FXML
    private void addStudentPhotoAction(){
        Utility.log("AddStudentScreen | addStudentPhotoAction");
        setPhotoView(addStudentPhotoView,getPhotoPath());
    }
    @FXML
    private void addStudentDOBAction(){
        Utility.log("AddStudentScreen | addStudentDOBAction");
        if(addStudentDOBDatePicker.getValue() != null){
            if(!LocalUtility.validateDOB(new DatePicker().getChronology().date(addStudentDOBDatePicker.getValue().getYear(), addStudentDOBDatePicker.getValue().getMonthValue(), addStudentDOBDatePicker.getValue().getDayOfMonth()))){
                LocalUtility.alertWarning(Labels.labelTag.ALERT_MESSAGE_DOB_FORMAT_INCORRECT.getLabel());
                addStudentDOBDatePicker.getEditor().clear();
            }
        } else{ Utility.errorLog("AddController | addStudentDOBAction | No Value set in DatePicker to take action."); }
    }
    @FXML
    private void addStudentReligionAction(){
        Utility.log("AddStudentScreen | addStudentReligionAction | value: " + addStudentReligionComboBox.getValue());
        addStudentOtherReligionField.setDisable(true);
        if(addStudentReligionComboBox.getValue().toString().equalsIgnoreCase(Labels.labelTag.ADD_NEW_RELIGION.getLabel())){
            addStudentOtherReligionField.setDisable(false);
        } else{ religion.setReligionId(getReligionID()); }
    }
    private void saveStudentRecord(){
        Utility.log("AddStudentScreen | saveStudentRecord");
        if(validateStudentForm()){
            if(saveReligionRecord() && new UIModel().saveStudentForm(student) && saveFamilyInfo()){
                Utility.log("AddStudentScreen | saveStudentRecord | Value of Student ID: " + student.getStudentId());
                savePhotoFile(Labels.labelTag.LABEL_STUDENT_PHOTO_PREFIX.getLabel() + student.getStudentId());
                String alertStudentName = addStudentFirstNameField.getText() + (addStudentMiddleNameField.getText().isEmpty() ? "" : " " + addStudentMiddleNameField.getText()) + (addStudentLastNameField.getText().isEmpty() ? "" : " " + addStudentLastNameField.getText());
                if(LocalUtility.alertInfo(Labels.labelTag.ALERT_MESSAGE_STUDENT_SAVE_SUCCESS.getLabel().replace("?", alertStudentName))){ Utility.log("AddStudentScreen | exiting after data saved. Ok selected."); }
                else{ Utility.log("AddStudentScreen | exiting after data saved. Cancel selected."); }
                flushScreenData();
                back();
            } else{ LocalUtility.alertErrorSave(); }
        } else{ Utility.log("AddStudentScreen | saveStudentRecord | Validation of student form failed. Exiting without saving."); }
    }
    private boolean saveReligionRecord(){
        Utility.log("AddStudentScreen | saveReligionRecord");
        if(addStudentOtherReligionField.isDisabled()){
            if(addStudentReligionComboBox.getValue() == null || addStudentReligionComboBox.getValue().toString().isEmpty()){ Utility.log("AddController | saveReligionRecord | No religion selected. Exiting."); }
            else{ 
                Utility.log("AddStudentScreen | saveReligionRecord | Saving religion id: " +  getReligionID() + " to student object."); 
                student.setReligionId(getReligionID());
            }
        } else{
            if(addStudentOtherReligionField.getText().isEmpty()){ Utility.log("AddController | saveReligionRecord | No value to save from Other Religion field. Exiting"); }
            else{ 
                Utility.log("AddStudentScreen | saveReligionRecord | Value of addStudentOtherReligionField: " + addStudentOtherReligionField.getText());
                religion.setReligionName(addStudentOtherReligionField.getText()); 
                if(new UIModel().saveReligion(religion)){ 
                    Utility.log("AddStudentScreen | saveReligionRecord | New Religion saved successfully."); 
                    student.setReligionId(religion.getReligionId());
                } else{ Utility.log("AddStudentScreen | saveReligionRecord | Error saving new religion record. Exiting"); return false; }
            }
        }
        return true;
    }
    private boolean saveFamilyInfo(){
        if(familyInfo1.getName() != null){
            if(!new UIModel().saveStudentFamilyInfo(familyInfo1, student)){ Utility.errorLog("AddStudentScreen | saveFamilyInfo | Error saving family info 1. Exiting."); return false; }
            
            if(familyInfo2.getName() != null){
                if(!new UIModel().saveStudentFamilyInfo(familyInfo2, student)){ Utility.errorLog("AddStudentScreen | saveFamilyInfo | Error saving family info 2. Exiting."); return false; }
                    
                if(familyInfo3.getName() != null){
                    if(!new UIModel().saveStudentFamilyInfo(familyInfo3, student)){ Utility.errorLog("AddStudentScreen | saveFamilyInfo | Error saving family info 3. Exiting."); return false; }
                    
                    if(familyInfo4.getName() != null){
                        if(!new UIModel().saveStudentFamilyInfo(familyInfo4, student)){ Utility.errorLog("AddStudentScreen | saveFamilyInfo | Error saving family info 4. Exiting."); return false; }
                        
                        if(familyInfo5.getName() != null){
                            if(!new UIModel().saveStudentFamilyInfo(familyInfo5, student)){ Utility.errorLog("AddStudentScreen | saveFamilyInfo | Error saving family info 5. Exiting."); return false; }
                            
                            if(familyInfo6.getName() != null){
                                if(!new UIModel().saveStudentFamilyInfo(familyInfo6, student)){ Utility.errorLog("AddStudentScreen | saveFamilyInfo | Error saving family info 6. Exiting."); return false; }
                            }
                        }
                    }
                }
            }
        } else { Utility.errorLog("AddStudentScreen | saveFamilyInfo | No family info to save."); }
        return true;
    }
    private boolean validateStudentForm(){
        Utility.log("AddStudentScreen | validateStudentForm");
        
        boolean flagFieldsEmpty = false;
        
        if(addStudentFirstNameField.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | FirstName empty."); LocalUtility.alertWarningFieldIsEmpty(Labels.labelTag.ADD_STUDENT_FIRST_NAME.getLabel()); return false; }
        else{ student.setFirstName(addStudentFirstNameField.getText()); }
        
        if(addStudentMiddleNameField.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | MiddleName empty."); flagFieldsEmpty = true; }
        else{ student.setMiddleName(addStudentMiddleNameField.getText()); }
        
        if(addStudentLastNameField.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | LastName empty."); flagFieldsEmpty = true; }
        else{ student.setLastName(addStudentLastNameField.getText()); }

        if(photoFileExtension.isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | DOB empty."); flagFieldsEmpty = true; }
        else{ student.setStudentPhotoId(photoFileExtension); }
        
        if(addStudentAddressField.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Address empty."); flagFieldsEmpty = true; }
        else{ student.setAddress(addStudentAddressField.getText()); }
        
        if(addStudentEmailField.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | E-Mail empty."); flagFieldsEmpty = true; } 
        else{ 
            if(LocalUtility.validateEmail(addStudentEmailField.getText())){ student.setEmailId(addStudentEmailField.getText()); }
            else{ LocalUtility.alertWarning(Labels.labelTag.ALERT_MESSAGE_EMAIL_FORMAT_INCORRECT.getLabel()); return false; }
        }
        
        if(addStudentDOBDatePicker.getValue() == null){ Utility.log("AddStudentScreen | validateStudentForm | DOB empty."); flagFieldsEmpty = true; } 
        else{ 
            if(!LocalUtility.validateDOB(new DatePicker().getChronology().date(addStudentDOBDatePicker.getValue().getYear(), addStudentDOBDatePicker.getValue().getMonthValue(), addStudentDOBDatePicker.getValue().getDayOfMonth()))){
                LocalUtility.alertWarning(Labels.labelTag.ALERT_MESSAGE_DOB_FORMAT_INCORRECT.getLabel());
                LocalUtility.ensureVisible(addStudentScrollPane, addStudentDOBDatePicker);
                return false;
            } else{ student.setDob(addStudentDOBDatePicker.getValue().toString()); }
        }
        
        if(addStudentPlaceOfBirthField.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Place of Birth empty."); flagFieldsEmpty = true; }
        else{ student.setPlaceOfBirth(addStudentPlaceOfBirthField.getText()); }
        
        if(religion.getReligionId() == null){ Utility.log("AddStudentScreen | validateStudentForm | No religion selected from list. Trying to save from Other religion."); flagFieldsEmpty = true; }
        else{ student.setReligionId(religion.getReligionId()); }
        
        if(addStudentEducationalBackgroundField.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Educational Background empty."); flagFieldsEmpty = true; }
        else{ student.setEducationalBackground(addStudentEducationalBackgroundField.getText()); }

        if(addStudentLanguagesField.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Languages empty."); flagFieldsEmpty = true; }
        else{ student.setLanguages(addStudentLanguagesField.getText()); }
        
        if(addStudentHobbiesField.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Hobbies empty."); flagFieldsEmpty = true; }
        else{ student.setHobbies(addStudentHobbiesField.getText()); }
        
        if(addStudentEmergencyContactPersonField.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Emergency Contact Person empty."); flagFieldsEmpty = true; }
        else{ 
            student.setEmergencyContactPerson(addStudentEmergencyContactPersonField.getText());
            
            if(addStudentEmergencyContactTelNoField.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Place of Birth empty."); flagFieldsEmpty = true; }
            else{ 
                if(LocalUtility.validateNumeric(addStudentEmergencyContactTelNoField.getText())){ student.setEmergencyContactNumber(addStudentEmergencyContactTelNoField.getText()); }
                else{ LocalUtility.alertWarning((addStudentEmergencyContactTelNo.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel())); return false; }
            }
        }
        
        if(addStudentFamilyMemberNameField1.getText() != null && !addStudentFamilyMemberNameField1.getText().isEmpty()){
            familyInfo1.setName(addStudentFamilyMemberNameField1.getText());
            
            if(addStudentFamilyMemberRelationshipField1.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Relationship 1 empty."); flagFieldsEmpty = true; }
            else{ familyInfo1.setRelationship(addStudentFamilyMemberRelationshipField1.getText()); }
            
            if(addStudentFamilyMemberAgeField1.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Age 1 empty."); flagFieldsEmpty = true; }
            else{ 
                if(LocalUtility.validateNumeric(addStudentFamilyMemberAgeField1.getText())){ familyInfo1.setAge(LocalUtility.convertStringToInteger(addStudentFamilyMemberAgeField1.getText())); }
                else{ LocalUtility.alertWarning(addStudentFamilyMemberAge1.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
            }
            
            if(addStudentFamilyMemberOccupationField1.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupation 1 empty."); flagFieldsEmpty = true; }
            else{ familyInfo1.setOccupation(addStudentFamilyMemberOccupationField1.getText()); }
            
            if(addStudentFamilyMemberOccupationalAddressField1.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupational Address 1 empty."); flagFieldsEmpty = true; }
            else{ familyInfo1.setOccupationalAddress(addStudentFamilyMemberOccupationalAddressField1.getText()); }
            
            if(addStudentFamilyMemberOccupationalTelNoField1.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupational Tel. No. 1 empty."); flagFieldsEmpty = true; }
            else{
                if(LocalUtility.validateNumeric(addStudentFamilyMemberOccupationalTelNoField1.getText())){ familyInfo1.setContactNumber(addStudentFamilyMemberOccupationalTelNoField1.getText()); }
                else{ LocalUtility.alertWarning(addStudentFamilyMemberOccupationalTelNo1.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
            }
            
            if(addStudentFamilyMemberNameField2.getText() != null && !addStudentFamilyMemberNameField2.getText().isEmpty()){
                familyInfo2.setName(addStudentFamilyMemberNameField2.getText());
                
                if(addStudentFamilyMemberRelationshipField2.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Relationship 2 empty."); flagFieldsEmpty = true; }
                else{ familyInfo2.setRelationship(addStudentFamilyMemberRelationshipField2.getText()); }
                
                if(addStudentFamilyMemberAgeField2.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Age 2 empty."); flagFieldsEmpty = true; }
                else{
                    if(LocalUtility.validateNumeric(addStudentFamilyMemberAgeField2.getText())){ familyInfo2.setAge(LocalUtility.convertStringToInteger(addStudentFamilyMemberAgeField2.getText())); }
                    else{ LocalUtility.alertWarning(addStudentFamilyMemberAge2.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
                }
                
                if(addStudentFamilyMemberOccupationField2.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupation 2 empty."); flagFieldsEmpty = true; }
                else{ familyInfo2.setOccupation(addStudentFamilyMemberOccupationField2.getText()); }
                
                if(addStudentFamilyMemberOccupationalAddressField2.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupational Address 2 empty."); flagFieldsEmpty = true; }
                else{ familyInfo2.setOccupationalAddress(addStudentFamilyMemberOccupationalAddressField2.getText()); }
                
                if(addStudentFamilyMemberOccupationalTelNoField2.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupational Tel. No. 2 empty."); flagFieldsEmpty = true; }
                else{
                    if(LocalUtility.validateNumeric(addStudentFamilyMemberOccupationalTelNoField2.getText())){ familyInfo2.setContactNumber(addStudentFamilyMemberOccupationalTelNoField2.getText()); }
                    else{ LocalUtility.alertWarning(addStudentFamilyMemberOccupationalTelNo2.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
                }
                
                if(addStudentFamilyMemberNameField3.getText() != null && !addStudentFamilyMemberNameField3.getText().isEmpty()){
                    familyInfo3.setName(addStudentFamilyMemberNameField3.getText());
                    
                    if(addStudentFamilyMemberRelationshipField3.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Relationship 3 empty."); flagFieldsEmpty = true; }
                    else{ familyInfo3.setRelationship(addStudentFamilyMemberRelationshipField3.getText()); }
                    
                    if(addStudentFamilyMemberAgeField3.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Age 3 empty."); flagFieldsEmpty = true; }
                    else{
                        if(LocalUtility.validateNumeric(addStudentFamilyMemberAgeField3.getText())){ familyInfo3.setAge(LocalUtility.convertStringToInteger(addStudentFamilyMemberAgeField3.getText())); }
                        else{ LocalUtility.alertWarning(addStudentFamilyMemberAge3.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
                    }
                    
                    if(addStudentFamilyMemberOccupationField3.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupation 3 empty."); flagFieldsEmpty = true; }
                    else{ familyInfo3.setOccupation(addStudentFamilyMemberOccupationField3.getText()); }
                    
                    if(addStudentFamilyMemberOccupationalAddressField3.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupational Address 3 empty."); flagFieldsEmpty = true; }
                    else{ familyInfo3.setOccupationalAddress(addStudentFamilyMemberOccupationalAddressField3.getText()); }
                    
                    if(addStudentFamilyMemberOccupationalTelNoField3.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupational Tel. No. 3 empty."); flagFieldsEmpty = true; }
                    else{
                        if(LocalUtility.validateNumeric(addStudentFamilyMemberOccupationalTelNoField3.getText())){ familyInfo3.setContactNumber(addStudentFamilyMemberOccupationalTelNoField3.getText()); }
                        else{ LocalUtility.alertWarning(addStudentFamilyMemberOccupationalTelNo3.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
                    }
                    
                    if(addStudentFamilyMemberNameField4.getText() != null && !addStudentFamilyMemberNameField4.getText().isEmpty()){
                        familyInfo4.setName(addStudentFamilyMemberNameField4.getText());
                        
                        if(addStudentFamilyMemberRelationshipField4.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Relationship 4 empty."); flagFieldsEmpty = true; }
                        else{ familyInfo4.setRelationship(addStudentFamilyMemberRelationshipField4.getText()); }
                        
                        if(addStudentFamilyMemberAgeField4.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Age 4 empty."); flagFieldsEmpty = true; }
                        else{
                            if(LocalUtility.validateNumeric(addStudentFamilyMemberAgeField4.getText())){ familyInfo4.setAge(LocalUtility.convertStringToInteger(addStudentFamilyMemberAgeField4.getText())); }
                            else{ LocalUtility.alertWarning(addStudentFamilyMemberAge4.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
                        }
                        
                        if(addStudentFamilyMemberOccupationField4.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupation 4 empty."); flagFieldsEmpty = true; }
                        else{ familyInfo4.setOccupation(addStudentFamilyMemberOccupationField4.getText()); }
                        
                        if(addStudentFamilyMemberOccupationalAddressField4.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupational Address 4 empty."); flagFieldsEmpty = true; }
                        else{ familyInfo4.setOccupationalAddress(addStudentFamilyMemberOccupationalAddressField4.getText()); }
                        
                        if(addStudentFamilyMemberOccupationalTelNoField4.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupational Tel. No. 4 empty."); flagFieldsEmpty = true; }
                        else{
                            if(LocalUtility.validateNumeric(addStudentFamilyMemberOccupationalTelNoField4.getText())){ familyInfo4.setContactNumber(addStudentFamilyMemberOccupationalTelNoField4.getText()); }
                            else{ LocalUtility.alertWarning(addStudentFamilyMemberOccupationalTelNo4.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
                        }
                        
                        if(addStudentFamilyMemberNameField5.getText() != null && !addStudentFamilyMemberNameField5.getText().isEmpty()){
                            familyInfo5.setName(addStudentFamilyMemberNameField5.getText());
                            
                            if(addStudentFamilyMemberRelationshipField5.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Relationship 5 empty."); flagFieldsEmpty = true; }
                            else{ familyInfo5.setRelationship(addStudentFamilyMemberRelationshipField5.getText()); }
                            
                            if(addStudentFamilyMemberAgeField5.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Age 5 empty."); flagFieldsEmpty = true; }
                            else{
                                if(LocalUtility.validateNumeric(addStudentFamilyMemberAgeField5.getText())){ familyInfo5.setAge(LocalUtility.convertStringToInteger(addStudentFamilyMemberAgeField5.getText())); }
                                else{ LocalUtility.alertWarning(addStudentFamilyMemberAge5.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
                            }
                            
                            if(addStudentFamilyMemberOccupationField5.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupation 5 empty."); flagFieldsEmpty = true; }
                            else{ familyInfo5.setOccupation(addStudentFamilyMemberOccupationField5.getText()); }
                            
                            if(addStudentFamilyMemberOccupationalAddressField5.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupational Address 5 empty."); flagFieldsEmpty = true; }
                            else{ familyInfo5.setOccupationalAddress(addStudentFamilyMemberOccupationalAddressField5.getText()); }
                            
                            if(addStudentFamilyMemberOccupationalTelNoField5.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupational Tel. No. 5 empty."); flagFieldsEmpty = true; }
                            else{
                                if(LocalUtility.validateNumeric(addStudentFamilyMemberOccupationalTelNoField5.getText())){ familyInfo5.setContactNumber(addStudentFamilyMemberOccupationalTelNoField5.getText()); }
                                else{ LocalUtility.alertWarning(addStudentFamilyMemberOccupationalTelNo5.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
                            }
                            
                            if(addStudentFamilyMemberNameField6.getText() != null && !addStudentFamilyMemberNameField6.getText().isEmpty()){
                                familyInfo6.setName(addStudentFamilyMemberNameField6.getText());
                                
                                if(addStudentFamilyMemberRelationshipField6.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Relationship 6 empty."); flagFieldsEmpty = true; }
                                else{ familyInfo6.setRelationship(addStudentFamilyMemberRelationshipField6.getText()); }
                                
                                if(addStudentFamilyMemberAgeField6.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Age 6 empty."); flagFieldsEmpty = true; }
                                else{
                                    if(LocalUtility.validateNumeric(addStudentFamilyMemberAgeField6.getText())){ familyInfo6.setAge(LocalUtility.convertStringToInteger(addStudentFamilyMemberAgeField6.getText())); }
                                    else{ LocalUtility.alertWarning(addStudentFamilyMemberAge6.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
                                }
                                
                                if(addStudentFamilyMemberOccupationField6.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupation 6 empty."); flagFieldsEmpty = true; }
                                else{ familyInfo6.setOccupation(addStudentFamilyMemberOccupationField6.getText()); }
                                
                                if(addStudentFamilyMemberOccupationalAddressField6.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupational Address 6 empty."); flagFieldsEmpty = true; }
                                else{ familyInfo6.setOccupationalAddress(addStudentFamilyMemberOccupationalAddressField6.getText()); }
                                
                                if(addStudentFamilyMemberOccupationalTelNoField6.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Occupational Tel. No. 6 empty."); flagFieldsEmpty = true; }
                                else{
                                    if(LocalUtility.validateNumeric(addStudentFamilyMemberOccupationalTelNoField6.getText())){ familyInfo6.setContactNumber(addStudentFamilyMemberOccupationalTelNoField6.getText()); }
                                    else{ LocalUtility.alertWarning(addStudentFamilyMemberOccupationalTelNo6.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
                                }
                            }
                        }
                    }
                }
            }
        } else { flagFieldsEmpty = true; }
        
        if(addStudentReferenceNoField.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Reference No. field empty."); flagFieldsEmpty = true; }
        else{
            if(LocalUtility.validateReferenceNo(addStudentReferenceNoField.getText())){ student.setReferenceNumber(addStudentReferenceNoField.getText()); }
            else{ LocalUtility.alertWarning(addStudentReferenceNo.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
        }
        
        if(addStudentEnrollmentNoField.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Enrollment No. field empty."); flagFieldsEmpty = true; }
        else{
            if(LocalUtility.validateEnrollmentNo(addStudentEnrollmentNoField.getText())){ student.setEnrollmentNumber(addStudentEnrollmentNoField.getText()); }
            else{ LocalUtility.alertWarning(addStudentEnrollmentNo.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
        }
        
        if(addStudentPlaceField.getText().isEmpty()){ Utility.log("AddStudentScreen | validateStudentForm | Place empty."); LocalUtility.alertWarningFieldIsEmpty(Labels.labelTag.ADD_STUDENT_PLACE.getLabel()); return false; }
        else{ student.setPlace(addStudentPlaceField.getText()); }
        
        if(addStudentDateDatePicker.getValue() == null){ Utility.errorLog("AddController | validateStudentForm | Student form date is empty."); LocalUtility.alertWarningFieldIsEmpty(Labels.labelTag.ADD_STUDENT_DATE.getLabel()); return false; }
        else{ student.setDate(addStudentDateDatePicker.getValue().toString()); }

        if(flagFieldsEmpty){ 
            if(LocalUtility.alertConfirmationFieldIsEmpty()){ return true; }
            else{ Utility.log("AddStudentScreen | validateStudentForm | Please fill up the remaining fields before saving."); return false; }
        } else { return true; }
    }
    private Integer getReligionID(){
        Utility.log("AddStudentScreen | getReligionID");
        Religion selectedReligion = (Religion)addStudentReligionComboBox.getItems().get(addStudentReligionComboBox.getSelectionModel().getSelectedIndex());
        return selectedReligion.getReligionId();
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
        
        final Callback<DatePicker,DateCell> dobDayCellFactory = new Callback<DatePicker,DateCell>(){
            @Override public DateCell call(final DatePicker datepicker){
                return new DateCell(){
                    @Override public void updateItem(LocalDate item, boolean empty){
                        super.updateItem(item,empty);
                        setDisable(!LocalUtility.validateDOB(new DatePicker().getChronology().date(item.getYear(), item.getMonthValue(), item.getDayOfMonth())));
                    }
                };
            }
        };
        final Callback<DatePicker,DateCell> dateDayCellFactory = new Callback<DatePicker,DateCell>(){
            @Override public DateCell call(final DatePicker datePicker){
                return new DateCell(){
                    @Override public void updateItem(LocalDate item, boolean empty){
                        if(item.isAfter(LocalDate.now())){
                            setDisable(true);
                        }
                    }
                };
            }
        };
        addStudentDOBDatePicker.showingProperty().addListener(new ChangeListener<Boolean>(){
            @Override public void changed(ObservableValue obValue, Boolean oldValue, Boolean newValue){
                if(addStudentDOBDatePicker.valueProperty().isNull().get()){
                    addStudentDOBDatePicker.setValue((LocalDate)Settings.getDOBMaximum());
                    Platform.runLater(() -> {
                        addStudentDOBDatePicker.getEditor().clear();
                    });
                }
            }
        });
        addStudentDOBDatePicker.setDayCellFactory(dobDayCellFactory);
        addStudentDateDatePicker.setDayCellFactory(dateDayCellFactory);
        addStudentDateDatePicker.setValue(LocalDate.now());
        
        Settings.getFlagDataUnsavedProperty().bind(
                addStudentFirstNameField.textProperty().isNotEmpty().or(
                addStudentMiddleNameField.textProperty().isNotEmpty().or(
                addStudentLastNameField.textProperty().isNotEmpty().or(
                addStudentDateDatePicker.valueProperty().isNotNull()
                )))
        );
    }
    private void setReligionData(){
        Utility.log("AddStudentScreen | setReligionData");
        ObservableList<Religion> list = FXCollections.observableArrayList(new UIModel().fetchAllReligion());
        
        addStudentReligionComboBox.setItems(list);
        addStudentReligionComboBox.getItems().add(Labels.labelTag.ADD_NEW_RELIGION.getLabel());
    }
    private void setID(){
        addStudentPersonalDetailsHBox.setId("sectionBG");
        addStudentEmergencyContactHBox.setId("sectionBG");
        addStudentFamilyDetailsHBox.setId("sectionBG");
        addStudentOfficeUseOnlyHBox.setId("sectionBG");
    }
    private void setLabels(){
        addStudentPhotoButton.setText(Labels.labelTag.ADD_PHOTO.getLabel());
        
        addStudentPersonalDetails.setText(Labels.labelTag.ADD_STUDENT_PERSONAL_DETAILS.getLabel());
        addStudentFirstName.setText(Labels.labelTag.ADD_STUDENT_FIRST_NAME.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentMiddleName.setText(Labels.labelTag.ADD_STUDENT_MIDDLE_NAME.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentLastName.setText(Labels.labelTag.ADD_STUDENT_LAST_NAME.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentAddress.setText(Labels.labelTag.ADD_STUDENT_ADDRESS.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentEmail.setText(Labels.labelTag.ADD_STUDENT_EMAIL.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentDOB.setText(Labels.labelTag.ADD_STUDENT_DATE_OF_BIRTH.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentPlaceOfBirth.setText(Labels.labelTag.ADD_STUDENT_PLACE_OF_BIRTH.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentReligion.setText(Labels.labelTag.ADD_STUDENT_RELIGION.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentOtherReligion.setText(Labels.labelTag.ADD_STUDENT_OTHER_RELIGION.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentEducationalBackground.setText(Labels.labelTag.ADD_STUDENT_EDUCATIONAL_BACKGROUND.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentLanguages.setText(Labels.labelTag.ADD_STUDENT_LANGUAGES.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentHobbies.setText(Labels.labelTag.ADD_STUDENT_HOBBIES.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        
        addStudentEmergencyContact.setText(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT.getLabel());
        addStudentEmergencyContactPerson.setText(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT_PERSON.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentEmergencyContactTelNo.setText(Labels.labelTag.ADD_STUDENT_EMERGENCY_CONTACT_TEL_NO.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        
        addStudentFamilyDetails.setText(Labels.labelTag.ADD_STUDENT_FAMILY_DETAILS.getLabel());
        addStudentFamilyMemberName1.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberAge1.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberRelationship1.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupation1.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupationalAddress1.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupationalTelNo1.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        
        addStudentFamilyMemberName2.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberAge2.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberRelationship2.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupation2.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupationalAddress2.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupationalTelNo2.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        
        addStudentFamilyMemberName3.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberAge3.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberRelationship3.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupation3.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupationalAddress3.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupationalTelNo3.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        
        addStudentFamilyMemberName4.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberAge4.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberRelationship4.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupation4.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupationalAddress4.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupationalTelNo4.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        
        addStudentFamilyMemberName5.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberAge5.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberRelationship5.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupation5.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupationalAddress5.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupationalTelNo5.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        
        addStudentFamilyMemberName6.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_NAME.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberAge6.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_AGE.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberRelationship6.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_RELATIONSHIP.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupation6.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATION.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupationalAddress6.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_ADDRESS.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentFamilyMemberOccupationalTelNo6.setText(Labels.labelTag.ADD_STUDENT_FAMILY_MEMBER_OCCUPATIONAL_TEL_NO.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        
        addStudentOfficeUseOnly.setText(Labels.labelTag.ADD_STUDENT_OFFICE_USE_ONLY.getLabel());
        addStudentReferenceNo.setText(Labels.labelTag.ADD_STUDENT_REFERENCE_NUMBER.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentEnrollmentNo.setText(Labels.labelTag.ADD_STUDENT_ENROLLMENT_NUMBER.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentPlace.setText(Labels.labelTag.ADD_STUDENT_PLACE.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addStudentDate.setText(Labels.labelTag.ADD_STUDENT_DATE.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        
        addHelpHeader.setText(Labels.labelTag.HELP.getLabel());
        addStudentHelpBody.setText(Labels.labelTag.HELP_ADD_STUDENT.getLabel());
    }
}
