package view;

import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Card;
import model.CardType;
import model.Player;

public class CardBox {
	Player player;
	GameView gameView;
	ArrayList<CardView> cardViewList;
	Boolean isCurrentPlayer;
	
	public CardBox(Player p, GameView gv) {
		player = p;
		gameView = gv;
		isCurrentPlayer = (p == gameView.getGame().getCurrentPlayer());
	}
	
	public void display() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setWidth(1250);
		window.setHeight(425);
		window.setResizable(false);
		

		cardViewList = new ArrayList<CardView>();
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(50, 50, 50, 50));
		gridPane.setHgap(25);
		gridPane.setVgap(25);
		CardView cvKnight = new CardView(player, isCurrentPlayer, CardType.Knight);
		CardView cvDiscovery = new CardView(player, isCurrentPlayer, CardType.Discovery);
		CardView cvMonopole = new CardView(player, isCurrentPlayer, CardType.Monopole);
		CardView cvRoadConstruction = new CardView(player, isCurrentPlayer, CardType.RoadConstruction);
		CardView cvVictoryPoint = new CardView(player, isCurrentPlayer, CardType.VictoryPoint);
		
		cardViewList.add(cvKnight);
		cardViewList.add(cvDiscovery);
		cardViewList.add(cvMonopole);
		cardViewList.add(cvRoadConstruction);
		cardViewList.add(cvVictoryPoint);
		
		gridPane.add(cvKnight.getGroup(), 0, 0);
		gridPane.add(cvDiscovery.getGroup(), 2, 0);
		gridPane.add(cvMonopole.getGroup(), 4, 0);
		gridPane.add(cvRoadConstruction.getGroup(), 6, 0);
		gridPane.add(cvVictoryPoint.getGroup(), 8, 0);
		
		if (isCurrentPlayer) {
			Button drawCardButton = new Button("PIOCHER\n\n"+ gameView.getGame().getCardList().size() + " cartes restantes");
			drawCardButton.setTextAlignment(TextAlignment.CENTER);
			drawCardButton.setPrefSize(150, 250);
			if (gameView.getGame().getCardList().size() == 0) {
				drawCardButton.setDisable(true);
			} 
			GridPane.setValignment(drawCardButton, VPos.TOP);
			drawCardButton.setOnAction(e -> { 
				if (player.getResourceInventory().getEnergy() > 0 &&
					player.getResourceInventory().getFood() > 0 &&
					player.getResourceInventory().getConstruction() > 0 &&
					player.getResourceInventory().getGold() > 0 ){
					
						player.getResourceInventory().addEnergy(-1);
						player.getResourceInventory().addFood(-1);
						player.getResourceInventory().addConstruction(-1);
						player.getResourceInventory().addGold(-1);
					
						gameView.getGame().drawCard(player);
						refresh();
						for (PlayerView pv : gameView.getPlayerViewList()) {
							pv.refresh();
						}
						drawCardButton.setText("PIOCHER\n\n"+ gameView.getGame().getCardList().size() + " cartes restantes");
						if (gameView.getGame().getCardList().size() == 0) {
							drawCardButton.setDisable(true);
						}
					}
				});
			gridPane.add(drawCardButton, 10, 0, 3, 5);
			
			Button knightUse = new Button("UTILISER");
			Button dicoverytUse = new Button("UTILISER");
			Button monopoleUse = new Button("UTILISER");
			Button roadUse = new Button("UTILISER");
			Button victoryUse = new Button("UTILISER");
			
			knightUse.setOnAction(e-> buttonAction(CardType.Knight));
			dicoverytUse.setOnAction(e-> buttonAction(CardType.Discovery));
			monopoleUse.setOnAction(e-> buttonAction(CardType.Monopole));
			roadUse.setOnAction(e-> buttonAction(CardType.RoadConstruction));
			victoryUse.setOnAction(e-> buttonAction(CardType.VictoryPoint));
			
			knightUse.setPrefSize(150, 50);
			dicoverytUse.setPrefSize(150, 50);
			monopoleUse.setPrefSize(150, 50);
			roadUse.setPrefSize(150, 50);
			victoryUse.setPrefSize(150, 50);
			
			gridPane.add(knightUse, 0, 1);
			gridPane.add(dicoverytUse, 2, 1);
			gridPane.add(monopoleUse, 4, 1);
			gridPane.add(roadUse, 6, 1);
			gridPane.add(victoryUse, 8, 1);
			
			GridPane icons = new GridPane();
			icons.setHgap(18);
			icons.setVgap(5);
			icons.setMouseTransparent(true);
			ImageView food = new ImageView(gameView.iManager.getFoodIcon());
			ImageView gold = new ImageView(gameView.iManager.getGoldIcon());
			ImageView energy = new ImageView(gameView.iManager.getEnergyIcon());
			ImageView construction = new ImageView(gameView.iManager.getConstructionIcon());
			
			food.setFitWidth(23);
			food.setFitHeight(23);
			gold.setFitWidth(23);
			gold.setFitHeight(23);
			energy.setFitWidth(23);
			energy.setFitHeight(23);
			construction.setFitWidth(23);
			construction.setFitHeight(23);
			
			icons.add(food, 0,34);
			icons.add(gold, 1,34);
			icons.add(energy, 2,34);
			icons.add(construction, 3,34);
			
			Label l1 = new Label("1");
			Label l2 = new Label("1");
			Label l3 = new Label("1");
			Label l4 = new Label("1");
			
			l1.setStyle( "-fx-font-size: 20");
			l2.setStyle( "-fx-font-size: 20");
			l3.setStyle( "-fx-font-size: 20");
			l4.setStyle( "-fx-font-size: 20");
			
			GridPane.setHalignment(l1, HPos.CENTER);
			GridPane.setHalignment(l2, HPos.CENTER);
			GridPane.setHalignment(l3, HPos.CENTER);
			GridPane.setHalignment(l4, HPos.CENTER);
			GridPane.setHalignment(icons, HPos.CENTER);
			
			icons.add(l1 , 0,35);
			icons.add(l2 , 1,35);
			icons.add(l3 , 2,35);
			icons.add(l4 , 3,35);
			
			gridPane.add(icons, 10, 0);
			
		} else {
			Rectangle hiddenCardR = new Rectangle(150, 250);
			hiddenCardR.setFill(Color.ANTIQUEWHITE);
			VBox vBox = new VBox();
			vBox.setPrefSize(150, 250);
			vBox.setAlignment(Pos.CENTER);
			Label hiddenLabel = new Label("\nCARTES CACHEES\n");
			hiddenLabel.setStyle( "-fx-text-fill: #000000	;");
			Label questionMark = new Label("?\n");
			questionMark.setStyle( "-fx-font-size: 80; -fx-text-fill: #000000	;");
			
			int nbHiddenCard = 0;
			for (Card c : player.getCardInventory()) {
				if (!c.isFaceUp()) {
					nbHiddenCard++;
				}
			}
			Label nbCards = new Label(Integer.toString(nbHiddenCard));
			nbCards.setStyle( "-fx-font-size: 50; -fx-text-fill: #000000	;");
			
			vBox.getChildren().addAll(hiddenLabel, questionMark, nbCards);
			vBox.setAlignment(Pos.TOP_CENTER);
			Group hiddenGroup = new Group();
			hiddenGroup.getChildren().addAll(hiddenCardR, vBox);
			gridPane.add(hiddenGroup, 10, 0);
			
		}
		
		Scene scene = new Scene(gridPane);
		scene.getStylesheets().add("resources/style.css");
		window.setScene(scene);
		window.showAndWait();
	}
	
	private void refresh() {
		for (CardView cv : cardViewList) {
			cv.refresh();
		}
		
	}
	
	private int buttonAction(CardType ct) {
		for (Card c : player.getCardInventory()) {
			if ((c.getCardType() == ct) && (c.isFaceUp() == false)) {
				c.faceUpCard();
				refresh();
				return 1;
			}
		}
		return 0;
	}
}
