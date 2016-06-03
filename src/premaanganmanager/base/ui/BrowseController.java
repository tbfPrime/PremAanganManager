/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import premaanganmanager.base.controller.background.Student;
import premaanganmanager.configurable.Labels;

/**
 * FXML Controller class
 *
 * @author Trevor Fernandes
 */
public class BrowseController{
    
    private AppContainer appContainer;
    
    @FXML
    private TableView browseTable;
    private TableColumn idColumn;
    private TableColumn dummyValueColumn;
    
    @FXML
    private Button browseStudentButton;
    
    @FXML
    private void browseStudentButtonAction(){
        appContainer.displayScreen(AppContainer.screenTag.BROWSE_STUDENT_TABLE);
    }
    
    // Constructor
    public BrowseController(AppContainer appContainer){
        this.appContainer = appContainer;
    }
    
    // Public functions
    public AnchorPane setBrowseScreenMenu(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/Browse.fxml"));
            loader.setController(this);
            AnchorPane homeBase = loader.load();
            setBrowseScreenMenuLabels();
            return homeBase;
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setBrowseHome | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public AnchorPane setBrowseTable(AppContainer.screenTag tag){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/BrowseTable.fxml"));
            loader.setController(this);
            AnchorPane homeBase = loader.load();
            dispayTable(tag);
            return homeBase;
        } catch (IOException e) {
            System.out.println("Error | AppContainer | setBrowseHome | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    // private functions
    private void dispayTable(AppContainer.screenTag tag){
        switch(tag){
            case BROWSE_STUDENT_TABLE: displayStudentTable(); break;
        }
    }
    
    private void displayStudentTable(){
        TableColumn col_id = new TableColumn();
        TableColumn col_firstName = new TableColumn();
        TableColumn col_middleName = new TableColumn();
        TableColumn col_lastName = new TableColumn();
        
        col_id.setText("ID");
        col_firstName.setText("First Name");
        col_middleName.setText("Middle Name");
        col_lastName.setText("Last Name");
        
        final ObservableList data = FXCollections.observableArrayList(appContainer.uiControl.uiModel.fetchAllStudent());
        
        col_id.setCellValueFactory(new PropertyValueFactory<Student,Integer>("studentId"));
        col_firstName.setCellValueFactory(new PropertyValueFactory<Student,Integer>("firstName"));
        col_middleName.setCellValueFactory(new PropertyValueFactory<Student,Integer>("middleName"));
        col_lastName.setCellValueFactory(new PropertyValueFactory<Student,Integer>("lastName"));
        
        browseTable.setItems(data);
        browseTable.getColumns().addAll(col_id,col_firstName,col_middleName,col_lastName);
    }

    private void setBrowseScreenMenuLabels(){
        browseStudentButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BROWSE_STUDENT));
    }
}
