package fr.uge.dao;

import commun.Utilisateur;
import fr.uge.dao.jdbc.Database;
import fr.uge.service.location.IServiceLocation;

public class UtilisateurDaoJdbc implements UtilisateurDao{

	
	private Database db;
	private IServiceLocation serviceLocation;

	public UtilisateurDaoJdbc(Database db, IServiceLocation serviceLocation) {
		super();
		this.db = db;
		this.serviceLocation = serviceLocation;
	}

	
	@Override
	public boolean NouveauClient(Utilisateur c, double solde) {
		if(db.insert("utilisateur", c.getIdUtilisateur(),c.getNomU(),c.getPrenomU(),c.getEmailU(),c.getAdressU(),c.getTelephoneU(),c.getMdp(),1)>0) {
			if (db.insert("comptebancaire", c.getIdUtilisateur(), solde)>0) return true;
			return false;
		}
		return false;
	
	}


}
