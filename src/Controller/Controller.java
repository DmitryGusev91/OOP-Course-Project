package Controller;

import java.util.ArrayList;
import Championship.Basketball;
import Championship.Championship;
import Championship.Football;
import Championship.Game;
import Championship.NameAndAmountException;
import Championship.Tennis;
import View.ExceptionWindow;
import View.MainWindow;
import View.TheGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
	private MainWindow theView;
	private Championship theChampionship;
	private int[] score;
	private int evenCounter = 0;//counts the stage of the games (0=beginning,1=after one draw,2=after 2 draws)

	public Controller(MainWindow m, Championship c) throws NameAndAmountException {
		theView = m;
		theChampionship = c;

		EventHandler<ActionEvent> add = new EventHandler<ActionEvent>() {//the add a player function

			@Override
			public void handle(ActionEvent event) {
				String name = theView.getName();//gets a given name through theView
				try {
					theChampionship.addPlayer(name);//creates a player
					ArrayList<TextField> txt1 = theView.getFields();//gets the first textFields array (the beginning, all the 8)
					for (int i = 0; i < txt1.size(); i++) {
						if (txt1.get(i).getText().equals("")) {//if the textfield is empty then fill it with the given name else search further
							addPlayerToTextField(name, txt1, i);//adds the player(name) to the given empty index(i) in the array field(txt1)
							break;
						}
					}
				} catch (NameAndAmountException e) {//throws exception if name exists or array is full
					ExceptionWindow ew = new ExceptionWindow(new Stage(), e.getMessage());
				}

				theView.resetTextField();//after each use the textfield gets "empty " again and you don't need to delete the previous String
			}
		};
		theView.changeListenerToAdd(add);

		EventHandler<ActionEvent> start = new EventHandler<ActionEvent>() {//starts the game

			@Override
			public void handle(ActionEvent event) {
				int gameNum = theView.getGame();//gets the num of the game, if its 1 the creates basketball , if 2 the creates football or if 3 then creates tennis
				if (gameNum == 1) {
					theChampionship.addBasketball();
				} else {
					if (gameNum == 2) {
						theChampionship.addFootball();
					} else
						theChampionship.addTennis();
				}

				try {
					theView.update(theChampionship.getList());//updates the list to phase 2 (the game process)
				} catch (NameAndAmountException e) {//if don't have 8 players throws exception
					ExceptionWindow ew = new ExceptionWindow(new Stage(), e.getMessage());
				}

			}
		};

		theView.ChangeListenerToStart(start);

		EventHandler<ActionEvent> play1 = new EventHandler<ActionEvent>() {//plays the game . works for all the :play" buttons

			@Override
			public void handle(ActionEvent event) {
				int[] buttonPressed = theView.wichButton(theChampionship);//gets the array nums for each "play" button (first player index,second player index,game stage,index of where to go next)
				if (theChampionship.getGame() instanceof Basketball) {//if the game is basketball then creates it and plays it
					TheGame g = new TheGame(new Stage(), "Basketball");
					play(g, buttonPressed, theChampionship.getGame());
				} else {
					if (theChampionship.getGame() instanceof Football) {//if the game is football then creates it and plays it
						TheGame g = new TheGame(new Stage(), "Football");
						g.updateToFootball();//updates the game window to football, less textfields for scores
						play(g, buttonPressed, theChampionship.getGame());

					} else {//if the game is basketball then creates it and plays it
						TheGame g = new TheGame(new Stage(), "Tennis");
						g.updateToTennis();//updates the game window to tennis, less textfields for scores
						play(g, buttonPressed, theChampionship.getGame());
					}
				}

			}
		};
		theView.changeListenerToFirstWinner(play1);//activated after the "play" button is pushed

	}

	private void addPlayerToTextField(String name, ArrayList<TextField> array, int index) {//adds a player(name) to the given index(index) in the textfield array(array)

		theView.setName(name, array, index);

	}

	public void play(TheGame g, int[] buttonPressed, Game game) {//gets the window "theGame" , the button array(with player1 index,player 2 index,stage,index where to go),and the game type
		g.setNames(theChampionship.get(buttonPressed[0]).getName(), theChampionship.get(buttonPressed[1]).getName());//sets in the Texts of theGame the two names of players by their index which are buttonPressed[0] and buttonPressed[1] 

		EventHandler<ActionEvent> done = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				score = g.getScores(theChampionship.getGame(), evenCounter);

				theChampionship.play(buttonPressed[0], buttonPressed[1], score);//gets toe index and a score array and plays the game (gives score to each player)
				ArrayList<TextField> txt2 = null;
				if (buttonPressed[2] == 1)//if the stage is 1 then the textfield array is quarter
					txt2 = theView.getQuarterFields();
				if (buttonPressed[2] == 2)//if the stage is 2 then the textfield array is half
					txt2 = theView.getHalfFields();
				if (buttonPressed[2] == 3)//if the stage is 1 then the textfield array is champion
					txt2 = theView.getChampion();

				if (theChampionship.winner(buttonPressed[0], buttonPressed[1]) == buttonPressed[0]) {//if the winner between player(buttonPressed[0]) and player(buttonPressed[1]) is the first(index buttonPressed[0])
					addPlayerToTextField(theChampionship.get(buttonPressed[0]).getName(), txt2, buttonPressed[3]);//then sets the first players name in the textfield array(txt2)

					g.exit();

				} else {
					if (theChampionship.winner(buttonPressed[0], buttonPressed[1]) == buttonPressed[1]) {//if the winner between player(buttonPressed[0]) and player(buttonPressed[1]) is the second index (buttonPressed[1])
						addPlayerToTextField(theChampionship.get(buttonPressed[1]).getName(), txt2, buttonPressed[3]);//then sets the second players name in the textfield array(txt2)

						g.exit();

					} else {//here are draw scenarios (the game type is important because each game needs different amount of matches)
						if (game instanceof Football//if the game is football and there was a draw( winner= -1)
								&& theChampionship.winner(buttonPressed[0], buttonPressed[1]) == -1) {
							evenCounter++;//add +1 to event counter

							theChampionship.setRounds(theChampionship.getRounds() + 1);//add one more round 

							g.updateToEvenScore1(evenCounter);//update the game window (add one more textfield for each player)
							g.lockTextField(game, evenCounter);//lock the previous textfields so the user couldn't change played match
						} else {
							if (game instanceof Tennis//if the game is tennis and there was a draw( winner= -1)
									&& theChampionship.winner(buttonPressed[0], buttonPressed[1]) == -1) {

								evenCounter++;//add +1 to event counter
								theChampionship.setRounds(5);//add two more roundes 
								g.updateToEvenScoreTennis();//update the game window (add one more textfield for each player)
								g.lockTextField(game, evenCounter);//lock the previous textfields so the user couldn't change played match

							}
						}
					}
				}
				theView.disableButton();//you can play the half games without playing quarter games(disables "play" buttons)
			}
		};
		g.changeListenerToDone(done);

	}
}
