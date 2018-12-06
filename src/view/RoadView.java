package view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import model.Road;

// Gère l'affichage lié à chaque route

public class RoadView {
	private Road road;
	private NodeView nodeView1;
	private NodeView nodeView2;
	private Line line;
	private Line underLine;
	
	private int width;
	
	RoadView(Road proad, NodeView n1, NodeView n2) {
		road = proad;
		nodeView1 = n1;
		nodeView2 = n2;
		width = 12;
		line = new Line(nodeView1.getX(), nodeView1.getY(), nodeView2.getX(), nodeView2.getY());
		line.setStrokeWidth(width);
		this.refreshColor();
		
		underLine = new Line(nodeView1.getX(), nodeView1.getY(), nodeView2.getX(), nodeView2.getY());
		underLine.setStrokeWidth(width+4);
		underLine.setStroke(Color.BLACK);
		
		line.addEventHandler(MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
		          public void handle(MouseEvent me) {
		            System.out.println("Click on Road from Node " + 
		          nodeView1.getNode().getX()+ " " +
		          nodeView1.getNode().getY()+
		          " to "+
		          nodeView2.getNode().getX()+ " " +
		          nodeView2.getNode().getY());
		          }
		        });
	}
	
	public Line getUnderLine() {
		return underLine;
	}
	
	public Line getLine() {
		return line;
	}
	
	void refreshColor(){

		switch (road.getStatus()) {
		case EMPTY:
			line.setStroke(Color.WHITE);
			break;
		case PLAYER1:
			break;
		case PLAYER2:
			break;
		case PLAYER3:
			break;
		case PLAYER4:
			break;
		default:
			break;
		}
	}
}
