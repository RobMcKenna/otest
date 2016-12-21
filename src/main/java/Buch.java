public class Buch extends Literatur{

//	Titel;ISBN-Nummer;Autoren;Kurzbeschreibung

	private static final int TITEL_POSITION  = 0;
	private static final int ISBN_POSITION   = 1;
	private static final int AUTOR_POSITION  = 2;
	private static final int BESCH_POSITION  = 3;
	
	private String beschreibung;
	
	public Buch (final String titel,final String isbn,final String autor,final String beschreibung) {
		super(titel, isbn, autor);
		this.setBeschreibung(beschreibung);
	}

	public Buch (){}
	
	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	@Override
	public String toString() {
		return titel + ";" + isbn + ";" + getAutorString() + ";" + beschreibung;
	}
	
	public static Buch parseBook(final String[] line) {
		Buch buch = null;
		if (line.length == 4) {
			buch = new Buch(line[TITEL_POSITION],
			                line[ISBN_POSITION],
			                line[AUTOR_POSITION],
			                line[BESCH_POSITION]);
		}
		return buch;
	}	
	
}
