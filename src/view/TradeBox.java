package view;

import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Player;

public class TradeBox {
	static int nbFood1=0;
	static int nbGold1=0;
	static int nbEnergy1=0;
	static int nbConstruction1=0;
	
	static int nbFood2=0;
	static int nbGold2=0;
	static int nbEnergy2=0;
	static int nbConstruction2=0;
	
	public static void display(Player p1, Player p2, GameView gv) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setWidth(600);
		window.setHeight(400);
		window.setResizable(false);
		
		nbFood1=0;
		nbGold1=0;
		nbEnergy1=0;
		nbConstruction1=0;
		
		
		Label nbFood1L = new Label(Integer.toString(nbFood1));
		GridPane.setHalignment(nbFood1L, HPos.CENTER);
		Label nbGold1L = new Label(Integer.toString(nbGold1));
		GridPane.setHalignment(nbGold1L, HPos.CENTER);
		Label nbEnergy1L = new Label(Integer.toString(nbEnergy1));
		GridPane.setHalignment(nbEnergy1L, HPos.CENTER);
		Label nbConstruction1L = new Label(Integer.toString(nbConstruction1));
		GridPane.setHalignment(nbConstruction1L, HPos.CENTER);
		
		Button closeButton = new Button("Annuler");
		closeButton.setPrefSize(200, 100);
		closeButton.setOnAction(e -> window.close());
		
		Button validateButton = new Button("Confirmer");
		validateButton.setPrefSize(200, 100);
		validateButton.setOnAction(e -> {
			p1.getResourceInventory().addEnergy(nbEnergy2);
			p1.getResourceInventory().addFood(nbFood2);
			p1.getResourceInventory().addGold(nbGold2);
			p1.getResourceInventory().addConstruction(nbConstruction2);
			p1.getResourceInventory().addEnergy(-nbEnergy1);
			p1.getResourceInventory().addFood(-nbFood1);
			p1.getResourceInventory().addGold(-nbGold1);
			p1.getResourceInventory().addConstruction(-nbConstruction1);
			
			p2.getResourceInventory().addEnergy(nbEnergy1);
			p2.getResourceInventory().addFood(nbFood1);
			p2.getResourceInventory().addGold(nbGold1);
			p2.getResourceInventory().addConstruction(nbConstruction1);
			p2.getResourceInventory().addEnergy(-nbEnergy2);
			p2.getResourceInventory().addFood(-nbFood2);
			p2.getResourceInventory().addGold(-nbGold2);
			p2.getResourceInventory().addConstruction(-nbConstruction2);
			
			for (PlayerView pv : gv.getPlayerViewList()) {
				pv.refresh();
			}
			window.close();
		});
		
