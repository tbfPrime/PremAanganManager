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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import premaanganmanager.configurable.Labels;

/**
 *
 * @author Trevor Fernandes
 */

public class SearchController {
    private AppContainer appContainer;

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
    private void searchAction(){
        System.out.println("SearchController | searchAction");
        appContainer.displayScreen(AppContainer.screenTag.SEARCH_RESULT);
    }
    
    @FXML 
    private void searchFilterResetAction(){
        System.out.println("SearchController | searchFilterResetAction");
    }
    
    @FXML
    private void searchResultBackAction(){
        System.out.println("SearchController | searchResultBackAction");
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
            System.out.println("Error | AppContainer | setSearch | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
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
            System.out.println("Error | AppContainer | setSearchResults | " + e);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    // Private functions
    private void setSearchScreenData(){
        setSearchScreenStyling();
    }
    
    private void setSearchResultScreenData(){
        setSearchResultScreenLabels();
    }
    
    private void setSearchScreenStyling(){
        searchFilterVBox.setId("ActiveBG");
        searchFilterButtonHBox.setId("ActiveBG");
    }
    
    private void setSearchResultScreenLabels(){
        searchResultBackButton.setText(appContainer.uiControl.settings.labels.getLabel(Labels.labelTag.BACK));
    }
}
