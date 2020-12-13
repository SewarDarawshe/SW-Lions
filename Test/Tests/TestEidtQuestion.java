import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Controllers.Sysdata;
import Model.Answer;
import Model.Question;

import utils.E_Difficulty;

class TestEidtQuestion {

	@Test
	void test() {
		Sysdata instance = Sysdata.getInstance();
		ArrayList<Answer> A = new ArrayList<Answer>();
		Question qold = new Question("What is Junit", E_Difficulty.EASY, A);
		Question qnew = new Question("What is an example of Black Box test", E_Difficulty.MEDIUM, A);
		assertTrue(instance.editQuestion(qold, qnew));
	}

}
