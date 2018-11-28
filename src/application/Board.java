package application;

public class Board {
	
	Node[][] nodeGrid = new Node[4][5];
	int[][] pattern = new int[][]{
		  { 0, 1, 1, 1, 0},
		  { 1, 1, 1, 1, 1},
		  { 1, 1, 1, 1, 1},
		  { 0, 1, 1, 1, 0}
		  
		};
	
	public Board(){
	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			if ((i%2 == 0) && (j%2 == 0)){
				nodeGrid[i][j] = new Node(j*100,i*100-20,pattern[i][j]);
			}
			else if ((i%2 == 0) && (j%2 == 1)){
				nodeGrid[i][j] = new Node(j*100,i*100,pattern[i][j]);
			}
			else if ((i%2 == 1) && (j%2 == 0)){
				nodeGrid[i][j] = new Node(j*100,i*100+20,pattern[i][j]);
			}
			else if ((i%2 == 1) && (j%2 == 1)){
				nodeGrid[i][j] = new Node(j*100,i*100,pattern[i][j]);
			}
		}
	}
}
}
