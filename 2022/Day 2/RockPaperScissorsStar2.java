import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RockPaperScissorsStar2 {
	public static void main(String[] args) throws FileNotFoundException {
		File RPSFile = new File("src/rock-paper-scissors.txt");
		Scanner console = new Scanner(RPSFile);
		int score = 0;
		while(console.hasNextLine()) {
			String curRound = console.nextLine();
			int opponentChoice = curRound.charAt(0) - 'A';
			int result = curRound.charAt(2) - 'X';
			score += result * 3;
			score += (opponentChoice + result + 2)%3 + 1;
		}
		console.close();
		System.out.println(score);
	}
}
