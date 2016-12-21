import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DateiLesen {

	private final File file;

	public DateiLesen(final String fileName) {
		file = new File(fileName);
	}

	public List<String[]> getLines() throws IOException {
		List<String[]> daten = new LinkedList<String[]>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String zeile;
			while ((zeile = br.readLine()) != null) {
				daten.add(zeile.split(";"));
			}
		}
		return daten;
	}
}