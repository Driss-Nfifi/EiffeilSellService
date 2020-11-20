package fr.uge.service.location;

import java.rmi.RemoteException;
import java.util.List;

import commun.Avis;
import commun.DemandeLocation;
import commun.ListeAttente;
import commun.Location;
import commun.Notification;
import commun.Role;
import commun.Utilisateur;
import commun.Voiture;

public interface IServiceLocation {


	public boolean ModifierVoiture(Voiture v) throws RemoteException;
	public Voiture GetVoitureById(int Voiture) throws RemoteException;
	public boolean DisponibliteVoiture(int idVoiture) throws RemoteException;
	public List<Voiture> ListVoiture() throws RemoteException;
	public List<Voiture> ListVoitureByMarque(String marque) throws RemoteException;
	public List<Voiture> ListVoitureByType(String type) throws RemoteException;
	public List<Voiture> ListVoiturePretEtreVendu() throws RemoteException;
	public List<Voiture> RechercherVoitureByKeyWord(String key) throws RemoteException;

	public String Authentification(String email,String password)  throws RemoteException;
	public Utilisateur GetUtilisateurById(int id)  throws RemoteException;
	public Utilisateur GetUtilisateurByEmail(String email)  throws RemoteException;
	
	public void NotifierUtilisateur(int IdUtilisateur,String message)  throws RemoteException;
	public Notification GetNotificationById(int idNotification)  throws RemoteException;
	public List<Notification> GetNotificationByUtilisateur(int idUtilisateur)  throws RemoteException;
	
}

