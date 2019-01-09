package view;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import model.Game;
import model.Node;
import model.ResourceType;
import model.Road;
import model.Tile;

//Gère l'affichage lié à chaque tuile

public class TileView {
	
	private Tile tile;
	private GameView gameView;
	private ArrayList<NodeView> nodeViewList;
	
	private Label resourceLabel;
	private Label numberLabel;
	private Group tileGroup;
	private VBox vBox;
	private Polygon hexagon;
	private Polygon smallHexagon;
	private int scale;
	
	TileView(Tile ptile, ArrayList<NodeView> pnodeViewList, GameView gv) {
		tile = ptile;
		gameView = gv;
		nodeViewList = pnodeViewList;
		tileGroup = new Group();
		scale = 2;

		hexagon = new Polygon(
				nodeViewList.get(0).getX(),
				nodeViewList.get(0).getY(),
				nodeViewList.get(1).getX(),
				nodeViewList.get(1).getY(),
				nodeViewList.get(2).getX(),
				nodeViewList.get(2).getY(),
				nodeViewList.get(5).getX(),
				nodeViewList.get(5).getY(),
				nodeViewList.get(4).getX(),
				nodeViewList.get(4).getY(),
				nodeViewList.get(3).getX(),
				nodeViewList.get(3).getY());
		tileGroup.getChildren().add(hexagon);
		
		vBox = new VBox();
		
		if (tile.getResource().getType() != ResourceType.SEA) {
			vBox.setLayoutX(nodeViewList.get(0).getX());
			vBox.setLayoutY(nodeViewList.get(0).getY());
			vBox.setPrefWidth(nodeViewList.get(2).getX()-nodeViewList.get(0).getX());
			vBox.setAlignment(Pos.CENTER);
			
			resourceLabel = new Label(tile.getResource().getType().toString());
			resourceLabel.setStyle("-fx-font-size: 15;"
					+ "-fx-font-weight: bold;" 
					+ "-fx-text-fill: black;");
			vBox.getChildren().add(resourceLabel);
			
			numberLabel = new Label(Integer.toString(tile.getNumber()));
			numberLabel.setStyle( "-fx-font-size: 30;" 
					+ "-fx-text-fill: black;");
			vBox.getChildren().add(numberLabel);
			
			HBox resourceHBox = new HBox();
			resourceHBox.setAlignment(Pos.CENTER);
			Circle c;
			
			for (int i = 0; i < tile.getResource().getFood(); i++) {
				c = new Circle(10);
				c.setFill(Color.GREENYELLOW);
				c.setStroke(Color.BLACK);
				ImageView tmp = new ImageView(gameView.iManager.getFoodIcon());
				tmp.setFitHeight(30);
				tmp.setFitWidth(30);
				resourceHBox.getChildren().add(tmp);
			}
			
			for (int i = 0; i < tile.getResource().getConstruction(); i++) {
				c = new Circle(10);
				c.setFill(Color.SADDLEBROWN);
				c.setStroke(Color.BLACK);
				ImageView tmp = new ImageView(gameView.iManager.getConstructionIcon());
				tmp.setFitHeight(30);
				tmp.setFitWidth(30);
				resourceHBox.getChildren().add(tmp);
			}
			for (int i = 0; i < tile.getResource().getGold(); i++) {
				c = new Circle(10);
				c.setFill(Color.GOLD);
				c.setStroke(Color.BLACK);
				ImageView tmp = new ImageView(gameView.iManager.getGoldIcon());
				tmp.setFitHeight(30);
				tmp.setFitWidth(30);
				resourceHBox.getChildren().add(tmp);
			}
			for (int i = 0; i < tile.getResource().getEnergy(); i++) {
				c = new Circle(10);
				c.setFill(Color.CORNFLOWERBLUE);
				c.setStroke(Color.BLACK);
				ImageView tmp = new ImageView(gameView.iManager.getEnergyIcon());
				tmp.setFitHeight(30);
				tmp.setFitWidth(30);
				resourceHBox.getChildren().add(tmp);
			}
			
			vBox.getChildren().add(resourceHBox);
			tileGroup.getChildren().add(vBox);
		}
		
		
		
		
		
		smallHexagon = new Polygon(
				nodeViewList.get(0).getX()/scale,
				nodeViewList.get(0).getY()/scale,
				nodeViewList.get(1).getX()/scale,
				nodeViewList.get(1).getY()/scale,
				nodeViewList.get(2).getX()/scale,
				nodeViewList.get(2).getY()/scale,
				nodeViewList.get(5).getX()/scale,
				nodeViewList.get(5).getY()/scale,
				nodeViewList.get(4).getX()/scale,
				nodeViewList.get(4).getY()/scale,
				nodeViewList.get(3).getX()/scale,
				nodeViewList.get(3).getY()/scale);
		refreshColor();
	}
		
	
	void refreshColor(){

		switch (tile.getResource().getType()) {
		case COAL:
			resourceLabel.setStyle("-fx-font-size: 15;"
					+ "-fx-font-weight: bold;" 
					+ "-fx-text-fill: white;");
			numberLabel.setStyle( "-fx-font-size: 30;" 
					+ "-fx-text-fill: white;");
			
			hexagon.setFill(Color.BLACK);
			smallHexagon.setFill(Color.BLACK);
			break;
		case FOOD:
			hexagon.setFill(Color.DARKOLIVEGREEN);
			smallHexagon.setFill(Color.DARKOLIVEGREEN);
			break;
		case GOLD:
			hexagon.setFill(Color.YELLOW);
			smallHexagon.setFill(Color.YELLOW);
			break;
		case METAL: 
			hexagon.setFill(Color.GREY);
			smallHexagon.setFill(Color.GREY);
			break;
		case MOUNTAIN:
			hexagon.setFill(Color.WHITE);
			smallHexagon.setFill(Color.WHITE);
			break;
		case OIL: 
			hexagon.setFill(Color.DARKGREY);
			smallHexagon.setFill(Color.DARKGREY);
			break;
		case PLUTONIUM: 
			hexagon.setFill(Color.LIMEGREEN);
			smallHexagon.setFill(Color.LIMEGREEN);
			break;
		case SEA: 
			hexagon.setFill(Color.TRANSPARENT);
			smallHexagon.setFill(Color.TRANSPARENT);
			break;
		case WOOD: 
			hexagon.setFill(Color.SADDLEBROWN);
			smallHexagon.setFill(Color.SADDLEBROWN);
			break;
		default:
			break;

		}

	}
	
	Polygon getTileGroup() {
		return hexagon;
	}
	
	Polygon getSmallHexagon() {
		return smallHexagon;
	}
	
	VBox getVBox() {
		return vBox;
	}
}
