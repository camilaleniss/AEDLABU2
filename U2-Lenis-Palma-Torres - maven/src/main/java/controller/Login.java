package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Login {
	
    @FXML
    private JFXButton btnContinue;

    @FXML
    void startFortnite(ActionEvent event) throws IOException {
    	Stage stage = (Stage)btnContinue.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("/view/lobby.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
}
