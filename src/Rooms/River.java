package Rooms;

import Game.Runner;
import People.Person;

import java.util.Scanner;

public class River extends Room
{

	public River(int x, int y) {
		super(x, y);

	}

	/**
	 * Triggers the game ending conditions.
	 * @param x the Person entering
	 */
	@Override
	public void enterRoom(Person x) {

		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("This is the river! You drowned!");
		Runner.gameOff();
	}

	public String toString()
	{
		if (occupant == null){
			return "~";
		}
		else{
			return "P";
		}
	}


}
