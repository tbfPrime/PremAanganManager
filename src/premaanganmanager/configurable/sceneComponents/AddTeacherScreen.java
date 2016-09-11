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
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Labels;
import premaanganmanager.configurable.Settings;
import premaanganmanager.configurable.scenes.ManagerScene;

/**
 *
 * @author TBF
 */
public class AddTeacherScreen extends AddScreen{
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
    private void setID(){
        addTeacherPersonalDetailsHBox.setId("sectionBG");
        addTeacherEmergencyContactHBox.setId("sectionBG");
        addTeacherOfficeUseOnlyHBox.setId("sectionBG");
    }
    private void setLabels(){
        addTeacherPersonalDetails.setText(Labels.labelTag.ADD_TEACHER_PERSONAL_DETAILS.getLabel());
        addTeacherEmergencyContact.setText(Labels.labelTag.ADD_TEACHER_EMERGENCY_CONTACT.getLabel());
        addTeacherOfficeUseOnly.setText(Labels.labelTag.ADD_TEACHER_OFFICE_USE_ONLY.getLabel());
        
        addTeacherFirstName.setText(Labels.labelTag.ADD_TEACHER_FIRST_NAME.getLabel());
        addTeacherMiddleName.setText(Labels.labelTag.ADD_TEACHER_MIDDLE_NAME.getLabel());
        addTeacherLastName.setText(Labels.labelTag.ADD_TEACHER_LAST_NAME.getLabel());
        addTeacherAddress.setText(Labels.labelTag.ADD_TEACHER_ADDRESS.getLabel());
        addTeacherEmail.setText(Labels.labelTag.ADD_TEACHER_EMAIL.getLabel());
        addTeacherDOB.setText(Labels.labelTag.ADD_TEACHER_DATE_OF_BIRTH.getLabel());
        addTeacherPhotoButton.setText(Labels.labelTag.ADD_PHOTO.getLabel());
    }    
}
