package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import model.Node;
import model.Road;
import model.StatusNodeType;
import model.Map;

public class Board {
	
	public static void display(Map map) {
		Stage boardWindow = new Stage();
		
		boardWindow.setTitle("BoardWindow");
		
		Group board = new Group();
		Circle tmpCircle;
		Node tmpNode;
		Line tmpLine;
		
		
		for (Road road : map.getroadList()) {
			tmpLine = new Line(
					road.getNode1().getY()*100+50,
					road.getNode1().getX()*100+50,
					road.getNode2().getY()*100+50,
					road.getNode2().getX()*100+50);
			tmpLine.setStrokeWidth(8);
			tmpLine.setOnMouseClicked(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent t) {
	                System.out.println("clicked on road");
	            }
	        });
			
			board.getChildren().add(tmpLine);
		}
		
		for (int i = 0; i < map.getSize()+3; i++){
			for(int j = 0; j < map.getSize()*2+3; j++){
				
				tmpNode = map.getNodeFromNodeList(i, j);
				if ( tmpNode.getStatus() ==  StatusNodeType.EMPTY) {
						tmpCircle = new Circle(tmpNode.getY()*100+50, tmpNode.getX()*100+50, 25);
						tmpCircle.setOnMouseClicked(new EventHandler<MouseEvent>()
				        {
				            @Override
				            public void handle(MouseEvent t) {
				                System.out.println("clicked on circle");
				            }
				        });
						board.getChildren().add(tmpCircle);
				}
			}
		}
		
		Scene scene = new Scene(board, 1000, 1000);
		boardWindow.setScene(scene);
		boardWindow.show();
}

}