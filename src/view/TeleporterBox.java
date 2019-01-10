package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Node;

public class TeleporterBox {
	
	private GameView gameView;
	private Node node;
	private int mapID;
	private int destinationMap;
	
	TeleporterBox(GameView gv,  Node n, int mID) {
		gameView = gv;
		node = n;
		mapID = mID;
		destinationMap = 0;
	}
	
	public void display() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setWidth(500);
		window.setHeight(400);
		window.setResizable(false);
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setVgap(50);
		gridPane.setHgap(25);
		
		Label label = new Label("Choisir l'epoque de \ndestination :");
		label.setStyle( "-fx-font-size: 40");
		label.setAlignment(Pos.CENTER);
		
		gridPane.add(label, 0, 0, 3, 1);
		
		Button date1 = new Button("1850");
		Button date2 = new Button("1955");
		Button date3 = new Button("1985");
		Button date4 = new Button("2015");
		date1.setPrefSize(125, 50);
		date2.setPrefSize(125, 50);
		date3.setPrefSize(125, 50);
		date4.setPrefSize(125, 50);
		
		date1.setOnAction(e-> {
			destinationMap = 0;
			buildDestination();
			window.close();
		});
		
		date2.setOnAction(e-> {
			destinationMap = 1;
			buildDestination();
			window.close();
		});
		
		date3.setOnAction(e-> {
			destinationMap = 2;
			buildDestination();
			window.close();
		});
		
		date4.setOnAction(e-> {
			destinationMap = 3;
			buildDestination();
			window.close();
		});
		
		switch (mapID){
		case 1 : 
			gridPane.add(date2, 0, 2);
			gridPane.add(date3, 1, 2);
			gridPane.add(date4, 2, 2);
		break;
		case 2 : 
			gridPane.add(date1, 0, 2);
			gridPane.add(date3, 1, 2);
			gridPane.add(date4, 2, 2);
		break;
		case 3 : 
			gridPane.add(date1, 0, 2);
			gridPane.add(date2, 1, 2);
			gridPane.add(date4, 2, 2);
		break;
		case 4 : 
			gridPane.add(date1, 0, 2);
			gridPane.add(date2, 1, 2);
			gridPane.add(date3, 2, 2);
		break;
		default : 
		break;		
		}
		
		
		
		
		Scene scene = new Scene(gridPane);
		scene.getStylesheets().add("resources/style.css");
		window.setScene(scene);
		window.showAndWait();
	}
	
	private void buildDestination() {
		for (int i=0;i<gameView.getGame().getMapList().get(destinationMap).getNodeList().length;i++)
		{
			for (int j=0;j<gameView.getGame().getMapList().get(destinationMap).getNodeListLine(i).length;j++)
			{
				if(gameView.getGame().getMapList().get(destinationMap).getNodeListElem(i,j).getX()==node.getX() && gameView.getGame().getMapList().get(destinationMap).getNodeListElem(i,j).getY()==node.getY() )
				{
					gameView.getGame().buildDeloreanFree( gameView.getGame().getMapList().get(destinationMap).getNodeListElem(i,j),gameView.getGame().getPlayerTurn());

				}
			}
		}
	}
}
