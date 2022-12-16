import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SupplyStacksStar2 {

	public static void main(String[] args) throws FileNotFoundException {
		File stackFile = new File("src/stacks.txt");
		Scanner console = new Scanner(stackFile);
		List<String> drawing = new ArrayList<String>();
		String curLine = console.nextLine();
		int numStacks = (curLine.length() + 1)/4;
		String[] stacks = new String[numStacks];
		
		while(!curLine.equals("")) {
			drawing.add(curLine);
			curLine = console.nextLine();
		}
		
		for(int row = drawing.size() - 1; row >= 0; --row) {
			String curRow = drawing.get(row);
			for(int col = 0; col < numStacks; ++col) {
				char curChar = curRow.charAt(col*4 + 1);
				if(curChar != ' ') {
					stacks[col] += curChar;
				}
			}
		}
		
		while(console.hasNextLine()) {
			console.next();
			int crates = console.nextInt();
			console.next();
			int start = console.nextInt();
			console.next();
			int destination = console.nextInt();
			console.nextLine();
			stacks[destination-1] += stacks[start-1].substring(stacks[start-1].length()-crates);
			stacks[start-1] = stacks[start-1].substring(0, stacks[start-1].length()-crates);
		}
		console.close();
		
		for(int col = 0; col < stacks.length; ++col) {
			System.out.print(stacks[col].charAt(stacks[col].length()-1));
		}
	}

}
