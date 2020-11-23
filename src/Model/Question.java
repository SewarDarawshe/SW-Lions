package Model;

public class Question {
	// -------------------------------Class Members------------------------------
	private static int number=0;
	private String text;
	private int difficulty;
	private String[] answers= new String[4];
	
	// -------------------------------Constructors-------------------------------

		public Question(String text, int difficulty, String[]answers ) {
			super();
			number++;
			this.text=text;
			this.difficulty=difficulty;
			this.answers=answers;
		}
	// -------------------------------Getters And Setters-------------------------

		public static int getNumber() {
			return number;
		}


		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public int getDifficulty() {
			return difficulty;
		}

		public void setDifficulty(int difficulty) {
			this.difficulty = difficulty;
		}

		public String[] getAnswers() {
			return answers;
		}

		public void setAnswers(String[] answers) {
			this.answers = answers;
		}

}
