package Championship;

public class Tennis extends Game {

	public Tennis(PlayerList list) {
		super(list);
		setAmountOfRounds(3);
	}

	public int winner(int index1, int index2) {// gets two players(indexes) ,checks who wins and give him a point , if
		// equals both of them get a point
		int sum1 = 0, sum2 = 0;
		for (int i = 0; i < amountOfRounds; i++) {// sums the scores
			if (players.get(index1).getScore().get(i) > players.get(index2).getScore().get(i)) {// if player1 score is
																								// better then player 2
				sum1++;

			} else if (players.get(index1).getScore().get(i) < players.get(index2).getScore().get(i)) { // if player2
																										// score
				// is better then
				// player1
				sum2++;

			}

		}
		if (sum1 >= 3) {// if first player won

			return index1;
		} else if (sum2 >= 3) {// is second player won

			return index2;
		} else

			return -1;// if the score is equal
	}

}
