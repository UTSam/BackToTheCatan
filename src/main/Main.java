package main;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import model.Map;
import view.Board;

public class Main  extends Application{
	
	Stage mainMenu;
	Button startButton;
	
    public static void main(String[] args) {
		launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Generation of the map
		Map map= new Map();
    	map.setToBigSize();
		map.generateMap();
		map.printRoad();
		map.printTile();
		
		//Displaying the board
		Board board = new Board(50, 50, 70);
		mainMenu = primaryStage;
		mainMenu.setTitle("MainMenu");
		
		startButton = new Button("START");
		startButton.setOnAction( e -> board.display(map));
		VBox layout = new VBox(10);
		layout.getChildren().addAll(startButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 600, 300);
		mainMenu.setScene(scene);
		mainMenu.show();
		

	}
}