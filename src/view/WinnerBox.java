package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Player;

public class WinnerBox {
	public static void display(Player player) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setWidth(600);
		window.setHeight(500);
		window.setResizable(false);
		
		Label label = new Label(player.getName() + " a gagné !!!\n\n\n\n");
		label.setStyle( "-fx-font-size: 50");
		
		Button close = new Button("Fermer");
		close.setPrefSize(200, 100);
		close.setOnAction(e -> window.close());
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(label, close);
		vBox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(vBox);
		scene.getStylesheets().add("resources/style.css");
		window.setScene(scene);
		window.showAndWait();
	}
}
