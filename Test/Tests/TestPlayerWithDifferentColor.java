import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Game;

import Model.Player;

import utils.Soldier_COLOR_AtSquare;

class TestPlayerWithDifferentColor {

	@Test
	void test() {
		Game g = new Game();
		Player p1 = new Player(A, 0);
		Player p2 = new Player(b, 0);
		g.AddPlayer(p1, p2);
		assertNotEquals(p1.getColor(), p2.getColor());
	}

}
