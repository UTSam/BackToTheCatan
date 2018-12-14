package view;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class WorldMap {
	ArrayList<MapView> mapViewList;
	GridPane gridPane;
	Group map1Group;
	Group map2Group;
	Group map3Group;
	Group map4Group;
	
	public WorldMap(ArrayList<MapView> pmapViewList){
		mapViewList = pmapViewList;
		gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(80);
		gridPane.setVgap(10);
		map1Group = new Group();
		map2Group = new Group();
		map3Group = new Group();
		map4Group = new Group();
	}
	
	public void generate() {
		printTiles();
		printRoads();
		printNodes();

		GridPane.setHalignment(map1Group, HPos.RIGHT);
		GridPane.setHalignment(map2Group, HPos.CENTER);
		GridPane.setHalignment(map3Group, HPos.CENTER);
		GridPane.setHalignment(map4Group, HPos.CENTER);
		
		gridPane.add(map1Group, 1, 0);
		gridPane.add(map2Group, 2, 0);
		gridPane.add(map3Group, 0, 1, 2, 1);
		gridPane.add(map4Group, 2, 1, 2, 1);  

		
	}
	
	private void printNodes(){
		for (NodeView mv : mapViewList.get(0).getNodeViewList()) {
			map1Group.getChildren().add(mv.getSmallCircle());
		}
		for (NodeView mv : mapViewList.get(1).getNodeViewList()) {
			map2Group.getChildren().add(mv.getSmallCircle());
		}
		for (NodeView mv : mapViewList.get(2).getNodeViewList()) {
			map3Group.getChildren().add(mv.getSmallCircle());
		}
		for (NodeView mv : mapViewList.get(3).getNodeViewList()) {
			map4Group.getChildren().add(mv.getSmallCircle());
		}

	}
	
	void printRoads() {
		for (RoadView rv : mapViewList.get(0).getRoadViewList()) {
			map1Group.getChildren().add( rv.getSmallUnderLine());
			map1Group.getChildren().add( rv.getSmallLine());
		}
		for (RoadView rv : mapViewList.get(1).getRoadViewList()) {
			map2Group.getChildren().add( rv.getSmallUnderLine());
			map2Group.getChildren().add( rv.getSmallLine());
		}
		for (RoadView rv : mapViewList.get(2).getRoadViewList()) {
			map3Group.getChildren().add( rv.getSmallUnderLine());
			map3Group.getChildren().add( rv.getSmallLine());
		}
		for (RoadView rv : mapViewList.get(3).getRoadViewList()) {
			map4Group.getChildren().add( rv.getSmallUnderLine());
			map4Group.getChildren().add( rv.getSmallLine());
		}
	}
	
	void printTiles() {
		for (TileView tv : mapViewList.get(0).getTileViewList()) {
			map1Group.getChildren().add( tv.getSmallHexagon());
		}
		for (TileView tv : mapViewList.get(1).getTileViewList()) {
			map2Group.getChildren().add( tv.getSmallHexagon());
		}
		for (TileView tv : mapViewList.get(2).getTileViewList()) {
			map3Group.getChildren().add( tv.getSmallHexagon());
		}
		for (TileView tv : mapViewList.get(3).getTileViewList()) {
			map4Group.getChildren().add( tv.getSmallHexagon());
		}
	}
	
	public GridPane getGridPane() {
		return gridPane;
	}
	
	public Group getMap1Group() {
		return map1Group;
	}
	public Group getMap2Group() {
		return map2Group;
	}
	public Group getMap3Group() {
		return map3Group;
	}
	public Group getMap4Group() {
		return map4Group;
	}
}
	

