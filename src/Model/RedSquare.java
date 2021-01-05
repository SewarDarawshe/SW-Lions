package Model;

import utils.SQUARE_COLOR;
import utils.Soldier_COLOR_AtSquare;

public class RedSquare extends SquareObject{

	public RedSquare(int x, int y, Soldier_COLOR_AtSquare soldierColor, Soldier s) {
		super(x, y, soldierColor, s);
		this.setSquareColor(SQUARE_COLOR.RED);

		// TODO Auto-generated constructor stub
	}

}
