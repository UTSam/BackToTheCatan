package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Game;

public class ActionBar {
	
	private GameView gameView;
	private VBox actionVBox;
	private Button buildRoadButton;
	private Button buildDeloreanButton;
	private Button buildConverterButton;
	private Button nextTurnButton;
	
	
	public ActionBar(GameView gv) {
		gameView = gv;
		actionVBox = new VBox();
		actionVBox.setSpacing(50);
		actionVBox.setAlignment(Pos.CENTER);
		
		buildRoadButton = new Button("Construire Route");
		buildDeloreanButton = new Button("Construire Delorean");
		buildConverterButton = new Button("Construire Convertisseur");
		nextTurnButton = new Button("Passer le tour");
		
		buildRoadButton.setPrefSize(250, 150);
		buildDeloreanButton.setPrefSize(250, 150);
		buildConverterButton.setPrefSize(250, 150);
		nextTurnButton.setPrefSize(250, 150);
		
		buildRoadButton.setOnAction( e -> System.out.println("road"));
		buildDeloreanButton.setOnAction( e -> System.out.println("delorean"));
		buildConverterButton.setOnAction( e -> System.out.println("converter"));
		nextTurnButton.setOnAction( e -> {
			gameView.getGame().nextPlayer();
			for (PlayerView pv : gameView.getPlayerViewList()) {
				pv.refresh();
			}
		} );
		
		actionVBox.getChildren().addAll(buildRoadButton, buildDeloreanButton, buildConverterButton, nextTurnButton);
	}
	
	public VBox getActionVBox() {
		return actionVBox;
	}
}