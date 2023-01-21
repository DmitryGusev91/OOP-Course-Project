package View;

import Championship.Basketball;
import Championship.Football;
import Championship.Game;
import Championship.Tennis;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class TheGame {// this is the window of the game itself
	private Group root;
	private Stage stage;
	private Text txt1, txt2, txt3, txt4;// texts for the user
	private Button done;// Submitting button
	private TextField a1, a2, a3, a4, a5, b5, b1, b2, b3, b4;// textfields for the scores
	private HBox hb1, hb2;
	private VBox vb;
	private int[] score;// the score from the textfields will go there

	public TheGame(Stage stage, String str) {
		root = new Group();
		this.stage = stage;

		txt1 = new Text(str + " Game");// main Text(with the game name)
		txt1.setFont(new Font(50));
		VBox.setMargin(txt1, new Insets(0, 0, 0, 100));
		DropShadow ds1 = new DropShadow(15, Color.BLUE);
		ds1.setOffsetX(5);
		ds1.setOffsetY(5);
		txt1.setEffect(ds1);

		txt4 = new Text("There was a draw , please play again.");// is getting added if there was a draw
		txt4.setFont(new Font(20));

		txt2 = new Text();
		txt2.setFont(new Font(20));
		HBox.setMargin(txt2, new Insets(50, 20, 20, 20));
		a1 = new TextField();
		HBox.setMargin(a1, new Insets(50, 20, 20, 20));
		a1.setMaxWidth(50);
		a2 = new TextField();
		HBox.setMargin(a2, new Insets(50, 20, 20, 20));
		a2.setMaxWidth(50);
		a3 = new TextField();
		HBox.setMargin(a3, new Insets(50, 20, 20, 20));
		a3.setMaxWidth(50);
		a4 = new TextField();
		HBox.setMargin(a4, new Insets(50, 20, 20, 20));
		a4.setMaxWidth(50);
		a5 = new TextField();
		HBox.setMargin(a5, new Insets(50, 20, 20, 20));
		a5.setMaxWidth(50);
		hb1 = new HBox();
		hb1.getChildren().addAll(txt2, a1, a2, a3, a4);

		txt3 = new Text();
		txt3.setFont(new Font(20));
		HBox.setMargin(txt3, new Insets(20, 20, 20, 20));
		b1 = new TextField();
		b1.setMaxWidth(50);
		HBox.setMargin(b1, new Insets(20, 20, 20, 20));
		b2 = new TextField();
		HBox.setMargin(b2, new Insets(20, 20, 20, 20));
		b2.setMaxWidth(50);
		b3 = new TextField();
		HBox.setMargin(b3, new Insets(20, 20, 20, 20));
		b3.setMaxWidth(50);
		b4 = new TextField();
		HBox.setMargin(b4, new Insets(20, 20, 20, 20));
		b4.setMaxWidth(50);
		b5 = new TextField();
		HBox.setMargin(b5, new Insets(20, 20, 20, 20));
		b5.setMaxWidth(50);
		hb2 = new HBox();
		hb2.getChildren().addAll(txt3, b1, b2, b3, b4);

		done = new Button("Done");
		done.setMinWidth(50);
		VBox.setMargin(done, new Insets(100, 20, 20, 230));

		vb = new VBox();
		vb.getChildren().addAll(txt1, hb1, hb2, done);
		root.getChildren().add(vb);

		Scene scene = new Scene(root, 500, 450);
		stage.setScene(scene);
		stage.show();
	}

	public int[] getScores(Game g, int even) {// gets the type of game and the stage of the game(first round or first
												// draw or second draw), puts the scores into an array and returns the
												// array depending on the type of game and the stage;
		if ((g instanceof Basketball) || (g instanceof Football && even == 2)) {// if the game is basketball or football
																				// after the second draw

			score = new int[8];
			score[0] = Integer.parseInt(a1.getText());
			score[1] = Integer.parseInt(a2.getText());
			score[2] = Integer.parseInt(a3.getText());
			score[3] = Integer.parseInt(a4.getText());
			score[4] = Integer.parseInt(b1.getText());
			score[5] = Integer.parseInt(b2.getText());
			score[6] = Integer.parseInt(b3.getText());
			score[7] = Integer.parseInt(b4.getText());
		}

		if (g instanceof Football && even == 0) {// if the game is football and the first stage
			score = new int[4];
			score[0] = Integer.parseInt(a1.getText());
			score[1] = Integer.parseInt(a2.getText());
			score[2] = Integer.parseInt(b1.getText());
			score[3] = Integer.parseInt(b2.getText());
		}
		if ((g instanceof Football && even == 1) || (g instanceof Tennis && even == 0)) {// if the game is tennis the
																							// first stage or football
																							// after a draw
			score = new int[6];
			score[0] = Integer.parseInt(a1.getText());
			score[1] = Integer.parseInt(a2.getText());
			score[2] = Integer.parseInt(a3.getText());
			score[3] = Integer.parseInt(b1.getText());
			score[4] = Integer.parseInt(b2.getText());
			score[5] = Integer.parseInt(b3.getText());
		}
		if (g instanceof Tennis && even == 1) {// the game is tennis after one draw
			score = new int[10];
			score[0] = Integer.parseInt(a1.getText());
			score[1] = Integer.parseInt(a2.getText());
			score[2] = Integer.parseInt(a3.getText());
			score[3] = Integer.parseInt(a4.getText());
			score[4] = Integer.parseInt(a5.getText());
			score[5] = Integer.parseInt(b1.getText());
			score[6] = Integer.parseInt(b2.getText());
			score[7] = Integer.parseInt(b3.getText());
			score[8] = Integer.parseInt(b4.getText());
			score[9] = Integer.parseInt(b5.getText());
		}

		return score;
	}

	public void exit() {// exits the window
		stage.close();
	}

	public void setNames(String name1, String name2) {// gets to strings (participant names) and put them into the Texts
		txt2.setText(name1);
		txt3.setText(name2);
	}

	public void changeListenerToDone(EventHandler<ActionEvent> done2) {// will run the game after you press the button
																		// (done)
		done.setOnAction(done2);

	}

	public void updateToFootball() {// the game by default have 4 score windows(for basketball) for each player,
									// this will clear them and add only two for each player if the game is football
		hb1.getChildren().clear();// clears everything from hb1
		hb1.getChildren().addAll(txt2, a1, a2);// adds the name of the player and two windows for scores
		hb2.getChildren().clear();// clears everything from hb2
		hb2.getChildren().addAll(txt3, b1, b2);// adds the name of the player and two windows for scores
	}

	public void updateToEvenScore1(int evenScore) {// if in a football game there was a draw the first or the second
													// time it adds more windows for another round ,depending on the
													// stage(first draw or second)
		if (evenScore == 1) {// if it is the first draw then adds another window (a3,b3)
			hb1.getChildren().clear();
			hb1.getChildren().addAll(txt2, a1, a2, a3);
			hb2.getChildren().clear();
			hb2.getChildren().addAll(txt3, b1, b2, b3);
			vb.getChildren().clear();
			vb.getChildren().addAll(txt1, txt4, hb1, hb2, done);
		} else {// if it is the second draw then adds another window to the existing ones
				// (a4,b4)
			hb1.getChildren().clear();
			hb1.getChildren().addAll(txt2, a1, a2, a3, a4);
			hb2.getChildren().clear();
			hb2.getChildren().addAll(txt3, b1, b2, b3, b4);
			vb.getChildren().clear();
			vb.getChildren().addAll(txt1, txt4, hb1, hb2, done);
		}
	}

	public void updateToTennis() {// the game by default have 4 score windows(for basketball) for each player,
									// this will clear them and add only three for each player if the game is Tennis
		hb1.getChildren().clear();
		hb1.getChildren().addAll(txt2, a1, a2, a3);
		hb2.getChildren().clear();
		hb2.getChildren().addAll(txt3, b1, b2, b3);

	}

	public void updateToEvenScoreTennis() {// if there was a draw at tennis then it adds another two windows for scores
											// for each player
		hb1.getChildren().clear();
		hb1.getChildren().addAll(txt2, a1, a2, a3, a4, a5);
		hb2.getChildren().clear();
		hb2.getChildren().addAll(txt3, b1, b2, b3, b4, b5);
		vb.getChildren().clear();
		vb.getChildren().addAll(txt1, txt4, hb1, hb2, done);
	}

	public void lockTextField(Game g, int even) {// after a draw and after the new Textfields were added we want to lock
													// the previus scores , so that the user could not change it after
													// the game
		if ((g instanceof Football && even == 1)) {// if the game is football and there was ONE draw then lock the first
													// TWO scores for each player
			a1.setEditable(false);
			a2.setEditable(false);
			b1.setEditable(false);
			b2.setEditable(false);
		}
		if ((g instanceof Football && even == 2)) {// if the game is football and there were TWO draws then lock in
													// addition another score for each player
			a3.setEditable(false);
			b3.setEditable(false);
		}
		if ((g instanceof Tennis && even == 1)) {// if the game is tennis and there was a draw then lock the first THREE
													// scores for each player
			a1.setEditable(false);
			a2.setEditable(false);
			b1.setEditable(false);
			b2.setEditable(false);
			a3.setEditable(false);
			b3.setEditable(false);
		}
	}
}
