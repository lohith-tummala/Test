import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sample {
	
	static int j = 1;
	static Set<String> ince = new HashSet<String>();

	public Set<String> getIncidents(WebDriver driver) throws InterruptedException, UnsupportedEncodingException {

		driver.get("https://hi.service-now.com/hi_login.do");

		String user = "ashish.pursani";
		// System.out.print("Enter Password : ");
		String pass = "S3NoaXRpakAyMzA2MTk4OA==";

		byte[] base64DecodedBytes = Base64.getDecoder().decode(pass);

		String password = new String(base64DecodedBytes, "utf-8");

		driver.findElement(By.xpath("//*[@name='user_name']")).sendKeys(user);
		driver.findElement(By.xpath("//*[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@name='user_password']")).sendKeys(Keys.RETURN);

		driver.get(
				"https://hi.service-now.com/task_list.do?sysparm_query=active%3Dtrue%5Eassigned_toISEMPTY%5EstateNOT%20IN3%2C-5%5Eassignment_group%3D7dc3c7ce4f931a403ed8b85e0210c751%5EORassignment_group%3D5c4d328a4fdfde00f347524e0210c72a%5Eshort_descriptionNOT%20LIKEcheduled%20migration%20of%20instance%5Esys_created_byLIKEdatacenter_sync%5EnumberNOT%20LIKEPRB%5EnumberNOT%20LIKEPRJ%5EnumberNOT%20LIKESTRY%5Eshort_descriptionNOT%20LIKEDATABASE_%5EnumberNOT%20LIKECHG%5Eshort_descriptionNOT%20LIKEzBoot%5Esys_class_name!%3Dsn_customerservice_case%5Eshort_descriptionLIKESafeNet");

		// No.of rows
		List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='task_table']/tbody/tr/td[1]"));
		int row = rows.size();
		
		System.out.println("Rows are :"+row);

		getIntNumber(row, driver);

		return ince;
	}

	public static void getIntNumber(int row, WebDriver driver) throws InterruptedException {
		String inc;
		boolean e_present = false;
		for (int i = 1; i <= row; i++) {
			try {
				inc = driver.findElement(By.xpath(".//*[@id='task_table']/tbody/tr[" + i + "]/td[3]/a")).getText();
				System.out.println(inc + " " + j++);
				ince.add(inc);

			} catch (NoSuchElementException exception) {

			}
		}
		Thread.sleep(5000);
		e_present = driver
				.findElement(By.xpath("//*[@id=\"task_expanded\"]/div[5]/div[1]/table/tbody/tr/td[2]/span/button[3]"))
				.isEnabled();
		if (e_present) {
			int row_c = -1;

			try {

				WebElement element = driver.findElement(
						By.xpath("//*[@id=\"task_expanded\"]/div[5]/div[1]/table/tbody/tr/td[2]/span/button[3]"));
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + element.getLocation().y + ")");
				element.click();
				Thread.sleep(5000);
				List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='task_table']/tbody/tr/td[1]"));
				row_c = rows.size();
				
				System.out.println("Rows are inside recursion :"+row_c);
				getIntNumber(row_c, driver);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
