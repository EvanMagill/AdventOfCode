import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CampCleanup {

	public static void main(String[] args) throws FileNotFoundException {
		File cleaningPairFile = new File("src/cleaning-pairs.txt");
		Scanner console = new Scanner(cleaningPairFile);
		int engulfed = 0;
		while(console.hasNextLine()) {
			String[] numberStrings = console.nextLine().split("[,-]");
			int[] numbers = new int[4];
			for(int i = 0; i < numbers.length; i ++) {
				numbers[i] = Integer.parseInt(numberStrings[i]);
			}
			if(numbers[0] == numbers[2] || numbers[1] == numbers[3]) {//start or end shared, full overlap guaranteed.
				engulfed ++;
			}else if(numbers[0] > numbers[2]) {
				if(numbers[1] <= numbers[3]) {
					engulfed ++;
				}
			}else {
				if(numbers[1] >= numbers[3]) {
					engulfed ++;
				}
			}
		}
		console.close();
		System.out.println(engulfed);
	}

}
