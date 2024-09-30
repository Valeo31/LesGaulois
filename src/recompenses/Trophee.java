package recompenses;

import personnages.Gaulois;
import personnages.equipement.Equipement;

public class Trophee {
	
	private Gaulois gaulois;
	private Equipement equipements;
	
	public Gaulois getGaulois() {
		return gaulois;
	}
	public void setGaulois(Gaulois gaulois) {
		this.gaulois = gaulois;
	}
	public Equipement getEquipements() {
		return equipements;
	}
	public void setEquipements(Equipement equipements) {
		this.equipements = equipements;
	}
	
	public String donnerNom(Gaulois gaulois) {
		return gaulois.getNom();
	}

	
	
}

