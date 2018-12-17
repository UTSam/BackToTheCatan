package model;

public enum CardType {
	VictoryPoint,
	Knight,
	Discovery, /* Take two cards from the same resource */
	Monopole, /* Player choose a resource and take steal all the resources of the other players */
	RoadConstruction; /* Construction of 2 roads */
}
