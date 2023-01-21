package View;


//will pop up a window with a message that something went wrong
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExceptionWindow {
	private Group root;
	private Text txt;

	public ExceptionWindow(Stage stage, String str) {
		root=new Group();
		stage.setTitle("Ops, somethin went wrong !!!");
		txt = new Text(str);
		txt.setFont(new Font(20));
		txt.setX(50);
		txt.setY(100);
		
		root.getChildren().add(txt);
		Scene scene = new Scene(root, 500, 200);
		stage.setScene(scene);
		stage.show();

	}

	private String getText() {
		return txt.getText();
	}

}
