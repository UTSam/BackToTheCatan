package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BankBox {
	
	public static void display(GameView gv) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setWidth(500);
		window.setHeight(500);
		window.setResizable(false);
		
		GridPane gridPane = new GridPane();
		gridPane.setVgap(50);
		gridPane.setHgap(25);
		gridPane.setAlignment(Pos.CENTER);
		
		Label label = new Label("Selectionnez une ressource\n a echanger pour 3 d'or");
		label.setStyle( "-fx-font-size: 25;");
		gridPane.add(label, 0, 0, 3, 1);
		
		int size = 60;
		ImageView foodView1 = new ImageView(gv.iManager.getFoodIcon());
		foodView1.setFitWidth(size);
		foodView1.setFitHeight(size);
		gridPane.add(foodView1, 0, 1);
		
		ImageView energyView1 = new ImageView(gv.iManager.getEnergyIcon());
		energyView1.setFitWidth(size);
		energyView1.setFitHeight(size);
		gridPane.add(energyView1, 1, 1);
		
		ImageView constructionView1 = new ImageView(gv.iManager.getConstructionIcon());
		constructionView1.setFitWidth(size);
		constructionView1.setFitHeight(size);
		gridPane.add(constructionView1, 2, 1);
		
		Button foodTrade = new Button("Acheter");
		gridPane.add(foodTrade, 0, 2);
		foodTrade.setOnAction(e-> {
			if (gv.getGame().getCurrentPlayer().getResourceInventory().getGold() > 2) {
				System.out.println("ffod");
				gv.getGame().getCurrentPlayer().getResourceInventory().addGold(-3);
				gv.getGame().getCurrentPlayer().getResourceInventory().addFood(1);
				for (PlayerView pv : gv.getPlayerViewList()) {
					pv.refresh();
				}
			}
		});
		
		Button energyTrade = new Button("Acheter");
		gridPane.add(energyTrade, 1, 2);
		energyTrade.setOnAction(e-> {
			if (gv.getGame().getCurrentPlayer().getResourceInventory().getGold() > 2) {
				gv.getGame().getCurrentPlayer().getResourceInventory().addGold(-3);
				gv.getGame().getCurrentPlayer().getResourceInventory().addEnergy(1);
				for (PlayerView pv : gv.getPlayerViewList()) {
					pv.refresh();
				}
			}
		});
		
		Button constructionTrade = new Button("Acheter");
		gridPane.add(constructionTrade, 2, 2);
		constructionTrade.setOnAction(e-> {
			if (gv.getGame().getCurrentPlayer().getResourceInventory().getGold() > 2) {
				gv.getGame().getCurrentPlayer().getResourceInventory().addGold(-3);
				gv.getGame().getCurrentPlayer().getResourceInventory().addConstruction(1);
				for (PlayerView pv : gv.getPlayerViewList()) {
					pv.refresh();
				}
			}
		});
		
		Scene scene = new Scene(gridPane);
		scene.getStylesheets().add("resources/style.css");
		window.setScene(scene);
		window.showAndWait();
	}
}
