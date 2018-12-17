package model;

public class Card {
	private CardType cardType;
	private boolean faceUp;

	public Card(CardType cardType){
		this.cardType = cardType;
		/* The card is faced down as long as the player want it to be*/
		faceUp=false;
	}

	public void faceUpCard(){
		faceUp=true;
	}

	public boolean isKnight(){
		if (cardType==CardType.Knight)
			return true;
		else
			return false;
	}

	public void activate(){ /*TODO*/
		switch (cardType){
		case Discovery:
			break;
		case Knight:
			break;
		case Monopole:
			break;
		case RoadConstruction:
			break;
		case VictoryPoint:
			break;
		default:
			break;

		}
	}

	public CardType getCardType(){
		return cardType;
	}
}
