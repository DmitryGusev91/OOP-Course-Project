package Championship;

import java.util.ArrayList;

public class Player {
	private String name;
	private ArrayList<Integer> score;

	public Player(String name) {
		setName(name);
		score = new ArrayList<Integer>();
	}

	public Player() {
		this("Gogo");
	}

	public void setScore(int num) {
		score.add(num);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Integer> getScore() {
		return score;
	}

	public boolean equals(Player other) {
		if (this.name.equals(other.name) && this.score.equals(other.score))
			return true;
		else
			return false;
	}

	public int getScore(int num) {
		return score.get(num);
	}

	public void clearScore() {
		score.clear();
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("The Player " + name + "\n");
		if (score.size() != 0)
			sb.append("Score : ");
		for (int i = 0; i < score.size(); i++) {
			sb.append(score.get(i) + "   ");
		}
		return sb.toString();
	}

}
