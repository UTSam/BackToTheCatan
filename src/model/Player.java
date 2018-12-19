package model;

public class Player {
	private static int score;
	private int id;
	private String name;
	private ResourceInventory resourceInventory;
	private static int[] cardInventory = new int[100];
	private static boolean hasLongestRoad;
	private static int nbCard;
	private int knightPoint;


	public Player(int id, String name) {
		this.id = id;
		this.name = name;
		resourceInventory = new ResourceInventory();
		score=0;
		knightPoint=0;
	}

	public ResourceInventory getResourceInventory(){
		return resourceInventory;
	}

	/*public void trade(ResourceType r1, int n1 , ResourceType r2, int n2, Player Player2 ) {
		this.resourceInventory.setType(r1);
		this.resourceInventory.addResource(n1);
		this.resourceInventory.setType(r2);
		this.resourceInventory.removeResource(n2);

		Player2.resourceInventory.setType(r2);
		Player2.resourceInventory.addResource(n2);
		Player2.resourceInventory.setType(r1);
		Player2.resourceInventory.removeResource(n1);

	}*/

	public void addVictoryPoint(){
		score++;
	}

	public void addKnightPoint(){
		knightPoint++;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	
	public StatusNodeType chooseNodeStatus() {
		StatusNodeType s =StatusNodeType.EMPTY;
		switch (this.id) {
		case 1 : s=StatusNodeType.PLAYER1;
		break;
		case 2 : s=StatusNodeType.PLAYER2;
		break;
		case 3 : s=StatusNodeType.PLAYER3;
		break;
		case 4 : s=StatusNodeType.PLAYER4;
		break;
		}
		return s;
	}
	
	public StatusRoadType chooseRoadStatus() {
		StatusRoadType s =StatusRoadType.EMPTY;
		switch (this.id) {
		case 1 : s=StatusRoadType.PLAYER1;
		break;
		case 2 : s=StatusRoadType.PLAYER2;
		break;
		case 3 : s=StatusRoadType.PLAYER3;
		break;
		case 4 : s=StatusRoadType.PLAYER4;
		break;
		}
		return s;
	}
	public boolean CheckResource(int f, int e, int c, int g) {

        if(resourceInventory.getFood() < f || resourceInventory.getEnergy() < e ||  resourceInventory.getConstruction() < c ||resourceInventory.getGold() < g  ) {
            return false;
        }
        else {
            return true;
        }

    }

	public void setScore(int score) {
		Player.score = score;
	}

}
