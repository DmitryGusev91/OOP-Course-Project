package Championship;


import java.util.ArrayList;

public class PlayerList {
	private ArrayList<Player> list;

	public PlayerList() {
		list = new ArrayList<Player>();
	}

	public void addPlayer(Player p) {// adds b Player
		list.add(p);
	}

	public void addPlayer(String s) throws NameAndAmountException {// adds by Name
		boolean ok = true;
		for (int i = 0; i < list.size(); i++) {//goes through all the names and checks if this name already exists 
			if ((list.get(i) != null && (list.get(i).getName().equals(s))))
				ok = false;
		}
		if (ok == true && list.size() < 8 && !s.equals("")) {//if the size is less then 8 then add a player
			Player p = new Player(s);
			list.add(p);
		} else if (ok == false) {//else if name exists throw exception
			throw new NameAndAmountException("This name is already taken,try another name.");
		} else if (list.size() == 8)//or if full throw exception
			throw new NameAndAmountException("Player List is full.");
	}

	public void removePlayer(String s) {// removes player by Name
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(s))
				list.remove(i);
		}

	}

	public void removePlayer(Player p) {// removes player by Player
		list.remove(p);
	}

	public int size() {
		return list.size();
	}

	public Player get(int num) {
		return list.get(num);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).toString());
		}
		return sb.toString();
	}
}
