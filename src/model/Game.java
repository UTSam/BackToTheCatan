package model;

import java.util.ArrayList;

public class Game {


	private ArrayList<Map> mapList;
	private ArrayList<Resource> resourceList;
	private ArrayList<Player> playerList;
	private ArrayList<Card> cardList;

	private Player playerTurn;
	private int scoreToWin;

	public Game () {

		generateResourceList();
		generateMapList();
		generatePlayerList();
		generateCardList();

		playerTurn=playerList.get(0);
		scoreToWin=10;

	}

	private void generateMapList(){
		mapList=new ArrayList<Map>();

		mapList.add(new Map("1850",4,1,1,4,3,4,3,2));
		mapList.add(new Map("1955",5,1,1,4,3,4,3,2));
		mapList.add(new Map("1985",5,1,1,4,3,4,3,2));
		mapList.add(new Map("2015",4,1,1,4,3,4,3,2));

		//Generation of the maps
		for (Map m : mapList) {
			m.generate(resourceList);
		}
	}

	private void generateResourceList(){
		resourceList= new ArrayList<Resource>();

		initializeResourceList();
	}

	private void generatePlayerList(){
		playerList=new ArrayList<Player>();

		playerList.add(new Player(1, "Alain"));
		playerList.add(new Player(2, "Michel"));
		playerList.add(new Player(3, "Jacky"));
		playerList.add(new Player(4, "Robert"));
	}

	private void generateCardList(){
		cardList = new ArrayList<Card>();

		/* cardValueList represent the number of time the card type i will be present*/
		/* The card type order is VictoryPoint,Knight,Discovery, Monopole and RoadConstruction;*/
		int cardValueList[], max=25, rand = 0, j=0;
		cardValueList=new int[] {5,14,2,2,2};

		int cardType;

		while (j!=max){
			/* Module that find a card type that is still not all in the card stack*/
			rand=(int) (Math.random()*25)+1;
			cardType=FindCardTypeFromStack(rand);
			while(cardValueList[cardType]==0 && j<max){
				rand=(int) (Math.random()*25)+1;
				cardType=FindCardTypeFromStack(rand);
			}

			if(j<max){

				cardValueList[cardType]--;

				switch (cardType){
				case 0:
					cardList.add(new Card(CardType.VictoryPoint));
					break;
				case 1:
					cardList.add(new Card(CardType.Knight));
					break;
				case 2:
					cardList.add(new Card(CardType.Discovery));
					break;
				case 3:
					cardList.add(new Card(CardType.Monopole));
					break;
				case 4:
					cardList.add(new Card(CardType.RoadConstruction));
					break;
				}
			}
			j++;
		}
	}


	public void printCardList(){
		int i=1;
		for(Card card:cardList){
			System.out.println("Carte n" + i + " " + card.getCardType());
			i++;
		}
	}

	public void Run(){
		/*boolean hasWin=false;
		while(hasWin=false){
			for(Player player: playerList){
				if (player.getScore()>=scoreToWin){
					hasWin=true;
				}
			}
			attributeResources();
				nextPlayer();
			}
		}*/
	}

	private int FindCardTypeFromStack(int rand){
		int cardType = 0;
		if(rand<=5){
			cardType=0;
			}
		else if(rand<=19){
			cardType=1;
		}
		else if(rand<=21){
			cardType=2;
		}
		else if(rand<=23){
			cardType=3;
		}
		else if(rand<=25){
			cardType=4;
		}
		return cardType;
	}



	public Player whoWin(){
		Player winner=null;
		for(Player player: playerList){
			if(player.getScore()==scoreToWin){
				winner=player;
			}
		}
		return winner;
	}

	public void nextPlayer(){
		if(playerTurn.getId()<4){
			playerTurn=playerList.get(playerTurn.getId());
		}
		else
			playerTurn=playerList.get(0);
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

	public Player getCurrentPlayer() {
		return playerTurn;
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
