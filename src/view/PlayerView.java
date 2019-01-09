package view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
		
		smallBorder = new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(6)));
		largeBorder = new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(12)));
		gridPane = new GridPane();
		gridPane.setPrefSize(300, 200);
		gridPane.setVgap(5);
		gridPane.setBorder(smallBorder);
		
		
		nbFood = new Label();
		nbGold = new Label();
		nbEnergy = new Label();
		nbConstruction = new Label();
		nbFood.setStyle( "-fx-font-size: 20; -fx-text-fill: #000000	;");
		nbGold.setStyle( "-fx-font-size: 20; -fx-text-fill: #000000	;");
		nbEnergy.setStyle( "-fx-font-size: 20; -fx-text-fill: #000000	;");
		nbConstruction.setStyle( "-fx-font-size: 20; -fx-text-fill: #000000	;");
		
		Label playerName = new Label(player.getName());
		playerName.setStyle( "-fx-font-size: 40; -fx-text-fill: #000000	;");
		
		tradeButton = new Button("Echanger");
		tradeButton.setPrefSize(80, 30);
		tradeButton.setStyle( "-fx-font-size: 13;");
		tradeButton.setOnAction(e -> TradeBox.display(gameView.getGame().getCurrentPlayer(), player, gameView));
		
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setHgap(30);
		
		gridPane.add(playerName, 0, 0, 4, 2);
		
		ImageView tmp = new ImageView(gameView.iManager.getFoodIcon());
		tmp.setFitHeight(40);
		tmp.setFitWidth(40);		
		gridPane.add(tmp, 1, 4);
		
		tmp = new ImageView(gameView.iManager.getGoldIcon());
		tmp.setFitHeight(40);
		tmp.setFitWidth(40);	
		gridPane.add(tmp, 2, 4);
		
		tmp = new ImageView(gameView.iManager.getEnergyIcon());
		tmp.setFitHeight(40);
		tmp.setFitWidth(40);	
		gridPane.add(tmp, 3, 4);
		
		tmp = new ImageView(gameView.iManager.getConstructionIcon());
		tmp.setFitHeight(40);
		tmp.setFitWidth(40);	
		gridPane.add(tmp, 4, 4);

		GridPane.setHalignment(nbFood, HPos.CENTER);
		GridPane.setHalignment(nbGold, HPos.CENTER);
		GridPane.setHalignment(nbEnergy, HPos.CENTER);
		GridPane.setHalignment(nbConstruction, HPos.CENTER);
		gridPane.add(nbFood, 1, 5);
		gridPane.add(nbGold, 2, 5);
		gridPane.add(nbEnergy, 3, 5);
		gridPane.add(nbConstruction, 4, 5);
		gridPane.add(tradeButton, 0, 10, 4, 1);
		
		gridPane.setStyle("-fx-background-color: #FFFAF0;");
		
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
