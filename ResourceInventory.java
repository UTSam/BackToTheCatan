package model;

public class ResourceInventory {
	private ResourceType type;
	private int food;
	private int gold;
	private int energy;
	private int construction;
	
	public ResourceInventory(){
	}

	public ResourceInventory(ResourceType type, int food, int gold, int energy, int construction) {
		super();
		this.type = type;
		this.food = food;
		this.gold = gold;
		this.energy = energy;
		this.construction = construction;
	}

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getConstruction() {
		return construction;
	}

	public void setConstruction(int construction) {
		this.construction = construction;
	}

	public void addResource(int nb) {
		switch(this.type) {

			case FOOD : food+=nb;
			break;
			case GOLD : gold+=nb;
			break;
			case CONSTRUCTION: construction+= nb;
			break;
			case ENERGY: energy+= nb;
			break;
			default:
			break;
		
		}
	}
	public void removeResource(int nb) {
		switch(this.type) {
		case FOOD : food-=nb;
		break;
		case GOLD : gold-=nb;
		break;
		case CONSTRUCTION: construction-= nb;
		break;
		case ENERGY: energy-= nb;
		break;
		default: 
		break;
	
	}

}
