package Controllers;

import Model.BlackSquare;
import Model.BlueSquare;
import Model.GreenSquare;
import Model.OrangeSquare;
import Model.RedSquare;
import Model.Soldier;
import utils.Soldier_COLOR_AtSquare;

import Model.SquareObject;
import Model.YellowSquare;
import utils.SQUARE_COLOR;
/**
 * Class public class SquareFactory - create square objects
 * 
 * @author Sewar Drawshe
 * 
 * 
 */
public class SquareFactory {
	
	
	/**
	 * returns a Square object type
	 * @param type
	 * @param x
	 * @param y
	 * @return
	 */
	public static SquareObject getSquareObject(SQUARE_COLOR type, int x, int y,Soldier_COLOR_AtSquare color,Soldier s) {
		if (type.equals(SQUARE_COLOR.BLACK))
			return new BlackSquare(x,y,color,s);
		else if (type.equals(SQUARE_COLOR.BLUE))
			return new BlueSquare(x,y,color,s);
		else if (type.equals(SQUARE_COLOR.GREEN))
			return new GreenSquare(x,y,color,s);
		else if (type.equals(SQUARE_COLOR.ORANGE))
			return new OrangeSquare(x,y,color,s);
		else if (type.equals(SQUARE_COLOR.RED))
			return new RedSquare(x,y,color,s);
		else if (type.equals(SQUARE_COLOR.YELLOW))
			return new YellowSquare(x,y,color,s);

		return null;
	}

}
