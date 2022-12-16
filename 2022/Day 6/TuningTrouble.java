import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TuningTrouble {

	public static void main(String[] args) throws FileNotFoundException {
		File dataFile = new File("src/datastream-buffer.txt");
		Scanner console = new Scanner(dataFile);
		String datastream = console.nextLine();
		console.close();
		int position = 0;
		int nonRepeatedCharacters = 0;
		while(nonRepeatedCharacters < 4) {
			++position;
			++nonRepeatedCharacters;
			char positionChar = datastream.charAt(position);
			for(int test = nonRepeatedCharacters - 1; test > 0; --test) {
				if(positionChar == datastream.charAt(position-test)) {
					nonRepeatedCharacters = test;
				}
			}
		}
		System.out.println(position + 1);
	}

}
