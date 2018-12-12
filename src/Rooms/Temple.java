package Rooms;

import Game.Runner;
import People.Person;

public class Temple extends Room {

    public Temple(int x, int y) {
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
        System.out.println("This is the temple ");
    }

    public String toString()
    {
        if (occupant == null){
            return "^";
        }
        else{
            return "P";
        }
    }
}
