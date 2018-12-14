package view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import model.Game;
import model.Player;

public class PlayerView {
	private Player player;
	private GameView gameView;
	private GridPane gridPane;
	private Color color;
	
	private Label nbFood;
	private Label nbGold;
	private Label nbEnergy;
	private Label nbConstruction;
	private Border smallBorder;
	private Border largeBorder;
	
	private Button tradeButton;
	
	public PlayerView(Player p, Color c, GameView gv) {
		gameView = gv;
		player = p;
		color = c;
		
		smallBorder = new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(8)));
		largeBorder = new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(20)));
		gridPane = new GridPane();
		gridPane.setPrefSize(300, 200);
		gridPane.setVgap(5);
		gridPane.setBorder(smallBorder);
		
		Circle foodCircle = new Circle(15);
		Circle goldCircle = new Circle(15);
		Circle energyCircle = new Circle(15);
		Circle constructionCircle = new Circle(15);
		
		
		foodCircle.setFill(Color.GREENYELLOW);
		goldCircle.setFill(Color.GOLD);
		energyCircle.setFill(Color.CORNFLOWERBLUE);
		constructionCircle.setFill(Color.SADDLEBROWN);
		
		nbFood = new Label();
		nbGold = new Label();
		nbEnergy = new Label();
		nbConstruction = new Label();
		nbFood.setFont(Font.font("Cambria", 20));
		nbGold.setFont(Font.font("Cambria", 20));
		nbEnergy.setFont(Font.font("Cambria", 20));
		nbConstruction.setFont(Font.font("Cambria", 20));
		
		Label playerName = new Label(player.getName());
		playerName.setFont(Font.font("Cambria", 40));
		
		tradeButton = new Button("Echanger");
		tradeButton.setPrefSize(80, 30);
		tradeButton.setOnAction(e -> TradeBox.display(gameView.getGame().getCurrentPlayer(), player, gameView.getPlayerViewList()));
		
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setHgap(30);
		
		gridPane.add(playerName, 0, 0, 4, 2);
		
		
		gridPane.add(foodCircle, 1, 4);
		gridPane.add(goldCircle, 2, 4);
		gridPane.add(energyCircle, 3, 4);
		gridPane.add(constructionCircle, 4, 4);

		GridPane.setHalignment(nbFood, HPos.CENTER);
		GridPane.setHalignment(nbGold, HPos.CENTER);
		GridPane.setHalignment(nbEnergy, HPos.CENTER);
		GridPane.setHalignment(nbConstruction, HPos.CENTER);
		gridPane.add(nbFood, 1, 5);
		gridPane.add(nbGold, 2, 5);
		gridPane.add(nbEnergy, 3, 5);
		gridPane.add(nbConstruction, 4, 5);
		gridPane.add(tradeButton, 0, 10, 4, 1);
		
		refresh();
	}
	
	public void refresh() {
		nbFood.setText(Integer.toString(player.getResourceInventory().getFood()));
		nbGold.setText(Integer.toString(player.getResourceInventory().getGold()));
		nbEnergy.setText(Integer.toString(player.getResourceInventory().getEnergy()));
		nbConstruction.setText(Integer.toString(player.getResourceInventory().getConstruction()));
		gridPane.getChildren().remove(tradeButton);
		if (gameView.getGame().getCurrentPlayer().getId() == player.getId()) {
			gridPane.setBorder(largeBorder);
			gridPane.setPrefSize(350, 250);
			gridPane.setMaxSize(350, 250);
		} else {
			gridPane.setBorder(smallBorder);
			gridPane.add(tradeButton, 0, 10, 4, 1);
			gridPane.setMaxSize(300, 200);
		}
		
	}
	
	public GridPane getGridPane() {
		return gridPane;
	}
}
