package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class PlayerBar {
	private VBox playerVBox;
	
	public PlayerBar(ArrayList<PlayerView> pvList){
		playerVBox = new VBox();
		playerVBox.setAlignment(Pos.CENTER);
		for (PlayerView pv : pvList) {
			playerVBox.getChildren().add(pv.getGridPane());
		}
	}
	
	VBox getPlayerVBox() {
		return playerVBox;
	}
	
	
}
