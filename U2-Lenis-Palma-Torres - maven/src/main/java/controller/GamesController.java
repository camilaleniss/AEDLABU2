package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Fortnite;
import model.Game;
import model.Matchmaking;
import model.Player;
import model.Server;

public class GamesController {

    @FXML
    private JFXButton btnStart;

    @FXML
    private JFXListView<Label> listPlayers;

    @FXML
    private JFXComboBox<Integer> comboGame;

    @FXML
    private JFXButton btnRefresh;
    
    @FXML
    private Label lblPlayers;
    
    private Fortnite fort;
    
    private Matchmaking mm;

    @FXML
    void refresh(ActionEvent event) {
    	
    	ObservableList<Label> list = FXCollections.observableArrayList();
    	
    	int index = comboGame.getSelectionModel().getSelectedIndex();
    	Player[] players = mm.getMatches()[index].getPlayers();
    	
    	for (int i = 0; i < players.length; i++) {
			list.add(new Label(players[i].toString()));
		}
    	
    	listPlayers.setItems(list);
    	
    	lblPlayers.setText("   -   Players: "+players.length);
    	
    }

    @FXML
    void startGame(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/stvalentines.fxml"));
    	Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
	    	Stage stage = (Stage)btnStart.getScene().getWindow();
	    	stage.setScene(scene);
	    	StValentinesController contr = loader.getController();
	    	contr.init(fort);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public void init(Fortnite fort) {
    	this.fort = fort;
		String platform = fort.getPlatform();
		Server server = fort.getServer();

		if (fort.isPlatformMode()) {
			mm = server.getPlatform().search(platform);
		} else {
			mm = server.getPlatform().search(Server.ALL);
		}
		
		mm.createGames();

		ObservableList<Integer> list = FXCollections.observableArrayList();
		
		for (int i = 0; i < mm.getMatches().length; i++) {
			list.add(i+1);
		}

		comboGame.setItems(list);
		
		comboGame.getSelectionModel().select(0);
		
		refresh(null);
		
		

    }

}
