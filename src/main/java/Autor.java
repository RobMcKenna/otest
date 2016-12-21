public class Autor {

	
	private static final int EMAIL_POSITION   = 0;
	private static final int NACHNAME_POSITION = 1;
	private static final int VORNAME_POSITION    = 2;
	
	private String email;
	private String nachname;
	private String vorname;
	
	public Autor(String email, String nname, String vname) {
		this.email    = email;
		this.nachname = nname;
		this.vorname  = vname;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nname) {
		this.nachname = nname;
	}
	public String getVorName() {
		return vorname;
	}
	public void setName(String vname) {
		this.vorname = vname;
	}
	
	public static Autor parseAutor(final String[] line) {
		Autor autor = null;
		if (line.length == 3) {
			autor = new Autor(line[EMAIL_POSITION], line[NACHNAME_POSITION], line[VORNAME_POSITION]);
		}
		return autor;
	}	
}
