package Rooms;

import Game.Runner;
import People.Person;

public class Beach extends Room{

    public Beach(int x, int y) {
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

        System.out.println("This is the beach! Do you collect all the necessary items?");
        }

    public String toString(){
        if (occupant == null){
        return "B";}
        else{
            return "P";
        }
    }
}
