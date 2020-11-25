package Model;

import java.util.ArrayList;

import utils.E_Difficulty;

public class Question {
// -------------------------------Class Members------------------------------
	private int number;
	private String text;
	private E_Difficulty difficulty;
	private ArrayList<Answer> answers;
	private int correct_ans;
	private String team;
	private int score;
	private int penalty; 
	
// -------------------------------Constructors-------------------------------
   public Question(int Number,String text, E_Difficulty difficulty, ArrayList<Answer> answers, int correct_ans) {
		super();
		this.number=Number;
		this.text = text;
		this.difficulty = difficulty;
		this.answers = answers;
		this.correct_ans = correct_ans;
		this.team = "Lions";
		if(difficulty.equals(E_Difficulty.EASY)) {
			this.score = 100;
			this.penalty = -250;
		}
		if(difficulty.equals(E_Difficulty.MEDIUM)) {
			this.score = 200;
			this.penalty = -100;
		}
		if(difficulty.equals(E_Difficulty.HARD)) {
			this.score =500;
			this.penalty = -50;
		}
		}
// -------------------------------Getters And Setters-------------------------------
   public  int getNumber() {
		return number;
	}

	public  void setNumber(int number) {
		this.number = number;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public E_Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(E_Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}

	public int getCorrect_ans() {
		return correct_ans;
	}

	public void setCorrect_ans(int correct_ans) {
		this.correct_ans = correct_ans;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getPenalty() {
		return penalty;
	}

	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
// -------------------------------Methods-------------------------

		//check if the same answer already exists 
		public boolean addAnswer(Answer answer, boolean isCorrect) {
			return true;
		}
		
		public boolean deleteAnswer(Answer answer) {
			if (answer != null) {
				answers.remove(answers.indexOf(answer));
				return true;
			}
			return false;
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((answers == null) ? 0 : answers.hashCode());
			result = prime * result + correct_ans;
			result = prime * result + ((difficulty == null) ? 0 : difficulty.hashCode());
			result = prime * result + penalty;
			result = prime * result + score;
			result = prime * result + ((team == null) ? 0 : team.hashCode());
			result = prime * result + ((text == null) ? 0 : text.hashCode());
			return result;
		}
		
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Question other = (Question) obj;
			if (answers == null) {
				if (other.answers != null)
					return false;
			} else if (!answers.equals(other.answers))
				return false;
			if (correct_ans != other.correct_ans)
				return false;
			if (difficulty != other.difficulty)
				return false;
			if (penalty != other.penalty)
				return false;
			if (score != other.score)
				return false;
			if (team == null) {
				if (other.team != null)
					return false;
			} else if (!team.equals(other.team))
				return false;
			if (text == null) {
				if (other.text != null)
					return false;
			} else if (!text.equals(other.text))
				return false;
			return true;
		}
		
		
		@Override
		public String toString() {
			return "Question [text=" + text + ", difficulty=" + difficulty + ", answers=" + answers + ", correct_ans="
					+ correct_ans + ", team=" + team + ", score=" + score + ", penalty=" + penalty + "]";
		}
	

}
