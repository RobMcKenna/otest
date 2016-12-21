import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VERW {

	private static final String AUTOR_FILE = "src/main/resources/data/autoren.csv";
	private static final String ZEITSCHRIFT_FILE = "src/main/resources/data/zeitschriften.csv";
	private static final String BUCH_FILE = "src/main/resources/data/buecher.csv";

	List<Literatur> Literaturliste = new ArrayList<Literatur>();
	List<Autor> Autorliste = new ArrayList<Autor>();

	public static void main(String[] args) throws IOException, ParseException {
		VERW verwaltung = new VERW();

		// Einlesen der CSV Dateien
		verwaltung.getBuecher();
		verwaltung.getAutoren();
		verwaltung.getZeitschriften();

		// Ausgabe aller Zeitschriften und Bücher
		verwaltung.printListe();

		// Anhand einer ISBN Werk ausgeben falls vorhanden
		String suchISBN = ("2365-5632-7854");
		// String suchISBN =("9999-9999-9999");
		if (verwaltung.ISBN_Suche(suchISBN) != null) {
			System.out.println("Gefundenes Werk: " + verwaltung.ISBN_Suche(suchISBN).toString());
		} else {
			System.out.println("Kein Werk mit der ISBN: " + suchISBN + " gefunden.");
		}

		// Anhand eines Autors Werke finden
		String suchAutorNN = ("Paul");
		String suchAutorVN = ("Walter");
		// String suchAutorNN=("Gamma");
		verwaltung.print_nach_Autoren_Suche(verwaltung.getEmailbyNames(suchAutorVN, suchAutorNN));

		// Bücher und Zeitschriften sortiert ausgeben
		verwaltung.TitelSort();
		verwaltung.printListe();
	}

	private Literatur ISBN_Suche(String isbn) {
		Literatur werk = null;
		for (Literatur elem : Literaturliste) {
			if (elem.isbn.equals(isbn)) {
				werk = elem;
				break;
			}
		}
		return werk;
	}

	private void print_nach_Autoren_Suche(String email) {
		for (Literatur elem : Literaturliste) {
			if (elem.autor.contains(email)) {
				if (elem instanceof Buch) {
					System.out.println("Buch: " + elem.toString());
				} else {
					System.out.println("Zeitschrift: " + elem.toString());
				}
			}
		}
	}

	private String getEmailbyNames(String vname, String nname) {
		String email = null;
		for (Autor elem : Autorliste) {
			if ((elem.getVorName().equals(vname)) && (elem.getNachname().equals(nname))) {
				email = elem.getEmail();
			}
		}
		return email;
	}

	private void printListe() {
		for (Literatur elem : Literaturliste) {
			if (elem instanceof Buch) {
				System.out.println("Buch: " + elem.toString());
			} else {
				System.out.println("Zeitschrift: " + elem.toString());
			}
		}
	}

	private void getBuecher() throws IOException {
		DateiLesen fileS = new DateiLesen(BUCH_FILE);
		List<String[]> list = fileS.getLines();
		boolean skipheader = true;
		for (String[] elem : list) {
			if (skipheader) {
				skipheader = false;
			} else {
				Literaturliste.add(Buch.parseBook(elem));
			}
		}
	}

	private void getAutoren() throws IOException {
		DateiLesen fileS = new DateiLesen(AUTOR_FILE);
		List<String[]> list = fileS.getLines();
		boolean skipheader = true;
		for (String[] elem : list) {
			if (skipheader) {
				skipheader = false;
			} else {
				Autorliste.add(Autor.parseAutor(elem));
			}
		}
	}

	private void getZeitschriften() throws IOException, ParseException {
		DateiLesen fileS = new DateiLesen(ZEITSCHRIFT_FILE);
		List<String[]> list = fileS.getLines();
		boolean skipheader = true;
		for (String[] elem : list) {
			if (skipheader) {
				skipheader = false;
			} else {
				Literaturliste.add(Zeitschrift.parseZeitschrift(elem));
			}
		}

	}

	private void TitelSort() {
		Literaturliste.sort(getTitelComparator());
	}

	private static Comparator<Literatur> getTitelComparator() {
		Comparator<Literatur> byTitel = new Comparator<Literatur>() {
			@Override
			public int compare(Literatur o1, Literatur o2) {
				return o1.getTitel().compareTo(o2.getTitel());
			}
		};
		return byTitel;
	}

}
