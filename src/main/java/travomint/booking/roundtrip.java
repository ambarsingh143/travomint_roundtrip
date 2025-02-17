package travomint.booking;

import java.lang.annotation.ElementType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.swing.text.DateFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class roundtrip {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		System.out.println("Chrome Open Successfully");

		driver.manage().window().maximize();
		System.out.println("Chrome Maximize Successfully");

		driver.get("https://travomint.com");
		System.out.println("Website Open Successfully");
		Thread.sleep(5000);

		driver.findElement(
				By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[1]/label[2]/span[2]"))
				.click();
		System.out.println("Select Round-Trip Successfully");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[1]"))
				.click();
//		Thread.sleep(2000);
		System.out.println("Click on From field successfully");

//		driver.findElement(By.xpath("//input[@id=\"from\"]")).click();
//		System.out.println("In from field click successfully");

		driver.findElement(By.id("from")).sendKeys("HYD");
		System.out.println("In from field keys send successfully");
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[3]/div/div[1]/div[2]/p[1]"))
				.click();
		System.out.println("In from field HYD select successfully");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[1]"))
				.click();
		System.out.println("Click on To field successfully");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/input"))
				.sendKeys("DEL");
		System.out.println("In To field keys send successfully");
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div[1]/div[2]/p[1]"))
				.click();
		System.out.println("In To field DEL select successfully");

		LocalDate currentDate = LocalDate.now(); // Get the current date
		LocalDate selectedDate = currentDate.plus(7, ChronoUnit.DAYS); // Add 7 days
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = selectedDate.format(formatter);
		// Print the selected date for verification
		System.out.println("Selected date after 7 days: " + formattedDate);
		// Open the calendar and select the correct date
		WebElement calendar = driver.findElement(By.id("departure"));
		calendar.click();
		Thread.sleep(2000);
		// Example of how you might use the calculated date to click on the calendar
		// element
		// Assuming the date picker has dates in this format (you may need to adjust the
		// XPath if different):
		String dateXpath = String.format("//td[contains(text(), '%s')]", selectedDate.getDayOfMonth());
		WebElement dateElement = driver.findElement(By.xpath(dateXpath));
		dateElement.click();

		LocalDate todayDate = LocalDate.now(); // Get the current date
		LocalDate selectedDate2 = todayDate.plus(15, ChronoUnit.DAYS); // Add 7 days
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate2 = selectedDate2.format(formatter);
		// Print the selected date for verification
		System.out.println("Selected date after 15 days: " + formattedDate2);
		// Open the calendar and select the correct date
		WebElement calendar2 = driver.findElement(By.id("return"));
		calendar.click();
		Thread.sleep(2000);
		// Example of how you might use the calculated date to click on the calendar
		// element
		// Assuming the date picker has dates in this format (you may need to adjust the
		// XPath if different):
		String dateXpath2 = String.format("//td[contains(text(), '%s')]", selectedDate.getDayOfMonth());
		WebElement dateElement2 = driver.findElement(By.xpath(dateXpath));
		dateElement2.click();

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[4]/div/div[1]/div/div[1]/div"))
				.click();
		System.out.println("In Traveler(s) & Class clicked successfully");

		for (int i = 0; i < 2; i++)
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[4]/div/div[1]/div[2]/div/div[1]/div[2]/div[2]"))
					.click();
		System.out.println("In Adult select successfully");

		for (int i = 0; i < 3; i++)
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[4]/div/div[1]/div[2]/div/div[2]/div[2]/div[2]"))
					.click();

		for (int i = 0; i < 3; i++)
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[4]/div/div[1]/div[2]/div/div[3]/div[2]/div[2]"))
					.click();

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[4]/div/div[1]/div[2]/div/div[6]/button"))
				.click();
		System.out.println("Done button clicked successfully");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[4]/div/div[2]/button"))
				.click();
		System.out.println("Search button clicked successfully");
		Thread.sleep(40000);
		
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div/button[2]")).click();
		System.out.println("Pop-up close button clicked successfully");
		
		
		
		
		
	}

}
