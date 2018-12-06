package view;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.Map;
import model.Node;
import model.Road;
import model.Tile;

public class GlobalMap {
	//Position départ
		private int xStart;
		private int yStart;
		
		//Largeur hexagone
		private int length;
		
		private ArrayList<Map> mapList;
		
		private ArrayList<TileView> tileViewList;
		private ArrayList<NodeView> nodeViewList; 
		private ArrayList<RoadView> roadViewList;
		
		GridPane gridPane;
		Group mapGroup;
	
	public GlobalMap(ArrayList<Map> pmapList) {
		mapList = pmapList;
		gridPane = new GridPane();
		mapGroup = new Group();
	}
	void generate() {
		
		for (Map m : mapList) {
			generateNodeViewList(m);
			generateRoadViewList(m);
			generateTileViewList(m);
					
			Group mapGroup = new Group();
			printTiles(mapGroup);
			printRoads(mapGroup);
			printNodes(mapGroup);
			
			gridPane.add(mapGroup, 0, 0);
		}
	}


	//GENERATION DES VIEW LISTS--------------------------------------------------------------------
	private void generateNodeViewList(Map map) {
		
		Node tmpNode;
		NodeView tmpNodeView = null;
			
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
							//tmpNodeView.getCircle().setFill(Color.BLUE);
					}
					if ((i%2 == 0)&&(j%2 == 0)){
						tmpNodeView = new NodeView(tmpNode,
								tmpNode.getY()*deltaLengthX+xStart,
								(tmpNode.getX()-1)*(length+deltaPosY)+yStart);
					//tmpNodeView.getCircle().setFill(Color.GREEN);
					}
					if ((i%2 == 1)&&(j%2 == 1)){
						tmpNodeView = new NodeView(
								tmpNode,
								tmpNode.getY()*deltaLengthX+xStart, 
								(tmpNode.getX()-1)*length+tmpNode.getX()*deltaPosY-deltaPosY+yStart);
						//tmpNodeView.getCircle().setFill(Color.RED);
						}
					if ((i%2 == 1)&&(j%2 == 0)){
						tmpNodeView = new NodeView(
								tmpNode,
								tmpNode.getY()*deltaLengthX+xStart, 
								(tmpNode.getX()-1)*length+tmpNode.getX()*deltaPosY+yStart);
						//tmpNodeView.getCircle().setFill(Color.YELLOW);
					}
				nodeViewList.add(tmpNodeView);
			}	
		}
	}
	private void generateRoadViewList(Map map) {
			
		RoadView tmpRoadView = null;
			
		for (Road tmpRoad : map.getRoadList()) {
			tmpRoadView = new RoadView(
					tmpRoad,
					NodeView.getNodeViewByNode(tmpRoad.getNode1(), nodeViewList), 
					NodeView.getNodeViewByNode(tmpRoad.getNode2(), nodeViewList));
			roadViewList.add(tmpRoadView);
		}
	}
			
	private void generateTileViewList(Map map) {
			
		TileView tmpTileView;
			
		for (Tile tmpTile : map.getTileList()) {
			tmpTileView = new TileView(
					tmpTile,
					NodeView.getNodeViewListFromTile(tmpTile, nodeViewList));
			tileViewList.add(tmpTileView);
		}
		
	}

	//AFFICHAGE DES OBJETS-----------------------------------------------------------------------
	void printTiles (Group group) {
		for (TileView tmpTileView : tileViewList) {
			group.getChildren().add(tmpTileView.getHexagon());
		}
	}

	void printRoads(Group group){
						
		for (RoadView tmpRoadView : roadViewList) {	
			group.getChildren().add(tmpRoadView.getUnderLine());
			group.getChildren().add(tmpRoadView.getLine());
		}
	
	}

	void printNodes(Group group){
			
		for (NodeView tmpNodeView : nodeViewList){
				
			group.getChildren().add(tmpNodeView.getCircle());
		}
	}
}