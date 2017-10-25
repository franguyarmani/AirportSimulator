import java.util.LinkedList;

public class Airport {
	public Runway Runway1;
	public Runway Runway2;
	public LinkedList<Plane> LandingQueue;
	public LinkedList<Plane> TakeOffQueue;
	public int lastLandingNumber;
	public int lastTakeOffNumber;

	public Airport() {
		this.Runway1 = new Runway();
		this.Runway2 = new Runway();
		LandingQueue = new LinkedList<Plane>();
		TakeOffQueue = new LinkedList<Plane>();
		lastLandingNumber = -1;
		lastTakeOffNumber = 0;
	}
	
	public int EvaluateQueues(){
		if(LandingQueue.size()-TakeOffQueue.size()>=4) {
			return 1;
		}
		if(LandingQueue.size()-TakeOffQueue.size()<=-4) {
			return -1;
		}
		return 0; 
	}
	
	public void DirectPlanes(int instructions) {
		if(instructions == 1) {
			Runway1.takeNext(LandingQueue);
			Runway2.takeNext(LandingQueue);
		}
		if(instructions == -1) {
			Runway1.takeNext(TakeOffQueue);
			Runway2.takeNext(TakeOffQueue);
		}
		if(instructions == 0) {
			Runway1.takeNext(LandingQueue);
			Runway2.takeNext(TakeOffQueue);
		}
	}
	public void ReceivePlanes(int[] Landing, int[] TakingOff) {
		
		
		for(int i = 0; i<Landing.length; i++) {
			int LNext = lastLandingNumber + 2;
			Plane temp = new Plane(Landing[i], LNext);
			LandingQueue.add(temp);
			lastLandingNumber = LNext;
		}
		for(int j = 0; j<TakingOff.length; j++) {
			int TNext = lastTakeOffNumber + 2;
			Plane temp = new Plane(TakingOff[j], TNext);
			TakeOffQueue.add(temp);
			lastTakeOffNumber = TNext;
		}
		
	}

}
