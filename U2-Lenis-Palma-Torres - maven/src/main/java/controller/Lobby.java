package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Fortnite;
import model.Server;

public class Lobby implements Initializable {

	@FXML
	private JFXButton btnPlay;

	@FXML
	private JFXCheckBox chkPlatform;

	@FXML
	private JFXComboBox<String> comboPlatform;
	
	@FXML
	void startGame(ActionEvent event) throws IOException {
		Fortnite fort = new Fortnite(comboPlatform.getSelectionModel().getSelectedItem(), chkPlatform.isSelected());
		
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/players.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	Stage stage = (Stage)btnPlay.getScene().getWindow();
    	stage.setScene(scene);
    	PlayersController contr = loader.getController();
    	contr.init(fort);
		stage.show();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		chkPlatform.setSelected(true);

		ObservableList<String> list = FXCollections.observableArrayList(Server.XBOX, Server.PLAYSTATION, Server.SWITCH,
				Server.PC, Server.MOBILE);

		comboPlatform.setItems(list);
		
		comboPlatform.getSelectionModel().select(0);
		

	}

}
