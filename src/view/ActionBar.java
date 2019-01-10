package view;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
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
	private Button bankButton;
	
	
	public ActionBar(GameView gv) {
		isRB=false;
		isDB=false;	
		isCB=false;
		gameView = gv;
		actionVBox = new VBox();
		actionVBox.setSpacing(30);
		actionVBox.setAlignment(Pos.CENTER);
		
		buildRoadButton = new Button("Construire\nRoute", displayCost(1,0,1,1));
		buildDeloreanButton = new Button("Construire \nDelorean\n", displayCost(1,0,1,2));
		buildConverterButton = new Button("Construire\nConvertisseur", displayCost(0,0,3,1));
		nextTurnButton = new Button("Passer le tour");
		bankButton = new Button("Acceder a la banque");
		
		
		buildRoadButton.setPrefSize(300, 150);
		buildDeloreanButton.setPrefSize(300, 150);
		buildConverterButton.setPrefSize(300, 150);
		nextTurnButton.setPrefSize(300, 150);
		bankButton.setPrefSize(300, 150);
		
		
		buildRoadButton.setStyle( "-fx-font-size: 20;");
		buildDeloreanButton.setStyle( "-fx-font-size: 20;");
		buildConverterButton.setStyle( "-fx-font-size: 20;");
		nextTurnButton.setStyle( "-fx-font-size: 20;");
		bankButton.setStyle( "-fx-font-size: 20;");
		
		buildRoadButton.setOnAction( e -> { isRB=true; isDB=false;isCB=false;});
		buildDeloreanButton.setOnAction( e -> { isRB=false; isDB=true;isCB=false;});
		buildConverterButton.setOnAction( e -> { isRB=false; isDB=false;isCB=true;});
		nextTurnButton.setOnAction( e -> {
			gameView.getGame().nextPlayer();
			gameView.getGame().attributeResources();
			for (PlayerView pv : gameView.getPlayerViewList()) {
				pv.refresh();
			}
			DiceBox.display(gameView.getGame());
		} );
		bankButton.setOnAction(e->BankBox.display(gameView));
		
		actionVBox.getChildren().addAll(buildRoadButton, buildDeloreanButton, buildConverterButton,bankButton, nextTurnButton);
	}
	
	
	public void disableButtons(Boolean bool) {
		buildRoadButton.setDisable(bool);
		buildDeloreanButton.setDisable(bool);
		buildConverterButton.setDisable(bool);
		nextTurnButton.setDisable(bool);
		bankButton.setDisable(bool);
	}
	
	private GridPane displayCost(int nfood, int ngold, int nenergy, int nconstruction) {
		
		GridPane icons = new GridPane();
		icons.setAlignment(Pos.BOTTOM_CENTER);
		icons.setHgap(2);
		icons.setVgap(2);
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

		Label l1 = new Label("" + nfood);
		Label l2 = new Label("" + ngold);
		Label l3 = new Label("" + nenergy);
		Label l4 = new Label("" + nconstruction);
		
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
		
		return icons;
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
