package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {

        Application.launch(args);
    }
	@Override
	public void start(Stage stage) {
		Group group = new Group();
    	Board board = new Board();
    	
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				if (board.nodeGrid[i][j].status == 1){
					group.getChildren().add(new Circle(
							board.nodeGrid[i][j].X,
							board.nodeGrid[i][j].Y,
							5));	
				}			
			}
		}
		Scene scene = new Scene(group, 600, 300); 
        stage.setScene(scene);
        stage.setTitle("Nodes");
        stage.show();

	}
}
		/*Polygon hexagone = new Polygon();
		Double[] coord = new Double[]{ 
				305.0, 55.0, 
				195.0, 55.0, 
				140.0, 150.0,          
				195.0, 245.0, 
				305.0, 245.0,                   
				360.0, 150.0};
		hexagone.getPoints().addAll(coord);
		hexagone.setFill(javafx.scene.paint.Color.BLUE);
		
		//Circle ville = new circle();
		
		
		Line route1 = new Line(
				coord[0] - 5,
				coord[1] - 5,
				coord[2] + 5,
				coord[3] - 5);
		route1.setStroke(javafx.scene.paint.Color.WHITE);
		route1.addEventHandler(MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
	          public void handle(MouseEvent me) {
	        	  route1.setStroke(javafx.scene.paint.Color.BLACK);
	          }
	        });
		
		Line route2 = new Line(
				coord[2] - 7,
				coord[3],
				coord[4] - 7,
				coord[5]);
		route2.setStroke(javafx.scene.paint.Color.WHITE);
		route2.addEventHandler(MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
	          public void handle(MouseEvent me) {
	        	  route2.setStroke(javafx.scene.paint.Color.BLACK);
	          }
	        });
		Line route3 = new Line(
				coord[4] - 7,
				coord[5],
				coord[6] - 7,
				coord[7]);
		route3.setStroke(javafx.scene.paint.Color.WHITE);
		route3.addEventHandler(MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
	          public void handle(MouseEvent me) {
	        	  route3.setStroke(javafx.scene.paint.Color.BLACK);
	          }
	        });
		route1.setStrokeWidth(8);
		route2.setStrokeWidth(8);
		route3.setStrokeWidth(8);
		
		Group root = new Group(hexagone,route1,route2,route3); 
		Scene scene = new Scene(root, 600, 300); 
        stage.setScene(scene);
        stage.setTitle("Hexagone");
        stage.show();
	}
}*/
