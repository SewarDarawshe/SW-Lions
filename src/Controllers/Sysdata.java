package Controllers;

import java.io.FileNotFoundException;



import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Model.Answer;
import Model.Game;
import Model.Player;
import Model.Question;
import utils.E_Difficulty;


/**
 * Class public class Sysdata - responsible for BL
 * 
 * @author Sewar Drawshe
 * 
 * 
 */
@SuppressWarnings("deprecation")
public class Sysdata {
	
	private static Sysdata instance;
	private static Player BlackPlayer;
	private static Player WhitePlayer;

	private ArrayList<Question> QuestionsArray = new ArrayList<>();
	private ArrayList<Game> GamesHistory = new ArrayList<>();
	
	public static Sysdata getInstance() {
		if (instance == null)
			instance = new Sysdata();
		return instance;
	}
	
	// ------------- Set & Get for the players -----------------

		public static Player getWhitePlayer() {
			return WhitePlayer;
		}

		public static void setWhitePlayer(Player player) {
			Sysdata.WhitePlayer = player;
		}
		public static Player getBlackPlayer() {
			return BlackPlayer;
		}

		public static void setBlackPlayer(Player player) {
			Sysdata.BlackPlayer = player;
		}

		// ------------- Manipulate Questions -----------------

		/*
		 * getQuestionsarr reads the JSON file with the questions and returns an array
		 * list containing them.
		 */
		public ArrayList<Question> getQuestionsarr() {
			readQuestionsJSON();

			return QuestionsArray;
		}
	
		// ------------- Read Write from JSON -----------------

		/*
		 * This method reads the questions written in JSON file and saves them in an
		 * array list.
		 */
		private void readQuestionsJSON() {
			QuestionsArray = new ArrayList<Question>();
			try {
				if (QuestionsArray.isEmpty())
					for (int i = 0; i < QuestionsArray.size(); i++) {
						QuestionsArray.remove(i);
					}
				int k = 1;

				Object obj = new JSONParser().parse(new FileReader("Questions.json"));
				JSONObject jo = (JSONObject) obj;
				JSONArray arr = (JSONArray) jo.get("questions");

				for (Object questionObj : arr) {
					JSONObject jsonQObjt = (JSONObject) questionObj;
					String context = (String) jsonQObjt.get("question");
					int correct_ans = Integer.parseInt((String) jsonQObjt.get("correct_ans"));
					JSONArray answersarr = (JSONArray) jsonQObjt.get("answers");
					ArrayList<Answer> arrlista = new ArrayList<Answer>();
					Iterator<?> itr = answersarr.iterator();
					int i = 1;
					while (itr.hasNext()) {
						String content = itr.next().toString();
						if (i == correct_ans) {
							Answer an = new Answer(content, true);
							arrlista.add(an);
						} else {
							Answer an = new Answer(content, false);
							arrlista.add(an);
						}
						i++;
					}
					E_Difficulty difficulty = E_Difficulty.returnEnum((String) jsonQObjt.get("level"));
			
				  Question q = new Question(k, context, difficulty, arrlista, correct_ans);
					k++;
					QuestionsArray.add(q);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/*
		 * given a question adds it to the data set of questions (the questionarr) and
		 * to the JSON file by rewriting it iff we don't already have the same question.
		 */
		public boolean addQuestion(Question q) {
			for (Question question : QuestionsArray) {
				if (question.equals(q)) {
					System.out.println("we already have this question");
					return false;
				}
				QuestionsArray.add(q);
				try {
					writeQuestionsToJSON();
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			return false;
		}
		/*
		 * Given an array list this method overrides the JSON questions file with the
		 * questions in the array list
		 */
		@SuppressWarnings({ "deprecation", "unchecked" })
		private void writeQuestionsToJSON() {
			try {
				JSONObject jo = new JSONObject();
				JSONArray ja = new JSONArray();

				for (Question q : QuestionsArray) {
					@SuppressWarnings("rawtypes")
					Map m = new LinkedHashMap(5);
					m.put("question", q.getText());
					List<String> list = new ArrayList<>();
					for (Answer a : q.getAnswers()) {
						list.add(a.getText());
					}
					JSONArray answersarr = new JSONArray(list);
					m.put("answers", answersarr);
					m.put("correct_ans", "" + q.getCorrect_ans());
					m.put("level", "" + q.getDifficulty().getNumber());
					m.put("team", q.getTeam());
					ja.add(m);
				}
				jo.put("questions", ja);
				PrintWriter pw = new PrintWriter("Questions.json");
				pw.write(jo.toJSONString());
				pw.flush();
				pw.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		/*
		 * given an old and new Question adds the new one and removes the old.
		 */
		public boolean editQuestion(Question old, Question newq) {
			if (old != null && newq != null) {
				if (removeQuestion(old))
					if (addQuestion(newq))
						return true;
			}
			return false;
		}
		
		/*
		 * given a question removes it from the array list and from the JSON file.
		 */
		public boolean removeQuestion(Question q) {
			if (q != null) {
				QuestionsArray.remove(QuestionsArray.indexOf(q));
				writeQuestionsToJSON();
				readQuestionsJSON();
				return true;
			}
			return false;
		}

		/*
		 * given a difficulty returns a random question with the requested difficulty.
		 */
		public Question fetchQuestion(E_Difficulty diff) {
			ArrayList<Question> arr = fetchQuestionsArr(diff);
			Random rand = new Random();
			int s = arr.size();
			if (s > 0) {
				Question choosenQuestion = arr.get(rand.nextInt(s));
				return choosenQuestion;
			} else {
				System.out.println("there are no questions with difficulty " + diff.toString());
				return null;
			}
		}
		
		/*
		 * given a difficulty returns an array list of all questions with the given
		 * difficulty.
		 */
		public ArrayList<Question> fetchQuestionsArr(E_Difficulty diff) {
			QuestionsArray = getQuestionsarr();
			ArrayList<Question> choosenQuestions = new ArrayList<Question>();
			for (Question q : QuestionsArray) {
				if (q.getDifficulty().equals(diff))
					choosenQuestions.add(q);
			}
			return choosenQuestions;
		}

}
