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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
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
	
	private Game game;
	
	private ArrayList<MapView> mapViewList;
	private ArrayList<PlayerView> playerViewList;
	private WorldMap worldMap;
	private PlayerBar playerBar;
	private ActionBar actionBar;
	
	private BorderPane borderPane;
	private Stage gameWindow;
	private Scene scene;

	public GameView(Game g){
		game = g;
		
		mapViewList = new ArrayList<MapView>();
		for (Map m : game.getMapList()) {
			mapViewList.add(new MapView(m, game));
		}
		worldMap = new WorldMap(mapViewList);
		generateWorldMap();
		
		playerViewList = new ArrayList<PlayerView>();
		borderPane = new BorderPane();
		/*BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
		BackgroundImage bi = new BackgroundImage(new Image("file:BackToTheCatan/ressources/blue_background.jpg"),
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
		          bSize);
		borderPane.setBackground(new Background(bi));*/
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
		
		generatePlayerBar();
		generateActionBar();
		
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
	private void generatePlayerBar() {
		
		PlayerView p1View = new PlayerView(game.getPlayerList().get(0), Color.RED, this);
		PlayerView p2View = new PlayerView(game.getPlayerList().get(1), Color.BLUE, this);
		PlayerView p3View = new PlayerView(game.getPlayerList().get(2), Color.GREEN, this);
		PlayerView p4View = new PlayerView(game.getPlayerList().get(3), Color.YELLOW, this);
		playerViewList.add(p1View);
		playerViewList.add(p2View);
		playerViewList.add(p3View);
		playerViewList.add(p4View);
		playerBar = new PlayerBar(playerViewList);
		borderPane.setRight(playerBar.getPlayerVBox());
	}
	
	private void generateActionBar() {
		actionBar = new ActionBar(this);
		borderPane.setLeft(actionBar.getActionVBox());
		
		
	}
	
	// GETERS
	public Game getGame() {
		return game;
	}
	public ArrayList<PlayerView> getPlayerViewList() {
		return playerViewList;
	}
}