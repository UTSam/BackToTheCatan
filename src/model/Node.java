package model;

public class Node {
	private int x;
	private int y;
	private StatusNodeType status;

	public Node(int x, int y,StatusNodeType status){
		this.x = x;
		this.y = y;
		this.status = status;
	}

	public Node(int x, int y){
		this.x = x;
		this.y = y;
		this.status = StatusNodeType.EMPTY;
	}

	public StatusNodeType getStatus(){
		return status;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

}