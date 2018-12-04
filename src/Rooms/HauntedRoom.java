package Rooms;

import Game.Runner;
import People.Person;

public class HauntedRoom extends Room {

        public HauntedRoom(int x, int y) {
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
            System.out.println("This is the haunted room! The ghost killed you :( ");
            Runner.gameOff();
        }
}