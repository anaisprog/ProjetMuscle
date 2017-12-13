package muscletp;

public class FeuxTricolore extends Feux{
	private Couleur couleurActuelle;
	
	public FeuxTricolore(){
		this.type = "FeuxTricolore";
	}
	// Les m�thodes qui suivent permettent de d�finir la couleur du feu
	public void verifCouleur(){
		System.out.println(this.couleurActuelle);
	}
	@Override
	public void attribueCouleurRouge(){
		this.setCouleurActuelle(Couleur.ROUGE);
	}	
	@Override
	public void attribueCouleurOrange(){
		/* Quand un feu tricolore devient ornange la vitesse de la voiture est divis�e par deux*/
		this.setCouleurActuelle(Couleur.ORANGE);
	}
	
	public void attribueCouleurVerte(){
		this.setCouleurActuelle(Couleur.VERT);
	}
	@Override
	public Couleur getCouleurActuelle() {
		return couleurActuelle;
	}

	public void setCouleurActuelle(Couleur couleurActuelle) {
		this.couleurActuelle = couleurActuelle;
	}

	
}
