import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) throws FileNotFoundException {
		File RPSFile = new File("src/rock-paper-scissors.txt");
		Scanner console = new Scanner(RPSFile);
		int score = 0;
		while(console.hasNextLine()) {
			String curRound = console.nextLine();
			int opponentChoice = curRound.charAt(0) - 'A' + 1;
			int myChoice = curRound.charAt(2) - 'X' + 1;
			score += myChoice;
			int result = (opponentChoice + 3 - myChoice)%3;
			switch(result) {
				case 0:
					score += 3;
					break;
				case 2:
					score += 6;
			}
		}
		console.close();
		System.out.println(score);
	}
}
