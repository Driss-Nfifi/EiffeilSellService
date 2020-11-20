package fr.uge.business;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.gustave.eiffel.banque.Banque;
import com.gustave.eiffel.banque.BanqueServiceLocator;
import com.gustave.eiffel.banque.BanqueSoapBindingStub;

import commun.Panier;
import commun.Utilisateur;
import fr.uge.dao.PanierDao;
import fr.uge.dao.PanierDaoJdbc;
import fr.uge.dao.UtilisateurDao;
import fr.uge.dao.UtilisateurDaoJdbc;
import fr.uge.dao.jdbc.DataSource;
import fr.uge.dao.jdbc.Database;
import fr.uge.dao.jdbc.MySQLDataSource;
import fr.uge.service.location.ServiceLocation;

public class EiffelSellService {
	
	private PanierDao panierDao;
	private UtilisateurDao utilisateurDao;
	private ServiceLocation serviceLocation;
	private Banque service;
	private Database db;
	
	public EiffelSellService() throws ServiceException,RemoteException{
		try {
			DataSource ds = new MySQLDataSource("localhost", "eiffel", "root", "root");
			db = new Database(ds);
			service = new BanqueServiceLocator().getBanque();
			((BanqueSoapBindingStub)service).setMaintainSession(true);
			serviceLocation = new ServiceLocation();
			utilisateurDao = new UtilisateurDaoJdbc(db, serviceLocation);
			panierDao = new PanierDaoJdbc(db, service, serviceLocation);
		} 
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	public boolean ajoutervoiturepanier(int p,int u,int v) {
		return panierDao.AjouterVoiturePanier(p, u, v);
	}
	
	public boolean supprimervoiturepanier(int p,int v) {
		return panierDao.SupprimerVoiturePanier(p, v);
	}
	
	public boolean viderpanier(int p) {
		return panierDao.ViderPanier(p);
	}
	
	public boolean validerachatpanier(int p) throws RemoteException {
		return panierDao.ValiderAchatPanier(p);
	}
	
	public Panier getPanierbyutilisateur(int u) throws RemoteException {
		return panierDao.GetPanierByUtilisateur(u);
	}
	
	public double totalpanier(int p)  throws RemoteException {
		return panierDao.TotalPanier(p);
	}
	
	public boolean nouveauclient(Utilisateur a, double s) {
		return utilisateurDao.NouveauClient(a, s);
	}

}
