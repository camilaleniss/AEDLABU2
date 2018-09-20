package controller;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.Fortnite;
import model.StackException;
import model.Weapon;

public class StValentinesController {

	@FXML
	private JFXButton btnUse;

	@FXML
	private JFXButton btnPick;

	@FXML
	private Label lblAmmo;

	@FXML
	private HBox boxRare;

	@FXML
	private ImageView imgWeapon;

	private Fortnite fort;

	@FXML
	void pickupWeapon(ActionEvent event) {
		fort.pickUpWeapon();
		updateWeapon();
	}

	@FXML
	void useWeapon(ActionEvent event) {
		fort.useWeapon();
		updateWeapon();
	}

	public void init(Fortnite fort) {
		this.fort = fort;
		updateWeapon();
	}

	private void updateWeapon() {
		try {
			Weapon weapon = fort.getInventory().top();
			imgWeapon.setImage(weapon.getImage());
			lblAmmo.setText("" + weapon.getSupplies());
			switch (weapon.getRange()) {
			case Weapon.BASIC:
				boxRare.setStyle("-fx-background-color: rgb(" + 123 + "," + 123 + ", " + 123 + ");");
				break;
			case Weapon.UNCOMMON:
				boxRare.setStyle("-fx-background-color: rgb(" + 58 + "," + 121 + ", " + 19 + ");");
				break;
			case Weapon.RARE:
				boxRare.setStyle("-fx-background-color: rgb(" + 18 + "," + 88 + ", " + 162 + ");");
				break;
			case Weapon.EPIC:
				boxRare.setStyle("-fx-background-color: rgb(" + 130 + "," + 38 + ", " + 189 + ");");
				break;
			case Weapon.LEGENDARY:
				boxRare.setStyle("-fx-background-color: rgb(" + 255 + "," + 118 + ", " + 5 + ");");
				break;
			}
		} catch (StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
