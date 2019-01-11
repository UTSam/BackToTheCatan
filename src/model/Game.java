package model;

import java.util.ArrayList;
import java.util.Collections;

import view.DiceBox;
import view.WinnerBox;

public class Game {


	private ArrayList<Map> mapList;
	private ArrayList<Resource> resourceList;
	private ArrayList<Player> playerList;
	private ArrayList<Card> cardList;

	private PairOfDice pairOfDice;

	private Player playerTurn;
	private int scoreToWin;

	private boolean firstTurn;
	private boolean secondTurn;

	public Game () {

		pairOfDice=new PairOfDice();

		generateResourceList();
		generateMapList();
		generatePlayerList();
		generateCardList();

		firstTurn=true;
		secondTurn=false;


		playerTurn=playerList.get(0);
		scoreToWin=10;

	}

	private void generateMapList(){
		mapList=new ArrayList<Map>();
		//int woodQuantity, int coalQuantity, int foodQuantity, int metalQuantity, int oilQuantity, int plutoniumQuantity, int GoldQuantity
		mapList.add(new Map("1850",4,3,3,3,1,0,0,3));
		mapList.add(new Map("1955",5,3,3,3,3,4,0,2));
		mapList.add(new Map("1985",5,1,1,4,3,4,3,2));
		mapList.add(new Map("2015",4,0,0,3,3,1,4,2));

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

		playerList.add(new Player(1, "Joueur 1"));
		playerList.add(new Player(2, "Joueur 2"));
		playerList.add(new Player(3, "Joueur 3"));
		playerList.add(new Player(4, "Joueur 4"));

		GeneratePlayerOrder();
	}

