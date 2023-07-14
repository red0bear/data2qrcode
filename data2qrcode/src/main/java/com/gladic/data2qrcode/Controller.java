package com.gladic.data2qrcode;

import java.net.URL;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private ComboBox randomtype;
    
    @FXML
    private TextField lenghtofpassword;
    
    @FXML
    private void HandleRandomAction(ActionEvent event)
    {
        if(lenghtofpassword.getText().matches("[0-9]+"))
        {    
         classqrcode = new simpleqrcode();
         String result = classqrcode.generaterandom(Integer.parseInt(lenghtofpassword.getText()),randomtype.getSelectionModel().getSelectedItem().toString());
         userqrcode.setPreserveRatio(true);
         userqrcode.setImage(classqrcode.get_qr_code(result));
         textfielddata.setText(result);
        }  
    }
    
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
        
        randomtype.setItems(observableArrayList(new String[]{"UUID","PASSWORD","HARDPASSWORD"}));
        randomtype.getSelectionModel().selectFirst();
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
