package Rooms;

import Game.Runner;
import People.Person;

import java.util.Scanner;

public class ForestSpecial1 extends Room {

    public ForestSpecial1(int x, int y) {
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
        System.out.println("You found the Sticks! Type 'keep' to place it in your inventory.");
        Scanner input = new Scanner(System.in);
        String response = input.nextLine().toLowerCase();
        if (response.equals("keep")){
            System.out.println("Ok great! If you have all three items go back to the beach and build the fire. \n" + "If not, keep looking");
        }
        else{
            System.out.println("Are you sure you don't want to keep it?");
        }
    }

    public String toString()
    {
        if (occupant == null){
            return "\uD83C\uDF34";
        }
        else{
            return "\uD83D\uDEB6";
        }
    }
}
