package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Map {

	private String name;
	private Node[][] nodeList;
	private ArrayList<Road> roadList;
	private ArrayList<Tile> tileList;
	private int mapSize;
	private int[][] patern;


	private int tileRepartition[];

	public Map () {
		mapSize=0;
		nodeList=new Node[8][15]; //TODO VARIABLE GLOBALE
		roadList= new ArrayList<Road>();
		tileList= new ArrayList<Tile>();
	}

	public Map (String name, int woodQuantity, int coalQuantity, int foodQuantity, int metalQuantity, int oilQuantity, int plutoniumQuantity, int GoldQuantity){
		nodeList=new Node[8][15]; //TODO VARIABLE GLOBALE
		roadList= new ArrayList<Road>();
		tileList= new ArrayList<Tile>();
		this.name=name;

		/* The 1 at the end represent the quantity of mountain*/
		tileRepartition=new int[] {woodQuantity,coalQuantity,foodQuantity,metalQuantity,oilQuantity,plutoniumQuantity,GoldQuantity,1};
	}

	public Map (String name, int size, int woodQuantity, int coalQuantity, int foodQuantity, int metalQuantity, int oilQuantity, int plutoniumQuantity, int GoldQuantity){
		nodeList=new Node[8][15]; //TODO VARIABLE GLOBALE
		roadList= new ArrayList<Road>();
		tileList= new ArrayList<Tile>();
		this.name=name;
		if (size==5){
			setToBigSize();
		}
		else {
			setToSmallSize();
		}
		/* The 1 at the end represent the quantity of mountain*/
		tileRepartition=new int[] {woodQuantity,coalQuantity,foodQuantity,metalQuantity,oilQuantity,plutoniumQuantity,GoldQuantity,1};
	}

	public void setToBigSize(){
		mapSize=5;
		patern = new int[][]{
			  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			  {0,0,0,0,1,1,1,1,1,1,1,0,0,0,0},
			  {0,0,0,1,1,1,1,1,1,1,1,1,0,0,0},
			  {0,0,1,1,1,1,1,1,1,1,1,1,1,0,0},
			  {0,0,1,1,1,1,1,1,1,1,1,1,1,0,0},
			  {0,0,0,1,1,1,1,1,1,1,1,1,0,0,0},
			  {0,0,0,0,1,1,1,1,1,1,1,0,0,0,0},
			  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			};
	}

	public void setToSmallSize(){
		mapSize=4;
		patern = new int[][]{
			  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			  {0,0,0,0,1,1,1,1,1,0,0,0,0,0,0},
			  {0,0,0,1,1,1,1,1,1,1,0,0,0,0,0},
			  {0,0,1,1,1,1,1,1,1,1,1,0,0,0,0},
			  {0,0,1,1,1,1,1,1,1,1,1,0,0,0,0},
			  {0,0,0,1,1,1,1,1,1,1,0,0,0,0,0},
			  {0,0,0,0,1,1,1,1,1,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			};
	}

	public void generate(ArrayList<Resource> resourceList){
		generateNodeList();
		generateRoadList();
		generateTileList();
		generateMap(resourceList);
	}

	public void generateNodeList () {
		int i,j;

		for (i=0;i<nodeList.length;i++){
			for(j=0;j<nodeList[i].length;j++){

				Node nodeTmp;

				if(patern[i][j]==1) { /* Initialize a new node to the coordinates i,j and define if it is a sea node or a usable node */
					nodeTmp = new Node(i,j);
				}
				else {
					nodeTmp = new Node(i,j,StatusNodeType.SEA);
				}
				nodeList[i][j]=nodeTmp;
			}
		}
	}

	public void generateRoadList(){
		int i,j;
		boolean placeRoad;
		for (i=1;i<nodeList.length;i++){ /* Start at i=1 because there are no roads on the first line*/
			placeRoad=true;
			for(j=0;j<nodeList[i].length;j++){

				/* Create a road if a node and the node to its right are EMPTY*/
				if(nodeList[i][j].getStatus()==StatusNodeType.EMPTY && nodeList[i][j+1].getStatus()==StatusNodeType.EMPTY){
					Road road = new Road(nodeList[i][j],nodeList[i][j+1]);
					roadList.add(road);
				}

				/* If the first node on the line and the one under it are EMPTY, a road is created*/
				/* Then it alternate between the construction of a road and nothing */
				if(nodeList[i][j].getStatus()==StatusNodeType.EMPTY && nodeList[i+1][j].getStatus()==StatusNodeType.EMPTY && placeRoad==true ){
					Road road = new Road(nodeList[i][j],nodeList[i+1][j]);
					roadList.add(road);
					placeRoad=false;
				}
				else {
					placeRoad=true;
				}
			}
		}
	}

	public void generateTileList(){
		int i,j;
		for (i=0;i<nodeList.length-1;i++){
			if (i%2 == 0) {
				for(j=1;j<nodeList[i].length-3;j+=2){ /* We create a tile composed of six consecutive nodes */
					Tile tile = new Tile();
					tile.addNode(nodeList[i][j]);
					tile.addNode(nodeList[i][j+1]);
					tile.addNode(nodeList[i][j+2]);
					tile.addNode(nodeList[i+1][j]);
					tile.addNode(nodeList[i+1][j+1]);
					tile.addNode(nodeList[i+1][j+2]);
					tileList.add(tile);
				}
			} else {
				for(j=0;j<nodeList[i].length-2;j+=2){
					Tile tile = new Tile();
					tile.addNode(nodeList[i][j]);
					tile.addNode(nodeList[i][j+1]);
					tile.addNode(nodeList[i][j+2]);
					tile.addNode(nodeList[i+1][j]);
					tile.addNode(nodeList[i+1][j+1]);
					tile.addNode(nodeList[i+1][j+2]);
					tileList.add(tile);
			}
			}
		}

	}

	private void generateMap(ArrayList<Resource> resourceList){
		/* tileValueList represent the number of time the number i will be present*/
		/* For example the number 1 is present 1 time and the number 6 is present 2 times */
		int tileValueList[],max;
		if (mapSize==5){
			tileValueList=new int[] {1,2,2,2,2,2,2,2,2,2,1};
			max=19;
		}
		else {
			tileValueList=new int[] {1,1,1,1,2,2,1,1,1,1,1};
			max=14;

		}

		int initialThiefPosition=(int) (Math.random()*max); /* The counter for the initial position of the thief */
		int rand,rand2,i=0,j=0;
		boolean isSeaTile;

		for(Tile tile : tileList){
			isSeaTile=false;

			/* Setting of the type of tile */
			for(Node node:tile.getNodeList()){
				if(node.getStatus()==StatusNodeType.SEA) isSeaTile=true;
			}

			if (isSeaTile){
				for(Resource resource: resourceList){
					if(resource.getType()==ResourceType.SEA){
						tile.setType(resource);
					}
				}
			}
			else {
				rand=(int) (Math.random()*8);
				while(tileRepartition[rand]==0 && j<max){
					rand=(int) (Math.random()*8);
				}
				if(tileRepartition[rand]!=0){
					tileRepartition[rand]--;
					tile.setType(resourceList.get(rand));
					j++;
				}

				if(initialThiefPosition==0) {
					tile.setThief(true);
					initialThiefPosition--;
				}
				else initialThiefPosition--;
			}

			/* Setting of the value of the tile */ 						/* TODO CHECK OPTIMISATION ET A TESTER SUR PETITE MAP*/
			if(tile.getResourceType()!=ResourceType.SEA && tile.getResourceType()!=ResourceType.MOUNTAIN){
				rand2=(int) (Math.random()*11);
				while(tileValueList[rand2]==0 && i<max){
					rand2=(int) (Math.random()*11);
				}
				if(tileValueList[rand2]!=0){
					tileValueList[rand2]--;
					tile.setNumber(rand2+2);
					i++;
				}
			}
		}
	}

	/* Function that returns the list of tiles with the corresponding number */
	public ArrayList<Tile> getTilesFromNumber(int number){

		ArrayList<Tile> tileListNumber = new ArrayList<Tile>();

		for(Tile tile:tileList){
			if(tile.getNumber()==number){
				tileListNumber.add(tile);
			}
		}

		return tileListNumber;
	}


	public int getSize() {
		return mapSize;
	}

	public ArrayList<Tile> getTileList(){
		return tileList;
	}

	public ArrayList<Road> getRoadList(){
		return roadList;
	}

	public Node getNodeFromNodeList(int X, int Y){
		return nodeList[X][Y];
	}

	public void printRoad(){

		int i=0;
		for(Road road : roadList){
			System.out.println("Road n" + i + ": " + road.getNode1().getX() + "," + road.getNode1().getY() + " - " + road.getNode2().getX() + "," + road.getNode2().getY());
			i++;
		}
	}

	public void printTile(){

		int i=0;
		for(Tile tile : tileList){
			System.out.print("Tile n"+ i + ": ");
			System.out.print("Valeur"+ tile.getNumber() + ", ");
			System.out.print("Type Ressource:"+ tile.getResourceType() + ", ");
			i++;
			for(Node node : tile.getNodeList()){
				System.out.print(node.getX() + "," + node.getY() + " ");
			}
			System.out.println();
		}
	}

}

// TODO GENERER PORT







