import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CalorieCounting {

	public static void main(String[] args) throws FileNotFoundException {
		File calorieFile = new File("src/calories.txt");
		Scanner console = new Scanner(calorieFile);
		int mostCalories = 0;
		int curCalories = 0;
		while(console.hasNextLine()) {
			String curFood = console.nextLine();
			if(curFood.length() != 0) {
				int caloriesOfCurFood = Integer.parseInt(curFood);
				curCalories += caloriesOfCurFood;
			} else {
				mostCalories = Math.max(mostCalories, curCalories);
				curCalories = 0;
			}
		}
		mostCalories = Math.max(mostCalories, curCalories);
		console.close();
		System.out.println(mostCalories);
	}

}
