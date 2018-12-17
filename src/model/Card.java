package model;

public class Card {
	private CardType cardType;
	private boolean faceUp;
	private Player player;
	private Game game;

	public Card(CardType cardType, Game game){
		this.cardType = cardType;
		/* The card is faced down as long as the player want it to be*/
		faceUp=false;
		this.player=null;
		this.game=game;
	}

	public Card(CardType cardType, Player player, Game game){
		this.cardType = cardType;
		/* The card is faced down as long as the player want it to be*/
		faceUp=false;
		this.player=player;
		this.game=game;
	}

	public void faceUpCard(){
		faceUp=true; /* Maybe a faceUp variable isn't necessary */
		activate();
	}

	public boolean isKnight(){
		if (cardType==CardType.Knight)
			return true;
		else
			return false;
	}

	public void activate(){
		switch (cardType){
		case Discovery:
			ActivateDiscoveryEffect();
			break;
		case Knight:
			ActivateKnightEffect();
			break;
		case Monopole:
			ActivateMonopoleEffect();
			break;
		case RoadConstruction:
			ActivateRoadConstructionEffect();
			break;
		case VictoryPoint:
			ActivateVictoryPointEffect();
			break;
		default:
			break;

		}
	}

	public void ActivateDiscoveryEffect(){/*TODO*/

	}

	public void ActivateKnightEffect(){/*TODO*/

	}

	public void ActivateMonopoleEffect(){/*TODO*/
		/* CLICK SYSTEM */
	}

	public void ActivateRoadConstructionEffect(){/*TODO*/

	}

	public void ActivateVictoryPointEffect(){
		player.addVictoryPoint();
	}

	public CardType getCardType(){
		return cardType;
	}

	public void setPlayer(Player player){
		this.player=player;
	}
}
