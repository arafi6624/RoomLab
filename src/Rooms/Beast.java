package Rooms;

import Game.Runner;
import People.Person;

public class Beast extends Room{

    public Beast(int x, int y) {
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

        System.out.println("UH-OH. YOU CAME ACROSS THE BEAST AND IT KILLED YOU ☠");
        Runner.gameOff();
    }

    @Override
    public String toString() {
        if (yLoc > 1){
            return "F";
        }
        else{
            return "B";
        }
    }
}
