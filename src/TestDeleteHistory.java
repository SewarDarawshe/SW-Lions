import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controllers.Sysdata;

class TestDeleteHistory {

	@Test
	void test() {
		Sysdata instance = Sysdata.getInstance();
		instance.deleteGameHistory();
		assertTrue(instance.getHistory().isEmpty());
	}

}
