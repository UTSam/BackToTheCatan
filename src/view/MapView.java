package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Game;
import model.Map;
import model.Node;
import model.Road;
import model.Tile;

public class MapView {

	//Largeur hexagone
	private int length;

	private Map map;

	private ArrayList<TileView> tileViewList;
	private ArrayList<NodeView> nodeViewList;
	private ArrayList<RoadView> roadViewList;


	private BorderPane borderPane;
	private Group mapGroup;
	private Button backButton;
	private PlayerBar playerBar;
	private GameView gameView;




	public MapView(Map pmap, GameView gv) {
		map = pmap;
		gameView = gv;
		borderPane = new BorderPane();
		mapGroup = new Group();
		backButton = new Button("BACK");
		backButton.setPrefSize(200, 100);
		backButton.setLayoutX(50);
		backButton.setLayoutY(100);

		tileViewList = new ArrayList<TileView>();
		nodeViewList = new ArrayList<NodeView>();
		roadViewList = new ArrayList<RoadView>();
	}


	void generate() {

		length = 80;

		generateNodeViewList(map);
		generateRoadViewList(map);
		generateTileViewList(map);

		Group mapGroup = new Group();
		printTiles(mapGroup);
		printRoads(mapGroup);
		printNodes(mapGroup);
		
		borderPane.setCenter(mapGroup);
		borderPane.setLeft(backButton);
	}



	//GENERATION DES VIEW LISTS--------------------------------------------------------------------
	private void generateNodeViewList(Map map) {

		Node tmpNode;
		NodeView tmpNodeView = null;

		int deltaLengthX = length*86/100;
		int deltaPosY = length/2;

		
		for (int i = 0; i < 8; i++){
			for(int j = 0; j < 15; j++){

				tmpNode = map.getNodeFromNodeList(i, j);
					if ((i%2 == 0)&&(j%2 == 1)){
						tmpNodeView = new NodeView(
								tmpNode,
								tmpNode.getY()*deltaLengthX,
								(tmpNode.getX()-1)*(length+deltaPosY)+deltaPosY,
								gameView);
						//tmpNodeView.getCircle().setFill(Color.BLUE);
					}
					if ((i%2 == 0)&&(j%2 == 0)){
						tmpNodeView = new NodeView(tmpNode,
								tmpNode.getY()*deltaLengthX,
								(tmpNode.getX()-1)*(length+deltaPosY),
								gameView);
						//tmpNodeView.getCircle().setFill(Color.GREEN);
					}
					if ((i%2 == 1)&&(j%2 == 1)){
						tmpNodeView = new NodeView(
								tmpNode,
								tmpNode.getY()*deltaLengthX,
								(tmpNode.getX()-1)*length+tmpNode.getX()*deltaPosY-deltaPosY,
								gameView);
						//tmpNodeView.getCircle().setFill(Color.RED);
					}
					if ((i%2 == 1)&&(j%2 == 0)){
						tmpNodeView = new NodeView(
								tmpNode,
								tmpNode.getY()*deltaLengthX,
								(tmpNode.getX()-1)*length+tmpNode.getX()*deltaPosY,
								gameView);
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
					NodeView.getNodeViewByNode(tmpRoad.getNode2(), nodeViewList),
					gameView);
			roadViewList.add(tmpRoadView);
		}
	}

	private void generateTileViewList(Map map) {

		TileView tmpTileView;
		if (map.getSize()==5) {
			for (Tile tmpTile : map.getTileList()) {
				tmpTileView = new TileView(
						tmpTile,
						NodeView.getNodeViewListFromTile(tmpTile, nodeViewList),
						gameView.getGame());
				tileViewList.add(tmpTileView);
			} 
		}
		else if (map.getSize()==4) {
			for (Tile tmpTile : map.getTileList()) {
				if (tmpTile.getNodeList().get(0).getY()<11) {
					tmpTileView = new TileView(
							tmpTile,
							NodeView.getNodeViewListFromTile(tmpTile, nodeViewList),
							gameView.getGame());
					tileViewList.add(tmpTileView);
				}
			}
		}

	}
	

	//AFFICHAGE DES OBJETS-----------------------------------------------------------------------
	void printTiles (Group group) {
		for (TileView tmpTileView : tileViewList) {
			group.getChildren().add(tmpTileView.getTileGroup());
			group.getChildren().add(tmpTileView.getVBox());
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

	//GETERS------------------------------------------------------------------------------------
	public ArrayList<NodeView> getNodeViewList() {
		return nodeViewList;
	}

	public ArrayList<RoadView> getRoadViewList() {
		return roadViewList;
	}

	public ArrayList<TileView> getTileViewList() {
		return tileViewList;
	}

	public BorderPane getBorderPane() {
		return borderPane;
	}

	public Button getBackButton() {
		return backButton;
	}
}


