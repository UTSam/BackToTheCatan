package view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.CardType;
import model.Player;

public class CardBox {
	public static void display(Player player) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setWidth(1000);
		window.setHeight(600);
		window.setResizable(false);
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(50, 50, 50, 50));
		gridPane.setHgap(25);
		gridPane.setVgap(25);
		CardView cv = new CardView(player, CardType.Knight);
		gridPane.add(cv.getGroup(), 0, 0);
		
		
		
		//GridPane.setHalignment(nbConstruction1L, HPos.CENTER);
		Scene scene = new Scene(gridPane);
		scene.getStylesheets().add("resources/style.css");
		window.setScene(scene);
		window.showAndWait();
	}
}
