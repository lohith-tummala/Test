import java.io.UnsupportedEncodingException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitTime {
	public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
		
		System.setProperty("webdriver.chrome.driver", "/users/lohith.tummala/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		Sample sample = new Sample();
		Set<String> inc = sample.getIncidents(driver);
//		for(String in : inc) {
//			System.out.println(in);
//		}
//		System.out.println(inc.size());
	}
	
	
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		
//		
//		
//		Calendar now = Calendar.getInstance();
//		now.add(Calendar.MINUTE, 1);
//		
//		//SimpleDateFormat df = new SimpleDateFormat("HH:mm");
//		// AM/PM format
//		SimpleDateFormat df = new SimpleDateFormat("hh:mm aa");
//
//		System.out.println(df.format(now.getTime()));
//		System.out.println("Started");
//	
//		Timer timer = new Timer();
//		TimerTask tt = new TimerTask() {
//			public void run() {
//					System.out.println("1 min completed");
//			}
//		};
//		 timer.schedule(tt, now.getTime());
//	}

}
