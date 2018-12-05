package Game;

import Rooms.Room;

public class Board {
    private Room[][] map;

    public Board(Room[][] map) {
        this.map = map;
    }


    public Room[][] getMap() {
        return map;
    }

    public void print() {
        String row = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                row += map[i][j].toString();
            }
            row =row + "\n";
        }
        System.out.println(row);
    }

}