		Label p1Name = new Label(p1.getName());
		p1Name.setStyle("-fx-font-size: 30;");
		Label p2Name = new Label(p2.getName());
		p2Name.setStyle("-fx-font-size: 30;");

		
		Button addFood1 = new Button("+");
		GridPane.setHalignment(addFood1, HPos.CENTER);
		addFood1.setOnAction(e-> { 
			if (nbFood1<p1.getResourceInventory().getFood()) {
				nbFood1++; 
				nbFood1L.setText(Integer.toString(nbFood1));
			}
		});
		Button removeFood1 = new Button("-");
		GridPane.setHalignment(removeFood1, HPos.CENTER);
		removeFood1.setOnAction(e-> {if (nbFood1>0) {
			nbFood1--; 
			nbFood1L.setText(Integer.toString(nbFood1));
			}
		});
		Button addGold1 = new Button("+");
		GridPane.setHalignment(addGold1, HPos.CENTER);
		addGold1.setOnAction(e-> { 
			if (nbGold1<p1.getResourceInventory().getGold()) {
				nbGold1++; 
				nbGold1L.setText(Integer.toString(nbGold1));
			}
		});
		Button removeGold1 = new Button("-");
		GridPane.setHalignment(removeGold1, HPos.CENTER);
		removeGold1.setOnAction(e-> {if (nbGold1>0) {
			nbGold1--; 
			nbGold1L.setText(Integer.toString(nbGold1));
			}
		});
		Button addEnergy1 = new Button("+");
		GridPane.setHalignment(addEnergy1, HPos.CENTER);
		addEnergy1.setOnAction(e-> { 
			if (nbEnergy1<p1.getResourceInventory().getEnergy()) {
				nbEnergy1++; 
				nbEnergy1L.setText(Integer.toString(nbEnergy1));
			}
		});
		Button removeEnergy1 = new Button("-");
		GridPane.setHalignment(removeEnergy1, HPos.CENTER);
		removeEnergy1.setOnAction(e-> {if (nbEnergy1>0) {
			nbEnergy1--; 
			nbEnergy1L.setText(Integer.toString(nbEnergy1));
			}
		});
		Button addConstruction1 = new Button("+");
		GridPane.setHalignment(addConstruction1, HPos.CENTER);
		addConstruction1.setOnAction(e-> {
			if (nbConstruction1<p1.getResourceInventory().getConstruction()) {
				nbConstruction1++; 
				nbConstruction1L.setText(Integer.toString(nbConstruction1));
			}
		});
		Button removeConstruction1 = new Button("-");
		GridPane.setHalignment(removeConstruction1, HPos.CENTER);
		removeConstruction1.setOnAction(e-> {if (nbConstruction1>0) {
			nbConstruction1--; 
			nbConstruction1L.setText(Integer.toString(nbConstruction1));
			}
		});
		
		nbFood2=0;
		nbGold2=0;
		nbEnergy2=0;
		nbConstruction2=0;
		
		
		Label nbFood2L = new Label(Integer.toString(nbFood2));
		GridPane.setHalignment(nbFood2L, HPos.CENTER);
		Label nbGold2L = new Label(Integer.toString(nbGold2));
		GridPane.setHalignment(nbGold2L, HPos.CENTER);
		Label nbEnergy2L = new Label(Integer.toString(nbEnergy2));
		GridPane.setHalignment(nbEnergy2L, HPos.CENTER);
		Label nbConstruction2L = new Label(Integer.toString(nbConstruction2));
		GridPane.setHalignment(nbConstruction2L, HPos.CENTER);
		
		
		
