import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.ID3v1;

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
		try {
			getSongTime();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TagException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public void getSongTime() throws IOException, TagException {

		File sourceFile = new File("C:/Users/Martijn/Documents/Files/Sixteen Bars.mp3");
		MP3File mp3file = new MP3File(sourceFile);
		ID3v1 tag = mp3file.getID3v1Tag();
		System.out.println(tag.getArtist());

	}

	public String getSong(int numb) {
		song = playlist.get(numb);
		return song;
	}
}
