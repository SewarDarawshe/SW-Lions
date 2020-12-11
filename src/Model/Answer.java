package Model;
/**
 * @author Maisa Mansour
 * 
 * 
 */public class Answer {
	// -------------------------------Class Members------------------------------
	 int id=0;
private String text;
private boolean isCorrect;

// -------------------------------Constructors-------------------------------

public Answer(String text, boolean isCorrect) {
	super();
	id=id++;
	this.text=text;
	this.isCorrect= isCorrect;
}
// -------------------------------Getters And Setters-------------------------

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;

}

public boolean isCorrect() {
	return isCorrect;
}

public void setIsCorrect(boolean iscorrect) {
	this.isCorrect= iscorrect;

}

@Override
public String toString() {
	return "Answer [text=" + text + ", isCorrect=" + isCorrect + "]";
}


}
