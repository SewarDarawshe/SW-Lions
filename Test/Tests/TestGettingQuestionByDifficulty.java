import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Controllers.Sysdata;
import Model.Question;
import utils.E_Difficulty;
class TestGettingQuestionByDifficulty {

	@Test
	void test() {
		Sysdata instance = Sysdata.getInstance();
		instance.getQuestionsarr();
		ArrayList<Question> hardQtest = instance.fetchQuestionsArr(E_Difficulty.HARD);
		ArrayList<Question> medQtest = instance.fetchQuestionsArr(E_Difficulty.MEDIUM);
		ArrayList<Question> easyQtest = instance.fetchQuestionsArr(E_Difficulty.EASY);
		assertFalse(hardQtest.isEmpty());
		assertFalse(medQtest.isEmpty());
		assertFalse(easyQtest.isEmpty());

	}

}
