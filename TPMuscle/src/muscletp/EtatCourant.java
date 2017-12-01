package muscletp;

public class EtatCourant {
	private PositionVoiture position;
	private SegmentRoute segmentRoute;
	//le sens de deplacement sera definit soit 'D' soit 'G' : vers Droite/vers Gauche
	private String sensDeplacement;
	private double vitesseCourante;

	public PositionVoiture getPosition() {
		return position;
	}
	
	public void setPosition(PositionVoiture position) {
		this.position = position;
	}
	
	public void setVitesseCourante(double vitesseCourante) {
		this.vitesseCourante = vitesseCourante;
	}

	public SegmentRoute getSegmentRoute() {
		return segmentRoute;
	}
	
	public void setSegmentRoute(SegmentRoute segmentRoute) {
		this.segmentRoute = segmentRoute;
	}
	public double getVitesseCourante() {
		return vitesseCourante;
	}
}
