import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RopeBridge {
	
	public static class Head {
		public int x;
		public int y;
		
		public Head() {
			x = 0;
			y = 0;
		}
	}
	
	public static class Tail {
		private int x;
		private int y;
		private Set<String> visited;
		
		public Tail() {
			x = 0;
			y = 0;
			visited = new HashSet<String>();
		}
		
		public void adjust(int headX, int headY) {
			int xDifference = headX - x;
			int yDifference = headY - y;
			if(Math.abs(xDifference) == 2) {
				x += xDifference/2;
				y = headY;
			}else if(Math.abs(yDifference) == 2) {
				x = headX;
				y += yDifference/2;
			}
			visited.add(x + "," + y);
		}
		
		public int getNumVisited() {
			return visited.size();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File ropeMoveFile = new File("src/rope-moving-instructions.txt");
		Scanner console = new Scanner(ropeMoveFile);
		Head head = new Head();
		Tail tail = new Tail();
		
		while(console.hasNextLine()) {
			String direction = console.next();
			int repetitions = console.nextInt();
			switch(direction) {
				case "U":
					for(int i = 0; i < repetitions; ++i) {
						tail.adjust(head.x, ++head.y);
					}
					break;
				case "D":
					for(int i = 0; i < repetitions; ++i) {
						tail.adjust(head.x, --head.y);
					}
					break;
				case "L":
					for(int i = 0; i < repetitions; ++i) {
						tail.adjust(--head.x, head.y);
					}
					break;
				case "R":
					for(int i = 0; i < repetitions; ++i) {
						tail.adjust(++head.x, head.y);
					}
					break;
			}
			console.nextLine();
		}
		
		console.close();
		System.out.println(tail.getNumVisited());
	}
}
