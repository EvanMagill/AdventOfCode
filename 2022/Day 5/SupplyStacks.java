import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SupplyStacks {

	public static void main(String[] args) throws FileNotFoundException {
		File stackFile = new File("src/stacks.txt");
		Scanner console = new Scanner(stackFile);
		List<String> drawing = new ArrayList<String>();
		String curLine = console.nextLine();
		int numStacks = (curLine.length() + 1)/4;
		@SuppressWarnings("unchecked")
		Stack<Character>[] stacks = new Stack[numStacks];
		
		while(!curLine.equals("")) {
			drawing.add(curLine);
			curLine = console.nextLine();
		}
		
		for(int col = 0; col < numStacks; ++col) {
			stacks[col] = new Stack<Character>();
		}
		
		for(int row = drawing.size() - 1; row >= 0; --row) {
			String curRow = drawing.get(row);
			for(int col = 0; col < numStacks; ++col) {
				char curChar = curRow.charAt(col*4 + 1);
				if(curChar != ' ') {
					stacks[col].push(curChar);
				}
			}
		}
		
		while(console.hasNextLine()) {
			console.next();
			int repetitions = console.nextInt();
			console.next();
			int start = console.nextInt();
			console.next();
			int destination = console.nextInt();
			console.nextLine();
			for(int iteration = 0; iteration < repetitions; ++iteration) {
				stacks[destination - 1].push(stacks[start - 1].pop());
			}
		}
		console.close();
		
		for(int col = 0; col < stacks.length; ++col) {
			System.out.print(stacks[col].peek());
		}
	}

}
