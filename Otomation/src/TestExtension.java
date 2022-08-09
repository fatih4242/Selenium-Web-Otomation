
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestExtension {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
		
		
		
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("/Users/fatihtoker/Desktop/vpn.crx"));
		WebDriver driver = new ChromeDriver(options);
		
	}
}
