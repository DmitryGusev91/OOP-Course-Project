package View;

import java.util.ArrayList;

import Championship.Championship;
import Championship.NameAndAmountException;
import Championship.PlayerList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


//this is the main window in which you add players and start the game .
//it is divided to two parts the first is the "adding window" and after you start the game it updates itself for the game where you can see the process of the game and the winers
public class MainWindow {

	private Text txt1, txt2;
	private TextField name, tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tfq1, tfq2, tfq3, tfq4, tfh1, tfh2, tfc;// the names
																											// of the
																											// players
																											// will
																											// Appear at
																											// those
																											// textfields(tf=All
																											// The
																											// Names,tfq=names
																											// in the
																											// quarter
																											// rounds,tfh=names
																											// in the
																											// half,
																											// tfc=champion)
	private RadioButton rbTennis, rbFootball, rbBasketball;// game types
	private ToggleGroup tg;
	private BorderPane bp;
	private Button add, start, play1, play2, play3, play4, play5, play6, play7;// the buttons to play the game
	private Stage stage;
	private ArrayList<TextField> fields, quarterFields, halfFields, champion;// the stages of the game
	private VBox vb4, vb3, vb5, vb6, vb7;
	private HBox hb5;

	public MainWindow(Stage stage) {
		this.stage = stage;
//////////////////////////////////////////////////////////////////////////////FIRST SCREEN///////////////////////////////////////////////////////////////////
		txt1 = new Text("Championship");
		txt1.setFont(new Font(50));
		txt1.setX(600);

		DropShadow ds1 = new DropShadow(15, Color.BLUE);
		ds1.setOffsetX(5);
		ds1.setOffsetY(5);
		txt1.setEffect(ds1);

		quarterFields = new ArrayList<TextField>();
		halfFields = new ArrayList<TextField>();
		champion = new ArrayList<TextField>();

		tg = new ToggleGroup();
		rbBasketball = new RadioButton("Basketball");
		rbBasketball.setSelected(true);
		rbBasketball.setToggleGroup(tg);
		rbFootball = new RadioButton("Football");
		rbFootball.setToggleGroup(tg);
		rbTennis = new RadioButton("Tennis");
		rbTennis.setToggleGroup(tg);
		VBox vbRight = new VBox();
		vbRight.getChildren().addAll(rbBasketball, rbFootball, rbTennis);
		vbRight.setAlignment(Pos.CENTER_LEFT);
		VBox.setMargin(rbBasketball, new Insets(0, 100, 0, 0));

		txt2 = new Text("Participant/Grup name: ");
		name = new TextField();
		HBox hb1 = new HBox();
		HBox.setMargin(txt2, new Insets(10, 20, 0, 20));
		HBox.setMargin(name, new Insets(10, 20, 10, 20));
		hb1.getChildren().addAll(txt2, name);

		add = new Button("Add Participant");
		start = new Button("Start Championship");
		HBox hb2 = new HBox();
		HBox.setMargin(add, new Insets(10, 20, 0, 50));
		HBox.setMargin(start, new Insets(10, 20, 10, 20));
		hb2.getChildren().addAll(add, start);

		VBox vb2 = new VBox();
		vb2.getChildren().addAll(hb1, hb2);

		Pane pane = new Pane();
		pane.getChildren().add(vb2);

		tf1 = new TextField();
		VBox.setMargin(tf1, new Insets(150, 0, 20, 40));
		tf2 = new TextField();
		VBox.setMargin(tf2, new Insets(20, 0, 20, 40));
		tf3 = new TextField();
		VBox.setMargin(tf3, new Insets(20, 0, 20, 40));
		tf4 = new TextField();
		VBox.setMargin(tf4, new Insets(20, 0, 20, 40));
		tf5 = new TextField();
		VBox.setMargin(tf5, new Insets(20, 0, 20, 40));
		tf6 = new TextField();
		VBox.setMargin(tf6, new Insets(20, 0, 20, 40));
		tf7 = new TextField();
		VBox.setMargin(tf7, new Insets(20, 0, 20, 40));
		tf8 = new TextField();
		VBox.setMargin(tf8, new Insets(20, 0, 20, 40));
		vb3 = new VBox();
		TextField[] arrtf1 = { tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8 };
		setTextfields(arrtf1);// gives shadows to all first 8 textfields, and makes them inactive

		fields = new ArrayList<TextField>();
		fields.add(tf1);
		fields.add(tf2);
		fields.add(tf3);
		fields.add(tf4);
		fields.add(tf5);
		fields.add(tf6);
		fields.add(tf7);
		fields.add(tf8);
		vb3.getChildren().addAll(tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8);

		bp = new BorderPane();
		bp.setRight(vbRight);
		BorderPane.setAlignment(txt1, Pos.CENTER);
		BorderPane.setMargin(txt1, new Insets(0, 0, 0, 0));
		bp.setTop(txt1);
		bp.setCenter(pane);
		BorderPane.setMargin(pane, new Insets(320, 0, 0, 250));
		BorderPane.setAlignment(pane, Pos.CENTER);
		bp.setLeft(vb3);

//////////////////////////////////////////////////////////////////////SECOND SCREEN/////////////////////////////////////////////////////////////////////////////////////////////////
		play1 = new Button("Play");
		play2 = new Button("Play");
		play3 = new Button("Play");
		play4 = new Button("Play");
		vb4 = new VBox();
		vb4.getChildren().addAll(play1, play2, play3, play4);

		setFirstPlayButtons(play1, play2, play3, play4);// sets the first 4 play buttons in a specific distance from
														// each other
		VBox.setMargin(play1, new Insets(185, 0, 55, 70));

		tfq1 = new TextField();
		VBox.setMargin(tfq1, new Insets(185, 0, 55, 50));
		quarterFields.add(tfq1);
		tfq2 = new TextField();
		VBox.setMargin(tfq2, new Insets(50, 0, 55, 50));
		quarterFields.add(tfq2);
		tfq3 = new TextField();
		VBox.setMargin(tfq3, new Insets(50, 0, 55, 50));
		quarterFields.add(tfq3);
		tfq4 = new TextField();
		VBox.setMargin(tfq4, new Insets(50, 0, 55, 50));
		quarterFields.add(tfq4);
		vb5 = new VBox();
		vb5.getChildren().addAll(tfq1, tfq2, tfq3, tfq4);

		TextField[] arrtf2 = { tfq1, tfq2, tfq3, tfq4 };
		setTextfields(arrtf2);// sets shadows to 4 textfields in the second round and makes them inactive

		play5 = new Button("Play");
		play5.setDisable(true);
		play5.setMinWidth(100);
		VBox.setMargin(play5, new Insets(255, 0, 115, 70));
		play6 = new Button("Play");
		play6.setDisable(true);
		play6.setMinWidth(100);
		VBox.setMargin(play6, new Insets(115, 0, 115, 70));
		vb6 = new VBox();
		vb6.getChildren().addAll(play5, play6);

		tfh1 = new TextField();
		VBox.setMargin(tfh1, new Insets(255, 0, 115, 50));
		halfFields.add(tfh1);
		tfh2 = new TextField();
		VBox.setMargin(tfh2, new Insets(115, 0, 115, 50));
		halfFields.add(tfh2);
		vb7 = new VBox();
		vb7.getChildren().addAll(tfh1, tfh2);
		TextField[] arrtf3 = { tfh1, tfh2 };
		setTextfields(arrtf3);// sets shadows to 2 textfields in the third round and makes them inactive

		play7 = new Button("Play");
		play7.setDisable(true);
		play7.setMinWidth(100);
		HBox.setMargin(play7, new Insets(380, 0, 0, 70));

		tfc = new TextField();
		HBox.setMargin(tfc, new Insets(380, 0, 0, 50));
		tfc.setEditable(false);
		DropShadow ds = new DropShadow(10, Color.RED);
		ds.setOffsetX(5);
		ds.setOffsetY(5);
		tfc.setEffect(ds);
		champion.add(tfc);
		hb5 = new HBox();

/////////////////////////////////////////////////////////////////////END OF SECOND SCREEN//////////////////////////////////////////////////////////////////////////////////////////////	
		Scene scene = new Scene(bp, 1350, 800);
		stage.setScene(scene);
		stage.show();
	}

