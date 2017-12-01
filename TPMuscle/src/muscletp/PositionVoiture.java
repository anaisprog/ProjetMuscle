package muscletp;

public class PositionVoiture {
	private SegmentRoute segmentRoute;
	private double position;
	
	public double getPosition(){
		System.out.println("Segment Route : " + segmentRoute + 
			" Position sur le segment : " + position );
		return position;
	}
 
	public SegmentRoute getSegmentRoute() {
		return segmentRoute;
	}

	public void setSegmentRoute(SegmentRoute segmentRoute) {
		this.segmentRoute = segmentRoute;
	}

	public void setPosition(double position) {
		this.position = position;
	}
	
	
}
