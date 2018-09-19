package controller;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    void createGames(ActionEvent event) {

    }

}
