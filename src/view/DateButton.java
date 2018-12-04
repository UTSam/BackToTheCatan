package view;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import model.Map;

public class DateButton {
	
	private Button button;
	private Map map;
	private int date;
	private BorderPane mapBorderPane;
	
	public DateButton(int pdate, Map pmap,BorderPane pmapBorderPane, Board board){
		date = pdate;
		map = pmap;
		mapBorderPane = pmapBorderPane;
		
		button = new Button(Integer.toString(date));
		button.setScaleX(1);
		button.setScaleY(1);
		button.setPrefSize(200, 75);
		
		button.setOnAction((event) -> {
			board.display(map);
		});
	}
	
	public void display() {
		
	}
}
