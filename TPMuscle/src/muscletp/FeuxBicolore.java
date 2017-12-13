package muscletp;

public class FeuxBicolore extends Feux{
	public FeuxBicolore(){
		this.type = "FeuxBicolore";
	}
	private Couleur couleurActuelle;
	
	// Les methodes qui suivent permettent de definir la couleur du feu
	public void verifCouleur(){
		System.out.println(this.couleurActuelle);
	}
	@Override
	public void attribueCouleurRouge(){
		this.setCouleurActuelle(Couleur.ROUGE);
	}	
	@Override
	public void attribueCouleurOrange(){
		this.setCouleurActuelle(Couleur.ORANGE);
	}
	@Override
	public Couleur getCouleurActuelle() {
		return couleurActuelle;
	}

	public void setCouleurActuelle(Couleur couleurActuelle) {
		this.couleurActuelle = couleurActuelle;
	}
}

