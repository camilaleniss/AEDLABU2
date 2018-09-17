package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
	void startGame(ActionEvent event) {

		Fortnite fort = new Fortnite(comboPlatform.getSelectionModel().getSelectedItem(), chkPlatform.isSelected());
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ObservableList<String> list = FXCollections.observableArrayList(Server.XBOX, Server.PLAYSTATION, Server.SWITCH,
				Server.PC, Server.MOBILE);

		comboPlatform.setItems(list);
		
		comboPlatform.getSelectionModel().select(0);

	}

}
