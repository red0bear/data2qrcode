/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gladic.data2qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Base64;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author felipe
 */
public class simpleqrcode {
    
    private Image aux;
    private ByteArrayOutputStream pngOutputStream;
    private ByteArrayInputStream pngInputStream;
    private String namevalue;
    
    public String generaterandom(int lenght)
    {
        return java.util.UUID.randomUUID().toString();
    }
       
    public Image get_qr_code(String value)
    {     
        namevalue = value;
        return get_qr_code_Image(value, 500 , 500); 
    }
    
    /*QR CODE*/
    private Image get_qr_code_Image(String text, int width, int height)  
    {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
              
            pngInputStream = new ByteArrayInputStream(pngOutputStream.toByteArray());
            aux = new Image(pngInputStream);
              
           return aux;

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (WriterException ex) {
            ex.printStackTrace();
        }
            
        return null;
    } 

    public void saveqrcode()
    {
       
        try {
            BufferedImage read = ImageIO.read(new ByteArrayInputStream(pngOutputStream.toByteArray()));
            BigInteger result = new BigInteger(Base64.getEncoder().encodeToString(namevalue.getBytes()).getBytes());
            File data = new File(result.toString()+".png");
            ImageIO.write(read, "PNG", data);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
