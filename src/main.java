import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		Airport Reagan = new Airport();
		try {
			PrintWriter P = new PrintWriter("Output.txt");
			while(input.hasNextLine()) {
				
				int Time = input.nextInt();;
				int Landing = input.nextInt();
				int TakingOff = input.nextInt();
				int[] LandingFlights = new int[Landing];
				int[] TakingOffFlights = new int[TakingOff];
				for (int i = 0; i < Landing; i++) {
					LandingFlights[i] = input.nextInt();
				}
				for (int j = 0; j < TakingOff; j++) {
					TakingOffFlights[j] = input.nextInt();
				}
				input.nextLine();
				
				Reagan.ReceivePlanes(LandingFlights, TakingOffFlights);
				Reagan.DirectPlanes(Reagan.EvaluateQueues());
				
				P.println("The time is "+calcTime(Time));
				P.println("There are "+Reagan.LandingQueue.size()+" planes waiting to land");
				P.println("There are "+Reagan.TakeOffQueue.size()+" planes waiting to take off");
				try {
					if ((Reagan.Runway1.LastPlane.QueueNumber % 2) == 0) {
						P.println("Flight "+Reagan.Runway1.LastPlane.FlightNumber+", queued at "+Reagan.Runway1.LastPlane.QueueNumber+" was cleared to take off on Runway 1");
					}else {
						P.println("Flight "+Reagan.Runway1.LastPlane.FlightNumber+", queued at "+Reagan.Runway1.LastPlane.QueueNumber+" was cleared to land on Runway 1");
					}
				} catch(NullPointerException N) {}
				try {
					if ((Reagan.Runway2.LastPlane.QueueNumber % 2) == 0) {
						P.println("Flight "+Reagan.Runway2.LastPlane.FlightNumber+", queued at "+Reagan.Runway2.LastPlane.QueueNumber+" was cleared to take off on Runway 2");
					}else {
						P.println("Flight "+Reagan.Runway2.LastPlane.FlightNumber+", queued at "+Reagan.Runway2.LastPlane.QueueNumber+" was cleared to land on Runway 2");
					}
					
				} catch(NullPointerException N) {}
				
	            
	        }
			P.close();
		}catch(FileNotFoundException e) {
			System.out.println("No such File");
		}
		
		

	}
	
	public static String calcTime(int Input) {
		if (0 <= Input && Input < 12) {
			String mins = String.format("%02d", 5*Input);
			return "12:"+mins+"pm";
		}
		if (12 <= Input && Input < 24) {
			String mins = String.format("%02d", 5*Input-60);
			return "1:"+mins+"pm";
		}
		return null;
	}

}
