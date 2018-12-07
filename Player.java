package model;

public class Player {
	private static int score;
	private int id;
	private ResourceInventory resourceInventory;
	private static int[] cardInventory = new int[100];
	private static boolean hasLongestRoad;
	private static int nbCard;
	public Player(int pid) {
		id = pid;
		
	}

	public void trade(ResourceType r1, int n1 , ResourceType r2, int n2, Player Player2 ) {
		this.resourceInventory.setType(r1);
		this.resourceInventory.addResource(n1);
		this.resourceInventory.setType(r2);
		this.resourceInventory.removeResource(n2);
		
		Player2.resourceInventory.setType(r2);
		Player2.resourceInventory.addResource(n2);
		Player2.resourceInventory.setType(r1);
		Player2.resourceInventory.removeResource(n1);
		
	}


}
