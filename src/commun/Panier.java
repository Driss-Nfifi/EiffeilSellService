package commun;

import java.io.Serializable;

public class Panier implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPanier;
	private Voiture voiture;
	private int idUtilisateur;
	private double prixTotal;
	
	public Panier() {
		
	}

	public Panier(int idPanier, Voiture voiture, int idUtilisateur, double prixTotal) {
		super();
		this.idPanier = idPanier;
		this.voiture = voiture;
		this.idUtilisateur = idUtilisateur;
		this.prixTotal = prixTotal;
	}

	public int getIdPanier() {
		return idPanier;
	}

	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Panier [idPanier=" + idPanier + ", voiture=" + voiture + ", idUtilisateur=" + idUtilisateur
				+ ", prixTotal=" + prixTotal + "]";
	}

	
}