	public void setTextfields(TextField[] array) {// gets and TextField array ,gives to every textfield a shadow ,and
													// makes it inactive

		for (int i = 0; i < array.length; i++) {

			array[i].setEditable(false);// makes it inactive
			DropShadow ds = new DropShadow(10, Color.BLUE);
			ds.setOffsetX(5);
			ds.setOffsetY(5);
			array[i].setEffect(ds);
		}
	}

	public void setFirstPlayButtons(Button b1, Button b2, Button b3, Button b4) {// gets 4 buttons and puts them in a
																					// specific distance one from the
																					// other
		Button[] array = { b1, b2, b3, b4 };
		for (int i = 0; i < array.length; i++) {
			VBox.setMargin(array[i], new Insets(50, 0, 55, 70));
			array[i].setMinWidth(100);
		}
	}

	public String getName() {// gets the name of the game
		return name.getText();
	}

	public void changeListenerToAdd(EventHandler<ActionEvent> creatPlayer) {// the function of adding a player wi a
																			// button
		add.setOnAction(creatPlayer);

	}

	public void resetTextField() {// deletes the name of the game
		name.setText("");
	}

	public ArrayList<TextField> getFields() {// returns an array with textfields(names) of all the 8 players
		return fields;
	}

	public ArrayList<TextField> getQuarterFields() {// returns an array with textfields(names) of 4 of the players who
													// are playing in the quarters
		return quarterFields;
	}

