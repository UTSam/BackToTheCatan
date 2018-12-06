package model;

public class Resource {
	private ResourceType type;
	private int food;
	private int energy;
	private int construction;
	private int gold;

	public Resource(){
	}

	public Resource(ResourceType type, int food, int energy, int construction, int gold){
		this.type=type;
		this.food=food;
		this.energy=energy;
		this.gold=gold;
		this.construction=construction;
	}

	public ResourceType getType(){
		return type;
	}

	public int getFood(){
		return food;
	}

	public int getEnergy(){
		return energy;
	}

	public int getGold(){
		return gold;
	}

	public int getConstruction(){
		return construction;
	}

}
