package Controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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
		//	readQuestionsJSON();
			return QuestionsArray;
		}
	
		// ------------- Read Write from JSON -----------------

		/*
		 * This method reads the questions written in JSON file and saves them in an
		 * array list.
		 */
		@SuppressWarnings("deprecation")
		private void readQuestionsJSON() {
			QuestionsArray = new ArrayList<Question>();
			try {
				if (QuestionsArray.isEmpty())
					for (int i = 0; i < QuestionsArray.size(); i++) {
						QuestionsArray.remove(i);
					}
				int k = 1;
				Object obj = new JSONParser().parse(new FileReader("questionsJSON.json"));
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
				/*	
				 * check the json questions build!!!!!! 
				 * we have to change it ! 
				 * Question q = new Question(k, context, difficulty, arrlista, correct_ans);
					k++;
					QuestionsArray.add(q);*/
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	
	
	

}
