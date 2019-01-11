package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

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
			player.increaseKnightPoint();
			break;
		case Monopole:
			//ActivateMonopoleEffect();
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

	public void ActivateDiscoveryEffect(){

	}

	public void ActivateKnightEffect(Tile tile){/*TODO*/  // Il faudra juste après l'appel de la fonction remettre l'ancien tuile voleur en false ( en faisant une recherche parmis toutes les tuiles)
		/*tile.setThief(true);
		int a=0;
		ArrayList<Player> PlayerListTemp = new ArrayList<Player>();
		for (Player play : game.getPlayerList() )
		{
			if(player!=play)
			{
				for (Node n : tile.getNodeList())
				{
					if (n.getStatus()==play.chooseNodeStatus())
					{


						PlayerListTemp.add(play);
						System.out.println(play.getName() + "entre le nombre" + a);
						a=a+1;
					}
				}
			}
		}
		System.out.println("choisis un jouer à voler");
		Scanner sc = new Scanner(System.in);
		int playerid =sc.nextInt();
		int rand = (int)(Math.random() * 4);
       switch(rand)
       {case 0 : PlayerListTemp.get(a).getResourceInventory().setFood(PlayerListTemp.get(a).getResourceInventory().getFood()-1);
       break;
       case 1 : PlayerListTemp.get(a).getResourceInventory().setGold(PlayerListTemp.get(a).getResourceInventory().getGold()-1);
       break;
       case 2 : PlayerListTemp.get(a).getResourceInventory().setEnergy(PlayerListTemp.get(a).getResourceInventory().getEnergy()-1);
       break;
       case 3 : PlayerListTemp.get(a).getResourceInventory().setEnergy(PlayerListTemp.get(a).getResourceInventory().getEnergy()-1);
       }
        if(rand==0)
        {
        	PlayerListTemp.get(a).getResourceInventory().setEnergy(PlayerListTemp.get(a).getResourceInventory().getEnergy()-1);
        }
        if(rand==1)
        {
        	PlayerListTemp.get(a).getResourceInventory().setEnergy(PlayerListTemp.get(a).getResourceInventory().getEnergy()-1);
        }
        if(rand==2)
        {
        	PlayerListTemp.get(a).getResourceInventory().setEnergy(PlayerListTemp.get(a).getResourceInventory().getEnergy()-1);
        }
        if(rand==3)
        {
        	PlayerListTemp.get(a).getResourceInventory().setConstruction(PlayerListTemp.get(a).getResourceInventory().getConstruction()-1);
        }*/
		player.addKnightPoint();






	}

	public void ActivateMonopoleEffect(){/*TODO*/
		/*int nb=0;
		
		switch (R)
		{case 'E' :


			for (Player play : game.getPlayerList())
			{
				if (play.getId()!=player.getId())
				{
					nb=nb+play.getResourceInventory().getEnergy();
					play.getResourceInventory().setEnergy(0);

				}

			}

			player.getResourceInventory().setEnergy(nb + player.getResourceInventory().getEnergy());
		break;
		case 'F' :


			for (Player play : game.getPlayerList())
			{
				if (play.getId()!=player.getId())
				{
					nb=nb+play.getResourceInventory().getFood();
					play.getResourceInventory().setFood(0);

				}

			}

			player.getResourceInventory().setFood(nb + player.getResourceInventory().getFood());
		break;
		case 'C' :


			for (Player play : game.getPlayerList())
			{
				if (play.getId()!=player.getId())
				{
					nb=nb+play.getResourceInventory().getConstruction();
					play.getResourceInventory().setConstruction(0);

				}

			}

			player.getResourceInventory().setConstruction(nb + player.getResourceInventory().getConstruction());
		break;
		case 'G' :


			for (Player play : game.getPlayerList())
			{
				if (play.getId()!=player.getId())
				{
					nb=nb+play.getResourceInventory().getGold();
					play.getResourceInventory().setGold(0);

				}

			}

			player.getResourceInventory().setGold(nb + player.getResourceInventory().getGold());
		break;

		}*/
	}

	public void ActivateRoadConstructionEffect(){/*TODO*/

	}

	public void ActivateVictoryPointEffect(){
		this.player.addVictoryPoint();
	}

	public CardType getCardType(){
		return cardType;
	}

	public void setPlayer(Player player){
		this.player=player;
	}

	public Boolean isFaceUp() {
		return faceUp;
	}
}
