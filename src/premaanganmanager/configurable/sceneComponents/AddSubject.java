/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.configurable.sceneComponents;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import premaanganmanager.base.controller.UIModel;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Labels;
import premaanganmanager.configurable.LocalUtility;
import premaanganmanager.configurable.AppSettings;
import premaanganmanager.configurable.entity.Subject;
import premaanganmanager.configurable.scenes.ManagerScene;

/**
 *
 * @author TBF
 */
public class AddSubject extends Add{
    private Subject subject;
    @FXML
    private HBox addSubjectDetailsHBox;
    @FXML
    private Text addSubjectDetails, addSubjectName, addSubjectDescription;
    @FXML
    private TextField addSubjectNameField, addSubjectDescriptionField;
    
    public AddSubject(ManagerScene managerScene){
        super(managerScene);
    }
    @Override
    public void save(){
        Utility.log("AddSubjectScreen | save");
        saveSubjectRecord();
    }
    @Override
    public FXMLLoader getContent(){
        Utility.log("AddSubjectScreen | getContent");
        FXMLLoader content = new FXMLLoader(Utility.getPathFXML("AddSubject.fxml"));
        content.setController(this);
        return content;
    }
    @Override
    public void initializeScreen(){
        Utility.log("AddSubjectScreen | initializeScreen");
        subject = new Subject();
        setLabels();
        setSectionID(new HBox[] {addSubjectDetailsHBox});
        setSubjectFormConditions();
    }
    @Override
    public void flushScreenData(){
        Utility.log("AddSubjectScreen | flushScreenData");
        addSubjectNameField.clear();
        addSubjectDescriptionField.clear();
    }

    private void setSubjectFormConditions(){
        Utility.log("AddSubjectScreen | setSubjectFormConditions");
        AppSettings.getFlagDataUnsavedProperty().bind(
                addSubjectNameField.textProperty().isNotEmpty().or(
                addSubjectDescriptionField.textProperty().isNotEmpty())
        );
    }
    private void saveSubjectRecord(){
        Utility.log("AddSubjectScreen | saveSubjectRecord");
        if(validateForm()){
            if(new UIModel().saveSubjectForm(subject)){
                Utility.log("AddSubjectScreen | saveSubjectRecord");
                if(LocalUtility.alertInfo(managerScene.getSceneContainer().getActiveScreenTag().getTitle() + Labels.labelTag.LABEL_SEPERATOR.getLabel() + " " + subject.getSubjectName() + " " + Labels.labelTag.ALERT_MESSAGE_SAVE_SUCCESS.getLabel())){ Utility.log("AddSubjectScreen | saveSubjectRecord | Ok selected."); }
                else{ Utility.log("AddSubjectScreen | saveSubjectRecord | Ok selected."); }
                flushScreenData();
                back();
            } else{ Utility.log("AddSubjectScreen | saveSubjectRecord | error saving subject record."); LocalUtility.alertErrorSave(); }
        } else{ Utility.log("AddSubjectScreen | saveSubjectRecord | validation of subject form failed."); }
    }
    private boolean validateForm(){
        Utility.log("AddSubjectScreen | validateForm");
        boolean flagFieldsEmpty = false;
        if(addSubjectNameField.getText().isEmpty()){ Utility.log("AddSubjectScreen | validateForm | Subject Name empty."); LocalUtility.alertWarningFieldIsEmpty(addSubjectName.getText()); return false; }
        else{ subject.setSubjectName(addSubjectNameField.getText()); }
        
        if(addSubjectDescriptionField.getText().isEmpty()){ Utility.log("AddSubjectScreen | validateForm | Subject description empty."); flagFieldsEmpty = true; }
        else{ subject.setSubjectDescription(addSubjectDescriptionField.getText()); }
        
        if(flagFieldsEmpty){ 
            if(LocalUtility.alertConfirmationFieldIsEmpty()){ return true; }
            else{ Utility.log("AddSubjectScreen | validateForm | Please fill up the remaining fields before saving."); return false; }
        } else{ return true; }
    }
    private void setLabels(){
        Utility.log("AddSubjectScreen | setLabels");
        addSubjectDetails.setText(Labels.labelTag.ADD_SUBJECT_DETAILS.getLabel());
        addSubjectName.setText(Labels.labelTag.ADD_SUBJECT_NAME.getLabel());
        addSubjectDescription.setText(Labels.labelTag.ADD_SUBJECT_DESCRIPTION.getLabel());
    }
}
