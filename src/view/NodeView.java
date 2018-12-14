package view;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Game;
import model.Node;
import model.Tile;

//Gère l'affichage lié à chaque node

public class NodeView {
	private Node node;
	private Game game;
	private int X;
	private int Y;
	private Circle circle;
	private Circle smallCircle;
	private int radius;
	private int scale;
	
	
	NodeView(Node pnode, int pX, int pY,Game g) {
		game = g;
		radius = 20;
		scale = 2;
		node = pnode;
		X = pX;
		Y = pY;
		circle = new Circle(pX, pY, radius);
		smallCircle = new Circle(pX/scale, pY/scale, radius/scale);
		refreshColor();
		
		circle.addEventHandler(MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
		          public void handle(MouseEvent me) {
		            System.out.println("Click on Node " + 
		          node.getX()+ " " +
		          node.getY());
		          }
		        });
	}
	
	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	public Node getNode() {
		return node;
	}
	
	public Circle getCircle() {
		return circle;
	}
	
	public Circle getSmallCircle() {
		return smallCircle;
	}
	
	void refreshColor(){
		switch (node.getStatus()) {
			case EMPTY:
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);
			smallCircle.setFill(Color.WHITE);
			smallCircle.setStroke(Color.BLACK);
				break;
			case PLAYER1:
				break;
			case PLAYER2:
				break;
			case PLAYER3:
				break;
			case PLAYER4:
				break;
			case SEA:
			circle.setFill(Color.TRANSPARENT);
			smallCircle.setFill(Color.TRANSPARENT);
				break;
			default:
				break;
		}
			
	}
	static NodeView getNodeViewByNode(Node pnode, ArrayList<NodeView> arrayList){
		for (NodeView nv : arrayList) {
			if (nv.node == pnode) {
				return nv;
			}
		}
		return null;
	}
	
	static ArrayList<NodeView> getNodeViewListFromTile(Tile tile, ArrayList<NodeView> nodeViewList) {
		ArrayList<NodeView> tmpNodeViewList = new ArrayList<NodeView>();
		for (Node n : tile.getNodeList()) {
				tmpNodeViewList.add(getNodeViewByNode(n, nodeViewList));
		}
		
		return tmpNodeViewList;
	}
}
