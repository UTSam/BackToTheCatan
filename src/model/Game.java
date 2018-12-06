package model;

import java.util.ArrayList;

public class Game {


	private ArrayList<Map> mapList;
	private ArrayList<Resource> resourceList;

	public Game () {
		mapList=new ArrayList<Map>();
		
		mapList.add(new Map("1985",1,1,4,3,4,3,2));
		mapList.add(new Map("1955",1,1,4,3,4,3,2));
		mapList.add(new Map("2000",1,1,4,3,4,3,2));
		mapList.add(new Map("2015",1,1,4,3,4,3,2));
		resourceList= new ArrayList<Resource>();

		initializeResourceList();

		//Generation of the map
		for (Map m : mapList) {
			m.setToBigSize();
			m.generate(resourceList);
		}
	}

	public void Run(){
		for (Map m : mapList) {
			//m.printRoad();
			m.printTile();
		}
	}

	public ArrayList<Map> getMapList(){
		return mapList;
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
