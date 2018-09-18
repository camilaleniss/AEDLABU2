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
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/lobby.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	Stage stage = (Stage)btnContinue.getScene().getWindow();
    	stage.setScene(scene);
    	Lobby lob = loader.getController();
    	lob.setAsd("willy");
    	lob.initData();
		stage.show();
    }
}
