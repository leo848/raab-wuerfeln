import java.util.*;

public class Game {
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();

	public Game() {}

	public void play() {
		System.out.println("Gib den Namen von Spieler 1 ein: ");
		Player player1 = new Player(scanner.next(), 0);
		System.out.println("Gib den Namen von Spieler 2 ein: ");
		Player player2 = new Player(scanner.next(), 1);

		for (
				int i = 1;
				player1.value < 50 && player2.value < 50 || player1.value == player2.value;
				i++
			){
			Utils.print();
			Utils.print("Zug "+i+" beginnt; es steht "+player1.value+" - "+player2.value+":");
			player1.turn();
			player2.turn();
		}

		(player1.value > player2.value ? player1 : player2).printWin();
	}
}
