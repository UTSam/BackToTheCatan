package model;

public class ResourceInventory {
	private int food;
	private int gold;
	private int energy;
	private int construction;

	public ResourceInventory() {
		this.food = 0;
		this.gold = 0;
		this.energy = 0;
		this.construction = 0;
	}


	public ResourceInventory(int food, int gold, int energy, int construction) {
		this.food = food;
		this.gold = gold;
		this.energy = energy;
		this.construction = construction;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public void addFood(int food) {
		this.food += food;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public void addGold(int gold) {
		this.gold += gold;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public void addEnergy(int energy) {
		this.energy += energy;
	}

	public int getConstruction() {
		return construction;
	}

	public void setConstruction(int construction) {
		this.construction = construction;
	}

	public void addConstruction(int construction) {
		this.construction += construction;
	}

	/*public void addResource(int nb) {
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

	}*/

}
