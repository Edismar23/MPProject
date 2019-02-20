package Utility;

public class SleepTime {
	public void Esperar(int seg) {
		try {
			Thread.sleep(seg*1000);			
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}	
	}
}
