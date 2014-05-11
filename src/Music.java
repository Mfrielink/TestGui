import java.io.File;
import java.util.ArrayList;

public class Music {

	private String song;
	private String newTitle = "";

	File folder = new File("C:/Users/Martijn/Documents/Files");
	File[] listOfFiles = folder.listFiles();

	ArrayList<String> playlist = new ArrayList<String>();

	public void fillPlaylist() {
		for (int i = 0; i < listOfFiles.length; i++) {
			String filename = listOfFiles[i].getName();
			playlist.add(filename);
		}
	}

	public void removeType() { // removes ".mp3" at the end of the fileName
		for (int x = 0; x < playlist.size(); x++) {
			String temp = playlist.get(x);

			for (int p = 0; p < (temp.length() - 4); p++) {
				newTitle = newTitle + temp.charAt(p);

			}
			playlist.set(x, newTitle);
			System.out.println(newTitle);
			newTitle = "";
		}

	}

	public String getSong(int numb) {
		song = playlist.get(numb);
		return song;
	}
}
