module com.gladic.data2qrcode {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.zxing.javase;
    requires com.google.zxing;
    requires java.desktop;

    opens com.gladic.data2qrcode to javafx.fxml;
    exports com.gladic.data2qrcode;
}
