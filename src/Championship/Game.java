package Championship;

//Abstract class "Game" 
public abstract class Game {
	protected PlayerList players;
	protected int amountOfRounds;

	public Game(PlayerList list) {
		players = new PlayerList();
		players = list;
		amountOfRounds = 0;

	}

	public void setAmountOfRounds(int num) {
		amountOfRounds = num;

	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < players.size(); i++) {
			sb.append(players.get(i).toString() + "\n");
		}
		return sb.toString();
	}

	public void play(int player1, int player2, int[] score) {//gets two players and an score array (the array is sorted from the beginning that the first half is first players score and second half is second players)
		players.get(player1).clearScore();//clears the score
		players.get(player2).clearScore();//clears the score
		for (int i = 0; i < score.length / 2; i++) {// first scores of array to first player

			players.get(player1).setScore(score[i]);

		}
		for (int i = score.length / 2; i < score.length; i++) {// second scores of array to second player
			players.get(player2).setScore(score[i]);

		}
	}

	public int winner(int index1, int index2) {// gets two players(indexes) ,sums their scores and check who have the
												// highest score
		int sum1 = 0, sum2 = 0;
		for (int i = 0; i < amountOfRounds; i++) {// sums the scores

			sum1 += players.get(index1).getScore().get(i);

			sum2 += players.get(index2).getScore().get(i);

		}

		if (sum1 > sum2)// if first player won
			return index1;
		else if (sum1 < sum2)// is second player won
			return index2;
		else
			return -1;// if the score is equal
	}

	public void refresh(int index) {
		players.get(index).clearScore();
	}

	public int getIndexByName(String name) {
		int index = 0;
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getName().equals(name))
				index = i;
		}
		return index;
	}

	public int getRounds() {
		return amountOfRounds;
	}

}