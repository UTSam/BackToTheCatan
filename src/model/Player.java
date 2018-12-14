package model;

public class Player {
	private static int score;
	private int id;
	private String name;
	private ResourceInventory resourceInventory;
	private static int[] cardInventory = new int[100];
	private static boolean hasLongestRoad;
	private static int nbCard;


	public Player(int id, String name) {
		this.id = id;
		this.name = name;
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

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

}
