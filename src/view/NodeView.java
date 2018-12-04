package view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Node;


public class NodeView {
	private Node node;
	private int X;
	private int Y;
	private Circle circle;
	
	NodeView(Node pnode, int pX, int pY) {
		node = pnode;
		X = pX;
		Y = pY;
		circle = new Circle(pX, pY, 20);
		this.refreshColor();
		
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
	
	void refreshColor(){
		switch (node.getStatus()) {
			case EMPTY:
			circle.setFill(Color.BLACK);
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
				break;
			default:
				break;
		}
			
	}
}
