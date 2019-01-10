package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Game;

public class ActionBar {
	private boolean isRB;
	private boolean isDB;
	private boolean isCB;
	private GameView gameView;
	private VBox actionVBox;
	private Button buildRoadButton;
	private Button buildDeloreanButton;
	private Button buildConverterButton;
	private Button nextTurnButton;
	
	
	public ActionBar(GameView gv) {
		isRB=false;
		isDB=false;	
		isCB=false;
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
		
		buildRoadButton.setStyle( "-fx-font-size: 20;");
		buildDeloreanButton.setStyle( "-fx-font-size: 20;");
		buildConverterButton.setStyle( "-fx-font-size: 20;");
		nextTurnButton.setStyle( "-fx-font-size: 20;");
		
		buildRoadButton.setOnAction( e -> { isRB=true; isDB=false;isCB=false;});
		buildDeloreanButton.setOnAction( e -> { isRB=false; isDB=true;isCB=false;});
		buildConverterButton.setOnAction( e -> { isRB=false; isDB=false;isCB=true;});
		nextTurnButton.setOnAction( e -> {
			gameView.getGame().nextPlayer();
			gameView.getGame().attributeResources();
			for (PlayerView pv : gameView.getPlayerViewList()) {
				pv.refresh();
			}
			DiceBox.display(gameView);
		} );
		
		actionVBox.getChildren().addAll(buildRoadButton, buildDeloreanButton, buildConverterButton, nextTurnButton);
	}
	
	public boolean isRB() {
		return isRB;
	}

	public void setRB(boolean isRB) {
		this.isRB = isRB;
	}

	public boolean isDB() {
		return isDB;
	}

	public void setDB(boolean isDB) {
		this.isDB = isDB;
	}

	public boolean isCB() {
		return isCB;
	}

	public void setCB(boolean isCB) {
		this.isCB = isCB;
	}

	public VBox getActionVBox() {
		return actionVBox;
	}
}
