package view;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Node;
import model.Road;
import model.Tile;
import model.Map;

public class Board {
	
	private int xStart;
	private int yStart;
	private int length;
	private ArrayList<TileView> tileViewList;
	private ArrayList<NodeView> nodeViewList; 
	private ArrayList<RoadView> roadViewList;

	public Board(int x,int y, int plength){
		xStart = x;
		yStart = y;
		length = plength;
		tileViewList = new ArrayList<TileView>();
		nodeViewList = new ArrayList<NodeView>();
		roadViewList = new ArrayList<RoadView>();
	}
	
	public void display(Map map) {
				
		Group board = new Group();
		Node tmpNode;
		
		TileView tmpTileView = null;
		NodeView tmpNodeView = null;
		RoadView tmpRoadView = null;

		int deltaLengthX = length*86/100;
		int deltaPosY = length/2;
		
		
		for (int i = 0; i < map.getSize()+3; i++){
			for(int j = 0; j < map.getSize()*2+5; j++){
				
				tmpNode = map.getNodeFromNodeList(i, j);
					if ((i%2 == 0)&&(j%2 == 1)){
						tmpNodeView = new NodeView(
								tmpNode,
								tmpNode.getY()*deltaLengthX+xStart, 
								(tmpNode.getX()-1)*(length+deltaPosY)+yStart+deltaPosY);
						tmpNodeView.getCircle().setFill(Color.BLUE);
					}
					if ((i%2 == 0)&&(j%2 == 0)){
						tmpNodeView = new NodeView(tmpNode,
								tmpNode.getY()*deltaLengthX+xStart,
								(tmpNode.getX()-1)*(length+deltaPosY)+yStart);
						tmpNodeView.getCircle().setFill(Color.GREEN);
					}
					if ((i%2 == 1)&&(j%2 == 1)){
						tmpNodeView = new NodeView(
								tmpNode,
								tmpNode.getY()*deltaLengthX+xStart, 
								(tmpNode.getX()-1)*length+tmpNode.getX()*deltaPosY-deltaPosY+yStart);
						tmpNodeView.getCircle().setFill(Color.RED);
					}
					if ((i%2 == 1)&&(j%2 == 0)){
						tmpNodeView = new NodeView(
								tmpNode,
								tmpNode.getY()*deltaLengthX+xStart, 
								(tmpNode.getX()-1)*length+tmpNode.getX()*deltaPosY+yStart);
						tmpNodeView.getCircle().setFill(Color.YELLOW);
					}
				nodeViewList.add(tmpNodeView);
			}	
		}
		
		for (Tile tmpTile : map.getTileList()) {
			tmpTileView = new TileView(
					tmpTile,
					getNodeViewListFromTile(tmpTile));
			tileViewList.add(tmpTileView);
		}
		System.out.println(map.getTileList().size());
		System.out.println(tileViewList.size());
		
		for (Road tmpRoad : map.getRoadList()) {
			tmpRoadView = new RoadView(
					tmpRoad,
					getNodeViewByNode(tmpRoad.getNode1()), 
					getNodeViewByNode(tmpRoad.getNode2()));
			roadViewList.add(tmpRoadView);
		}
		
		this.printTiles(board);
		this.printRoads(board);
		this.printNodes(board);
		
		Stage boardWindow = new Stage();
		boardWindow.setTitle("BoardWindow");
		
		HBox dateHBox = new HBox();
		Button b1850 = new Button("1850");
		Button b1955 = new Button("1955");
		Button b1985 = new Button("1985");
		Button b2015 = new Button("2015");
		
		dateHBox.getChildren().addAll(b1850, b1955, b1985, b2015);
		
		dateHBox.setAlignment(Pos.CENTER);
		BorderPane borderPane = new BorderPane();
		BorderPane mapBorderPane = new BorderPane();
		mapBorderPane.setCenter(board);
		
		Button button = new Button("HELLLOOOO");
		borderPane.setRight(button);
		borderPane.setCenter(mapBorderPane);
		borderPane.setBottom(dateHBox);
		
		Scene scene = new Scene(borderPane, 2000, 1000);
		
		boardWindow.setScene(scene);
		boardWindow.show();
		boardWindow.setMaximized(true);
		//boardWindow.setFullScreen(true);
}

	void printTiles (Group group) {
		for (TileView tmpTileView : tileViewList) {
			group.getChildren().add(tmpTileView.getHexagon());
		}
	}
	
	void printRoads(Group group){
		
		for (RoadView tmpRoadView : roadViewList) {	
			
			group.getChildren().add(tmpRoadView.getLine());
		}
		
	}
	
	void printNodes(Group group){
		
		for (NodeView tmpNodeView : nodeViewList){
			
			group.getChildren().add(tmpNodeView.getCircle());
		}
	}
	
	
	NodeView getNodeViewByNode(Node pnode){
		for (NodeView nv : nodeViewList) {
			if (nv.getNode() == pnode) {
				return nv;
			}
		}
		return null;
	}
	
	ArrayList<NodeView> getNodeViewListFromTile(Tile tile) {
		ArrayList<NodeView> tmpNodeViewList = new ArrayList<NodeView>();
		for (Node n : tile.getNodeList()) {
				tmpNodeViewList.add(getNodeViewByNode(n));
		}
		
		return tmpNodeViewList;
	}
}