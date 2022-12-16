import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RucksackReorganizationStar2 {

	public static void main(String[] args) throws FileNotFoundException {
		File rucksackFile = new File("src/rucksacks.txt");
		Scanner console = new Scanner(rucksackFile);
		long prioritySum = 0;
		while (console.hasNextLine()) {
			long[] elves = new long[3];

			for (int elf = 0; elf < 3; elf++) {
				String curLine = console.nextLine();
				for (int i = 0; i < curLine.length(); i++) {
					char curChar = curLine.charAt(i);
					int curPriority = curChar - 'a';
					if (curPriority < 0) {
						curPriority = curChar - 'A' + 26;
					}
					elves[elf] |= (1l << curPriority);
				}
			}
			long usedThrice = elves[0] & elves[1] & elves[2];
			int priority = 0;
			do {
				priority++;
				usedThrice >>= 1;
			} while (usedThrice > 0);
			prioritySum += priority;
		}
		console.close();
		System.out.println(prioritySum);
	}

}