	public ArrayList<TextField> getHalfFields() {// returns an array with textfields(names) of 2 of the players who are
													// playing in the half
		return halfFields;
	}

	public ArrayList<TextField> getChampion() {// returns the champion
		return champion;
	}

	public void setName(String name, ArrayList<TextField> array, int index) {// Receives a name , an textfield array and
																				// an index(where to put the name) and
																				// puts the name in the array at the
																				// given index
		// thats how it updates the winners name to the next stage
		array.get(index).setText(name);
	}

	public int getGame() {// if the radiobutton selects basketball then return 1 , if football return 2 ,
							// if tennis return 3
		// from here we know which game to create
		if (rbBasketball.isSelected()) {
			return 1;
		} else {
			if (rbFootball.isSelected()) {
				return 2;
			} else {
				return 3;
			}
		}
	}

	public void close() {
		stage.close();

	}

	public void ChangeListenerToStart(EventHandler<ActionEvent> start2) {// starts the game by pressing a button

		start.setOnAction(start2);

	}

	public void update(PlayerList l) throws NameAndAmountException {// after creating all the players and pressing
																	// "start" , the window update itself to game
																	// process
		if (l.size() == 8) {
			bp.setRight(null);
			bp.setCenter(null);
			hb5.getChildren().clear();
			hb5.getChildren().addAll(vb3, vb4, vb5, vb6, vb7, play7, tfc);
			bp.setLeft(hb5);
		} else if (l.size() < 8)// if the amount of players is less then 8 it throws an exception
			throw new NameAndAmountException("Player/s missing , please add more player/s.");

	}

	public void changeListenerToFirstWinner(EventHandler<ActionEvent> play12) {// plays a game after you press a button

		play1.setOnAction(play12);
		play2.setOnAction(play12);
		play3.setOnAction(play12);
		play4.setOnAction(play12);
		play5.setOnAction(play12);
		play6.setOnAction(play12);
		play7.setOnAction(play12);

	}

	public int[] wichButton(Championship c) {//each "play' button triggers different players to play the game , the array  helps to know which player will play against which and where will go the winers name,and what stage of the game it is
		//the array numbers are:
		// first index,second index,what stage of the championship(beginning,quarter,half),index of place to go for the winner
		

		if (play1.isArmed()) {
			int[] players = { 0, 1, 1, 0 };//first player,second player,first stage(beginning),will go to index 0 in the next array(quarter)

			return players;
		}
		if (play2.isArmed()) {
			int[] players = { 2, 3, 1, 1 };
			return players;
		}
		if (play3.isArmed()) {
			int[] players = { 4, 5, 1, 2 };
			return players;
		}
		if (play4.isArmed()) {
			int[] players = { 6, 7, 1, 3 };
			return players;
		}
		if (play5.isArmed()) {
			int[] players = { c.winner(0, 1), c.winner(2, 3), 2, 0 };//takes the winners between two first players and between the third and fourth
			c.refresh(players[0]);//sets the score to 0
			c.refresh(players[1]);//sets the score to 0
			return players;
		}
		if (play6.isArmed()) {
			int[] players = { c.winner(4, 5), c.winner(6, 7), 2, 1 };
			c.refresh(players[0]);
			c.refresh(players[1]);
			return players;
		} else {//gets the last two players index by their name and puts it in th emethod
			int player1 = c.getIndexByName(halfFields.get(0).getText());
			int player2 = c.getIndexByName(halfFields.get(1).getText());
			int[] players = { player1, player2, 3, 0 };
			c.refresh(players[0]);
			c.refresh(players[1]);
			return players;
		}

	}

	public void disableButton() {//the "play" button will be disabled if you do not have two players ready to play against each other
		// and after you play a game it locks the play button so you cant play the same game twice

		if (!(tfq1.getText().equals("")))//if there is a winner(a name)
			play1.setDisable(true);//then the button will be locked
		if (!(tfq2.getText().equals("")))
			play2.setDisable(true);
		if(!(tfq1.getText().equals(""))&&!(tfq2.getText().equals("")))
				play5.setDisable(false);
		if (!(tfq3.getText().equals("")))
			play3.setDisable(true);
		if (!(tfq4.getText().equals("")))
			play4.setDisable(true);
		if(!(tfq3.getText().equals(""))&&!(tfq4.getText().equals("")))
			play6.setDisable(false);
		if (!(tfh1.getText().equals("")))
			play5.setDisable(true);
		if (!(tfh2.getText().equals("")))
			play6.setDisable(true);
		if(!(tfh1.getText().equals(""))&&!(tfh2.getText().equals("")))
			play7.setDisable(false);
		if (!(tfc.getText().equals("")))
			play7.setDisable(true);
	}
}
