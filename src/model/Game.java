package model;

import java.util.ArrayList;

public class Game {


	private ArrayList<Map> mapList;
	private ArrayList<Resource> resourceList;
	private ArrayList<Player> playerList;

	public Game () {
		mapList=new ArrayList<Map>();

		mapList.add(new Map("1850",4,1,1,4,3,4,3,2));
		mapList.add(new Map("1955",5,1,1,4,3,4,3,2));
		mapList.add(new Map("1985",5,1,1,4,3,4,3,2));
		mapList.add(new Map("2015",4,1,1,4,3,4,3,2));
		resourceList= new ArrayList<Resource>();

		initializeResourceList();

		//Generation of the map
		for (Map m : mapList) {
			//m.setToBigSize();
			m.generate(resourceList);
		}

		playerList=new ArrayList<Player>();

		playerList.add(new Player(1, "Alain"));
		playerList.add(new Player(2, "Michel"));
		playerList.add(new Player(3, "Jacky"));
		playerList.add(new Player(4, "Robert"));

	}

	public void Run(){
		for (Map m : mapList) {
			m.printRoad();
			m.printTile();
		}
	}

	public int throwDice(){
		return (int) (Math.random()*11)+2;
	}

	/* TODO A CHECK */
	public void attributeResources(){

		int dice=throwDice();

		/* Return the tiles with the corresponding number on the 4 maps*/
		ArrayList<Tile> tileList=new ArrayList<Tile>();
		for(Map m:mapList){
			tileList.addAll(m.getTilesFromNumber(dice));
		}

		/* Check if a player is in possession of the corresponding node */
		for(Tile tile:tileList){

			Player player=null;

			for(Node node: tile.getNodeList()){
				switch(node.getStatus()){
				case PLAYER1:
					player=playerList.get(0);
					break;
				case PLAYER2:
					player=playerList.get(1);
					break;
				case PLAYER3:
					player=playerList.get(2);
					break;
				case PLAYER4:
					player=playerList.get(3);
					break;
				default:
					break;
				}

				/* If a node belongs to a player it adds the corresponding resources to its inventory */
				if(player!=null){
					player.getResourceInventory().addConstruction(tile.getResource().getConstruction());
					player.getResourceInventory().addEnergy(tile.getResource().getEnergy());
					player.getResourceInventory().addFood(tile.getResource().getFood());
					player.getResourceInventory().addGold(tile.getResource().getGold());
				}
			}
		}
	}



	public ArrayList<Map> getMapList(){
		return mapList;
	}
	
	public ArrayList<Player> getPlayerList(){
		return playerList;
	}



	private void initializeResourceList(){
		/* Initialize the list of all the different type of resources in the game*/
		/* The 4 categories are Food, Energy, Construction and Gold*/
		resourceList.add(new Resource(ResourceType.WOOD,0,0,1,0));
		resourceList.add(new Resource(ResourceType.COAL,0,1,0,0));
		resourceList.add(new Resource(ResourceType.FOOD,1,0,0,0));
		resourceList.add(new Resource(ResourceType.METAL,0,0,1,0));
		resourceList.add(new Resource(ResourceType.OIL,0,1,1,0));
		resourceList.add(new Resource(ResourceType.PLUTONIUM,0,2,0,0));
		resourceList.add(new Resource(ResourceType.GOLD,0,0,0,1));
		resourceList.add(new Resource(ResourceType.MOUNTAIN,0,0,0,0));
		resourceList.add(new Resource(ResourceType.SEA,0,0,0,0));
	}




}
