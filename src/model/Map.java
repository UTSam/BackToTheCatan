package model;

import java.util.ArrayList;

public class Map {

	private Node[][] nodeList;
	private ArrayList<Road> roadList;
	private int mapSize;
	private int[][] patern;
	
	public Map () {
		mapSize=0;
		nodeList=new Node[8][13]; //VARIABLE GLOBALE
		roadList= new ArrayList<Road>();
	}
	
	public Node getNodeFromNodeList(int X, int Y){
		return nodeList[X][Y];		
	}
	
	public int getSize() {
		return mapSize;
	}
	
	public ArrayList<Road> getroadList(){
		return roadList;
	}

	public void setToBigSize(){
		mapSize=5;
		patern = new int[][]{
			  {0,0,0,0,0,0,0,0,0,0,0,0,0},
			  {0,0,0,1,1,1,1,1,1,1,0,0,0},
			  {0,0,1,1,1,1,1,1,1,1,1,0,0},
			  {0,1,1,1,1,1,1,1,1,1,1,1,0},
			  {0,1,1,1,1,1,1,1,1,1,1,1,0},
			  {0,0,1,1,1,1,1,1,1,1,1,0,0},
			  {0,0,0,1,1,1,1,1,1,1,0,0,0},
			  {0,0,0,0,0,0,0,0,0,0,0,0,0},
			};
	}

	public void setToSmallSize(){
		mapSize=4;
		//DO PATERN
	}

	public void generateMap(){
		generateNodeList();
		generateRoadList();
	}

	public void generateNodeList () {
		int i,j;
		//int max=mapSize*2+3;

		for (i=0;i<8;i++){
			for(j=0;j<13;j++){

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

	public void printRoad(){

		int i=0;
		for(Road road : roadList){
			System.out.println("Road n" + i + ": " + road.getNode1().getX() + "," + road.getNode1().getY() + " - " + road.getNode2().getX() + "," + road.getNode2().getY());
			i++;
		}
	}

}









