package personnages;

import personnages.equipement.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement [] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		assert force > 0;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "Â« " + texte + "Â»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert force > 0;
//		int oldForce = this.force;
//		this.force -= forceCoup;
//		if (this.force > 0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert force < oldForce;
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		if (forceCoup >= 0) {
			force -= forceCoup;
		}
		
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force > 0) {
			parler("Aïe");
		}
		equipementEjecte = ejecterEquipement();
		parler("J'abandonne...");
		
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
		}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			} 
		}
		return equipementEjecte;
	}
		
	
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if (equipements[i] != null) {
					if (equipements[i].equals(Equipement.BOUCLIER)) {
						resistanceEquipement += 8;
					} else if(equipements[i].equals(Equipement.CASQUE)){
						System.out.println("Equipement casque");
						resistanceEquipement += 5;
					}
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private void reEquiper(Equipement eq) {
		this.equipements[this.nbEquipement++]= eq;
		System.out.println("Le soldat " + this.nom +" s'équipe avec un " + eq);
	}
	
	public void sEquiper(Equipement eq) {
		switch(this.nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé");
			break;
		case 1:
			if (eq == this.equipements[0]) {
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
