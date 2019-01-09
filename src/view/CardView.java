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
	
	
	public CardView(Player p, CardType ct) {
		
		player = p;
		cardType = ct;		
		group = new Group();
		
		Rectangle rectangle = new Rectangle(150, 250);
		rectangle.setFill(Color.WHITE);
		
		VBox vBox = new VBox();
		vBox.setPrefSize(150, 250);
		vBox.setAlignment(Pos.CENTER);
		
		Label name;
		Label description;
		Label owned;
		Label hidden;
		
		
		switch (cardType) {
		case Discovery:
			name = new Label("Discovery");
			description = new Label("descriptioooooonnnnn");
			rectangle.setFill(Color.BLUE);
			break;
		case Knight:
			name = new Label("Knight");
			description = new Label("descriptioooooonnnnn");
			rectangle.setFill(Color.RED);
			break;
		case Monopole:
			name = new Label("Monopole");
			description = new Label("descriptioooooonnnnn");
			rectangle.setFill(Color.GREEN);
			break;
		case RoadConstruction:
			name = new Label("RoadConstruction");
			description = new Label("descriptioooooonnnnn");
			rectangle.setFill(Color.WHITE);
			break;
		case VictoryPoint:
			name = new Label("VictoryPoint");
			description = new Label("descriptioooooonnnnn");
			rectangle.setFill(Color.YELLOW);
			break;
		default:
			name = new Label();
			description = new Label();
			break;
			
			

		
		}
		
		//owned = new Label("Nombre révélées : " + )

		vBox.getChildren().addAll(name, description);
		group.getChildren().addAll(rectangle, vBox);
	}
	
	public Group getGroup() {
		return group;
	}
}
