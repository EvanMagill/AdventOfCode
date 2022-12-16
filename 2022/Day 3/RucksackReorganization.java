import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RucksackReorganization {

	public static void main(String[] args) throws FileNotFoundException {
		File rucksackFile = new File("src/rucksacks.txt");
		Scanner console = new Scanner(rucksackFile);
		long prioritySum = 0;
		while (console.hasNextLine()) {
			String curLine = console.nextLine();
			int halfWay = curLine.length() / 2;
			long[] halves = new long[2];
			int start = 0;
			int stop = halfWay;
			for (int half = 0; half < 2; half++) {
				for (int i = start; i < stop; i++) {
					char curChar = curLine.charAt(i);
					int curPriority = curChar - 'a';
					if (curPriority < 0) {
						curPriority = curChar - 'A' + 26;
					}
					halves[half] |= (1l << curPriority);
				}
				start = halfWay;
				stop = curLine.length();
			}
			long usedTwice = halves[0] & halves[1];
			int priority = 0;
			do {
				priority++;
				usedTwice >>= 1;
			} while (usedTwice > 0);
			prioritySum += priority;
		}
		console.close();
		System.out.println(prioritySum);
	}

}
