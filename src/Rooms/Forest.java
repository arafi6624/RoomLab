package Rooms;

import Game.Runner;
import People.Person;

public class Forest extends Room {

        public Forest(int x, int y) {
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
            System.out.println("This is the forest. Continue looking for the items if you haven't found them.");
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
