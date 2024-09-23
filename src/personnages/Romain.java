package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		assert force > 0;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
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
		assert force > oldForce;
	}
	
	public static void main(String[] args) {
		
		Romain rom = new Romain("Rom", 6);
		rom.prendreParole();
		rom.parler("Bonjour je suis moi");
		rom.recevoirCoup(7);
		
		
	}
}
