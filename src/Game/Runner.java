/* Text Based Adventure Project by Abdul Rafi */

package Game;

import Items.Fire;
import People.Person;
import Rooms.*;

import java.util.Scanner;

public class Runner {


	private static boolean gameOn = true;

	public static void main(String[] args) {
		Room[][] building = new Room[10][16];

		//Fill the building with normal rooms
		for (int x = 0; x < building.length; x++) {
			for (int y = 1; y < building[x].length; y++) {
				building[x][y] = new Room(x, y);
			}
		}

		for (int x = 0; x <building.length; x++){
			building [x][0] = new Beach(x,0);
		}

		for (int x = 0; x < building.length; x++){
			for (int y = 1; y < building[x].length; y++){
				building [x][y]= new Forest(x,y);
			}
		}

		for (int x = 3; x < (building.length); x++){
			for (int y = 6; y < (building[x].length - 6); y++){
				building [x][y]= new River(x,y);
			}
		}

		for (int x = 6; x < (building.length - 1); x++){
			for (int y = 12; y < (building[x].length -1); y++){
				building [x][y] = new Temple(x, y);
			}
		}

		int a = (int) (Math.random()* building.length);
		int b = (int) (Math.random()* building.length);
		int c = (int) (Math.random()* building.length);
		int d = (int) (Math.random()* building.length);
		int e = (int) (Math.random()* building.length);
		int f = (int) (Math.random()* building.length);
		int g = (int) (Math.random()* building.length);
		int h = (int) (Math.random()* building.length);

		if (b > 5 && b < 10){
			b = b + 3;
		}

		if (d > 5 && d < 10){
			d = d + 3;
		}

		if (f > 5 && f < 10){
			f = f + 3;
		}

		if (h > 5 && h < 10){
			h = h + 3;
		}


		building [a][b] = new Beast(a, b);
		building [c][d] = new ForestSpecial(c,d);
		building [e][f] = new ForestSpecial1(e,f);
		building [g][h] = new ForestSpecial2(g,h);

		System.out.println("Welcome to Survival Island! \n" + "In this game you will be searching through the island to find many items that can help you make a campfire at the beach to survive the night. \n"+
		"Beware of the beasts in the forest! \n" + "Make the campfire to win the game \n" + "A map will update your position throughout the game.\n" +
				"The character 'P' is your position, '\uD83C\uDF34' is the forest, '~' is the river (becareful you cannot swim), and '^' is the temple. \n");

		//Setup player 1 and the input scanner
		Person player1 = new Person("FirstName", "FamilyName", 0, 0);
		building[0][0].enterRoom(player1);
		Board map = new Board(building);
		map.print();
		Scanner in = new Scanner(System.in);
		while (gameOn) {
			System.out.println("What is your next move? (Choose N, S, E, W)");
			String move = in.nextLine();
			if (validMove(move, player1, map.getMap() )) {
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());

			} else {
				System.out.println("Please choose a valid move.");
			}
			map.print();

		}
		in.close();
	}

	/**
	 * Checks that the movement chosen is within the valid game map.
	 *
	 * @param move the move chosen
	 * @param p    person moving
	 * @param map  the 2D array of rooms
	 * @return
	 */
	public static boolean validMove(String move, Person p, Room[][] map) {
		move = move.toLowerCase().trim();
		switch (move) {
			case "n":
				if (p.getxLoc() > 0) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc() - 1][p.getyLoc()].enterRoom(p);
					return true;
				} else {
					return false;
				}
			case "e":
				if (p.getyLoc() < map[p.getxLoc()].length - 1) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				} else {
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc() + 1][p.getyLoc()].enterRoom(p);
					return true;
				} else {
					return false;
				}

			case "w":
				if (p.getyLoc() > 0) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() - 1].enterRoom(p);
					return true;
				} else {
					return false;
				}
			default:
				break;

		}
		return true;
	}

	public static void gameOff() {
		gameOn = false;
	}

}
