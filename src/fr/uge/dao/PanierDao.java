package fr.uge.dao;


import java.rmi.RemoteException;

import commun.Panier;

public interface PanierDao {

	public boolean AjouterVoiturePanier(int idPanier,int idUtilisateur,int idVoiture);
	public boolean SupprimerVoiturePanier(int idPanier,int idVoiture);
	public boolean ViderPanier(int idPanier);
	public boolean ValiderAchatPanier(int idPanier) throws RemoteException;
	public Panier GetPanierByUtilisateur(int idUtilisateur)  throws RemoteException;	
	public double TotalPanier(int idPanier)  throws RemoteException;
}
