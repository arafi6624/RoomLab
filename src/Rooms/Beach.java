package Rooms;

import Game.Runner;
import People.Person;
import java.util.Scanner;

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

        System.out.println("Right now you are at the beach! Do you collect all the necessary items?");
        Scanner input = new Scanner(System.in);
        String response = input.nextLine().toLowerCase();

        if (response.equals("yes")){
            System.out.println("Great now type 'build' to build the campfire and survive the night!");
        }
        else{
            System.out.println("Go get the necessary items from the forest first. Beware of the beast!");
        }
        }

    public String toString(){
        if (occupant == null){
        return "B";}
        else{
            return "P";
        }
    }
}
