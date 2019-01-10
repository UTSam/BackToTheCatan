package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Player;

public class DiscoveryBox {
	public static void display(GameView gv, Player p) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setWidth(500);
		window.setHeight(500);
		window.setResizable(false);
		
		GridPane gridPane = new GridPane();
		
		int size = 30;
		ImageView foodView1 = new ImageView(gv.iManager.getFoodIcon());
		foodView1.setFitWidth(size);
		foodView1.setFitHeight(size);
		gridPane.add(foodView1, 0, 1);
		
		ImageView goldView1 = new ImageView(gv.iManager.getGoldIcon());
		goldView1.setFitWidth(size);
		goldView1.setFitHeight(size);
		gridPane.add(goldView1, 1, 1);
		
		ImageView energyView1 = new ImageView(gv.iManager.getEnergyIcon());
		energyView1.setFitWidth(size);
		energyView1.setFitHeight(size);
		gridPane.add(energyView1, 2, 1);
		
		ImageView constructionView1 = new ImageView(gv.iManager.getConstructionIcon());
		constructionView1.setFitWidth(size);
		constructionView1.setFitHeight(size);
		gridPane.add(constructionView1, 4, 1);
	}
}
