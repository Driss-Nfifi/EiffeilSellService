package fr.uge.service.location;

import java.rmi.RemoteException;
import java.util.List;

import commun.ILocationService;
import commun.Notification;
import commun.Utilisateur;
import commun.Voiture;

public class ServiceLocation implements IServiceLocation{

	private ILocationService service;
	@Override
	public boolean ModifierVoiture(Voiture v) throws RemoteException {
		
		return service.ModifierVoiture(v);
	}

	@Override
	public Voiture GetVoitureById(int Voiture) throws RemoteException {
		
		return service.GetVoitureById(Voiture);
	}

	@Override
	public boolean DisponibliteVoiture(int idVoiture) throws RemoteException {
		
		return service.DisponibliteVoiture(idVoiture);
	}

	@Override
	public List<Voiture> ListVoiture() throws RemoteException {
		
		return service.ListVoiture();
	}

	@Override
	public List<Voiture> ListVoitureByMarque(String marque) throws RemoteException {
		
		return service.ListVoitureByMarque(marque);
	}

	@Override
	public List<Voiture> ListVoitureByType(String type) throws RemoteException {
		
		return service.ListVoitureByType(type);
	}

	@Override
	public List<Voiture> ListVoiturePretEtreVendu() throws RemoteException {
		
		return service.ListVoiturePretEtreVendu();
	}

	@Override
	public List<Voiture> RechercherVoitureByKeyWord(String key) throws RemoteException {
		
		return service.RechercherVoitureByKeyWord(key);
	}

	@Override
	public String Authentification(String email, String password) throws RemoteException {
		
		return service.Authentification(email, password);
	}

	@Override
	public Utilisateur GetUtilisateurById(int id) throws RemoteException {
		
		return service.GetUtilisateurById(id);
	}

	@Override
	public void NotifierUtilisateur(int IdUtilisateur, String message) throws RemoteException {
		service.NotifierUtilisateur(IdUtilisateur, message);
		
	}

	@Override
	public Notification GetNotificationById(int idNotification) throws RemoteException {
		
		return service.GetNotificationById(idNotification);
	}

	@Override
	public List<Notification> GetNotificationByUtilisateur(int idUtilisateur) throws RemoteException {
		return service.GetNotificationByUtilisateur(idUtilisateur);
	}

}
