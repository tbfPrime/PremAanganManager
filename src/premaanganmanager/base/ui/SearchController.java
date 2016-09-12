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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import premaanganmanager.configurable.entity.Student;
import premaanganmanager.base.controller.UIControl;
import premaanganmanager.base.controller.Utility;
import premaanganmanager.configurable.Labels;

/**
 *
 * @author Trevor Fernandes
 */

public class SearchController {
    public enum searchCategory{
        SEARCH_STUDENT, SEARCH_TEACHER, SEARCH_SUBJECT;
        
        private String label = "NA";
        
        @Override
        public String toString(){
            return label;
        }
    }
            
    private AppContainer appContainer;
    

    @FXML
    private ComboBox searchCategoryComboBox;
    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton, searchFilterResetButton;
    @FXML
    private HBox searchFilterButtonHBox;
    @FXML
    private VBox searchFilterVBox;
    
    @FXML
    private Button searchResultBackButton;
    @FXML
    private HBox searchResultFilterToggleHBox;
    @FXML
    private VBox searchResultVBox;
    @FXML
    private TableView searchTable;
    
    @FXML
    private void searchAction(){
        Utility.log("SearchController | searchAction");
        search();
    }
    
    @FXML 
    private void searchFilterResetAction(){
        Utility.log("SearchController | searchFilterResetAction");
    }
    
    @FXML
    private void searchResultBackAction(){
        Utility.log("SearchController | searchResultBackAction");
        appContainer.displayScreen(AppContainer.screenTag.SEARCH);
    }
    
    public SearchController(AppContainer appcontainer){
        this.appContainer = appcontainer;
    }

