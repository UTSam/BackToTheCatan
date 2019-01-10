package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DiceBox {
	public static void display(GameView gv) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setWidth(500);
		window.setHeight(500);
		window.setResizable(false);
		
		Label label = new Label(gv.getGame().getCurrentPlayer().getName() + " vous avez obtenu un " + gv.getGame().getDice().getSum() + " (" + gv.getGame().getDice().getDice1() + " + " + gv.getGame().getDice().getDice2() + ")");
		Button close = new Button("Jouer");
		close.setPrefSize(200, 100);
		close.setOnAction(e-> window.close());
		
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);
		
		vBox.getChildren().addAll(label,close);
		
		Scene scene = new Scene(vBox);
		scene.getStylesheets().add("resources/style.css");
		window.setScene(scene);
		window.showAndWait();
	}
}
