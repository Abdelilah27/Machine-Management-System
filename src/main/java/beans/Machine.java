package beans;

import java.util.Date;

public class Machine {

    private int id;
    private String reference;
    private Date dateAchat;
    private double prix;
    private int idMarque;
    private Marque marque;
    private int count;
    
    
   
    
    public Machine(int id, String reference, Marque marque, int count) {
		super();
		this.id = id;
		this.reference = reference;
		this.marque = marque;
		this.count = count;
	}



	public Machine(String reference, Marque marque, int count) {
		super();
		this.reference = reference;
		this.marque = marque;
		this.count = count;
	}



	public Machine(int id, String reference, Date dateAchat, double prix, int idMarque) {
        super();
        this.id = id;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.idMarque = idMarque;
    }
    
    
    
    public Machine(String reference, Date dateAchat, double prix, Marque marque) {
		super();
		this.reference = reference;
		this.dateAchat = dateAchat;
		this.prix = prix;
		this.marque = marque;
	}



	public Machine(int id, String reference, Date dateAchat, double prix, Marque marque) {
		super();
		this.id = id;
		this.reference = reference;
		this.dateAchat = dateAchat;
		this.prix = prix;
		this.marque = marque;
	}



	public Machine(String reference, Date dateAchat, double prix, int idMarque) {
        super();
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.idMarque = idMarque;
    }

    public Machine(String reference, Date dateAchat, double prix) {
        super();
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    

    public int getIdMarque() {
		return idMarque;
	}

	public void setIdMarque(int idMarque) {
		this.idMarque = idMarque;
	}

	@Override
    public String toString() {
        return this.id + " " + this.reference;
    }

}
