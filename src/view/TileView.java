package view;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import model.Node;
import model.Road;
import model.Tile;

//Gère l'affichage lié à chaque tuile

public class TileView {
	
	private Tile tile;
	private ArrayList<NodeView> nodeViewList;
	private Polygon hexagon;
	
	TileView(Tile ptile, ArrayList<NodeView> pnodeViewList) {
		tile = ptile;
		nodeViewList = pnodeViewList;
		hexagon = new Polygon(
				pnodeViewList.get(0).getX(),
				pnodeViewList.get(0).getY(),
				pnodeViewList.get(1).getX(),
				pnodeViewList.get(1).getY(),
				pnodeViewList.get(2).getX(),
				pnodeViewList.get(2).getY(),
				pnodeViewList.get(5).getX(),
				pnodeViewList.get(5).getY(),
				pnodeViewList.get(4).getX(),
				pnodeViewList.get(4).getY(),
				pnodeViewList.get(3).getX(),
				pnodeViewList.get(3).getY());
		refreshColor();
		
		hexagon.addEventHandler(MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
	          public void handle(MouseEvent me) {
	            System.out.println("Click on Tile surrounded by : " 
	            					+ pnodeViewList.get(0).getNode().getX() + ","
	            					+ pnodeViewList.get(0).getNode().getY() + " "
	            					+ pnodeViewList.get(1).getNode().getX() + ","
	            					+ pnodeViewList.get(1).getNode().getY() + " "
	            					+ pnodeViewList.get(2).getNode().getX() + ","
	            					+ pnodeViewList.get(2).getNode().getY() + " "
	            					+ pnodeViewList.get(3).getNode().getX() + ","
	            					+ pnodeViewList.get(3).getNode().getY() + " "
	            					+ pnodeViewList.get(4).getNode().getX() + ","
	            					+ pnodeViewList.get(4).getNode().getY() + " "
	            					+ pnodeViewList.get(5).getNode().getX() + ","
	            					+ pnodeViewList.get(5).getNode().getY() );
	          }
	        });
	}
	
	void refreshColor(){

		switch (tile.getResourceType()) {
		case COAL:
			hexagon.setFill(Color.BLACK);
			break;
		case FOOD:
			hexagon.setFill(Color.DARKOLIVEGREEN);
			break;
		case GOLD:
			hexagon.setFill(Color.YELLOW);
			break;
		case METAL: hexagon.setFill(Color.GREY);
			break;
		case MOUNTAIN:
			hexagon.setFill(Color.WHITE);
			break;
		case OIL: hexagon.setFill(Color.DARKGREY);
			break;
		case PLUTONIUM: hexagon.setFill(Color.LIMEGREEN);
			break;
		case SEA: hexagon.setFill(Color.LIGHTSKYBLUE);
			break;
		case WOOD: hexagon.setFill(Color.SADDLEBROWN);
			break;
		default:
			break;

		}

	}
	
	Polygon getHexagon() {
		return hexagon;
	}

}
