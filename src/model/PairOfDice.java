package model;

public class PairOfDice {
	private int dice1;
	private int dice2;

	public PairOfDice(){

	}

	public int roll(){
		dice1=(int) ((Math.random() * 6) + 1);
		dice2=(int) ((Math.random() * 6) + 1);
		return dice1+dice2;
	}

	public int getDice1(){
		return dice1;
	}

	public int getDice2(){
		return dice2;
	}

	public int getSum(){
		return dice1+dice2;
	}
}
