import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TreetopTreeHouse {
	
	public static void main(String[] args) throws FileNotFoundException {
		File treeHeightFile = new File("src/tree-height-map.txt");
		Scanner console = new Scanner(treeHeightFile);
		ArrayList<String> input = new ArrayList<String>();
		while(console.hasNextLine()) {
			input.add(console.nextLine());
		}
		console.close();
		int[][] heightMap = new int[input.size()][input.get(0).length()];
		
		for(int row = 0; row < heightMap.length; ++row) {//populate array with data from input
			String curRow = input.get(row);
			for(int col = 0; col < heightMap[row].length; ++col) {
				heightMap[row][col] = curRow.charAt(col) - '0';
			}
		}
		
		boolean[][] visible = new boolean[heightMap.length][heightMap[0].length];
		
		int dir = 1;
		int colStart = 0;
		for(int row = 0; row < visible.length;) {//horizontal passes
			int highest = -1;
			for(int col = colStart; col >= 0 && col < visible[row].length; col += dir) {
				int curHeight = heightMap[row][col];
				if(curHeight > highest) {
					highest = curHeight;
					visible[row][col] = true;
					if(highest == 9) {
						break;
					}
				}
			}
			if(dir == 1) {
				colStart = visible[row].length - 1;
				dir = -1;
			}else {
				colStart = 0;
				dir = 1;
				++row;
			}
		}
		
		int rowStart = 0;
		for(int col = 0; col < visible[0].length;) {//vertical passes
			int highest = -1;
			for(int row = rowStart; row >= 0 && row < visible.length; row += dir) {
				int curHeight = heightMap[row][col];
				if(curHeight > highest) {
					highest = curHeight;
					visible[row][col] = true;
					if(highest == 9) {
						break;
					}
				}
			}
			if(dir == 1) {
				rowStart = visible.length - 1;
				dir = -1;
			}else {
				rowStart = 0;
				dir = 1;
				++col;
			}
		}
		
		int visibleCount = 0;
		for(int row = 0; row < visible.length; ++row) {
			for(int col = 0; col < visible[row].length; ++col) {
				if(visible[row][col]) {
					++visibleCount;
				}
			}
		}
		System.out.println(visibleCount);
		
	}
}
