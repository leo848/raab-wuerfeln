import java.util.*;

public class Player {
	String name;

	int id;
	public int value;
	
	private int fragileValue;

	Random random = new Random();

	public Player(String name, int id) {
		this.name = name;
		this.id = id;
		this.value = 0;
		this.fragileValue = 0;
	}

	public void turn() {
		Utils.print();
		Utils.print(name+", du bist dran.");
		Utils.input("Drücke <Enter>, um fortzufahren.");
		Utils.print("Du hast einen sicheren Stand von "+this.value+".");
		Utils.print();
		
		String playerInput = "y";
		do {
			if (rollDice()) {
				this.fragileValue = 0; break;
			};
			Utils.print("In dieser Runde hast du bisher "+this.fragileValue+" gewürfelt.");
			playerInput = Utils.input("Möchtest du noch einmal würfeln (yN)? ");
		} while (playerInput.equals("y"));
		Utils.print("Dein Zug ist zu Ende. Die "+this.fragileValue+" werden zu "+this.value+" addiert.");
		this.value += this.fragileValue;
		this.fragileValue = 0;
		Utils.print("Insgesamt hast du nun "+this.value+".");
	}

	private void safeSleep(int millis){
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {}
	}

	public void printWait(String str, int count, int wait) {
		for (int i = 0; i < count+1; i++){
			safeSleep(random.nextInt(100)+wait-50);
			System.out.print(str);
			for (int j = 0; j < i; j++){
				System.out.print(".");
			}
			System.out.print("\r");
		}
		safeSleep(random.nextInt(100)+wait-50);
	}

	public boolean rollDice(){
		printWait("Würfeln", 3, 500);
		int diceResult = random.nextInt(6) + 1;
		Utils.print("Du hast eine "+diceResult+" gewürfelt!");
		safeSleep(444);
		if (diceResult == 6) return true;
		this.fragileValue += diceResult;
		return false;
	}

	public void printWin(){
		printWait("Und gewonnen hat", 4, 333);
		Utils.print();
		Utils.print();
		Utils.print(this.name);
	}
}
