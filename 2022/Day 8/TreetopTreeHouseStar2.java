import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TreetopTreeHouseStar2 {
	
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
		
		int bestScenicScore = 0;
		for(int row = 1; row < heightMap.length - 1; ++row) {
			for(int col = 1; col < heightMap[row].length - 1; ++col) {
				int curHeight = heightMap[row][col];
				int visibleUp = 0;
				for(int up = row - 1; up >= 0; --up) {
					++visibleUp;
					if(heightMap[up][col] >= curHeight) {
						break;
					}
				}
				int visibleDown = 0;
				for(int down = row + 1; down < heightMap.length; ++down) {
					++visibleDown;
					if(heightMap[down][col] >= curHeight) {
						break;
					}
				}
				int visibleLeft = 0;
				for(int left = col - 1; left >= 0; --left) {
					++visibleLeft;
					if(heightMap[row][left] >= curHeight) {
						break;
					}
				}
				int visibleRight = 0;
				for(int right = col + 1; right < heightMap[row].length; ++right) {
					++visibleRight;
					if(heightMap[row][right] >= curHeight) {
						break;
					}
				}
				bestScenicScore = Math.max(bestScenicScore, visibleUp * visibleDown * visibleLeft * visibleRight);
			}
		}
		System.out.println(bestScenicScore);
	}
}
