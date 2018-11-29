package model;

public class Road {
	private StatusRoadType status;
	private Node node1;
	private Node node2;

	public Road(){
		status=StatusRoadType.EMPTY;
		node1=null;
		node2=null;
	}

	public Road(Node node1, Node node2){
		status=StatusRoadType.EMPTY;
		this.node1=node1;
		this.node2=node2;
	}


	public void setNode(Node node){ /* A TESTER Link the road to a first node if fist node empty, link to a second node if the first is already linked*/
		if (this.node1==null){
			this.node1=node;
		}
		else {
			this.node2=node;
		}
	}

	public Node getNode1(){
		return node1;
	}

	public Node getNode2(){
		return node2;
	}


}