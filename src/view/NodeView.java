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
		            		gameView.getGame().buildTeleporter(node, gameView.getGame().getPlayerTurn(),gameView.getGame().getMapList().get(0));refreshColor();
		            		int MA;
		            		do
		            		{System.out.println(" ECRIS UN NBR ENTRE 1 ET 3");
		            		Scanner sc = new Scanner(System.in);
		            		MA= sc.nextInt();

		            		System.out.println(MA);

		            		}
		            		while(MA!=2 && MA !=3 && MA !=4);







		            		for (int i=0;i<gameView.getGame().getMapList().get(MA-1).getNodeList().length;i++)
		            		{
		            			for (int j=0;j<gameView.getGame().getMapList().get(MA-1).getNodeListLine(i).length;j++)
		            			{
		            				if(gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j).getX()==node.getX() && gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j).getY()==node.getY() )
		            				{
		            					gameView.getGame().buildDeloreanFree( gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j),gameView.getGame().getPlayerTurn());


		            				}


		            			}
		            		}
		            	}
		            	if (gameView.isMap2())
		            	{
		            		if (gameView.getGame().buildTeleporter(node, gameView.getGame().getPlayerTurn(),gameView.getGame().getMapList().get(1)))
		            		{
		            		int MA;
		            		do
		            		{
		            			System.out.println(" ECRIS UN NBR ENTRE 0  2 ET 3");
		            		Scanner sc = new Scanner(System.in);
		            		MA= sc.nextInt();


		            		System.out.println(MA);

		            		}
		            		while(MA!=1 && MA !=3 && MA !=4);






		            		int i;
		            		for (i=0;i<gameView.getGame().getMapList().get(MA-1).getNodeList().length;i++)
		            		{
		            			for (int j=0;j<gameView.getGame().getMapList().get(MA-1).getNodeListLine(i).length;j++)
		            			{System.out.println(gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j).getX() + "=" + node.getX()  +  "ET" + gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j).getY() +  "=" + node.getY()  );
		            				if(gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j).getX()==node.getX() && gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j).getY()==node.getY() )
		            				{
		            					gameView.getGame().buildDeloreanFree( gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j),gameView.getGame().getPlayerTurn());


		            				}


		            			}
		            		}
		            		}
		            	}
		            	if (gameView.isMap3())
		            	{
		            		if(gameView.getGame().buildTeleporter(node, gameView.getGame().getPlayerTurn(),gameView.getGame().getMapList().get(2)))
		            		{
		            		int MA;
		            		do
		            		{System.out.println(" ECRIS UN NBR ENTRE 0 1 ET 3");
		            		Scanner sc = new Scanner(System.in);
		            		MA= sc.nextInt();

		            		System.out.println(MA);

		            		}
		            		while(MA!=1 && MA !=2 && MA !=4);


		            		// MARCHE POUR LA MAP 1 A LA DEUX




		            		for (int i=0;i<gameView.getGame().getMapList().get(MA-1).getNodeList().length;i++)
		            		{
		            			for (int j=0;j<gameView.getGame().getMapList().get(MA-1).getNodeListLine(i).length;j++)
		            			{ System.out.println(gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j).getX() + "=" + node.getX()  +  "ET" + gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j).getY() +  "=" + node.getY()  );
		            				if(gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j).getX()==node.getX() && gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j).getY()==node.getY() )
		            				{
		            					gameView.getGame().buildDeloreanFree( gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j),gameView.getGame().getPlayerTurn());


		            				}


		            			}
		            		}
		            		}
		            	}
		            	if (gameView.isMap4())
		            	{
		            		gameView.getGame().buildTeleporter(node, gameView.getGame().getPlayerTurn(),gameView.getGame().getMapList().get(3));refreshColor();
		            		int MA;
		            		do
		            		{System.out.println(" ECRIS UN NBR ENTRE  0 1 2 ET ");
		            		Scanner sc = new Scanner(System.in);
		            		MA= sc.nextInt();

		            		System.out.println(MA);

		            		}
		            		while(MA!=1 && MA !=2 && MA !=3);

		            		// MARCHE POUR LA MAP 1 A LA DEUX

		            		for (int i=0;i<gameView.getGame().getMapList().get(MA-1).getNodeList().length;i++)
		            		{
		            			for (int j=0;j<gameView.getGame().getMapList().get(MA-1).getNodeListLine(i).length;j++)
		            			{
		            				if(gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j).getX()==node.getX() && gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j).getY()==node.getY() )
		            				{
		            					gameView.getGame().buildDeloreanFree( gameView.getGame().getMapList().get(MA-1).getNodeListElem(i,j),gameView.getGame().getPlayerTurn());


		            				}

		            			}
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
