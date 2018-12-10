package model;

import java.util.ArrayList;

public class Tile {
	private ArrayList<Node> nodeList;
	private Resource type;
	private boolean thief;
	private int number;


	public Tile(){
	nodeList= new ArrayList<Node>();
	thief=false;
	}

	public ArrayList<Node> getNodeList(){
		return nodeList;
	}

	public void addNode(Node node){
		nodeList.add(node);
	}

	public void setType(Resource type){
		this.type=type;
	}

	public boolean getThief(){
		return thief;
	}

	public void setThief(boolean thief){
		this.thief=thief;
	}

	public void setNumber(int number){
		this.number=number;
	}

	public int getNumber(){
		return number;
	}

	public ResourceType getResourceType(){
		return type.getType();
	}
	
	public Resource getResource(){
		return type;
	}
}

