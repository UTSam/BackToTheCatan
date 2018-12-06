package view;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Node;
import model.Road;
import model.Tile;
import model.Game;
import model.Map;

public class GameView {
	
	ArrayList<Map> mapList;
	ArrayList<MapView> mapViewList;
	
	BorderPane borderPane;
	Stage gameWindow;
	Scene scene;

	public GameView(ArrayList<Map> pmapList){
		mapList = pmapList;
		mapViewList = new ArrayList<MapView>();
		for (Map m : mapList) {
			mapViewList.add(new MapView(m));
		}
		
		borderPane = new BorderPane();
		gameWindow = new Stage();
		gameWindow.setTitle("gameWindow");
		scene = new Scene(borderPane, 2000, 1000);
		gameWindow.setScene(scene);
	}
	

	public void generate() {

		
		for (MapView mv : mapViewList) {
			mv.generate();
		}
		/*GlobalMap globalMap = new GlobalMap(mapViewList);
		globalMap.generate();*/
		generateDateButtons();
		
		gameWindow.show();
		gameWindow.setMaximized(true);
		//boardWindow.setFullScreen(true);
	}
	
		
		//GENERATION DES ELEMENTS DE L'IINTERFACE------------------------------------------------------
		private void generateDateButtons() {
		
		HBox dateHBox = new HBox();
		
		Button b1850 = new Button("1850");
		Button b1955 = new Button("1955");
		Button b1985 = new Button("1985");
		Button b2015 = new Button("2015");
		
		b1850.setPrefSize(250, 100);
		b1955.setPrefSize(250, 100);
		b1985.setPrefSize(250, 100);
		b2015.setPrefSize(250, 100);

		b1850.setOnAction( e -> setMapView(mapViewList.get(0)));
		b1955.setOnAction( e -> setMapView(mapViewList.get(1)));
		b1985.setOnAction( e -> setMapView(mapViewList.get(2)));
		b2015.setOnAction( e -> setMapView(mapViewList.get(3)));
			
		dateHBox.getChildren().addAll(b1850, b1955, b1985, b2015);
		dateHBox.setAlignment(Pos.CENTER);
		dateHBox.setSpacing(25);
		
		borderPane.setBottom(dateHBox);
	}
	
	private void setMapView(MapView mapView) {
		borderPane.setCenter(mapView.borderPane);
	}
}