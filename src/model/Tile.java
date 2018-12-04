package model;

import java.util.ArrayList;

public class Tile {
	private ArrayList<Node> nodeList;
	private StatusTileType type;
	private boolean thief;

	public Tile(){
	nodeList= new ArrayList<Node>();
	type=StatusTileType.SEA;
	thief=false;

	}

	public ArrayList<Node> getNodeList(){
		return nodeList;
	}

	public void addNode(Node node){
		nodeList.add(node);
	}

	public boolean getThief(){
		return thief;
	}

	public void setThief(boolean thief){
		this.thief=thief;
	}


}

