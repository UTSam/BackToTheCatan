package view;

import java.util.ArrayList;
import java.util.Scanner;

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
	private GameView gameView;
	private int X;
	private int Y;
	private Circle circle;
	private Circle smallCircle;
	private int radius;
	private int scale;


	NodeView(Node pnode, int pX, int pY,GameView gv) {
		gameView = gv;
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
		            if (gameView.getActionBar().isDB())
		            {



		            	if (gameView.isMap1())
		            	{


		            		gameView.getGame().buildDelorean(node, gameView.getGame().getPlayerTurn(), gameView.getGame().getMapList().get(0));refreshColor();

		            	}
		            	if (gameView.isMap2())
		            	{

		            		gameView.getGame().buildDelorean(node, gameView.getGame().getPlayerTurn(), gameView.getGame().getMapList().get(1));refreshColor();
		            	}
		            	if (gameView.isMap3())

		            	{

		            		gameView.getGame().buildDelorean(node, gameView.getGame().getPlayerTurn(), gameView.getGame().getMapList().get(2));refreshColor();
		            	}
		            	if (gameView.isMap4())

		            	{
		            		gameView.getGame().buildDelorean(node, gameView.getGame().getPlayerTurn(), gameView.getGame().getMapList().get(3));refreshColor();
		            	}

		            }

		            if (gameView.getActionBar().isCB())
		            {

		            	if (gameView.isMap1())
		            	{
		            		if (gameView.getGame().buildTeleporter(node, gameView.getGame().getPlayerTurn(),gameView.getGame().getMapList().get(0))) {
		            			refreshColor();
		            			TeleporterBox tpBox = new TeleporterBox(gameView, node, 1);
		            			tpBox.display();
		            		}
		            	}
		            	if (gameView.isMap2())
		            	{
		            		if (gameView.getGame().buildTeleporter(node, gameView.getGame().getPlayerTurn(),gameView.getGame().getMapList().get(1))) {
		            			refreshColor();
	            				TeleporterBox tpBox = new TeleporterBox(gameView, node, 2);
	            				tpBox.display();
		            		}
		            	}
		            	if (gameView.isMap3())
		            	{
		            		if(gameView.getGame().buildTeleporter(node, gameView.getGame().getPlayerTurn(),gameView.getGame().getMapList().get(2)))
		            		{
		            			refreshColor();
		            			TeleporterBox tpBox = new TeleporterBox(gameView, node, 3);
		            			tpBox.display();
		            		}
		            	}
		            	if (gameView.isMap4())
		            	{
		            		if(gameView.getGame().buildTeleporter(node, gameView.getGame().getPlayerTurn(),gameView.getGame().getMapList().get(3))){
		            			refreshColor();
	            				TeleporterBox tpBox = new TeleporterBox(gameView, node, 4);
	            				tpBox.display();
		            		}
		            	}
		            }
		            
		            	if (gameView.isMap3() 
		            			&& !(gameView.getGame().getCurrentPlayer().getFirstDelorean()) 
		            			&& gameView.getGame().isFirstTurn())
		            	{
		            		gameView.getGame().buildDeloreanBegin(node, gameView.getGame().getCurrentPlayer());
		            		refreshColor();
		            		if ( gameView.getGame().getCurrentPlayer().getFirstDelorean() 
		            				&& gameView.getGame().getCurrentPlayer().getFirstRoad()) {
		            			gameView.getGame().nextPlayer();
		            			if (gameView.getGame().getCurrentPlayer().getId() == 1) {
		            				gameView.getGame().previousPlayer();
		            				gameView.getGame().setSecondTurn(true);
		            				gameView.getGame().setFirstTurn(false);
		            			}
		            		}
		            		
		            	}	else if (gameView.isMap3() 
		            			&& !(gameView.getGame().getCurrentPlayer().getSecondDelorean()) 
		            			&& gameView.getGame().isSecondTurn())
		            	{
		            		gameView.getGame().buildDeloreanBegin(node, gameView.getGame().getCurrentPlayer());
		            		refreshColor();
		            		if ( gameView.getGame().getCurrentPlayer().getSecondDelorean() 
		            				&& gameView.getGame().getCurrentPlayer().getSecondRoad()) {
		            			gameView.getGame().previousPlayer();
		            			if (gameView.getGame().getCurrentPlayer().getId() == 4) {
		            				gameView.disableButtons(false);
		            				gameView.getGame().nextPlayer();
		            				gameView.getGame().attributeResources();
		            				DiceBox.display(gameView.getGame());
		            			}
		            		}
		            	}	

		        	for (PlayerView pv : gameView.getPlayerViewList())
            		{
		        		pv.refresh();
            		}
		        	for (MapView mv : gameView.getMapViewList())
					{
						mv.refreshMap();
					}
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
				circle.setFill(Color.RED);
				circle.setStroke(Color.BLACK);
				smallCircle.setFill(Color.RED);
				smallCircle.setStroke(Color.BLACK);

				break;
			case PLAYER2:
				circle.setFill(Color.BLUE);
				circle.setStroke(Color.BLACK);
				smallCircle.setFill(Color.BLUE);
				smallCircle.setStroke(Color.BLACK);
				break;
			case PLAYER3:
				circle.setFill(Color.GREEN);
				circle.setStroke(Color.BLACK);
				smallCircle.setFill(Color.GREEN);
				smallCircle.setStroke(Color.BLACK);
				break;
			case PLAYER4:
				circle.setFill(Color.YELLOW);
				circle.setStroke(Color.BLACK);
				smallCircle.setFill(Color.YELLOW);
				smallCircle.setStroke(Color.BLACK);
				break;
			case SEA:
			circle.setFill(Color.TRANSPARENT);
			smallCircle.setFill(Color.TRANSPARENT);
				break;
			default:
				break;
		}
		if (node.isTeleporter())
		{

			circle.setStrokeWidth(10);
			smallCircle.setStrokeWidth(5);}

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
