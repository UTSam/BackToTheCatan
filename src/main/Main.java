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
import model.Card;
import model.CardType;
import model.Game;
import model.Map;
import view.CardBox;
import view.DiscoveryBox;
import view.GameView;
import view.MainMenu;
import view.WinnerBox;

public class Main  extends Application{


    public static void main(String[] args) {
		launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Generation of the map
		Game game= new Game();
		//game.Run();
		/*Map map= new Map();
    	map.setToBigSize();
		map.generateMap();*/


		//Displaying the board
		//GameView gameView = new GameView(game.getMapList());
		GameView gameView = new GameView(game);
		
		MainMenu mainMenu = new MainMenu(primaryStage, gameView);
	}
}