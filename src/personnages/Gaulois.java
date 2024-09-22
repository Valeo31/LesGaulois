package personnages;


public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		romain.recevoirCoup(force*effetPotion / 3);
	}

	public void boirePotion(int forcePotion) {
		effetPotion += forcePotion; 
		parler("Merci Druide, je sens que ma force est "+ forcePotion + " décuplée.");
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) { //TODO cr�er un main permettant de tester la classe Gaulois 
		
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		
		Druide pano = new Druide("Panoramix", 0, 9);
		
		asterix.prendreParole();
		asterix.parler("Je parle ");
		int force = pano.preparerPotion();
		asterix.boirePotion(force);
		asterix.frapper(new Romain("rom", 7));

		
	}
}
