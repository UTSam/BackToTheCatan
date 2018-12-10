package view;

import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PlayerView {
	GridPane gridPane;
	
	public PlayerView() {
		gridPane.setPrefSize(300, 200);
		gridPane.add(new Rectangle(250, 150), 0, 0);
	}
	
	public GridPane getGridPane() {
		return gridPane;
	}
}
