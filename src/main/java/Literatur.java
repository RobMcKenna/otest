import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Literatur{
	
	
	protected String titel;
	protected String isbn;
	protected List<String> autor;
	
	public Literatur(final String titel,final String isbn,final String autor) {
		this.titel  = titel;
		this.isbn   = isbn;
		this.autor = parseAutoren(autor);
	}
	
	public Literatur(){}
	
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public List<String> getAutor() {
		return autor;
	}
	public void setAutor(List<String> autor) {
		this.autor = autor;
	}
	
	public String getAutorString() {
		return String.join(",", autor.toArray(new String[autor.size()]));
	}
	
	public List<String> parseAutoren(String autor) {
		return new ArrayList<String>(Arrays.asList(autor.split(",")));
	}

	
}