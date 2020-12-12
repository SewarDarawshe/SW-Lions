package Controllers;

import Model.Player;

import utils.Soldier_COLOR_AtSquare;

public class GameController {
	
	private static GameController single_control = null;

	
	public static GameController getInstance() {
		if (single_control == null)
			single_control = new GameController();

		return single_control;
	}

	
	
}
