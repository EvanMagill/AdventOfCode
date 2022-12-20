import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NoSpaceLeftOnDeviceStar2 {

	public static class Directory {
		private Map<String, Directory> subDirectories;
		private Directory superDirectory;
		private int directFileSize;
		private int size;
		
		public void addDirectory(String name) {
			Directory directory = new Directory(this);
			subDirectories.put(name, directory);
		}
		
		public void addFile(int fileSize) {
			directFileSize += fileSize;
		}
		
		public Directory() {
			subDirectories = new HashMap<String, Directory>();
			directFileSize = 0;
			superDirectory = null;
			size = -1;
		}
		
		private Directory(Directory superDirectory) {
			subDirectories = new HashMap<String, Directory>();
			directFileSize = 0;
			this.superDirectory = superDirectory;
			size = -1;
		}
		
		public Directory cd(String name) {
			if(name.equals("..")) {
				return superDirectory;
			}
			return subDirectories.get(name);
		}
		
		public int size() {
			if(size == -1) {
				size = 0;
				size += directFileSize;
				for(String directoryName : subDirectories.keySet()) {
					size += subDirectories.get(directoryName).size();
				}
			}
			return size;
		}
		
		public int smallestOverThreshold(int threshold) {
			int result = size();
			if(result < threshold) {
				return Integer.MAX_VALUE;
			}
			for(String directoryName : subDirectories.keySet()) {
				result = Math.min(subDirectories.get(directoryName).smallestOverThreshold(threshold), result);
			}
			return result;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File terminalOutputFile = new File("src/terminal-output.txt");
		Scanner console = new Scanner(terminalOutputFile);
		Directory overallDirectory = new Directory();
		Directory curDirectory = overallDirectory;
		console.nextLine();
		while(console.hasNextLine()) {
			String firstToken = console.next();
			if(firstToken.equals("$")) {
				if(console.next().equals("cd")) {
					curDirectory = curDirectory.cd(console.next());
				}
			}else if(firstToken.equals("dir")) {
				curDirectory.addDirectory(console.next());
			}else {
				curDirectory.addFile(Integer.parseInt(firstToken));
			}
			console.nextLine();
		}
		console.close();
		int unusedSpace = 70000000 - overallDirectory.size();
		int neededSpace = 30000000 - unusedSpace;
		System.out.println(overallDirectory.smallestOverThreshold(neededSpace));
	}

}
