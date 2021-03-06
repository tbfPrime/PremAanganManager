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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import premaanganmanager.base.controller.UIModel;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Labels;
import premaanganmanager.configurable.LocalUtility;
import premaanganmanager.configurable.AppSettings;
import premaanganmanager.configurable.entity.Teacher;
import premaanganmanager.configurable.scenes.ManagerScene;

/**
 *
 * @author TBF
 */
public class AddTeacher extends Add{
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
    
    public AddTeacher(ManagerScene managerScene){
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
        setPhotoView(addTeacherPhotoView,Paths.get(AppSettings.getPlaceHolderDir(),AppSettings.getPlaceHolderTeacherPhoto()));
        setLabels();
        setSectionID(new HBox[] {addTeacherPersonalDetailsHBox, addTeacherEmergencyContactHBox, addTeacherOfficeUseOnlyHBox});
    }
    @Override
    public void save(){
        Utility.log("AddTeacherScreen | save");
        saveTeacherRecord();
    }
    @Override
    public void flushScreenData(){
        if(photoFileExtension.isEmpty()){ Utility.log("AddTeacherScreen | flushScreenData | No Photo File to flush."); }
        else{
            Path tempPhotoFilePath = Paths.get(AppSettings.getPhotoDir(),(AppSettings.getTempPhotoFilename() + "." + photoFileExtension));
            File tempPhotoFile = new File(tempPhotoFilePath.toAbsolutePath().toString());
            if(tempPhotoFile.exists()){ tempPhotoFile.delete(); }
        }
        addTeacherFirstNameField.clear();
//        addTeacherMiddleNameField.clear();
//        addTeacherLastNameField.clear();
        addTeacherPlaceField.clear();
        addTeacherDatePicker.setValue(null);
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
        if(addTeacherDateOfBirthPicker.getValue() != null){
            if(!LocalUtility.validateDOB(new DatePicker().getChronology().date(addTeacherDateOfBirthPicker.getValue().getYear(), addTeacherDateOfBirthPicker.getValue().getMonth().getValue(), addTeacherDateOfBirthPicker.getValue().getDayOfMonth()))){
                LocalUtility.alertWarning(addTeacherDOB.getText() + " " + Labels.labelTag.ALERT_MESSAGE_DOB_FORMAT_INCORRECT.getLabel());
                addTeacherDateOfBirthPicker.getEditor().clear();
            }
        } else{
            Utility.log("AddTeacherScreen | addTeacherDOBAction | No DOB to validate.");
        }
    }
    private void setTeacherFormConditions(){
        Utility.log("AddTeacherScreen | setTeacherFormConditions");
        addTeacherEmergencyContactTelNoField.disableProperty().bind(addTeacherEmergencyContactPersonField.textProperty().isEmpty());
        final Callback<DatePicker,DateCell> dobDayCellFactory = new Callback<DatePicker,DateCell>(){
          @Override
          public DateCell call(final DatePicker datePicker){
              return new DateCell(){
                  @Override
                  public void updateItem(LocalDate item, boolean empty){
                      super.updateItem(item,empty);
                      setDisable(!LocalUtility.validateDOB(new DatePicker().getChronology().date(item.getYear(), item.getMonthValue(), item.getDayOfMonth())));
                  };
              };
          }
        };
        final Callback<DatePicker,DateCell> dorDayCellFactory = new Callback<DatePicker,DateCell>(){
            @Override
            public DateCell call(final DatePicker datePicker){
                return new DateCell(){
                    @Override
                    public void updateItem(LocalDate item, boolean empty){
                        super.updateItem(item,empty);
                        if(item.isBefore(addTeacherDatePicker.getValue().plusDays(1))){
                            setDisable(true);
                        }
                    }
                };
            }
        };
        final Callback<DatePicker,DateCell> dateDayCellFactory = new Callback<DatePicker,DateCell>(){
            @Override
            public DateCell call(final DatePicker datePicker){
                return new DateCell(){
                    @Override
                    public void updateItem(LocalDate item, boolean empty){
                        super.updateItem(item, empty);
                        if(item.isAfter(LocalDate.now())){
                            setDisable(true);
                        }
                    }
                };
            }
        };
        addTeacherDateOfBirthPicker.setDayCellFactory(dobDayCellFactory);
        addTeacherDateOfResignationPicker.setDayCellFactory(dorDayCellFactory);
        addTeacherDatePicker.setDayCellFactory(dateDayCellFactory);
        addTeacherDatePicker.setValue(LocalDate.now());
        addTeacherDateOfBirthPicker.showingProperty().addListener(new ChangeListener<Boolean>(){
            @Override 
            public void changed(ObservableValue obValue,Boolean oldValue,Boolean newValue){
                if(addTeacherDateOfBirthPicker.valueProperty().isNull().get()){ 
                    addTeacherDateOfBirthPicker.setValue((LocalDate)AppSettings.getDOBMaximum());
                    Platform.runLater(() -> {
                        addTeacherDateOfBirthPicker.getEditor().clear();
                    });
                }
            }
        });
        
        AppSettings.getFlagDataUnsavedProperty().bind(
                addTeacherFirstNameField.textProperty().isNotEmpty().or(
                addTeacherPlaceField.textProperty().isNotEmpty())
        );
    }
    private void saveTeacherRecord(){
        Utility.log("AddTeacherScreen | saveTeacherRecord");
        if(validateForm()){
            Utility.log("AddTeacherScreen | saveTeacherRecord | about to save teacher record.");
            if(new UIModel().saveTeacherForm(teacher)){ 
                Utility.log("AddTeacherScreen | saveTeacherRecord | teacher ID: " + teacher.getTeacherId());
                savePhotoFile(Labels.labelTag.LABEL_TEACHER_PHOTO_PREFIX.getLabel() + teacher.getTeacherId());
                Utility.log("AddTeacherScreen | saveTeacherRecord | teacher record saved successfully.");
                String alertTeacherName = addTeacherFirstNameField.getText() + (addTeacherMiddleNameField.getText().isEmpty() ? "" : (" " + addTeacherMiddleNameField.getText())) + (addTeacherLastNameField.getText().isEmpty() ? "" : (" " + addTeacherLastNameField.getText()));
                if(LocalUtility.alertInfo(managerScene.getSceneContainer().getActiveScreenTag().getTitle() + Labels.labelTag.LABEL_SEPERATOR.getLabel() + " "  + alertTeacherName + " " + Labels.labelTag.ALERT_MESSAGE_SAVE_SUCCESS.getLabel())){ Utility.log("AddTeacher | saveTeacherRecord | exiting after data saved. Ok selected."); }
                else{ Utility.log("AddTeacher | saveTeacherRecord | exiting after data saved. Ok selected."); }
                flushScreenData();
                back();
            }
            else{ Utility.log("AddTeacherScreen | saveTeacherRecord | Error saving teacher record."); LocalUtility.alertErrorSave(); }
        } else{ Utility.log("AddTeacherScreen | saveTeacherRecord | validation of teacher record failed. Exiting."); }
    }
    private boolean validateForm(){
        Utility.log("AddTeacherScreen | validateForm");
        
        boolean flagFieldsEmpty = false;
        
        if(addTeacherFirstNameField.getText().isEmpty()){ Utility.log("AddTeacherScreen | validateForm | First Name empty."); LocalUtility.alertWarningFieldIsEmpty(Labels.labelTag.ADD_TEACHER_FIRST_NAME.getLabel()); return false; }
        else{ teacher.setFirstName(addTeacherFirstNameField.getText()); }
        
        if(addTeacherMiddleNameField.getText().isEmpty()){ Utility.log("AddTeacherScreen | validateForm | Middle Name empty."); flagFieldsEmpty = true; }
        else{ teacher.setMiddleName(addTeacherMiddleNameField.getText()); }
        
        if(addTeacherLastNameField.getText().isEmpty()){ Utility.log("AddTeacherScreen | validateForm | Last Name empty."); flagFieldsEmpty = true; }
        else{ teacher.setLastName(addTeacherLastNameField.getText()); }
        
        if(addTeacherAddressField.getText().isEmpty()){ Utility.log("AddTeacherScreen | validateForm | Address empty."); flagFieldsEmpty = true; }
        else{ teacher.setAddress(addTeacherAddressField.getText()); }
        
        if(addTeacherEmailField.getText().isEmpty()){ Utility.log("AddTeacherScreen | validateScreen | email-id field empty."); flagFieldsEmpty = true; }
        else{
            if(!LocalUtility.validateEmail(addTeacherEmailField.getText())){ Utility.log("AddTeacher | validateForm | email-id not valid."); LocalUtility.alertWarning(Labels.labelTag.ALERT_MESSAGE_EMAIL_FORMAT_INCORRECT.getLabel()); return false; }
            else{ teacher.setEmailId(addTeacherEmailField.getText()); }
        }
        
        if(addTeacherDateOfBirthPicker.valueProperty().isNull().getValue()){ Utility.log("AddTeacherScreen | validateForm | DOB empty."); flagFieldsEmpty = true; }
        else{ 
            if(!LocalUtility.validateDOB(new DatePicker().getChronology().date(addTeacherDateOfBirthPicker.getValue().getYear(), addTeacherDateOfBirthPicker.getValue().getMonth().getValue(), addTeacherDateOfBirthPicker.getValue().getDayOfMonth()))){
                LocalUtility.alertWarning(addTeacherDOB.getText() + " " + Labels.labelTag.ALERT_MESSAGE_DOB_FORMAT_INCORRECT.getLabel());
                addTeacherDateOfBirthPicker.requestFocus();
                return false;
            } else{ teacher.setDob(addTeacherDateOfBirthPicker.getValue().toString()); }
        }
        
        if(photoFileExtension.isEmpty()){ Utility.log("AddTeacher | validateForm | photoFileExtension is empty."); flagFieldsEmpty = true; }
        else{ teacher.setTeacherPhotoId(photoFileExtension); }
        
        if(addTeacherEmergencyContactPersonField.getText().isEmpty()){ Utility.log("AddTeacher | validateForm | EmergencyContactPerson name is empty."); flagFieldsEmpty = true; }
        else{
            teacher.setEmergencyContactPerson(addTeacherEmergencyContactPersonField.getText());
            
            if(addTeacherEmergencyContactTelNoField.getText().isEmpty()){ Utility.log("AddTeacher | validateForm | EmergencyContactTelNo. empty."); flagFieldsEmpty = true; }
            else{
                if(!LocalUtility.validateNumeric(addTeacherEmergencyContactTelNoField.getText())){ LocalUtility.alertWarning(addTeacherEmergencyContactTelNo.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
                else{ teacher.setEmergencyContactNumber(LocalUtility.convertStringToInteger(addTeacherEmergencyContactTelNoField.getText())); }
            }
        }
        
        if(addTeacherSalaryField.getText().isEmpty()){ Utility.log("AddTeacher | validateForm | Salary field empty."); flagFieldsEmpty = true; }
        else{ 
            if(!LocalUtility.validateNumeric(addTeacherSalaryField.getText())){ LocalUtility.alertWarning(addTeacherSalary.getText() + " " + Labels.labelTag.ALERT_MESSAGE_NUMBER_FORMAT_INCORRECT.getLabel()); return false; }
            else{ teacher.setSalary(LocalUtility.convertStringToInteger(addTeacherSalaryField.getText())); }
        }
        
        if(addTeacherDateOfResignationPicker.valueProperty().isNull().getValue()){ Utility.log("AddTeacher | validateForm | date of resignation empty."); flagFieldsEmpty = true; }
        else{ teacher.setDateOfResignation(addTeacherDateOfResignationPicker.getValue().toString()); }
        
        if(addTeacherPlaceField.getText().isEmpty()){ LocalUtility.alertWarningFieldIsEmpty(addTeacherPlace.getText()); return false; }
        else{ teacher.setPlace(addTeacherPlaceField.getText()); }
        
        if(addTeacherDatePicker.valueProperty().isNull().getValue()){ LocalUtility.alertWarningFieldIsEmpty(addTeacherDate.getText()); return false; }
        else{ teacher.setDate(addTeacherDatePicker.getValue().toString()); }

        if(flagFieldsEmpty){ 
            if(LocalUtility.alertConfirmationFieldIsEmpty()){ return true; }
            else{ Utility.log("AddStudentScreen | validateForm | Please fill up the remaining fields before saving."); return false; }
        } else { return true; }
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
