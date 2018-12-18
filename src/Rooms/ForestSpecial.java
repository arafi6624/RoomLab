package Rooms;

import Game.Runner;
import People.Person;

import java.util.Scanner;

public class ForestSpecial extends Room {

    public ForestSpecial(int x, int y) {
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
        System.out.println("You found the fire! Type 'keep' to place it in your inventory.");
        Scanner input = new Scanner(System.in);
        String response = input.nextLine().toLowerCase();
        if (response.equals("keep")){

        }
    }
    public String toString()
    {
        if (occupant == null){
            return "F";
        }
        else{
            return "P";
        }
    }
}
