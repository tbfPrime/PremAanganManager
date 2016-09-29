/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import java.nio.file.Paths;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import premaanganmanager.base.controller.UIModel;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Labels;
import premaanganmanager.configurable.LocalUtility;
import premaanganmanager.configurable.Settings;
import premaanganmanager.configurable.entity.Teacher;
import premaanganmanager.configurable.scenes.ManagerScene;

/**
 *
 * @author TBF
 */
public class AddTeacherScreen extends AddScreen{
    Teacher teacher;
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
    
    public AddTeacherScreen(ManagerScene managerScene){
        super(managerScene);
    }
    
    // public methods
    @Override
    public FXMLLoader getContent(){
        Utility.log("AddTeacherScreen | getContent");
        FXMLLoader content = new FXMLLoader(Utility.getPathFXML("AddTeacher.fxml"));
        content.setController(this);
        return content;
    }
    @Override
    public void initializeScreen(){
        Utility.log("AddTeacherScreen | initializeScreen");
        teacher = new Teacher();
        setTeacherFormConditions();
        setPhotoView(addTeacherPhotoView,Paths.get(Settings.getPlaceHolderDir(),Settings.getPlaceHolderTeacherPhoto()));
        setID();
        setLabels();
    }
    @Override
    public void back(){
        Utility.log("AddTeacherScreen | back");
        managerScene.getSceneContainer().displayScreen(Settings.screenTag.ADD);
    }
    @Override
    public void save(){
        Utility.log("AddTeacherScreen | save");
        saveTeacherRecord();
    }

    // private methods
    @FXML
    private void addTeacherPhotoAction(){
        Utility.log("AddTeacherScreen | addTeacherPhotoAction");
        setPhotoView(addTeacherPhotoView, getPhotoPath());
    }
    @FXML
    private void addTeacherDOBAction(){
        Utility.log("AddTeacherScreen | addTeacherDOBAction");
    }
    private void setTeacherFormConditions(){
        Utility.log("AddTeacherScreen | setTeacherFormConditions");
        addTeacherEmergencyContactTelNoField.disableProperty().bind(addTeacherEmergencyContactPersonField.textProperty().isEmpty());
        
        Settings.getFlagDataUnsavedProperty().bind(
                addTeacherFirstNameField.textProperty().isNotEmpty().or(
                addTeacherPlaceField.textProperty().isNotEmpty().or(
                addTeacherDatePicker.valueProperty().isNotNull()
                ))
        );
    }
    private void saveTeacherRecord(){
        Utility.log("AddTeacherScreen | saveTeacherRecord");
        if(validateForm()){
            Utility.log("AddTeacherScreen | saveTeacherRecord | about to save teacher record.");
            if(new UIModel().saveTeacherForm(teacher)){ 
                Utility.log("AddTeacherScreen | saveTeacherRecord | teacher record saved successfully.");
                String alertTeacherName = addTeacherFirstNameField.getText() + (addTeacherMiddleNameField.getText().isEmpty() ? "" : (" " + addTeacherMiddleNameField.getText())) + (addTeacherLastNameField.getText().isEmpty() ? "" : (" " + addTeacherLastNameField.getText()));
                if(LocalUtility.alertInfo(Labels.labelTag.ALERT_MESSAGE_STUDENT_SAVE_SUCCESS.getLabel().replace("?",alertTeacherName))){ back(); }
                else{ back(); }
            }
            else{ Utility.log("AddTeacherScreen | saveTeacherRecord | Error saving teacher record."); LocalUtility.alertErrorSave(); }
        }
    }
    private boolean validateForm(){
        Utility.log("AddTeacherScreen | validateForm");
        
        boolean flagFieldsEmpty = false;
        
        if(addTeacherFirstNameField.getText().isEmpty()){ Utility.log("AddTeacherScreen | validateForm | First Name empty."); LocalUtility.alertWarningFieldIsEmpty(Labels.labelTag.ADD_TEACHER_FIRST_NAME.getLabel()); return false; }
        else{ teacher.setFirstName(addTeacherFirstNameField.getText()); }
        
        if(addTeacherEmailField.getText().isEmpty()){ Utility.log("AddTeacherScreen | validateScreen | email-id field empty."); flagFieldsEmpty = true; }
        else{
            if(!LocalUtility.validateEmail(addTeacherEmailField.getText())){ Utility.log("AddTeacher | validateForm | email-id not valid."); LocalUtility.alertWarning(Labels.labelTag.ALERT_MESSAGE_EMAIL_FORMAT_INCORRECT.getLabel()); }
            else{ teacher.setEmailId(addTeacherEmailField.getText()); }
        }
        
        return true;
    }
    private void setID(){
        addTeacherPersonalDetailsHBox.setId("sectionBG");
        addTeacherEmergencyContactHBox.setId("sectionBG");
        addTeacherOfficeUseOnlyHBox.setId("sectionBG");
    }
    private void setLabels(){
        addTeacherPersonalDetails.setText(Labels.labelTag.ADD_TEACHER_PERSONAL_DETAILS.getLabel());
        addTeacherEmergencyContact.setText(Labels.labelTag.ADD_TEACHER_EMERGENCY_CONTACT.getLabel());
        addTeacherOfficeUseOnly.setText(Labels.labelTag.ADD_TEACHER_OFFICE_USE_ONLY.getLabel());
        
        addTeacherFirstName.setText(Labels.labelTag.ADD_TEACHER_FIRST_NAME.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addTeacherMiddleName.setText(Labels.labelTag.ADD_TEACHER_MIDDLE_NAME.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addTeacherLastName.setText(Labels.labelTag.ADD_TEACHER_LAST_NAME.getLabel()+  Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addTeacherAddress.setText(Labels.labelTag.ADD_TEACHER_ADDRESS.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addTeacherEmail.setText(Labels.labelTag.ADD_TEACHER_EMAIL.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addTeacherDOB.setText(Labels.labelTag.ADD_TEACHER_DATE_OF_BIRTH.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addTeacherPhotoButton.setText(Labels.labelTag.ADD_PHOTO.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addTeacherEmergencyContactPerson.setText(Labels.labelTag.ADD_TEACHER_EMERGENCY_CONTACT_PERSON.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addTeacherEmergencyContactTelNo.setText(Labels.labelTag.ADD_TEACHER_EMERGENCY_CONTACT_TEL_NO.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addTeacherPlace.setText(Labels.labelTag.ADD_TEACHER_PLACE.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addTeacherDate.setText(Labels.labelTag.ADD_TEACHER_DATE.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addTeacherSalary.setText(Labels.labelTag.ADD_TEACHER_SALARY.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
        addTeacherDateOfResignation.setText(Labels.labelTag.ADD_TEACHER_DATE_OF_RESIGNATION.getLabel() + Labels.labelTag.LABEL_SEPERATOR.getLabel());
    }    
}
