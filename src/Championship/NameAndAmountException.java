package Championship;

import View.ExceptionWindow;
import javafx.stage.Stage;

public class NameAndAmountException extends Exception{
private String msg;


public NameAndAmountException(String msg)  {
this.msg=msg;	

	
}
public String getMessage() {
	return msg;
}
}
