/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.components;

import premaanganmanager.base.controller.Utility;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Font;
import premaanganmanager.base.controller.UIControl;

/**
 *
 * @author Trevor Fernandes
 */
public class CustomToggleButton1 extends ToggleButton{

    /**
     * Creates a customToggleButton1 with style class "CustomToggleButton1"
     * default text "Foo"
     */
    public CustomToggleButton1(){
        this.getStylesheets().add(Utility.getPathCSS(UIControl.getComponentCssFilename()));
        getStyleClass().add("CustomToggleButton1");
        setText("Foo");
        mnemonicParsingProperty().set(false);
        setFont(Font.font(UIControl.getButtonFontSize()));
    }
}
