package beans;

public class Marque {

	private int id;
	private String code;
	private String libelle;
	
	public Marque(int id, String code, String libelle) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
	}

	public Marque(String code, String libelle) {
		super();
		this.code = code;
		this.libelle = libelle;
	}
	
	public Marque(int  id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Marque [id=" + id + ", code=" + code + ", libelle=" + libelle + "]";
	}
	
	
	
	
}
