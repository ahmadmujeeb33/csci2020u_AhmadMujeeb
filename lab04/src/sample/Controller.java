package sample;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



import javafx.scene.control.DatePicker;


import java.awt.*;

public class Controller {
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField nameField;
    @FXML
    private PasswordField password;
    @FXML
    private TextField fullnme;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;

    @FXML
    public void btnOnPress(ActionEvent event) {
        System.out.println(nameField.getText());
        System.out.println(password.getText());
        System.out.println(fullnme.getText());
        System.out.println(email.getText());
        System.out.println(phone.getText());
        System.out.println(datePicker.getEditor().getText());

    }

}
