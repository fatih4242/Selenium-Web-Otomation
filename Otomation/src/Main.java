


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Main {
	
	static boolean buttonIsShowing;
	static String actionElement;
	static int waitForPageLoadSec = 5;
	
	static String userName = "", passWord = "";

	public static void main(String[] args) throws InterruptedException {
		
		buttonIsShowing = true;
		System.setProperty("webdriver.chrome.driver","/Users/fatihtoker/EclipseProject/Jython/chromedriver");
		
		
		ChromeOptions options = new ChromeOptions();
		//options.addExtensions(new File("/Users/fatihtoker/Library/Application Support/Google/Chrome/Default/Extensions/ffbkglfijbcbgblgflchnbphjdllaogb/7.0.0_0.crx"));
		options.addExtensions(new File("/Users/fatihtoker/Desktop/vpn.crx"));
	
		
		WebDriver driver = new ChromeDriver(options);
	
		driver.get("http://google.com");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		driver.get("http://guvenliqr.com/agent.auth");
		
		driver.manage().timeouts().implicitlyWait(waitForPageLoadSec, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"auth-form\"]/div/div[1]/div/input")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id=\"auth-form\"]/div/div[2]/div/input")).sendKeys(passWord);
		driver.findElement(By.xpath("//*[@id=\"planetsqr-content\"]/div/div/div/div/button[1]")).click();
		
	
		driver.manage().timeouts().implicitlyWait(waitForPageLoadSec, TimeUnit.SECONDS);
		
		
		
		
		
		
		
		while (buttonIsShowing) {
			try {
				
				actionElement = driver.findElement(By.xpath("//tbody[@id='trx-pool-tbody']/tr/td")).getText();
				if (actionElement.equals("işlem bulunamadı.")) {
					System.out.println("nothing...");
				}else {
					driver.findElement(By.xpath("//tbody[@id='trx-pool-tbody']/tr/td/button")).click();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Thread.sleep(500);
			
			
			
		}
		System.out.println("Founded --> "+actionElement);
		driver.manage().timeouts().implicitlyWait(waitForPageLoadSec, TimeUnit.SECONDS);
	
		
		driver.findElement(By.xpath("//div[@id='trxModal']/div/div/div/div[@class='tab-container']/div[@id='atm-list-nearest']/div[@class='atm-item']")).click();
		System.out.println("1.konuma tıklanıldı");
		
		
		//tbody[@id='trx-pool-tbody']/tr/td --> Banka ismi
		//tbody[@id='trx-pool-tbody']/tr/td/button --> İşlem için tıklanılacak ilk button
		
		//div[@id='trxModal']/div/div/div/div[@class='tab-container']/div[@id='atm-list-nearest']/div[@class='atm-item'] --> en yakın konum
		
	}

}
