package Model;
//test for class
public class Answer {
	// -------------------------------Class Members------------------------------
private String text;
private boolean isCorrect;

// -------------------------------Constructors-------------------------------

public Answer(String text, boolean isCorrect) {
	super();
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
