package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Fortnite;
import model.Server;
import model.Player;

public class PlayersController {

	@FXML
	private JFXButton btnCreate;

	@FXML
	private JFXListView<Label> listPlayers;

	@FXML
	private Label lblPlatform;
	
	private Fortnite fort;

	public void init(Fortnite fort) {
		this.fort = fort;
		String platform = fort.getPlatform();
		Server server = fort.getServer();
		ArrayList<Player> players = null;
		if (fort.isPlatformMode()) {
			players = server.getPlatform().search(platform).getPlayers();
			lblPlatform.setText("Platform: " + platform);
		} else {
			players = server.getPlatform().search(Server.ALL).getPlayers();
			lblPlatform.setText("Platform: All");
		}

		for (int i = 0; i < players.size(); i++) {
			listPlayers.getItems().add(new Label(players.get(i).toString()));
		}
	}
	
	@FXML
    void createGames(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/games.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	Stage stage = (Stage)btnCreate.getScene().getWindow();
    	stage.setScene(scene);
    	GamesController contr = loader.getController();
    	contr.init(fort);
		stage.show();
    }

}