	/* Can be upgraded*/
	private void GeneratePlayerOrder(){ /* Fonction that set the order of the player */

		int playerRoll[][]=new int[4][2],i;

		for(i=0;i<4;i++){
			playerRoll[i][0]=i+1;
			playerRoll[i][1]=pairOfDice.roll();
			System.out.println("lancé de dé:"+ pairOfDice.getSum());
			//DiceBox.display(this);
		}

		triBulleCroissant(playerRoll);
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
					cardList.add(new Card(CardType.VictoryPoint,this));
					break;
				case 1:
					cardList.add(new Card(CardType.Knight,this));
					break;
				case 2:
					cardList.add(new Card(CardType.Discovery,this));
					break;
				case 3:
					cardList.add(new Card(CardType.Monopole,this));
					break;
				case 4:
					cardList.add(new Card(CardType.RoadConstruction,this));
					break;
				}
			}
			j++;
		}
	}

	public void drawCard(Player player){
		player.addCard(cardList.get(0));
		cardList.remove(0);
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



	public void whoWin(){
		for(Player player: playerList){
			if(player.getScore()>=scoreToWin){
				WinnerBox.display(player);
			}
		}
	}

	public void nextPlayer(){
		if(playerTurn == playerList.get(0)){
			playerTurn=playerList.get(1);
		}
		else if(playerTurn == playerList.get(1)){
			playerTurn=playerList.get(2);
		}
		else if(playerTurn == playerList.get(2)){
			playerTurn=playerList.get(3);
		}
		else {
			playerTurn=playerList.get(0);
		}
	}
	
	public void previousPlayer(){
		if(playerTurn == playerList.get(0)){
			playerTurn=playerList.get(3);
		}
		else if(playerTurn == playerList.get(1)){
			playerTurn=playerList.get(0);
		}
		else if(playerTurn == playerList.get(2)){
			playerTurn=playerList.get(1);
		}
		else {
			playerTurn=playerList.get(2);
		}
	}

	/* TODO A CHECK */
	public void attributeResources(){

		pairOfDice.roll();

		System.out.println("de" + pairOfDice.getSum());
		/* Return the tiles with the corresponding number on the 4 maps*/
		ArrayList<Tile> tileList=new ArrayList<Tile>();
		for(Map m:mapList){
			tileList.addAll(m.getTilesFromNumber(pairOfDice.getSum()));
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
					player=null;
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

	public ArrayList<Card> getCardList(){
		return cardList;
	}

	public Player getCurrentPlayer() {
		return playerTurn;
	}

	public PairOfDice getDice() {
		return pairOfDice;
	}


	private void initializeResourceList(){
		/* Initialize the list of all the different type of resources in the game*/
		/* The 4 categories are Food, Energy, Construction and Gold*/
		resourceList.add(new Resource(ResourceType.WOOD,0,0,1,0));
		resourceList.add(new Resource(ResourceType.COAL,0,1,0,0));
		resourceList.add(new Resource(ResourceType.FOOD,1,0,0,0));
		resourceList.add(new Resource(ResourceType.METAL,0,0,2,0));
		resourceList.add(new Resource(ResourceType.OIL,0,1,1,0));
		resourceList.add(new Resource(ResourceType.PLUTONIUM,0,2,0,0));
		resourceList.add(new Resource(ResourceType.GOLD,0,0,0,1));
		resourceList.add(new Resource(ResourceType.MOUNTAIN,0,0,0,0));
		resourceList.add(new Resource(ResourceType.SEA,0,0,0,0));
	}

	public void buildDelorean(Node n, Player p,Map m) {
		if (p.CheckResource(1, 1, 2, 0) && n.getStatus()==StatusNodeType.EMPTY && !m.checkNeighbour(n) && m.checkTP(getCurrentPlayer()) && m.checkNeighbourDR(n, p))
		{
			n.setStatus(p.chooseNodeStatus());
			p.setScore(p.getScore()+1);
			p.getResourceInventory().addEnergy(-1);
			p.getResourceInventory().addConstruction(-2);
			p.getResourceInventory().addFood(-1);

		}


	}

	public int getScoreToWin() {
		return scoreToWin;
	}

	public void setScoreToWin(int scoreToWin) {
		this.scoreToWin = scoreToWin;
	}

	public void buildRoad(Road r, Player p, Map m) {
						 /*(f, e, c, g)*/
		if (p.CheckResource(1, 1, 1, 0) && r.getStatus()==StatusRoadType.EMPTY && m.checkNeighbourR(r, p) && m.checkTP(p))
		{
			r.setStatus(p.chooseRoadStatus());
			p.getResourceInventory().addEnergy(-1);
			p.getResourceInventory().addConstruction(-1);
			p.getResourceInventory().addFood(-1);
		}


	}

	public void buildRoadFree(Road r, Player p, Map m) {
		if (r.getStatus()==StatusRoadType.EMPTY && m.checkNeighbourR(r, p))
		{
			if (p.getFirstRoad() == false) {
				p.setFirstRoad(true);
			} else {
				p.setSecondRoad(true);
			}
			r.setStatus(p.chooseRoadStatus());
		}
	}

	public boolean buildTeleporter(Node n, Player p, Map m)
	{
		if (p.CheckResource(0, 3, 1, 0) && n.getStatus()==p.chooseNodeStatus() && !n.isTeleporter() && !m.checkMapEdge(n))

		{
			n.setTeleporter(true);
			p.setScore(p.getScore()+1);
			p.getResourceInventory().addEnergy(-3);
			p.getResourceInventory().addConstruction(-1);
			return true;
		}
			else
				return false;
	}

	public void buildDeloreanFree(Node n1, Player p){
		if (n1.getStatus()==StatusNodeType.EMPTY)

		{
			n1.setStatus(p.chooseNodeStatus());
		}
	}

	public void buildDeloreanBegin(Node n1, Player p){
		if (n1.getStatus()==StatusNodeType.EMPTY && !(mapList.get(2).checkNeighbour(n1)))

		{
			n1.setStatus(p.chooseNodeStatus());
			p.setScore(p.getScore()+1);
			if (p.getFirstDelorean() == false) {
				p.setFirstDelorean(true);
			} else {
				p.setSecondDelorean(true);
			}		
		}
	}
	
	public void firstArmy()
	{System.out.println("First army");
		for(Player p : playerList)
		{
			if(p.getKnightPoint()>=3 && cmpArmy()==p)
			{	for(Player P : playerList)
				{
					if(P.isFirstKnight())
					{
					  P.setScore(P.getScore()-2);
					}
					
				P.setFirstKnight(false);
				
				
				}
			p.setFirstKnight(true);
			System.out.println("joueur" + p.getName() + "   " + p.isFirstKnight());
			p.setScore(p.getScore()+2);
			System.out.println(p.getScore());
				

			}
			else if(p.getKnightPoint()>=3 && cmpArmy()==null)
			{	System.out.println("AAAA");
				for(Player P : playerList)
				{
					if(P.isFirstKnight())
					{
					  P.setScore(P.getScore()-2);
					}
					
				P.setFirstKnight(false);
				
				
				}
			
			

			}
		}
	}
	public Player cmpArmy()
	{Player win=null;
		int max=0;
		
		for(Player p : playerList)
		{
			if(p.getKnightPoint()>max)
			{max=p.getKnightPoint();
			win=p;
			System.out.println(win.getName());
			}
			else if(p.getKnightPoint()==max)
			{win=null;}
			
		}
		

		return win;
		
	}

	public Player getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(Player playerTurn) {
		this.playerTurn = playerTurn;
	}

	private void triBulleCroissant(int tableau[][]) {
		int longueur = tableau.length;
		int tampon[] = {0,0};
		boolean permut;
		Player playerTemp1,playerTemp2;

		do {
			// hypothèse : le tableau est trié
			permut = false;
			for (int i = 0; i < longueur - 1; i++) {
				// Teste si 2 éléments successifs sont dans le bon ordre ou non
				if (tableau[i][1] < tableau[i + 1][1]) {
					// s'ils ne le sont pas, on échange leurs positions

					playerTemp1=playerList.get(i);
					playerTemp2=playerList.get(i+1);
					playerList.set(i, playerTemp2);
					playerList.set(i+1, playerTemp1);

					tampon = tableau[i];
					tableau[i] = tableau[i + 1];
					tableau[i + 1] = tampon;

					permut = true;
				}
			}
		} while (permut);
	}

	public Boolean isFirstTurn() {
		return firstTurn;
	}
	
	public void setFirstTurn(Boolean bool) {
		firstTurn = bool;
	}
	
	public Boolean isSecondTurn() {
		return secondTurn;
	}
	
	public void setSecondTurn(Boolean bool) {
		secondTurn = bool;
	}
}
