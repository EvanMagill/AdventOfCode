import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CalorieCountingStar2 {

	public static void main(String[] args) throws FileNotFoundException {
		File calorieFile = new File("src/calories.txt");
		Scanner console = new Scanner(calorieFile);
		int[] topElves = new int[3];//With a value of 3, solves second star. With a value of 1, solves first star.
		int curCalories = 0;
		while(console.hasNextLine()) {
			String curFood = console.nextLine();
			if(curFood.length() != 0) {
				int caloriesOfCurFood = Integer.parseInt(curFood);
				curCalories += caloriesOfCurFood;
			} else {
				if(curCalories > topElves[topElves.length - 1]) {
					topElves[topElves.length - 1] = curCalories;
					for(int i = topElves.length - 1; i > 0; i --) {
						if(topElves[i] > topElves[i-1]) {
							int temp = topElves[i];
							topElves[i] = topElves[i-1];
							topElves[i - 1] = temp;
						}else {
							break;
						}
					}
				}
				curCalories = 0;
			}
		}
		int total = 0;
		for(int i = 0; i < topElves.length; i ++) {
			total += topElves[i];
		}
		System.out.println(total);
	}

}
