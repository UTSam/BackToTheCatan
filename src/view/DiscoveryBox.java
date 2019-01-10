package view;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Player;

public class DiscoveryBox {
	public static void display(GameView gv, Player p) {
		
		Boolean chose1 = false;
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setWidth(500);
		window.setHeight(500);
		window.setResizable(false);
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setVgap(25);
		gridPane.setHgap(50);
		
		Label label = new Label("Choisissez une ressource a obtenir");
		label.setAlignment(Pos.CENTER);
		label.setStyle( "-fx-font-size: 25;");
		gridPane.add(label, 0, 0, 4, 1);
		
		int size = 50;
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
		gridPane.add(constructionView1, 3, 1);
		
		GridPane.setHalignment(energyView1, HPos.CENTER);
		GridPane.setHalignment(goldView1, HPos.CENTER);
		GridPane.setHalignment(foodView1, HPos.CENTER);
		GridPane.setHalignment(constructionView1, HPos.CENTER);
		
		Button foodButton = new Button("Obtenir");
		foodButton.setPrefSize(70, 20);
		gridPane.add(foodButton, 0, 2);
		
		Button goldButton = new Button("Obtenir");
		goldButton.setPrefSize(70, 20);
		gridPane.add(goldButton, 1, 2);
		
		Button energyButton = new Button("Obtenir");
		energyButton.setPrefSize(70, 20);
		gridPane.add(energyButton, 2, 2);
		
		Button constructionButton = new Button("Obtenir");
		constructionButton.setPrefSize(70, 20);
		gridPane.add(constructionButton, 3, 2);
		
		foodButton.setOnAction(e-> {
			p.getResourceInventory().addFood(1);
			window.close();			
		});
		
		goldButton.setOnAction(e-> {
			p.getResourceInventory().addGold(1);
			window.close();			
		});
		
		energyButton.setOnAction(e-> {
			p.getResourceInventory().addEnergy(1);
			window.close();			
		});
		
		constructionButton.setOnAction(e-> {
			p.getResourceInventory().addConstruction(1);
			window.close();

		});
		
		Scene scene = new Scene(gridPane);
		scene.getStylesheets().add("resources/style.css");
		window.setScene(scene);
		window.showAndWait();
	}
}
