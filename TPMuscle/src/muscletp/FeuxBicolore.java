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
	
	public void attribueCouleurRouge(){
		this.setCouleurActuelle(Couleur.ROUGE);
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

	public static void main(String[] args){
		
		FeuxBicolore f = new FeuxBicolore();
		f.attribueCouleurVerte();
		f.verifCouleur();
	}
}

