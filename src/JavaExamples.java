import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;


public class JavaExamples {

	public JavaExamples() {
		// TODO Auto-generated constructor stub
		this.run();
	}
	ArrayList<String> songList = new ArrayList<String>();
	private void run() {
		// TODO Auto-generated method stub
		getSongsFromFile();
		Collections.sort(songList);
		System.out.println(songList);
	}
	

	private void getSongsFromFile() {
		// TODO Auto-generated method stub
		try {
			File file = new File("C:\\Documents and Settings\\tabsh02\\Desktop\\songs.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null) {
				addSongsToList(line);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	private void addSongsToList(String lineToParse) {
		// TODO Auto-generated method stub
		String[] tokens = lineToParse.split("/");
		songList.add(tokens[0]);
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String str = null;
		
		System.out.println(str.trim());
		new JavaExamples();
	}

}
