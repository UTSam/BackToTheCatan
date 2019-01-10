package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class PlayerBar {
	private ArrayList<PlayerView> playerViewList;
	private VBox playerVBox;
	
	public PlayerBar(ArrayList<PlayerView> pvList){
		playerViewList = pvList;
		playerVBox = new VBox();
		playerVBox.setAlignment(Pos.CENTER_RIGHT);
		for (PlayerView pv : playerViewList) {
			playerVBox.getChildren().add(pv.getGridPane());
		}
	}
	
	VBox getPlayerVBox() {
		return playerVBox;
	}
	
	void disableButtons(Boolean bool) {
		for (PlayerView pv : playerViewList) {
			pv.disableButtons(bool);
		}
	}
	
	
}
