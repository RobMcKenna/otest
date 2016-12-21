import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Zeitschrift extends Literatur{
	
	
//	Titel;ISBN-Nummer;Autor;Erscheinungsdatum
	private static final int TITEL_POSITION   = 0;
	private static final int ISBN_POSITION    = 1;
	private static final int AUTOR_POSITION   = 2;
	private static final int EDATUM_POSITION  = 3;
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	
	private Date pubDate;
	
	public Zeitschrift(final String titel,
	               final String isbn,
	               final String author,
	               final Date pubDate) {
		super(titel, isbn, author);
		this.setPubDate(pubDate);
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	
	@Override
	public String toString() {
		return titel + ";" + isbn + ";" + getAutorString() + ";" + sdf.format(pubDate);
	}
	
	public static Date parseDatum(final String datum) throws ParseException{
		return sdf.parse(datum);
	}
	
	public static Zeitschrift parseZeitschrift(final String[] line) throws ParseException{
		Zeitschrift zeitschr = null;
		if (line.length == 4) {
			zeitschr = new Zeitschrift(line[TITEL_POSITION],line[ISBN_POSITION],line[AUTOR_POSITION],
			                           parseDatum(line[EDATUM_POSITION]));
		}
		return zeitschr;
	}
	
}
