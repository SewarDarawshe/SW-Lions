package Model;

import utils.SQUARE_COLOR;
import utils.Soldier_COLOR_AtSquare;

public class BlackSquare extends SquareObject {

	public BlackSquare(int x, int y, Soldier_COLOR_AtSquare soldierColor, Soldier s) {
		super(x, y, soldierColor, s);
		this.setSquareColor(SQUARE_COLOR.BLACK);
		// TODO Auto-generated constructor stub
	}

}
