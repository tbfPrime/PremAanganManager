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
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Labels;
import premaanganmanager.configurable.Settings;
import premaanganmanager.configurable.scenes.ManagerScene;

/**
 *
 * @author TBF
 */
public class AddSubjectScreen extends AddScreen{
    @FXML
    private HBox addSubjectDetailsHBox;
    @FXML
    private Text addSubjectDetails, addSubjectName, addSubjectDescription;
    @FXML
    private TextField addSubjectNameField, addSubjectDescriptionField;
    
    public AddSubjectScreen(ManagerScene managerScene){
        super(managerScene);
    }
    @Override
    public void save(){
        Utility.log("AddSubjectScreen | save");
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
        setLabels();
        setSectionID(new HBox[] {addSubjectDetailsHBox});
        setSubjectFormConditions();
    }

    private void setSubjectFormConditions(){
        Utility.log("AddSubjectScreen | setSubjectFormConditions");
        Settings.getFlagDataUnsavedProperty().bind(
                addSubjectNameField.textProperty().isNotEmpty().or(
                addSubjectDescriptionField.textProperty().isNotEmpty())
        );
    }
    private void setLabels(){
        Utility.log("AddSubjectScreen | setLabels");
        addSubjectDetails.setText(Labels.labelTag.ADD_SUBJECT_DETAILS.getLabel());
        addSubjectName.setText(Labels.labelTag.ADD_SUBJECT_NAME.getLabel());
        addSubjectDescription.setText(Labels.labelTag.ADD_SUBJECT_DESCRIPTION.getLabel());
    }
}
