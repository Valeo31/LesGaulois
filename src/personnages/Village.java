package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois [] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int numero) {
//		if (numero>=nbVillageois) {
//			System.out.println("Numéro invalide!");
//		} else {
//		System.out.println("Le villageois recherché est : " + villageois[numero]);
		return villageois[numero];
		//}
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + this.chef.getNom() + " vivent les légendaires gaulois : ");
		for (int i =0; i<this.nbVillageois; i++) {
			System.out.println("- "+villageois[i].getNom());
		}
	}
	
	public String getNom() {
		return nom;
	}
	
	public static void main(String[] args) {
		Village ville1 = new Village("Village des Irréductibles", 30);
		
		//Gaulois gaulois = ville1.trouverHabitant(30);
		//On obtient une exception car le tableau contient au maximum 30 villageois et que l'on essaye d'accéder au 31e
		
		Chef chef = new Chef("Abracadabrix", 6, ville1);
		ville1.setChef(chef);
		Gaulois asterix = new Gaulois("Asterix",8);
		ville1.ajouterHabitant(asterix);
		
		//Gaulois gaulois = ville1.trouverHabitant(1);
		//System.out.println(gaulois);
		//On obtient null : la case selectionnée est vide et par defaut initialisée a null
		
		Gaulois obelix = new Gaulois("Obelix",30);
		ville1.ajouterHabitant(obelix);
		ville1.afficherVillageois();
	}
}
