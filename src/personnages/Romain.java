package personnages;

import personnages.equipement.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement [] equipement = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		assert force > 0;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "Â« " + texte + "Â»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert force > 0;
		int oldForce = this.force;
		this.force -= forceCoup;
		if (this.force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert force < oldForce;
	}
	
	private void reEquiper(Equipement eq) {
		this.equipement[this.nbEquipement++]= eq;
		System.out.println("Le soldat " + this.nom +" s'équipe avec un " + eq);
	}
	
	private void sEquiper(Equipement eq) {
		switch(this.nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé");
			break;
		case 1:
			if (eq == this.equipement[0]) {
				System.out.println("Le soldat " + this.nom + " possède déjà un " + eq);
			} else {
				reEquiper(eq);
			}
			break;
		case 0:
			reEquiper(eq);
			break;
		}
	}
	
	public static void main(String[] args) {
		
		Romain rom = new Romain("Rom", 6);
		rom.prendreParole();
		rom.parler("Bonjour je suis moi");
		rom.recevoirCoup(7);
		rom.sEquiper(Equipement.CASQUE);
		rom.sEquiper(Equipement.CASQUE);
		rom.sEquiper(Equipement.BOUCLIER);
		rom.sEquiper(Equipement.CASQUE);
	}
}
