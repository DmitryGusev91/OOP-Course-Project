package Championship;

import java.util.ArrayList;

public class Championship {
	private String name;
	private Game g;
	public PlayerList list;

	public Championship() {
		setName("Championship 2020");
		list = new PlayerList();
	}

	public void addFootball() {//creates a football game , adds a list there
		g = new Football(list);

	}

	public void addTennis() {//creates a Tennis game , adds a list there
		g = new Tennis(list);

	}

	public void addBasketball() {//creates a Basketball game , adds a list there
		g = new Basketball(list);

	}

	public void addPlayer(String name) throws NameAndAmountException {//creates a player with a String(name) , if the conditions are not met then throws exception
		list.addPlayer(name);
	}

	public void play(int player1, int player2, int[] score) {//gets two players and an score array and puts the scores to each player his
		g.play(player1, player2, score);
	}

	public int winner(int index1, int index2) {//gets two players and by counting the scores returns the winner
		return g.winner(index1, index2);
	}

	public void setName(String string) {
		name = string;
	}

	public Player get(int num) {//get a player by an index
		return list.get(num);
	}

	public Game getGame() {
		return g;
	}

	public void removePlayer(String name) {
		list.removePlayer(name);
	}

	public void refresh(int index) {//clears the score of a given player(by index)
		g.refresh(index);
	}

	public int getIndexByName(String name) {//gets a name and return the players index
		return g.getIndexByName(name);
	}

	public void setRounds(int num) {//sets the amount o rounds in a game( football have 2, after a draw it have 3 and after another draw it have 4)
		g.setAmountOfRounds(num);
	}

	public String getScore(int index) {//gets score of a given player(by index)
		return list.get(index).toString();
	}

	public int getRounds() {//
		return g.getRounds();
	}
	public PlayerList getList() {
		return list;
	}
}
