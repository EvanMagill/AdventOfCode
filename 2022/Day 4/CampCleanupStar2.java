import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CampCleanupStar2 {

	public static void main(String[] args) throws FileNotFoundException {
		File cleaningPairFile = new File("src/cleaning-pairs.txt");
		Scanner console = new Scanner(cleaningPairFile);
		int overlapping = 0;
		while(console.hasNextLine()) {
			String[] numberStrings = console.nextLine().split("[,-]");
			int[] numbers = new int[4];
			for(int i = 0; i < numbers.length; i ++) {
				numbers[i] = Integer.parseInt(numberStrings[i]);
			}
			if(numbers[1] >= numbers[2] && numbers[3] >= numbers[0]) {
				overlapping ++;
			}
		}
		console.close();
		System.out.println(overlapping);
	}

}
