import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controllers.Sysdata;

import Model.Question;

import utils.E_Difficulty;

import Model.Answer;

import java.util.ArrayList;


class TestDeleteQuestion {

	@Test
	void test() {
		Sysdata instance = Sysdata.getInstance();
		ArrayList<Answer> A = new ArrayList<Answer>();
		Question q = new Question("What is Junit",E_Difficulty.EASY , A);
		instance.removeQuestion(q);
		assertTrue(instance.removeQuestion(q));

	}

}
