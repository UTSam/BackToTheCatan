package view;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Card;
import model.CardType;
import model.Player;

public class CardView {
	private Player player;
	private CardType cardType;
	private Group group;
	private Label ownedLabel;
	private Label hiddenLabel;
	private Boolean isCurrentPlayer;
	
	private int nbOwned = 0;
	int nbHidden = 0;
	
	public CardView(Player p, Boolean isCurrentP, CardType ct) {
		
		player = p;
		cardType = ct;		
		group = new Group();
		isCurrentPlayer = isCurrentP;
		
		Rectangle rectangle = new Rectangle(150, 250);
		rectangle.setFill(Color.WHITE);
		
		VBox vBox = new VBox();
		vBox.setPrefSize(150, 250);
		vBox.setAlignment(Pos.CENTER);
		
		Label name;
		Label description;

		
		
		switch (cardType) {
		case Discovery:
			name = new Label("\nDECOUVERTE");
			description = new Label("descriptioooooonnnnn");
			rectangle.setFill(Color.DARKBLUE);
			break;
		case Knight:
			name = new Label("\nCHEVALIER");
			description = new Label("descriptioooooonnnnn");
			rectangle.setFill(Color.FIREBRICK);
			break;
		case Monopole:
			name = new Label("\nMONOPOLE");
			description = new Label("descriptioooooonnnnn");
			rectangle.setFill(Color.DARKOLIVEGREEN);
			break;
		case RoadConstruction:
			name = new Label("\nROUTE GRATUITE");
			description = new Label("descriptioooooonnnnn");
			rectangle.setFill(Color.BLACK);
			break;
		case VictoryPoint:
			name = new Label("\nPOINT DE VICTOIRE");
			description = new Label("descriptioooooonnnnn");
			rectangle.setFill(Color.DARKORANGE);
			break;
		default:
			name = new Label();
			description = new Label();
			break;
		}
		
		ownedLabel = new Label();
		hiddenLabel = new Label();
		vBox.getChildren().addAll(name, description, new Label("\n\n\n\n\n\n"), ownedLabel);
		if (isCurrentPlayer) {
			vBox.getChildren().add(hiddenLabel);
		}
		vBox.setAlignment(Pos.TOP_CENTER);
		group.getChildren().addAll(rectangle, vBox);	
		
		refresh();
	}
	
	public void refresh() {
		
		nbOwned = 0;
		
		for (Card c : player.getCardInventory()) {
			if(c.getCardType() == cardType && c.isFaceUp()) {
				nbOwned++;
			}
		}
		ownedLabel.setText("Nombre révélées : " + nbOwned);


		nbHidden = 0;
		for (Card c : player.getCardInventory()) {
			if(c.getCardType() == cardType && !(c.isFaceUp())) {
				nbHidden++;
			}
		}
		hiddenLabel.setText("Nombre cachées : " + nbHidden);
}
	
	public Group getGroup() {
		return group;
	}
	
	public int getNbHidden() {
		return nbHidden;
	}
}