    public AnchorPane setSearch(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/Search.fxml"));
            loader.setController(this);
            AnchorPane searchBase = loader.load();
            searchBase.getStylesheets().add(SearchController.class.getResource("SearchFilter.css").toExternalForm());
            setSearchScreenData();
            return searchBase;
        } catch (IOException e) {
            Utility.log("Error | AppContainer | setSearch | " + e);
            Logger.getLogger(P_Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public AnchorPane setSearchResults(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/premaanganmanager/base/ui/SearchResult.fxml"));
            loader.setController(this);
            AnchorPane searchBase = loader.load();
            searchBase.getStylesheets().add(SearchController.class.getResource("SearchFilter.css").toExternalForm());
            setSearchResultScreenData();
            return searchBase;
        } catch (IOException e) {
            Utility.log("Error | AppContainer | setSearchResults | " + e);
            Logger.getLogger(P_Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    // Private functions
    private void setSearchScreenData(){
        setSearchControls();
        setSearchScreenStyling();
    }
    
    private void setSearchResultScreenData(){
        setSearchResultScreenStyling();
        setSearchResultScreenLabels();
    }
    
    private void setSearchScreenStyling(){
        searchFilterVBox.setId("ActiveBG");
        searchFilterButtonHBox.setId("ActiveBG");
    }
    
    private void setSearchResultScreenStyling(){
        searchResultVBox.setId("ActiveBG");
        searchResultFilterToggleHBox.setId("ActiveBG");
    }
    
    private void setSearchResultScreenLabels(){
        searchResultBackButton.setText(appContainer.uiControl.p_settings.labels.getLabel(Labels.labelTag.BACK));
    }
    
    private void setSearchControls(){
        Utility.log("SearchController | setSearchControls");
        
//        searchCategory.SEARCH_STUDENT.label = appContainer.uiControl.p_settings.labels.getLabel(Labels.labelTag.ADD_STUDENT);
//        searchCategory.SEARCH_TEACHER.label = appContainer.uiControl.p_settings.labels.getLabel(Labels.labelTag.ADD_TEACHER);
//        searchCategory.SEARCH_SUBJECT.label = appContainer.uiControl.p_settings.labels.getLabel(Labels.labelTag.ADD_SUBJECT);
        
        ObservableList<searchCategory> list = FXCollections.observableArrayList(searchCategory.values());

        searchCategoryComboBox.setItems(list);
    }
    
    private void search(){
        Utility.log("SearchController | search | text: " + searchField.getText());
        
        if(searchCategoryComboBox.getValue() == null){ appContainer.uiControl.alert(UIControl.alertTag.WARNING, "ZZZZZZZzzzzZZZZZZZZ"); return; }
        switch((searchCategory)searchCategoryComboBox.getValue()){
            case SEARCH_STUDENT: 
//                if()
                appContainer.displayScreen(AppContainer.screenTag.SEARCH_RESULT);
                displaySearchStudentTable(); 
                break;
            case SEARCH_TEACHER: Utility.log("Printing teacher"); break;
            case SEARCH_SUBJECT: Utility.log("Printing subject"); break;
        }
        
    }
    
    private void displaySearchStudentTable(){
        TableColumn col_id = new TableColumn();
        TableColumn col_firstName = new TableColumn();
        TableColumn col_middleName = new TableColumn();
        TableColumn col_lastName = new TableColumn();
        TableColumn col_dob = new TableColumn();
        TableColumn col_referenceNo = new TableColumn();
        TableColumn col_enrollmentNo = new TableColumn();
        TableColumn col_date = new TableColumn();
        
        col_id.setText(appContainer.uiControl.p_settings.labels.getLabel(Labels.labelTag.LABEL_ID));
        col_firstName.setText(appContainer.uiControl.p_settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_FIRST_NAME));
        col_middleName.setText(appContainer.uiControl.p_settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_MIDDLE_NAME));
        col_lastName.setText(appContainer.uiControl.p_settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_LAST_NAME));
        col_dob.setText(appContainer.uiControl.p_settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_DATE_OF_BIRTH));
        col_referenceNo.setText(appContainer.uiControl.p_settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_REFERENCE_NUMBER));
        col_enrollmentNo.setText(appContainer.uiControl.p_settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_ENROLLMENT_NUMBER));
        col_date.setText(appContainer.uiControl.p_settings.labels.getLabel(Labels.labelTag.ADD_STUDENT_DATE));
        
        col_id.setCellValueFactory(new PropertyValueFactory<Student,Integer>("studentId"));
        col_firstName.setCellValueFactory(new PropertyValueFactory<Student,String>("firstName"));
        col_middleName.setCellValueFactory(new PropertyValueFactory<Student,String>("middleName"));
        col_lastName.setCellValueFactory(new PropertyValueFactory<Student,String>("lastName"));
        col_dob.setCellValueFactory(new PropertyValueFactory<Student,String>("dob"));
        col_referenceNo.setCellValueFactory(new PropertyValueFactory<Student,String>("referenceNumber"));
        col_enrollmentNo.setCellValueFactory(new PropertyValueFactory<Student,String>("enrollmentNumber"));
        col_date.setCellValueFactory(new PropertyValueFactory<Student,String>("date"));
        
        searchTable.getColumns().addAll(
                col_id,col_firstName,col_middleName,col_lastName,
                col_dob, col_referenceNo, col_enrollmentNo, col_date
        );
        
        // Get Doubleclick event
//        searchTable.setRowFactory(tv -> {
//            TableRow<Student> row = new TableRow();
//            row.setOnMouseClicked(event -> {
//                if(event.getClickCount() == 2 && (!row.isEmpty())){
//                    Student rowData = row.getItem();
//                    Utility.log("onMouseClicked >> " + rowData);
//                    currentStudent = rowData;
//                    appContainer.displayScreen(AppContainer.screenTag.BROWSE_STUDENT_RECORD);
//                }
//            });
//            return row;
//        });
        
//        searchTable.setItems(data);

        
//        firstPage();
        
        // Code to get selected item in table.
//        searchTable.getSelectionModel().selectedItemProperty().addListener((oldValue) -> {
//            //Check whether item is selected and set value of selected item to Label
//            if (searchTable.getSelectionModel().getSelectedItem() != null) {
//                Utility.log("BrowseController | #################  | old: " + oldValue);
////                lblTool.setText(newValue.getTool());
//            }
//        });
    }
}