		Button addFood2 = new Button("+");
		GridPane.setHalignment(addFood2, HPos.CENTER);
		addFood2.setOnAction(e-> { 
			if (nbFood2<p2.getResourceInventory().getFood()) {
				nbFood2++; 
				nbFood2L.setText(Integer.toString(nbFood2));
			}
		});
		Button removeFood2 = new Button("-");
		GridPane.setHalignment(removeFood2, HPos.CENTER);
		removeFood2.setOnAction(e-> {if (nbFood2>0) {
			nbFood2--; 
			nbFood2L.setText(Integer.toString(nbFood2));
			}
		});
		Button addGold2 = new Button("+");
		GridPane.setHalignment(addGold2, HPos.CENTER);
		addGold2.setOnAction(e-> { 
			if (nbGold2<p2.getResourceInventory().getGold()) {
				nbGold2++; 
				nbGold2L.setText(Integer.toString(nbGold2));
			}
		});
		Button removeGold2 = new Button("-");
		GridPane.setHalignment(removeGold2, HPos.CENTER);
		removeGold2.setOnAction(e-> {if (nbGold2>0) {
			nbGold2--; 
			nbGold2L.setText(Integer.toString(nbGold2));
			}
		});
		Button addEnergy2 = new Button("+");
		GridPane.setHalignment(addEnergy2, HPos.CENTER);
		addEnergy2.setOnAction(e-> { 
			if (nbEnergy2<p2.getResourceInventory().getEnergy()) {
				nbEnergy2++; 
				nbEnergy2L.setText(Integer.toString(nbEnergy2));
			}
		});
		Button removeEnergy2 = new Button("-");
		GridPane.setHalignment(removeEnergy2, HPos.CENTER);
		removeEnergy2.setOnAction(e-> {if (nbEnergy2>0) {
			nbEnergy2--; 
			nbEnergy2L.setText(Integer.toString(nbEnergy2));
			}
		});
		Button addConstruction2 = new Button("+");
		GridPane.setHalignment(addConstruction2, HPos.CENTER);
		addConstruction2.setOnAction(e-> {
			if (nbConstruction2<p2.getResourceInventory().getConstruction()) {
				nbConstruction2++; 
				nbConstruction2L.setText(Integer.toString(nbConstruction2));
			}
		});
		Button removeConstruction2 = new Button("-");
		GridPane.setHalignment(removeConstruction2, HPos.CENTER);
		removeConstruction2.setOnAction(e-> {if (nbConstruction2>0) {
			nbConstruction2--; 
			nbConstruction2L.setText(Integer.toString(nbConstruction2));
			}
		});
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(50, 50, 50, 50));
		gridPane.setHgap(25);
		gridPane.setVgap(10);
		//grid 10*6
		gridPane.add(p1Name, 0, 0,3, 1);

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
		gridPane.add(constructionView1, 3, 1);

		ImageView foodView2 = new ImageView(gv.iManager.getFoodIcon());
		foodView2.setFitWidth(size);
		foodView2.setFitHeight(size);
		gridPane.add(foodView2, 5, 1);
		
		ImageView goldView2 = new ImageView(gv.iManager.getGoldIcon());
		goldView2.setFitWidth(size);
		goldView2.setFitHeight(size);
		gridPane.add(goldView2, 6, 1);
		
		ImageView energyView2 = new ImageView(gv.iManager.getEnergyIcon());
		energyView2.setFitWidth(size);
		energyView2.setFitHeight(size);
		gridPane.add(energyView2, 7, 1);
		
		ImageView constructionView2 = new ImageView(gv.iManager.getConstructionIcon());
		constructionView2.setFitWidth(size);
		constructionView2.setFitHeight(size);
		gridPane.add(constructionView2, 8, 1);
		
		gridPane.add(addFood1, 0, 3);
		gridPane.add(addGold1, 1, 3);
		gridPane.add(addEnergy1, 2, 3);
		gridPane.add(addConstruction1, 3, 3);
		
		gridPane.add(nbFood1L, 0, 4);
		gridPane.add(nbGold1L, 1, 4);
		gridPane.add(nbEnergy1L, 2, 4);
		gridPane.add(nbConstruction1L, 3, 4);
		
		gridPane.add(removeFood1, 0, 5);
		gridPane.add(removeGold1, 1, 5);
		gridPane.add(removeEnergy1, 2, 5);
		gridPane.add(removeConstruction1, 3, 5);

		
		gridPane.add(p2Name, 5, 0,3, 1);
		
		gridPane.add(addFood2, 5, 3);
		gridPane.add(addGold2, 6, 3);
		gridPane.add(addEnergy2, 7, 3);
		gridPane.add(addConstruction2, 8, 3);
		
		gridPane.add(nbFood2L, 5, 4);
		gridPane.add(nbGold2L, 6, 4);
		gridPane.add(nbEnergy2L, 7, 4);
		gridPane.add(nbConstruction2L, 8, 4);
		
		gridPane.add(removeFood2, 5, 5);
		gridPane.add(removeGold2, 6, 5);
		gridPane.add(removeEnergy2, 7, 5);
		gridPane.add(removeConstruction2, 8, 5);
		
		gridPane.add(closeButton, 6, 12, 4, 3);
		gridPane.add(validateButton, 1, 12, 4, 3);
		
		Scene scene = new Scene(gridPane);
		scene.getStylesheets().add("resources/style.css");
		window.setScene(scene);
		window.showAndWait();
	}
}
