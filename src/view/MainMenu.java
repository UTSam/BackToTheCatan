package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Player;

public class MainMenu {
	private Stage stage;
	
	
	public MainMenu(Stage primaryStage, GameView gameView){
		
		stage = primaryStage;
		stage.setTitle("MainMenu");
		
		Label title = new Label("Back To The Catan");
		title.setStyle( "-fx-font-size: 50;");
		
		TextField name1 = new TextField();
		name1.setPrefColumnCount(15);
		name1.setPromptText("Entrer le nom du joueur 1");
		name1.setMaxSize(400, 30);
		TextField name2 = new TextField();
		name2.setPrefColumnCount(15);
		name2.setMaxSize(400, 30);
		name2.setPromptText("Entrer le nom du joueur 2");
		TextField name3 = new TextField();
		name3.setPrefColumnCount(15);
		name3.setMaxSize(400, 30);
		name3.setPromptText("Entrer le nom du joueur 3");
		TextField name4 = new TextField();
		name4.setPrefColumnCount(15);
		name4.setMaxSize(400, 30);
		name4.setPromptText("Entrer le nom du joueur 4");
		
		
		Button startButton = new Button("JOUER");
		startButton.setStyle( "-fx-font-size: 40;");
		startButton.setOnAction( e -> {
			ArrayList<Player> tmpList = new ArrayList<Player>();
			tmpList = gameView.getGame().getPlayerList();
			tmpList.get(0).setName(name1.getText());
			tmpList.get(1).setName(name2.getText());
			tmpList.get(2).setName(name3.getText());
			tmpList.get(3).setName(name4.getText());
			gameView.generate();
			primaryStage.close();
		});
		startButton.setPrefSize(400, 100);
		VBox layout = new VBox(30);
		layout.getChildren().addAll(title, name1, name2, name3, name4, startButton);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout, 500, 500);
		scene.getStylesheets().add("resources/style.css");
		stage.setScene(scene);
		stage.show();
	}
}
