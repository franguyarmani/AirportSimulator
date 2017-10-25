import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;


public class InputRandomizer {
	public static void main(String[] args) {
		Random R = new Random();
		try {
			PrintWriter P = new PrintWriter("input.txt");
			for (int i = 0; i <= 23; i++) {
				int landing = R.nextInt(4);
				int takingoff = R.nextInt(4);
				String line = i+" "+landing+" "+takingoff;
				for(int j = 0; j < landing; j++) {
					line = line+" "+String.format("%04d", R.nextInt(4000));
				}
				for(int j = 0; j < takingoff; j++) {
					line = line+" "+String.format("%04d", R.nextInt(4000));
				}
				P.println(line);
			
				
			}
			P.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
	

}
