/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premaanganmanager.base.components;

import premaanganmanager.base.controller.Utility;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import premaanganmanager.base.controller.UIControl;

/**
 *
 * @author Trevor Fernandes
 */
public class CustomButton extends Button{

    /**
     * Creates a CustomButton with style class "CustomButton"
     * default text "Foo"
     */
    public CustomButton() {
        this.getStylesheets().add(Utility.getPathCSS(UIControl.getComponentCssFilename()));
        getStyleClass().add("CustomButton");
        setText("Foo");
        mnemonicParsingProperty().set(false);
        setFont(Font.font(UIControl.getButtonFontSize()));
    }
}
