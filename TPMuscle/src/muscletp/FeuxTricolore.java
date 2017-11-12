package muscletp;

public class FeuxTricolore extends Feux{
	private Couleur couleurActuelle;
	
	// Les m�thodes qui suivent permettent de d�finir la couleur du feu
	public void verifCouleur(){
		System.out.println(this.couleurActuelle);
	}
	
	public void attribueCouleurRouge(){
		this.setCouleurActuelle(Couleur.ROUGE);
	}	
	
	public void attribueCouleurOrange(){
		this.setCouleurActuelle(Couleur.ORANGE);
	}
	
	public void attribueCouleurVerte(){
		this.setCouleurActuelle(Couleur.VERT);
	}
	
	
	public Couleur getCouleurActuelle() {
		return couleurActuelle;
	}

	public void setCouleurActuelle(Couleur couleurActuelle) {
		this.couleurActuelle = couleurActuelle;
	}

	
}
