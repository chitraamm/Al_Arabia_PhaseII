package test.java.step_definitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.EmailReader;

import javax.mail.MessagingException;
import java.io.IOException;

public class ConfirmAccountTest {
    public static void main(String[] args) throws MessagingException, IOException {
        // Email credentials (Use environment variables for security)
        String email = "your-email@gmail.com";
        String password = "your-email-password";

        // Fetch confirmation link
        String confirmationLink = EmailReader.getConfirmationLink(email, password);
        if (confirmationLink == null) {
            System.out.println("⚠️ No confirmation link found in the email.");
            return;
        }

        // Launch Selenium WebDriver
        System.setProperty("webdriver.chrome.driver", "path-to-chromedriver"); // Update path
        WebDriver driver = new ChromeDriver();
        driver.get(confirmationLink);

        // Wait for page to load
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

        // Click the confirm button (Modify XPath based on your application)
        WebElement confirmButton = driver.findElement(By.xpath("//button[contains(text(),'Confirm Account')]"));
        confirmButton.click();

        System.out.println("✅ Account successfully confirmed!");
        
        // Close browser
        driver.quit();
    }
}
