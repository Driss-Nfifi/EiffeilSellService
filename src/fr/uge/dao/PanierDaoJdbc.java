package fr.uge.dao;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import com.gustave.eiffel.banque.Banque;

import commun.Panier;
import commun.Voiture;
import fr.uge.dao.jdbc.Database;
import fr.uge.service.location.IServiceLocation;
import fr.uge.service.location.ServiceLocation;

public class PanierDaoJdbc implements PanierDao{

	private Database db;
	private Banque banque;
	private ServiceLocation serviceLocation;
	
	
	public PanierDaoJdbc(Database db, Banque banque, ServiceLocation serviceLocation) {
		super();
		this.db = db;
		this.banque = banque;
		this.serviceLocation = serviceLocation;
	}
	@Override
	public boolean AjouterVoiturePanier(int idPanier, int idUtilisateur, int idVoiture) {
		db.insert("panier", idPanier, idUtilisateur, idVoiture);
		return true;
	}
	@Override
	public boolean SupprimerVoiturePanier(int idPanier, int idVoiture) {
		db.delete("panier", "idPanier", idPanier, "idVoiture", idVoiture);
		return true;
	}
	@Override
	public boolean ViderPanier(int idPanier) {
		if (db.delete("panier", "idPanier", idPanier)>0) return true;
		return false;
	}
	@Override
	public boolean ValiderAchatPanier(int idPanier) throws RemoteException {
		double total = TotalPanier(idPanier);
		if (banque.soldesuffisant(idPanier, total)) {
			banque.validerachat(idPanier, total);
			Voiture v = GetPanierByUtilisateur(idPanier).getVoiture();
			
		
			v.setDisponible(false);
			serviceLocation.ModifierVoiture(v);
			
			ViderPanier(idPanier);
			return true;
		}
		return false;
	}
	
	public Panier mapPanier(String data[][]) throws RemoteException{
		if(data==null) return null;
		Voiture v = serviceLocation.GetVoitureById(Integer.parseInt(data[1][2]));
		return new Panier(Integer.parseInt(data[1][1]),v,Integer.parseInt(data[1][3]), v.getPrixVoiture());
	}
	
	
	
	@Override
	public Panier GetPanierByUtilisateur(int idUtilisateur) throws RemoteException {
		
		return mapPanier(db.select("panier", "idUtilisateur",idUtilisateur));
	}
	@Override
	public double TotalPanier(int idPanier) throws RemoteException {
		 
		return mapPanier(db.select("panier", "idPanier", idPanier)).getPrixTotal();
	}
		
	

}
