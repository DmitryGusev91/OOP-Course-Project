import Championship.Championship;
import Controller.Controller;
import View.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Program extends Application{

	public static void main(String[] args) {
		launch(args);

		
		
		
		
	}

	public void start(Stage stage) throws Exception {
		Championship ch=new Championship();
		MainWindow m=new MainWindow(stage);
		Controller c=new Controller(m,ch);
		
		
	}
	
}
