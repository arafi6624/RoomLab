/* Text Based Adventure Project by Abdul Rafi */

package Game;

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

		int beast1 = (int) Math.random() * 17;
		int beast2 = (int) Math.random() * 11;

		building [beast1][beast2] = new Beast(beast1, beast2);

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
