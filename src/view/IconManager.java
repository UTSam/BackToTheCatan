package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IconManager {
	
	private Image goldImage;
	private Image foodImage;
	private Image energyImage;
	private Image constructionImage;
	
	IconManager() {
		goldImage = new Image("resources/goldIcon.png");
		foodImage = new Image("resources/foodIcon.png");
		energyImage = new Image("resources/energyIcon.png");
		constructionImage = new Image("resources/constructionIcon.png");
	}
	
	public Image getGoldIcon() {
		return goldImage;
	}
	
	public Image getFoodIcon() {
		return foodImage;
	}
	
	public Image getEnergyIcon() {
		return energyImage;
	}
	
	public Image getConstructionIcon() {
		return constructionImage;
	}
}
