package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int score;
	private int id;
	private String name;
	private ResourceInventory resourceInventory;
	private ArrayList<Card> cardInventory = new ArrayList<Card>();
	private boolean hasLongestRoad;
	private int nbCard;
	private int knightPoint;
	private boolean firstKnight;
	public boolean isFirstKnight() {
		return firstKnight;
	}

	public void setFirstKnight(boolean firstKnight) {
		this.firstKnight = firstKnight;
	}

	public void setKnightPoint(int knightPoint) {
		this.knightPoint = knightPoint;
	}

	private Boolean firstRoad;
	private Boolean firstDelorean;
	
	private Boolean secondRoad;
	private Boolean secondDelorean;
	
	private ArrayList<Road> RoadList;
	private ArrayList<ArrayList<Road>> SuperRoadList;
	
	private int nbVisited;


	public Player(int id, String name) {
		this.id = id;
		this.name = name;
		resourceInventory = new ResourceInventory();
		score=0;
		knightPoint=0;
		firstRoad = false;
		firstDelorean = false;
		secondRoad = false;
		secondDelorean = false;		
	}

	public ResourceInventory getResourceInventory(){
		return resourceInventory;
	}

	public void addVictoryPoint(){
		score++;
	}

	public void addCard(Card card){
		cardInventory.add(card);
		card.setPlayer(this);
	}

	public void addKnightPoint(){
		knightPoint++;
	}

	public int getId() {
		return id;
	}
	public void setID(int i) {
		id = i;
	}
	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public ArrayList<Card> getCardInventory() {
		return cardInventory;
	}

	public StatusNodeType chooseNodeStatus() {
		StatusNodeType s =StatusNodeType.EMPTY;
		switch (this.id) {
		case 1 : s=StatusNodeType.PLAYER1;
		break;
		case 2 : s=StatusNodeType.PLAYER2;
		break;
		case 3 : s=StatusNodeType.PLAYER3;
		break;
		case 4 : s=StatusNodeType.PLAYER4;
		break;
		}
		return s;
	}

	public StatusRoadType chooseRoadStatus() {
		StatusRoadType s =StatusRoadType.EMPTY;
		switch (this.id) {
		case 1 : s=StatusRoadType.PLAYER1;
		break;
		case 2 : s=StatusRoadType.PLAYER2;
		break;
		case 3 : s=StatusRoadType.PLAYER3;
		break;
		case 4 : s=StatusRoadType.PLAYER4;
		break;
		}
		return s;
	}
	public boolean CheckResource(int f, int e, int c, int g) {

        if(resourceInventory.getFood() < f || resourceInventory.getEnergy() < e ||  resourceInventory.getConstruction() < c ||resourceInventory.getGold() < g  ) {
            return false;
        }
        else {
            return true;
        }

    }

	public void setScore(int s) {
		score = s;
	}

	public void setName(String n){
		if (n.trim().length() > 0 && n != null && !n.isEmpty()) {
			name = n;
		}
	}

	public ArrayList<Road> getRoadList() {
		return RoadList;
	}

	public void setRoadList(ArrayList<Road> roadList) {
		RoadList = roadList;
	}

	public boolean ifedgeRoad(Road r) {
		ArrayList<Road> tmp = new ArrayList<Road>(this.RoadList);
		tmp.remove(r);
		int n = 0;
		for (Road rd : tmp) {
			if (ifnodeinvolved(rd, r.getNode1()) || ifnodeinvolved(rd, r.getNode2())) {
				n = n + 1;
			}
		}
		if (n == 1) {
			return true;
		} else {
			return false;
		}

	}

	public boolean ifnodeinvolved(Road r, Node n) {
		if (n.equals(r.getNode1()) || n.equals(r.getNode2())) {
			return true;
		} else {
			return false;
		}

	}

	public boolean iflink(Road r1, Road r2) {
		if (ifnodeinvolved(r1, r2.getNode1()) || ifnodeinvolved(r1, r2.getNode2())) {
			return true;

		} else {
			return false;

		}

	}

	public boolean isintersection(Road r) {
		ArrayList<Road> tmp = new ArrayList<Road>(this.RoadList);
		tmp.remove(r);
		int n = 0;
		for (Road rd : tmp) {
			if (iflink(rd, r)) {
				n = n + 1;
			}
		}
		if (n == 2) {
			return true;
		} else {
			return false;

		}

	}

	/*
	 * public int longuestroad(ArrayList<Road> roadlist) { ArrayList<Road> tmp =
	 * new ArrayList<Road>(this.RoadList); for( Road r : tmp) {
	 * if(ifedgeRoad(r)) { tmp.remove(r); return 1 + longuestroad(tmp); } else
	 * if (isintersection(r)) { r.return longuestroad(), ); } }
	 *
	 * }
	 */
	public ArrayList<Road> roadofintersection(ArrayList<Road> tmp, Road r) {
		ArrayList<Road> list2 = new ArrayList<Road>();
		for (Road rd : tmp) {
			if (iflink(rd, r)) {
				list2.add(rd);
			}
		}
		return list2;

	}

	public void manageRoadlist(Road r) {

		if (SuperRoadList.isEmpty()) {
			ArrayList<Road> tmp = new ArrayList<Road>();
			tmp.add(r);
			SuperRoadList.add(tmp);
		} else {
			int n = 0;
			for (ArrayList<Road> rlist : this.SuperRoadList) {
				for (Road rd : rlist) {
					if (iflink(rd, r)) {
						n += 1;
					}
				}
				if (n == 1 || n == 2) {
					rlist.add(r);
				}

			}
			if (n == 0) {
				ArrayList<Road> tmp1 = new ArrayList<Road>();
				tmp1.add(r);
				SuperRoadList.add(tmp1);

			}
		}
	}

	public int lenghtofroad(ArrayList<Road> rlist, Road r) {
        if(rlist.isEmpty()) {
            return 0;
        }
        else {
            for(Road rd : rlist) {
                if(iflink(rd,r)) {
                    if(isintersection(rd)) {
                    	ArrayList<Road> tmp = roadofintersection(rlist, rd);
                    	rlist.remove(r);
                    	return 1 + Math.max(lenghtofroad(rlist, tmp.get(0)),lenghtofroad(rlist,tmp.get(1)));
                    }
                    else {
                    rlist.remove(r);
                    return 1 + lenghtofroad(rlist, rd);
                    }
                }

            }
        }
		return 0;
	}

	public int lenghtofIntersectionRoad(ArrayList<Road> list) {
		List<Integer> tmp = new ArrayList<>();
		for(Road r : list) {
			if(isintersection(r)) {
				tmp.add(lenghtofroad(list, r));
			}
		}

		return tmp.stream().max(Integer::compare).get().intValue();
	}

	public int longuestroad() {
		ArrayList<Integer> lenght = new ArrayList<Integer>();
		for(ArrayList<Road> list : SuperRoadList) {
			if(this.isIntersectionRoad(list)) {
				lenght.add(lenghtofIntersectionRoad(list));
			}
			else {
				lenght.add(list.size());
			}
		}
		return lenght.stream().max(Integer::compare).get().intValue();
	}

	public boolean isIntersectionRoad(ArrayList<Road> list) {
		for(Road r : list) {
			if(isintersection(r)) {
				return true;
			}
		}
		return false;
	}

	public int getKnightPoint(){
		return knightPoint;
	}

	public void increaseKnightPoint(){
		knightPoint++;
	}
	
	public Boolean getFirstRoad() {
		return firstRoad;
	}
	
	public void setFirstRoad(Boolean bool) {
		firstRoad = bool;
	}
	
	public Boolean getFirstDelorean() {
		return firstDelorean;
	}
	
	public void setFirstDelorean(Boolean bool) {
		firstDelorean = bool;
	}
	
	public Boolean getSecondRoad() {
		return secondRoad;
	}
	
	public void setSecondRoad(Boolean bool) {
		secondRoad = bool;
	}
	
	public Boolean getSecondDelorean() {
		return secondDelorean;
	}
	
	public void setSecondDelorean(Boolean bool) {
		secondDelorean = bool;
	}
}
