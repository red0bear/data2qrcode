package com.gladic.data2qrcode;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Controller implements Initializable{
  
    private simpleqrcode classqrcode;     
        
    @FXML
    private TextField textfielddata;  
        
    @FXML
    private ImageView userqrcode;
    
    @FXML
    private Button qrcodegen;
            
    @FXML
    private Button qrcodesave;
    
    @FXML
    private void HandleConvertAction(ActionEvent event){
        
        classqrcode = new simpleqrcode();
        userqrcode.setPreserveRatio(true);
        userqrcode.setImage(classqrcode.get_qr_code(textfielddata.getText()));
    }
    
    @FXML
    private void HandleSaveAction(ActionEvent event){
      classqrcode.saveqrcode();
    }    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
