package view;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.MouseEvent;
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
	WorldMap worldMap;
	
	BorderPane borderPane;
	Stage gameWindow;
	Scene scene;

	public GameView(ArrayList<Map> pmapList){
		mapList = pmapList;
		mapViewList = new ArrayList<MapView>();
		for (Map m : mapList) {
			mapViewList.add(new MapView(m));
		}
		worldMap = new WorldMap(mapViewList);
		generateWorldMap();
		
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
		
		worldMap.generate();
		setMapView(worldMap);
		
		gameWindow.show();
		gameWindow.setMaximized(true);
		//boardWindow.setFullScreen(true);
	}
	
		
		//GENERATION DES ELEMENTS DE L'IINTERFACE------------------------------------------------------
	
	private void setMapView(MapView mapView) {
		borderPane.setCenter(mapView.getBorderPane());
	}
	
	private void setMapView(WorldMap worldMap) {
		borderPane.setCenter(worldMap.getGridPane());
	}
	
	private void generateWorldMap(){
		
		worldMap.getMap1Group().addEventHandler(MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
	          public void handle(MouseEvent me) {
	        	  setMapView(mapViewList.get(0));
	          }
	        });
		
		worldMap.getMap2Group().addEventHandler(MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
	          public void handle(MouseEvent me) {
	        	  setMapView(mapViewList.get(1));
	          }
	        });
		
		worldMap.getMap3Group().addEventHandler(MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
	          public void handle(MouseEvent me) {
	        	  setMapView(mapViewList.get(2));
	          }
	        });
		
		worldMap.getMap4Group().addEventHandler(MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
	          public void handle(MouseEvent me) {
	        	  setMapView(mapViewList.get(3));
	          }
	        });
		
		for (MapView mv : mapViewList) {
			mv.getBackButton().addEventHandler(MouseEvent.MOUSE_PRESSED,
			        new EventHandler<MouseEvent>() {
		          public void handle(MouseEvent me) {
		        	  setMapView(worldMap);
		          }
		        });
		}
	}
}